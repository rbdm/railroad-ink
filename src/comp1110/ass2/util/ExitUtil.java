package comp1110.ass2.util;

import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeSquare;
import comp1110.ass2.model.TypeTile;

import java.util.ArrayList;
import java.util.List;

public class ExitUtil {
    /**
     * input an exit A and return all other exit that are on the same mix-type route with A
     * @param exit
     * @return a list of all the exit that are connected with A
     */
    public static List<Square> getConnectedExit(Square exit, Square[][] map){
        if (haveConnectedNeighbour(exit, map)==false){
            return new ArrayList<>();
        }
        else{

        }
        return new ArrayList<>() ;
    }

    /**
     * judge if the square have connected neighbours
     * @param square
     * @param map
     * @return have at least one connected neighbour square?
     */
    public static boolean haveConnectedNeighbour(Square square, Square[][] map){
        if (square.positionPoint.getX()==-1 && square.positionPoint.getY()==-1){return false;}
        else {
            Square upS = map[square.positionPoint.getX()-1][square.positionPoint.getY()];
            Square rightS = map[square.positionPoint.getX()-1][square.positionPoint.getY()+1];
            Square downS = map[square.positionPoint.getX()+1][square.positionPoint.getY()];
            Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY()-1];

            if (upS.bottom==square.top && square.top!=TypeTile.BLOCK){ return true; }
            else if (rightS.left==square.right && square.right!=TypeTile.BLOCK){return true;}
            else if (downS.top==square.bottom && square.bottom!=TypeTile.BLOCK){return true;}
            else if (leftS.right==square.left && square.left!=TypeTile.BLOCK){return true;}
            else {return false;}
        }
    }

}
