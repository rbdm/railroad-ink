package comp1110.ass2.util;

import com.sun.glass.ui.CommonDialogs;
import comp1110.ass2.RailroadInk;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeSquare;
import comp1110.ass2.model.TypeTile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExitUtil {

    public static void main(String[] args) {
        Board board = new Board();

        board.putPlacementStringToMap("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11");
        Square[][] map = board.getMap();
        List<Square> X = ExitUtil.getConnectedExit(map[2][0],map);
        int xx=getExitScore(map);
        System.out.println(xx);
        //List<Square> X = ExitUtil.getConnectedNeighbour(map[2][2],map,TypeTile.BLOCK);
        //List<Square> X = ExitUtil.allRoute(map[1][2], map, map[0][2], new ArrayList<>());
        //System.out.println(conType(map[2][2],map[2][1]));
        //System.out.println(map[0][2].positionPoint.getY());
        for (Square i : X) {
            System.out.print("[" + i.positionPoint.getX() + "," + i.positionPoint.getY() + "]");
        }
        System.out.println();
    }

    /**
     *
     * @param map
     * @return
     */

    public static int getExitScore(Square[][] map){
        List<Square> exitList =new ArrayList<>();
        int Score=0;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                if (map[i][j].type==TypeSquare.EXIT){
                    exitList.add(map[i][j]);
                }
            }
        }
        return Score;

    }

    public static int exitScoreTable(int number){
        switch (number){
            case 2: return 4 ;
            case 3:return 8;
            case 4:return 12;
            case 5:return 16;
            case 6:return 20;
            case 7:return 24;
            case 8:return 28;
            case 9:return 32;
            case 10:return 36;
            case 11:return 40;
            case 12:return 45;
            default:return 0;
        }

    }
    /**
     * input an exit A and return all other exit that are on the same mix-type route with A
     *
     * @param exit
     * @return a list of all the exit that are connected with A
     */
    public static List<Square> getConnectedExit(Square exit, Square[][] map) {
        if (getConnectedNeighbour(exit, map, TypeTile.BLOCK).isEmpty() == true) {
            return new ArrayList<>();
        } else {
            TypeTile lastIn;
            if (exit.name.equals("  R  ")) {
                lastIn = TypeTile.RAILWAY;
            } else {
                lastIn = TypeTile.HIGHWAY;
            }

            Square start = getConnectedNeighbour(exit, map, lastIn).get(0);
            List<Square> nowList = new ArrayList<>();
            nowList.add(exit);
            nowList.add(start);
            List<Square> all = allRoute(start, map, exit, nowList);
            List<Square> exits = new ArrayList<>();
            for (Square element : all) {
                if (element.type == TypeSquare.EXIT) {
                    exits.add(element);
                }
            }
            return exits;
        }
    }

    /**
     * if the square have connected neighbours return it, if don't just return null
     *
     * @param square
     * @param map
     * @return neighbour square of this Square
     */
    public static List<Square> getConnectedNeighbour(Square square, Square[][] map, TypeTile lastIn) {
        if (square.positionPoint.getX() == -1 && square.positionPoint.getY() == -1) {
            return new ArrayList<>();
        } else {
            int x = square.positionPoint.getX();
            int y = square.positionPoint.getY();
            if (square.type == TypeSquare.TILE) {
                Square upS = map[square.positionPoint.getX() - 1][square.positionPoint.getY()];
                Square rightS = map[square.positionPoint.getX()][square.positionPoint.getY() + 1];
                Square downS = map[square.positionPoint.getX() + 1][square.positionPoint.getY()];
                Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY() - 1];
                List<Square> answer = new ArrayList<>();
                if (square.isOverpass == false) {
                    if (upS.bottom == square.top && square.top != TypeTile.BLOCK) {
                        answer.add(upS);
                    }
                    if (rightS.left == square.right && square.right != TypeTile.BLOCK) {
                        answer.add(rightS);
                    }
                    if (downS.top == square.bottom && square.bottom != TypeTile.BLOCK) {
                        answer.add(downS);
                    }
                    if (leftS.right == square.left && square.left != TypeTile.BLOCK) {
                        answer.add(leftS);
                    }
                    return answer;
                }
                else {
                    if (upS.bottom == square.top && square.top == lastIn) {
                        answer.add(upS);
                    }
                    if (rightS.left == square.right && square.right == lastIn) {
                        answer.add(rightS);
                    }
                    if (downS.top == square.bottom && square.bottom == lastIn) {
                        answer.add(downS);
                    }
                    if (leftS.right == square.left && square.left == lastIn) {
                        answer.add(rightS);
                    }
                    return answer;
                }
            } else if (square.type == TypeSquare.EXIT) {
                List<Square> answer = new ArrayList<>();
                if (square.positionPoint.getX() == 0) {
                    Square downS = map[square.positionPoint.getX() + 1][square.positionPoint.getY()];
                    if (downS.top == square.bottom) {
                        answer.add(downS);
                    }
                } else if (square.positionPoint.getX() == map.length - 1) {
                    Square upS = map[square.positionPoint.getX() - 1][square.positionPoint.getY()];
                    if (upS.bottom == square.top) {
                        answer.add(upS);
                    }
                } else if (square.positionPoint.getY() == 0) {
                    Square rightS = map[square.positionPoint.getX()][square.positionPoint.getY() + 1];
                    if (rightS.left == square.right) {
                        answer.add(rightS);
                    }
                } else {
                    Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY() - 1];
                    if (leftS.right == square.left) {
                        answer.add(leftS);
                    }
                }
                return answer;
            } else {
                return new ArrayList<>();
            }
        }
    }

    public static TypeTile conType(Square A, Square B) {
        if (areConSquares(A, B) == 'n') {
            return null;
        } else {
            if (areConSquares(A,B)=='l'){
                if (A.right==TypeTile.RAILWAY){return TypeTile.RAILWAY;}
                else {return TypeTile.HIGHWAY;}
            }
            else if (areConSquares(A,B)=='r'){
                if (A.left==TypeTile.RAILWAY){return TypeTile.RAILWAY;}
                else {return TypeTile.HIGHWAY;}
            }
            else if (areConSquares(A,B)=='a'){
                if (A.bottom==TypeTile.RAILWAY){return TypeTile.RAILWAY;}
                else {return TypeTile.HIGHWAY;}
            }
            else {
                if (A.top==TypeTile.RAILWAY){return TypeTile.RAILWAY;}
                else {return TypeTile.HIGHWAY;}
            }
        }
    }


    public static List<Square> allRoute(Square s, Square[][] map, Square lastIn, List<Square> alreadyGet)
    {
        List<Square> answer = new ArrayList<>();
        Square squareNow=s;
        Square squareLast = lastIn;

        if (alreadyGet.contains(squareNow) == false) {
            alreadyGet.add(squareNow);
        }
        if (alreadyGet.contains(squareLast) == false) {
            alreadyGet.add(squareLast);
        }
        List<Square> neighbour = getConnectedNeighbour(squareNow, map, conType(squareLast,squareNow));
        List<Square> removeList = new ArrayList<>();
        for (Square i : neighbour) {
            if (alreadyGet.contains(i) == true) {
                removeList.add(i);
            }
        }
        neighbour.removeAll(removeList);
        if (neighbour.isEmpty() == true) {
            return alreadyGet;
        } else{
            for (Square element : neighbour){
                squareLast=squareNow;
                squareNow=element;
                for(Square i:allRoute(squareNow,map,squareLast,alreadyGet)){
                    if (answer.contains(i)==false){answer.add(i);}
                }
            }
        }
        return answer;

    }



    public static char areConSquares(Square A, Square B) {
        int rowA = A.positionPoint.getX();
        int colA = A.positionPoint.getY();
        int rowB = B.positionPoint.getX();
        int colB = B.positionPoint.getY();
        //determine whether A and B are neighbours

        if (rowA == rowB && colB - colA == 1) { //A is on the left of B
            if (A.right == B.left && A.right != TypeTile.BLOCK) {
                return 'l';
            } else {
                return 'n';
            }

        } else if (rowA == rowB && colA - colB == 1) { //A is on the right of B
            if (A.left == B.right && A.left != TypeTile.BLOCK) {
                return 'r';
            } else {
                return 'n';
            }

        } else if (colA == colB && rowA - rowB == 1) { //A is below B
            if (A.top == B.bottom && A.top != TypeTile.BLOCK) {
                return 'b';
            } else {
                return 'n';
            }
        } else if (colA == colB && rowB - rowA == 1) {  //A is above B
            if (A.bottom == B.top && A.bottom != TypeTile.BLOCK) {
                return 'a';
            } else {
                return 'n';
            }
        } else {
            return 'n';
        }
    }


}
