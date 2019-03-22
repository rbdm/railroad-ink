package comp1110.ass2.model;

import java.util.List;

public class Board
{
    private static final int MAX_HEIGHT = 9;
    private static final int MAX_WITDH = 9;
    private Square[][] map = new Square[MAX_HEIGHT][MAX_WITDH];

    public Board()
    {
        InitialMap();
    }

    private void InitialMap()
    {
        //set all to EMPTY
        for (int i = 0; i < MAX_WITDH; i++)
        {
            for (int j = 0; j < MAX_HEIGHT; j++)
            {
                map[i][j] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "NUL", TypeSquare.EMPTY);
            }
        }
        //set surround wall
        for (int i = 0; i < MAX_WITDH; i++)
        {
            map[i][0] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "-", TypeSquare.WALL);
        }
        for (int i = 0; i < MAX_WITDH; i++)
        {
            map[i][MAX_HEIGHT - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "-", TypeSquare.WALL);
        }
        for (int i = 0; i < MAX_HEIGHT; i++)
        {
            map[0][i] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "-", TypeSquare.WALL);
        }
        for (int i = 0; i < MAX_HEIGHT; i++)
        {
            map[MAX_WITDH - 1][i] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "-", TypeSquare.WALL);
        }
        //set exits
        map[0][2] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[0][4] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[0][6] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][2] = new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][4] = new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][6] = new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[2][0] = new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[4][0] = new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[6][0] = new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[2][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "R", TypeSquare.EXIT);
        map[4][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "H", TypeSquare.EXIT);
        map[6][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "R", TypeSquare.EXIT);

    }

    public void printMap()
    {
        for (int i = 0; i < MAX_HEIGHT; i++)
        {
            for (int j = 0; j < MAX_WITDH; j++)
            {
                String data = map[i][j].name;
                int leftSpace = data.length() < 5 ? (5 - data.length()) / 2 : 0;
                int rightSpace = data.length() < 5 ? 5 - data.length() - leftSpace : 0;

                for (int k = 0; k < leftSpace; k++)
                {
                    data = " " + data;
                }
                for (int k = 0; k < rightSpace; k++)
                {
                    data = data + " ";
                }
                System.out.print(String.format("%s", data));


            }
            System.out.println();
        }
    }

    /**
     * transfer SquareString to Square
     * @param squareString squareString like "B1C54"
     * @return if valid string,return a Square class. if squareString is invalid, return null.
     */
    public Square getSquareFormSquareString(String squareString)
    {
        if (squareString.length() != 5)
        {
            return null;
        }
        char dice = squareString.charAt(0);
        char face = squareString.charAt(1);
        char row = squareString.charAt(2);
        char col = squareString.charAt(3);
        char orientation = squareString.charAt(4);
        Tile tile = new Tile();
        if (dice != 'A' && dice != 'B' && dice != 'S')
        {
            return null;
        }
        if (dice == 'A' || dice == 'S')
        {
            if (face < '0' || face > '5')
            {
                return null;
            }
        }
        if (dice == 'B')
        {
            if (face < '0' || face > '2')
            {
                return null;
            }
        }

        if (row < 'A' || row > 'G')
        {
            return null;
        }
        if (col < '0' || col > '6')
        {
            return null;
        }
        if (orientation < '0' || orientation > '7')
        {
            return null;
        }
        List<Square> squareList = tile.getSquareList(dice);

        squareList = squareList.subList(8 * (face - '0'), 8 * (face - '0') + 8);
        Square square = squareList.get(orientation - '0');
        square.positionPoint.setPositionPoint(row - 'A' + 1, col - '0' + 1);
        return square;

    }
}
