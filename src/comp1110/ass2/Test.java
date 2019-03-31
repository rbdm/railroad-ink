package comp1110.ass2;

import comp1110.ass2.gui.Viewer;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.Tile;
import comp1110.ass2.util.RouteUtil;

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
        testTask12();
    }

    public static void testTask12()
    {
        Board board = new Board();
        board.putPlacementStringToMap("A4A10A1A30B2A40A1B01B2B10A1B21S1B32B1B44A4C10A5C31A4C41A5C53A4D01A3D13A5D23A3D50A4D61A4E20B1E31S2E40S4E50A1F01A2F11B1F24A1F30A0F51A1F61B0G12A2G30A1G41B1G52");
        //board.putPlacementStringToMap("A4A10B2B10");
        board.getBonusScoring();

    }
}
