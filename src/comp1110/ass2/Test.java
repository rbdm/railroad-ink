package comp1110.ass2;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.Tile;

/**
 * User: u6613739
 * Date: 2019/3/22
 * Time: 20:05
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        Board board = new Board();
        Tile tile = new Tile();
        board.isValidPlacement(tile.getSquareList('A').get(0));
    }
}
