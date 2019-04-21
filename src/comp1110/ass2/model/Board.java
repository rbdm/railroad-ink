package comp1110.ass2.model;


import comp1110.ass2.util.ExitUtil;
import comp1110.ass2.util.RouteUtil;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private static final int MAX_HEIGHT = 9;
    private static final int MAX_WITDH = 9;
    private Square[][] map = new Square[MAX_HEIGHT][MAX_WITDH];
    public ImageView[][] imageViews = new ImageView[MAX_HEIGHT][MAX_WITDH];
    public List<List<Square>> squareClusters= new ArrayList<List<Square>>();

    /**
     * constructor of Board
     */
    public Board()
    {
        InitialMap();
    }
    public Square[][] getMap()
    {
        return map;
    }

    /**
     * InitialMap with railway, highway exits and wall and empty block.
     */
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
        map[0][2].positionPoint.setPositionPoint(0,2);
        map[0][4] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[0][4].positionPoint.setPositionPoint(0,4);
        map[0][6] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[0][6].positionPoint.setPositionPoint(0,6);
        map[MAX_HEIGHT - 1][2] = new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][2].positionPoint.setPositionPoint(MAX_HEIGHT - 1,2);
        map[MAX_HEIGHT - 1][4] = new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][4].positionPoint.setPositionPoint(MAX_HEIGHT - 1,4);
        map[MAX_HEIGHT - 1][6] = new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[MAX_HEIGHT - 1][6].positionPoint.setPositionPoint(MAX_HEIGHT - 1,6);
        map[2][0] = new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[2][0].positionPoint.setPositionPoint(2,0);
        map[4][0] = new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "H", TypeSquare.EXIT);
        map[4][0].positionPoint.setPositionPoint(4,0);
        map[6][0] = new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "R", TypeSquare.EXIT);
        map[6][0].positionPoint.setPositionPoint(6,0);
        map[2][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "R", TypeSquare.EXIT);
        map[2][MAX_WITDH - 1].positionPoint.setPositionPoint(2,MAX_WITDH - 1);
        map[4][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "H", TypeSquare.EXIT);
        map[4][MAX_WITDH - 1].positionPoint.setPositionPoint(4,MAX_WITDH - 1);
        map[6][MAX_WITDH - 1] = new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "R", TypeSquare.EXIT);
        map[6][MAX_WITDH - 1].positionPoint.setPositionPoint(6,MAX_WITDH - 1);

    }

    /**
     * print the current state of map, which is similar to boardString but include information about
     * wall, exit and empty square
     */
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
     * transfer a tilePlacementString (i.e. SquareString) to Square
     * @param tilePlacementString is like "B1C54"
     * @return if valid string, return an instance of Square class. if tilePlacementString is invalid, return null.
     */
    public Square getSquareFormSquareString(String tilePlacementString)
    {
        if (tilePlacementString.length() != 5)
        {
            return null;
        }
        char dice = tilePlacementString.charAt(0);
        char face = tilePlacementString.charAt(1);
        char row = tilePlacementString.charAt(2);
        char col = tilePlacementString.charAt(3);
        char orientation = tilePlacementString.charAt(4);
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
        square.type=TypeSquare.TILE;
        return square;

    }

    /**
     * judge if two squaresa are connected?
     * @param tilePlacementA Square A
     * @param tilePlacementB Square B
     * @return are connected?
     */
    public boolean areConnectedSquares(String tilePlacementA, String tilePlacementB) {
        char rowA = tilePlacementA.charAt(2);
        int colA = tilePlacementA.charAt(3);
        int rowB = tilePlacementB.charAt(2);
        int colB = tilePlacementB.charAt(3);
        Square A = getSquareFormSquareString(tilePlacementA);
        Square B = getSquareFormSquareString(tilePlacementB);
        //determine whether A and B are neighbours
        if (rowA != rowB && colA != colB) {
            return false;
        } else {
            if (rowA == rowB) {
                if (colB - colA == 1) {  //A is on the left of B
                    if (A.right == B.left && A.right != TypeTile.BLOCK) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (colA - colB == 1) {  //A is on the right of B
                    if (A.left == B.right && A.left != TypeTile.BLOCK) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (colA == colB) {
                if (rowA - rowB == 1) {  //A is below B
                    if (A.top == B.bottom && A.top != TypeTile.BLOCK) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (rowB - rowA == 1) {  //A is above B
                    if (A.bottom == B.top && A.bottom != TypeTile.BLOCK) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    /**
     * judge if a square is connected to an exit
     * @param tilePlacementString SquareString
     * @return iff connected returns true
     */
    public Boolean isConnectedWithExit(String tilePlacementString) {
        int row = Character.getNumericValue(tilePlacementString.charAt(2)) - 9;
        int col = Character.getNumericValue(tilePlacementString.charAt(3)) + 1;
        Square tile = getSquareFormSquareString(tilePlacementString);

        if (row == 1) {
            if (col != 2 && col != 4 && col != 6) return false;
            return (tile.top == map[row - 1][col].bottom);
        }
        else if (row == 7) {
            if (col != 2 && col != 4 && col != 6) return false;
            return (tile.bottom == map[row + 1][col].top);
        }
        else if (col == 1) {
            if (row != 2 && row != 4 && row != 6) return false;
            return (tile.left == map[row][col - 1].right);
        }
        else if (col == 7) {
            if (row != 2 && row != 4 && row != 6) return false;
            return (tile.right == map[row][col + 1].left);
        }
        return false;
    }

    /**
     * get titleString's Position
     * @param tilePlacementString tilteString like 'A0B00'
     * @return PositionPoint x,y
     */
    public PositionPoint getPositionFromString(String tilePlacementString){
        int row = tilePlacementString.charAt(2)-'A'+1;
        int col = tilePlacementString.charAt(3)-'0'+1;
        PositionPoint positionPoint = new PositionPoint(row,col);
        return positionPoint;
    }

    /**
     * Judge if two tile is illegally placed, that is
     * when A=UP.bottom=Railway and B=Down.Top=Highway, return true
     * @param A
     * @param B
     * @return boolean
     */

    public boolean isIllegal(TypeTile A, TypeTile B){
        if (A==TypeTile.HIGHWAY && B==TypeTile.RAILWAY){return true;}
        else if (A==TypeTile.RAILWAY && B==TypeTile.HIGHWAY){return true;}
        else {return false;}
    }

    /**
     * Judge if a tile placement is valid in the current board state. Similar to Task 6 but for a single placement.
     * it judges whether it is true or not by placing the square on the map,
     * then checks all direction of valid and invalid connections.
     * @param square a placement square
     * @return true if there is a valid connection and there is no invalid connection to the placed tile.
     */
    public Boolean isValidPlacement(Square square) {
        if ( ! isEmptyPosition(square.positionPoint.getX(), square.positionPoint.getY())) return false;
        else if (square.positionPoint.getX()==-1 && square.positionPoint.getY()==-1) return false;
        else {
            Square upS = map[square.positionPoint.getX()-1][square.positionPoint.getY()];
            Square rightS = map[square.positionPoint.getX()][square.positionPoint.getY()+1];
            Square downS = map[square.positionPoint.getX()+1][square.positionPoint.getY()];
            Square leftS = map[square.positionPoint.getX()][square.positionPoint.getY()-1];

            if (isIllegal(upS.bottom,square.top) || isIllegal(rightS.left,square.right) ||
                    isIllegal(downS.top,square.bottom) || isIllegal(leftS.right,square.left)){
                return false;
            }
            else {
                if (upS.bottom==square.top && square.top!=TypeTile.BLOCK){ return true; }
                else if (rightS.left==square.right && square.right!=TypeTile.BLOCK){return true;}
                else if (downS.top==square.bottom && square.bottom!=TypeTile.BLOCK){return true;}
                else if (leftS.right==square.left && square.left!=TypeTile.BLOCK){return true;}
                else {return false;}
            }
        }
    }

    /**
     * Finds out if the current position x,y is empty or occupied by other tile. x,y similar to in PositionPoint
     * @param x col
     * @param y row
     * @return boolean
     */
    public boolean isEmptyPosition(int x, int y) {
        return (map[x][y].type == TypeSquare.EMPTY);
    }

    /**
     * Validate whether a given boardString can be placed in current board
     * @param boardString placementString(s) concatenated in ordered sequence, like 'A0A07A1A30S1B20'
     * @return boolean
     */
    public boolean isValidBoardStringPlacement(String boardString) {
        for (int i = 0; i < boardString.length(); i += 5) {
            String placementString = boardString.substring(i, i + 5);
            if ( ! isValidPlacement(getSquareFormSquareString(placementString))) {
                return false;
            } else {
                putPlacementStringToMap(placementString);
            }
        }
        return true;
    }

    /**
     * Given a dice, returns a possible placementString for that dice
     * if none is possible (for every combination of board position and dice orientation), returns an empty string
     * @param dice one of the dice rolled in this turn, like 'A0' or 'B1'
     * @return String placementString or emptyString
     */
    private String getPossibleDicePlacement(String dice) {
        String emptyString = "";
        for (char row='A'; row<='G'; row++) {
            for (char col='1'; col<='6'; col++) {
                for (char orientation='0'; orientation<='7'; orientation++) {
                    String placementString = dice + row + col + orientation;
                    if (isValidPlacement(getSquareFormSquareString(placementString))) {
                        return placementString;
                    }
                }
            }
        }
        return emptyString;
    }

    /**
     * Given a dice roll (group of dices), returns a possible sequence of placementString(s)
     * if none is possible (for every combination of dice order, board position and dice orientation), returns empty string
     * @param diceRoll all of the dices rolled in this turn, like 'A0A1A3B2' or 'A0A0A0B1'
     * @return String validPlacementSequence or emptyString
     */
    public String getPossibleDicePlacementSequence(String diceRoll) {
        int diceCount = diceRoll.length()/2;
        String emptyString = "";
        String validPlacementSequence = emptyString;

        List<String> availableDice = new ArrayList<>();
        for (int i=0; i<diceRoll.length(); i+=2) {
            availableDice.add(diceRoll.substring(i, i+2));
        }

        // uses getPossibleDicePlacement to determine whether a dice can be placed
        // if a placement is found, repeat for other dices that are still available
        for (int i=0; i < diceCount; i++) {
            for (int j=0; j < diceRoll.length(); j+=2) {
                String dice = diceRoll.substring(j, j+2);
                if (availableDice.contains(dice)) {
                    if ( ! getPossibleDicePlacement(dice).equals(emptyString)) {
                        String placementString = getPossibleDicePlacement(dice);
                        validPlacementSequence = validPlacementSequence.concat(placementString);
                        putPlacementStringToMap(placementString);
                        availableDice.remove(dice);
                    }
                }
            }
        }
        return validPlacementSequence;
    }

    /**
     * Counts how many exits are currently connected.
     * Would be used for tasks related to score generating.
     * does not take any parameters, counts using the current map variable
     * @param
     * @return number of connected exits
     */
    public int countConnectedExits() {
        int connectedExits = 0;

        return connectedExits;
    }

    /**
     * Counts how many dead ends are there in the board.
     * Would be used for tasks related to score generating.
     * does not take any parameters, counts using the current map variable
     * @param
     * @return number of dead ends.
     */
    public int countDeadEnds() {
        int deadEnds = 0;

        return deadEnds;
    }

    /**
     * cluster the exit .
     * List<List<Square>> squareClusters
     * use deep first method.
     *
     */
    private void getCluster()
    {
     ;
    }

    /**
     * Counts the longest distance with railway type in the current board.
     * Would be used for tasks related to score generating.
     * does not take any parameters, counts using the current map variable
     * @param
     * @return longest distance of typeTile RAILWAY
     */
    public int getLongestRailway() {
        int longestRailway = 0;

        return longestRailway;
    }

    /**
     * Counts the longest distance with highway type in the current board.
     * Would be used for tasks related to score generating.
     * does not take any parameters, counts using the current map variable
     * @param
     * @return longest distance with typeTile HIGHWAY
     */
    public int getLongestHighway() {
        int longestHighway = 0;

        return longestHighway;
    }

    /**
     * get the bonus score.
     *
     * @return bonus score.
     */
    public int getBonusScoring()
    {
        Square[][] squareRoutes = RouteUtil.findSquareLongestRoute(map, MAX_HEIGHT, MAX_WITDH);

        int maxHighWayRouteLength = - 1;
        int maxRailWayRouteLength = - 1;
        for (int i = 0; i < MAX_HEIGHT - 1; i++)
        {
            for (int j = 1; j < MAX_WITDH - 1; j++)
            {
                if (squareRoutes[i][j].longestRailWayRouteLength > maxRailWayRouteLength)
                {
                    maxRailWayRouteLength = squareRoutes[i][j].longestRailWayRouteLength;
                }
                if (squareRoutes[i][j].longestHighWayRouteLength > maxHighWayRouteLength)
                {
                    maxHighWayRouteLength = squareRoutes[i][j].longestHighWayRouteLength;
                }
            }
        }
        return maxHighWayRouteLength + maxRailWayRouteLength+getBasicScoring();

    }

    /**
     * put the placementString to map and javafx
     * @param placementString placementString
     */
    public void putPlacementStringToMap(String placementString)
    {
        for(int i=0;i<placementString.length();i+=5)
        {
            Square square =getSquareFormSquareString(placementString.substring(i,i+5));
            map[square.positionPoint.getX()][square.positionPoint.getY()] = square;

        }
    }

    public int getBasicScoring(){
        int bs=0;
        Square[][] m =this.map.clone();
        bs=ExitUtil.getExitScore(m)+ExitUtil.getCenterScore(m)-ExitUtil.getErrorScore(m);
        return bs;
    }
}
