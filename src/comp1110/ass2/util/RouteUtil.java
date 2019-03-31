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

    public class SquareRoute{
        private Square square;
        public int longestRailWayLength = -1;
        public int longestHighWayLength = -1;
        public List<Square> longestRailWayRoute = new ArrayList<>();
        public List<Square> longestHighWayRoute = new ArrayList<>();
    }

    public SquareRoute[][]squareRoutes;
    public SquareRoute[][] FindSquareLongestRoute(Square[][]map,int height,int width)
    {
        squareRoutes = new SquareRoute[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                squareRoutes[i][j]=new SquareRoute();
                squareRoutes[i][j].square = map[i][j];
            }
        }

        for(int i=1;i<height-1;i++)
        {
            for(int j=1;j<width-1;j++)
            {
                int maxlength = oneStep(i,j,0,TypeTile.HIGHWAY,Direction.NONE);
                squareRoutes[i][j].longestHighWayLength=maxlength;
            }
        }
        for(int i=1;i<height-1;i++)
        {
            for(int j=1;j<width-1;j++)
            {
                int maxlength = oneStep(i,j,0,TypeTile.RAILWAY,Direction.NONE);
                squareRoutes[i][j].longestRailWayLength=maxlength;
            }
        }



        return squareRoutes;
    }

    private List<Direction> getAccessDirection(Square square,TypeTile typeTile,Direction getInDirection)
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
    private List<Direction> removeDirection(List<Direction> directions,Direction direction)
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

    private List<Direction> getSameTileDirection(Square square,TypeTile typeTile)
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

    private int oneStep(int x,int y,int deepth, TypeTile typeTile,Direction getInDirection)
    {

        SquareRoute squareRoute = squareRoutes[x][y];


        if(squareRoute.square.type== TypeSquare.WALL || squareRoute.square.type==TypeSquare.EXIT ||squareRoute.square.type==TypeSquare.EMPTY)
        {
            return deepth;
        }
        deepth=deepth+1;
        List<Direction> accessDirections =getAccessDirection(squareRoute.square,typeTile,getInDirection);
        int maxDepth = deepth;

        int tmpDepth;
        for(Direction direction:accessDirections)
        {
            switch (direction)
            {
                case TOP: tmpDepth =oneStep(x-1,y,deepth,typeTile,Direction.TOP);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case RIGHT:tmpDepth =oneStep(x,y+1,deepth,typeTile,Direction.RIGHT);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case BOTTOM:tmpDepth =oneStep(x+1,y,deepth,typeTile,Direction.BOTTOM);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
                case LEFT:tmpDepth =oneStep(x,y-1,deepth,typeTile,Direction.LEFT);
                    if(maxDepth<tmpDepth){maxDepth=tmpDepth;};
                    break;
            }
        }

        return maxDepth;
    }
}
