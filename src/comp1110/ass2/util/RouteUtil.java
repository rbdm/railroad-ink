package comp1110.ass2.util;

import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeSquare;
import comp1110.ass2.model.TypeTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: u6613739
 * Date: 2019/3/31
 * Time: 16:43
 * Description:
 */
public class RouteUtil
{

    enum Direction{
        TOP,
        LEFT,
        BOTTOM,
        RIGHT,
        NONE
    }


    public static Square[][] FindSquareLongestRoute(Square[][]map,int height,int width)
    {
        Square[][] squares = new Square[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                squares[i][j] = map[i][j];
            }
        }

        for(int i=1;i<height-1;i++)
        {
            for(int j=1;j<width-1;j++)
            {
                int maxlength = oneStep(squares,i,j,0,TypeTile.HIGHWAY,Direction.NONE);
                squares[i][j].longestHighWayRouteLength=maxlength;
            }
        }
        for(int i=1;i<height-1;i++)
        {
            for(int j=1;j<width-1;j++)
            {
                int maxlength = oneStep(squares,i,j,0,TypeTile.RAILWAY,Direction.NONE);
                squares[i][j].longestRailWayRouteLength=maxlength;
            }
        }
        return squares;
    }

    private static List<Direction> getAccessDirection(Square square,TypeTile typeTile,Direction getInDirection)
    {

        List<Direction> accessDirections = new ArrayList<>();

        accessDirections.addAll(getSameTileDirection(square,typeTile));

        //remove InDirection no turn round
        switch (getInDirection)
        {
            case TOP: removeDirection(accessDirections,Direction.BOTTOM);break;
            case RIGHT:removeDirection(accessDirections,Direction.LEFT);break;
            case BOTTOM:removeDirection(accessDirections,Direction.TOP);break;
            case LEFT:removeDirection(accessDirections,Direction.RIGHT);break;
        }


        return accessDirections;
    }
    private static List<Direction> removeDirection(List<Direction> directions,Direction direction)
    {
        for(int i=directions.size()-1;i>=0;i--)
        {
            if(directions.get(i)==direction)
            {
                directions.remove(i);
            }
        }
        return directions;
    }

    private static List<Direction> getSameTileDirection(Square square,TypeTile typeTile)
    {
        List<Direction> sameTileDirections = new ArrayList<>();
        if(square.top == typeTile)
        {
            sameTileDirections.add(Direction.TOP);
        }
        if(square.right == typeTile)
        {
            sameTileDirections.add(Direction.RIGHT);
        }
        if(square.bottom == typeTile)
        {
            sameTileDirections.add(Direction.BOTTOM);
        }
        if(square.left == typeTile)
        {
            sameTileDirections.add(Direction.LEFT);
        }
        return sameTileDirections;
    }

    private static boolean canGetIn(Square square,TypeTile typeTile,Direction getInDirection)
    {
        switch (getInDirection)
        {
            case TOP:if(square.bottom != typeTile){return false;}break;
            case RIGHT:if(square.left != typeTile){return false;}break;
            case BOTTOM:if(square.top != typeTile){return false;}break;
            case LEFT:if(square.right != typeTile){return false;}break;
        }
        return true;
    }

    private static int oneStep(Square[][] squareRoutes,int x,int y,int deepth, TypeTile typeTile,Direction getInDirection)
    {

        Square square = squareRoutes[x][y];

        if(!canGetIn(square,typeTile,getInDirection))
        {
            return deepth;
        }

        if(square.type== TypeSquare.WALL || square.type==TypeSquare.EXIT ||square.type==TypeSquare.EMPTY)
        {
            return deepth;
        }
        deepth=deepth+1;
        List<Direction> accessDirections =getAccessDirection(square,typeTile,getInDirection);
        int maxDepth = deepth;

        int tmpDepth;
        for(Direction direction:accessDirections)
        {
            switch (direction)
            {
                case TOP: tmpDepth =oneStep(squareRoutes,x-1,y,deepth,typeTile,Direction.TOP);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case RIGHT:tmpDepth =oneStep(squareRoutes,x,y+1,deepth,typeTile,Direction.RIGHT);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case BOTTOM:tmpDepth =oneStep(squareRoutes,x+1,y,deepth,typeTile,Direction.BOTTOM);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case LEFT:tmpDepth =oneStep(squareRoutes,x,y-1,deepth,typeTile,Direction.LEFT);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
            }
        }
        return maxDepth;
    }
}
