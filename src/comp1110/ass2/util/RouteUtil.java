package comp1110.ass2.util;

import comp1110.ass2.model.EnumTypeTile;
import comp1110.ass2.model.PositionPoint;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.EnumTypeSquare;

import java.util.ArrayList;
import java.util.List;

/**
 * User: u6613739
 * Date: 2019/3/31
 * Time: 16:43
 * Description: to calculate the longest route length.
 */
public class RouteUtil
{

    public enum Direction
    {
        TOP, LEFT, BOTTOM, RIGHT, NONE
    }

    /**
     * find each square max highway and railway route length
     *
     * @param map    the original map
     * @param height the map height
     * @param width  the map width
     * @return the map with longest highway and railway distance
     */
    public static Square[][] findSquareLongestRoute(Square[][] map, int height, int width)
    {
        //Intial map
        Square[][] squares = map.clone();
        // find each square's longest highway
        for (int i = 1; i < height - 1; i++)
        {
            for (int j = 1; j < width - 1; j++)
            {
                ArrayList<PositionPoint> trackingList = new ArrayList<>();
                int maxlength = oneStep(squares, i, j, 0, EnumTypeTile.HIGHWAY, Direction.NONE, trackingList);
                squares[i][j].longestHighWayRouteLength = maxlength;
            }
        }
        // find each square's longest railway
        for (int i = 1; i < height - 1; i++)
        {
            for (int j = 1; j < width - 1; j++)
            {
                ArrayList<PositionPoint> trackingList = new ArrayList<>();
                int maxlength = oneStep(squares, i, j, 0, EnumTypeTile.RAILWAY, Direction.NONE, trackingList);
                squares[i][j].longestRailWayRouteLength = maxlength;
            }
        }
        return squares;
    }

    /**
     * to judge a square what directions can it goes next.
     *
     * @param square         current square
     * @param enumTypeTile   choose typetile
     * @param getInDirection how does the previous square get in.
     * @return the direction the square can approach next.
     */
    public static List<Direction> getAccessDirection(Square square, EnumTypeTile enumTypeTile, Direction getInDirection)
    {
        if (square == null)
        {
            return new ArrayList<>();
        }
        List<Direction> accessDirections = new ArrayList<>();

        accessDirections.addAll(getSameTileDirection(square, enumTypeTile));

        //remove InDirection no turn round
        switch (getInDirection)
        {
            case TOP:
                removeDirection(accessDirections, Direction.BOTTOM);
                break;
            case RIGHT:
                removeDirection(accessDirections, Direction.LEFT);
                break;
            case BOTTOM:
                removeDirection(accessDirections, Direction.TOP);
                break;
            case LEFT:
                removeDirection(accessDirections, Direction.RIGHT);
                break;
        }
        return accessDirections;
    }

    /**
     * remove the direction which is already used
     *
     * @param directions all directions can approach
     * @param direction  the directions already used
     * @return correct direction.
     */
    private static List<Direction> removeDirection(List<Direction> directions, Direction direction)
    {
        for (int i = directions.size() - 1; i >= 0; i--)
        {
            if (directions.get(i) == direction)
            {
                directions.remove(i);
            }
        }
        return directions;
    }

    /**
     * get the Direction list which is consist of choosen tile
     *
     * @param square       square
     * @param enumTypeTile highway or railway
     * @return same tile direction
     */
    private static List<Direction> getSameTileDirection(Square square, EnumTypeTile enumTypeTile)
    {
        List<Direction> sameTileDirections = new ArrayList<>();
        if (square == null)
        {
            return null;
        }

        if (square.top == enumTypeTile)
        {
            sameTileDirections.add(Direction.TOP);
        }
        if (square.right == enumTypeTile)
        {
            sameTileDirections.add(Direction.RIGHT);
        }
        if (square.bottom == enumTypeTile)
        {
            sameTileDirections.add(Direction.BOTTOM);
        }
        if (square.left == enumTypeTile)
        {
            sameTileDirections.add(Direction.LEFT);
        }
        return sameTileDirections;
    }

    /**
     * to judge if the square can be get in by the getInDirection
     *
     * @param square         square
     * @param enumTypeTile   highway or railway
     * @param getInDirection get in direction
     * @return can get in?
     */
    private static boolean canGetIn(Square square, EnumTypeTile enumTypeTile, Direction getInDirection)
    {
        switch (getInDirection)
        {
            case TOP:
                if (square.bottom != enumTypeTile)
                {
                    return false;
                }
                break;
            case RIGHT:
                if (square.left != enumTypeTile)
                {
                    return false;
                }
                break;
            case BOTTOM:
                if (square.top != enumTypeTile)
                {
                    return false;
                }
                break;
            case LEFT:
                if (square.right != enumTypeTile)
                {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * check if there is a loop in game
     *
     * @param curPositionPoint current square position
     * @param trackingList     tracking list
     * @return is Loop
     */
    public static boolean isLoop(PositionPoint curPositionPoint, List<PositionPoint> trackingList)
    {
        if (trackingList == null || curPositionPoint == null)
        {
            return false;
        }

        for (PositionPoint positionPoint : trackingList)
        {
            if (positionPoint.getX() == curPositionPoint.getX() && positionPoint.getY() == curPositionPoint.getY())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * use deep-first method to find each square's longest railway or highway
     *
     * @param squareRoutes   all squares
     * @param x              current square x
     * @param y              current square y
     * @param deepth         last square's deepth(route length)
     * @param enumTypeTile   choosen tile type
     * @param getInDirection how to get in current square? top ....
     * @param trackingList   tracking list
     * @return current square's deepth(route length)
     */
    private static int oneStep(Square[][] squareRoutes, int x, int y, int deepth, EnumTypeTile enumTypeTile, Direction getInDirection, List<PositionPoint> trackingList)
    {

        Square square = squareRoutes[x][y];
        //can get in from the previous square's dirction?
        if (! canGetIn(square, enumTypeTile, getInDirection))
        {
            return deepth;
        }
        //is in loop?
        if (isLoop(square.positionPoint, trackingList))
        {
            return deepth;
        }
        // do the track meet the wall
        if (square.type == EnumTypeSquare.WALL || square.type == EnumTypeSquare.EXIT || square.type == EnumTypeSquare.EMPTY)
        {
            return deepth;
        }
        trackingList.add(square.positionPoint);
        deepth = deepth + 1;
        List<Direction> accessDirections = getAccessDirection(square, enumTypeTile, getInDirection);
        int maxDepth = deepth;

        int tmpDepth = 0;
        for (Direction direction : accessDirections)
        {
            switch (direction)
            {
                case TOP:
                    tmpDepth = oneStep(squareRoutes, x - 1, y, deepth, enumTypeTile, Direction.TOP, trackingList);
                    break;
                case RIGHT:
                    tmpDepth = oneStep(squareRoutes, x, y + 1, deepth, enumTypeTile, Direction.RIGHT, trackingList);
                    break;
                case BOTTOM:
                    tmpDepth = oneStep(squareRoutes, x + 1, y, deepth, enumTypeTile, Direction.BOTTOM, trackingList);
                    break;
                case LEFT:
                    tmpDepth = oneStep(squareRoutes, x, y - 1, deepth, enumTypeTile, Direction.LEFT, trackingList);
                    break;
            }
            if (maxDepth < tmpDepth)
            {
                maxDepth = tmpDepth;
            }
        }
        trackingList.remove(trackingList.size() - 1);
        return maxDepth;
    }
}
