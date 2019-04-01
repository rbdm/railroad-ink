package comp1110.ass2.util;

import com.sun.glass.ui.CommonDialogs;
import comp1110.ass2.RailroadInk;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeSquare;
import comp1110.ass2.model.TypeTile;

import java.util.ArrayList;
import java.util.List;

public class ExitUtil {

    public static void main(String[] args){
        Board board = new Board();

        board.putPlacementStringToMap("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11");
        Square[][] map = board.getMap();
        List<Square> X = ExitUtil.getConnectedExit(map[0][2],map);
        System.out.println(X);
    }
    /**
     * input an exit A and return all other exit that are on the same mix-type route with A
     * @param exit
     * @return a list of all the exit that are connected with A
     */
    public static List<Square> getConnectedExit(Square exit, Square[][] map){
        if (getConnectedNeighbour(exit,map,TypeTile.BLOCK).isEmpty()==true){
            return new ArrayList<>();
        }
        else{
            TypeTile lastIn;
            if (exit.name.equals("  R  ")){lastIn=TypeTile.RAILWAY;}
            else{lastIn=TypeTile.HIGHWAY;}
            Square start = getConnectedNeighbour(exit,map,lastIn).get(0);
            List<Square> nowList = new ArrayList<>();
            nowList.add(exit);
            nowList.add(start);
            List<Square> all = allRoute(start,map,lastIn,nowList);
            List<Square> exits=new ArrayList<>();
            for (Square element:all){
                if (element.type==TypeSquare.EXIT){
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
    public static List<Square> getConnectedNeighbour(Square square, Square[][] map, TypeTile lastIn){
        if (square.positionPoint.getX()==-1 && square.positionPoint.getY()==-1){return new ArrayList<>();}
        else {
            if (square.type==TypeSquare.TILE){
                Square upS = map[square.positionPoint.getX()-1][square.positionPoint.getY()];
                Square rightS = map[square.positionPoint.getX()-1][square.positionPoint.getY()+1];
                Square downS = map[square.positionPoint.getX()+1][square.positionPoint.getY()];
                Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY()-1];
                List<Square> answer = new ArrayList<>();
                if (square.isOverpass==false){
                    if (upS.bottom==square.top && square.top!=TypeTile.BLOCK){ answer.add(upS); }
                    else if (rightS.left==square.right && square.right!=TypeTile.BLOCK){answer.add(rightS);}
                    else if (downS.top==square.bottom && square.bottom!=TypeTile.BLOCK){answer.add(downS);}
                    else if (leftS.right==square.left && square.left!=TypeTile.BLOCK){answer.add(rightS);}
                    return answer;
                }
                else {
                    if (upS.bottom==square.top && square.top==lastIn){ answer.add(upS); }
                    else if (rightS.left==square.right && square.right==lastIn){answer.add(rightS);}
                    else if (downS.top==square.bottom && square.bottom==lastIn){answer.add(downS);}
                    else if (leftS.right==square.left && square.left==lastIn){answer.add(rightS);}
                    return answer;
                }
            }
            else if (square.type==TypeSquare.EXIT){
                List<Square> answer = new ArrayList<>();
                if (square.positionPoint.getX()==0){
                    Square downS=map[square.positionPoint.getX()+1][square.positionPoint.getY()];
                    if (downS.top==square.bottom){
                        answer.add(downS);
                    }
                }
                else if (square.positionPoint.getX()==map.length-1){
                    Square upS = map[square.positionPoint.getX()-1][square.positionPoint.getY()];
                    if (upS.bottom==square.top){
                        answer.add(upS);
                    }
                }
                else if (square.positionPoint.getY()==0){
                    Square rightS = map[square.positionPoint.getX()-1][square.positionPoint.getY()+1];
                    if (rightS.left==square.right){answer.add(rightS);}
                }
                else{
                    Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY()-1];
                    if (leftS.right==square.left){answer.add(leftS);}
                }
                return answer;
            }
            else{return new ArrayList<>();}
        }
    }

    public static TypeTile conType(Square A, Square B){
        if (RailroadInk.areConnectedNeighbours(A.name,B.name)==false){
            return null;
        }
        else{
            if ((A.left==B.right && A.left==TypeTile.RAILWAY) ||
                    (A.right==B.left && A.right==TypeTile.RAILWAY) ||
                    (A.bottom==B.top && A.bottom==TypeTile.RAILWAY)||
                    (A.top==B.bottom && A.top==TypeTile.RAILWAY)){
                return TypeTile.RAILWAY;
            }
            else if((A.left==B.right && A.left==TypeTile.HIGHWAY) ||
                    (A.right==B.left && A.right==TypeTile.HIGHWAY) ||
                    (A.bottom==B.top && A.bottom==TypeTile.HIGHWAY)||
                    (A.top==B.bottom && A.top==TypeTile.HIGHWAY)){
                return TypeTile.HIGHWAY;
            }
            else {return null;}

        }
    }

    public static List<Square> allRoute(Square s,Square[][] map, TypeTile lastIn, List<Square> alreadyGet ){
        if (alreadyGet.contains(s)==false){alreadyGet.add(s);}
        List<Square> neighbour = getConnectedNeighbour(s,map,lastIn);
        for (Square i:neighbour){
            if (alreadyGet.contains(i)==true){neighbour.remove(i);}
        }

        if (neighbour.isEmpty()==true){return alreadyGet;}
        else {
            for (Square i:neighbour){
                alreadyGet.add(i);
                alreadyGet=allRoute(i,map,lastIn,alreadyGet);
            }
            return alreadyGet;
        }

    }

}
