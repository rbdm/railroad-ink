package comp1110.ass2.util;

import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeSquare;
import comp1110.ass2.model.TypeTile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: u6613739
 * Date: 2019/3/31
 * Time: 16:43
 * Description:
 */
public class RouteUtil
{

    enum Direction
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
    public static Square[][] FindSquareLongestRoute(Square[][] map, int height, int width)
    {
        Square[][] squares = new Square[height][width];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                squares[i][j] = map[i][j];
            }
        }

        for (int i = 1; i < height - 1; i++)
        {
            for (int j = 1; j < width - 1; j++)
            {
                int maxlength = oneStep(squares, i, j, 0, TypeTile.HIGHWAY, Direction.NONE);
                squares[i][j].longestHighWayRouteLength = maxlength;
            }
        }
        for (int i = 1; i < height - 1; i++)
        {
            for (int j = 1; j < width - 1; j++)
            {
                int maxlength = oneStep(squares, i, j, 0, TypeTile.RAILWAY, Direction.NONE);
                squares[i][j].longestRailWayRouteLength = maxlength;
            }
        }
        return squares;
    }

    /**
     * to judge a square what directions can it goes next.
     *
     * @param square         current square
     * @param typeTile       choose typetile
     * @param getInDirection how does the previous square get in.
     * @return the direction the square can approach next.
     */
    private static List<Direction> getAccessDirection(Square square, TypeTile typeTile, Direction getInDirection)
    {

        List<Direction> accessDirections = new ArrayList<>();

        accessDirections.addAll(getSameTileDirection(square, typeTile));

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
     * @param square   square
     * @param typeTile highway or railway
     * @return same tile direction
     */
    private static List<Direction> getSameTileDirection(Square square, TypeTile typeTile)
    {
        List<Direction> sameTileDirections = new ArrayList<>();
        if (square.top == typeTile)
        {
            sameTileDirections.add(Direction.TOP);
        }
        if (square.right == typeTile)
        {
            sameTileDirections.add(Direction.RIGHT);
        }
        if (square.bottom == typeTile)
        {
            sameTileDirections.add(Direction.BOTTOM);
        }
        if (square.left == typeTile)
        {
            sameTileDirections.add(Direction.LEFT);
        }
        return sameTileDirections;
    }

    /**
     * to judge if the square can be get in by the getInDirection
     *
     * @param square         square
     * @param typeTile       highway or railway
     * @param getInDirection get in direction
     * @return can get in?
     */
    private static boolean canGetIn(Square square, TypeTile typeTile, Direction getInDirection)
    {
        switch (getInDirection)
        {
            case TOP:
                if (square.bottom != typeTile)
                {
                    return false;
                }
                break;
            case RIGHT:
                if (square.left != typeTile)
                {
                    return false;
                }
                break;
            case BOTTOM:
                if (square.top != typeTile)
                {
                    return false;
                }
                break;
            case LEFT:
                if (square.right != typeTile)
                {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * use deep-first method to find each square's longest railway and highway
     *
     * @param squareRoutes   all squares
     * @param x              current square x
     * @param y              current square y
     * @param deepth         last square's deepth(route length)
     * @param typeTile       choosen tile type
     * @param getInDirection how to get in current square? top ....
     * @return current square's deepth(route length)
     */
    private static int oneStep(Square[][] squareRoutes, int x, int y, int deepth, TypeTile typeTile, Direction getInDirection)
    {

        Square square = squareRoutes[x][y];

        if (! canGetIn(square, typeTile, getInDirection))
        {
            return deepth;
        }

        if (square.type == TypeSquare.WALL || square.type == TypeSquare.EXIT || square.type == TypeSquare.EMPTY)
        {
            return deepth;
        }
        deepth = deepth + 1;
        List<Direction> accessDirections = getAccessDirection(square, typeTile, getInDirection);
        int maxDepth = deepth;

        int tmpDepth;
        for (Direction direction : accessDirections)
        {
            switch (direction)
            {
                case TOP:
                    tmpDepth = oneStep(squareRoutes, x - 1, y, deepth, typeTile, Direction.TOP);
                    if (maxDepth < tmpDepth)
                    {
                        maxDepth = tmpDepth;
                    }
                    ;
                    break;
                case RIGHT:
                    tmpDepth = oneStep(squareRoutes, x, y + 1, deepth, typeTile, Direction.RIGHT);
                    if (maxDepth < tmpDepth)
                    {
                        maxDepth = tmpDepth;
                    }
                    ;
                    break;
                case BOTTOM:
                    tmpDepth = oneStep(squareRoutes, x + 1, y, deepth, typeTile, Direction.BOTTOM);
                    if (maxDepth < tmpDepth)
                    {
                        maxDepth = tmpDepth;
                    }
                    ;
                    break;
                case LEFT:
                    tmpDepth = oneStep(squareRoutes, x, y - 1, deepth, typeTile, Direction.LEFT);
                    if (maxDepth < tmpDepth)
                    {
                        maxDepth = tmpDepth;
                    }
                    break;
            }
        }
        return maxDepth;
    }
}
