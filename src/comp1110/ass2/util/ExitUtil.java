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

        board.putPlacementStringToMap("A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41");
        Square[][] map = board.getMap();
        //List<Square> X = ExitUtil.getConnectedExit(map[0][2],map);
        //int xxex = getExitScore(map);
        //int xxer=getErrorScore(map);
        //int xxce=getCenterScore(map);
        //System.out.print(xxex+","+xxer+","+xxce);
        //List<Square> X = ExitUtil.getConnectedNeighbour(map[0][2],map,TypeTile.BLOCK);
        List<Square> X = ExitUtil.allRoute(map[1][2], map, map[0][2], new ArrayList<>());
        //System.out.println(conType(map[2][2],map[2][1]));
        //System.out.println(map[0][2].positionPoint.getY());
        for (Square i : X) {
            System.out.print("[" + i.positionPoint.getX() + "," + i.positionPoint.getY() + "]");
        }
        System.out.println();

    }

    /**
     * return the score about number of exits in one route
     * @param map
     * @return score
     */
    public static int getExitScore(Square[][] map){
        List<List<Square>> exitCluster =new ArrayList<>();
        List<Square> allExit = new ArrayList<>();
        int Score=0;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                if (map[i][j].type==TypeSquare.EXIT){
                    allExit.add(map[i][j]);
                }
            }
        }
        exitCluster.add(allExit);
        for(Square i : exitCluster.get(0)){
            boolean ct=false;
            for (int index=1;index<exitCluster.size();index++){
                if (exitCluster.get(index).contains(i)){
                    ct = true;
                }
            }
            if (ct==true){break;}
            else {
                List<Square> nb=getConnectedExit(i,map);
                exitCluster.add(nb);
            }

        }
        exitCluster.remove(0);
        for (List l :exitCluster){
            Score+=exitScoreTable(l.size());
        }

        return Score;

    }

    /**
     * @param number of exit in one route
     * @return the score of this route
     */

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
     * @param exit
     * @return a list of all the exit that are connected with A
     */

    public static List<Square> getConnectedExit(Square exit, Square[][] map) {
        if (getConnectedNeighbour(exit, map, TypeTile.BLOCK).isEmpty() == true) {
            return new ArrayList<>();
        } else {
            TypeTile lastIn;
            if (exit.name.equals("R")) {
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

    /**
     * return the type of connection of two squares
     * @param A
     * @param B
     * @return TypeTile.Railway or TypeTile.Highway
     */
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


    /**
     *
     * @Square s
     * @param map
     * @Square lastIn  the square from which we come into this square
     * @param alreadyGet the list of squares we already know that is in this route
     * @return all the squares that in this route
     */
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

    /**
     * judge if A and B are connectedSquares
     * @param A
     * @param B
     * @return if A and B are connectedSquares
     */

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

    /**
     * get the score about center squares that covered by tile
     * @param map
     * @return score of center tiles
     */
    public static int getCenterScore(Square[][] map){
        int cs=0;
        for (Square s: centerList(map)){
            if (s.type==TypeSquare.TILE){
                cs+=1;
            }
        }
        return cs;
    }

    /**
     * get squares that are located in CENTER from a map
     * @param map
     * @return
     */
    public static List<Square> centerList(Square[][] map){
        List<Square> center = new ArrayList<>();
        for (int i=3;i<6;i++){
            for (int j=3;j<6;j++) {
                center.add(map[i][j]);
            }
        }
        return center;
    }

    /**
     * get scores that need to be deducted from basic score for error
     * @param map
     * @return error scores
     */
    public static int getErrorScore(Square[][] map){
        int es=0;
        for (int i=1;i<map.length-1;i++) {
            for (int j=1;j<map[0].length-1;j++){
                int topEr = errorPoint(map[i][j],map,'t');
                int rightEr = errorPoint(map[i][j],map,'r');
                int bottomEr = errorPoint(map[i][j],map,'b');
                int leftEr = errorPoint(map[i][j],map,'l');

                int totalEr = topEr+rightEr+bottomEr+leftEr;

                if (i==1){totalEr=totalEr-topEr;}
                if (i == map.length - 2) { totalEr=totalEr-bottomEr;}
                if (j==1) {totalEr=totalEr-leftEr;}
                if (j==map[0].length-2){totalEr=totalEr-rightEr;}
                es=es+totalEr;

            }
        }
        return es;
    }

    /**
     * give a direction (e.g. 't' for top), see if there is an error on the top of square s,
     * if so return 1, 0 otherwise
     * @param square
     * @param map
     * @param direction
     * @return 1 or 0
     */
    public static int errorPoint(Square square, Square[][] map, char direction){
        if (square.type==TypeSquare.TILE){
            Square upS = map[square.positionPoint.getX() - 1][square.positionPoint.getY()];
            Square rightS = map[square.positionPoint.getX()][square.positionPoint.getY() + 1];
            Square downS = map[square.positionPoint.getX() + 1][square.positionPoint.getY()];
            Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY() - 1];
            if (direction=='t'){
                //check if has ERROR POINT on TOP
                if (square.top!=TypeTile.BLOCK && upS.bottom==TypeTile.BLOCK){
                    return 1;
                }
                else {return 0;}
            }
            else if (direction=='r'){
                //check if has ERROR POINT on Right
                if (square.right!=TypeTile.BLOCK && rightS.left==TypeTile.BLOCK){
                    return 1;
                }
                else {return 0; }
            }
            else if (direction=='b'){
                //check if has ERROR POINT on bottom
                if (square.bottom!=TypeTile.BLOCK && downS.top==TypeTile.BLOCK){
                    return 1;
                }
                else {return 0; }
            }
            else if(direction=='l'){
                //check if has ERROR POINT on Left
                if (square.left!=TypeTile.BLOCK && leftS.right==TypeTile.BLOCK){
                    return 1;
                }
                else {return 0; }
            }
            else {return 0;}
        }
        else {return 0;}

    }


}
