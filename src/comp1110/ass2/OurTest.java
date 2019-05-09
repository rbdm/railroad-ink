package comp1110.ass2;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.util.ExitUtil;
import comp1110.ass2.util.PlacementUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: u6613739
 * Date: 2019/3/31
 * Time: 19:11
 * Description:
 */
public class OurTest
{
//    @Rule
//    public Timeout globalTimeout = Timeout.millis(2000);
    @Test
    public void testTask12()
    {
        Board board = new Board();
        board.putPlacementStringToMap("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33B0A30S4E11A4E21A3C21A3C31S5F11");
        //board.putPlacementStringToMap("A4A10B2B10");
        board.getBonusScoring();
    }

    @Test
    public void testTask8() {
        Board board = new Board();

        board.putPlacementStringToMap("A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02");
        Square[][] mapOfBoard=board.getMap();
        int basic=board.getBasicScoring();

        System.out.println(basic);
        int exitScore = ExitUtil.getExitScore(mapOfBoard);
        int errorScore=ExitUtil.getErrorScore(mapOfBoard);
        int centerScore=ExitUtil.getCenterScore(mapOfBoard);
        System.out.print("exit "+exitScore+", center "+centerScore+", error "+errorScore);
        //List<Square> X = ExitUtil.getConnectedNeighbour(map[0][2],map,EnumTypeTile.BLOCK);
        //List<Square> X = ExitUtil.allRoute(map[1][6], map, map[0][6], new ArrayList<>());
        //System.out.println(conType(map[2][2],map[2][1]));
        //System.out.println(map[0][2].positionPoint.getY());
        //for (Square i : X) {
        //    System.out.print("[" + i.positionPoint.getX() + "," + i.positionPoint.getY() + "]");
        //}
        System.out.println();

    }
    @Test
    public void testPlacementUtil()
    {
        PlacementUtil.getPlacementByGreedyAlgorithm("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33B0A30S4E11A4E21A3C21A3C31","S5",true);
    }

    public static void main(String[] args)
    {
        PlacementUtil.getPlacementByGreedyAlgorithm("A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52","A0",true);

    }

    /**
     * Tests running task 10 (generateMove) with some predefined boardString and diceRoll
     * Then checks if the output string equals to EXPECTED_MOVES using assertEquals method
     */
    @Test
    public void testTask10() {
        int indexOfExpectedMove = 0;
        for (String bs : BOARD_STRINGS) {
            for (String dr : DICE_ROLLS) {
                assertEquals(EXPECTED_MOVES[indexOfExpectedMove], RailroadInk.generateMove(bs, dr));
                indexOfExpectedMove++;
            }
        }
    }

    // Uses some conditions of board string: filled, rarely filled, and empty.
    private String[] BOARD_STRINGS = {
            "A3D53A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33B0A30S4E11A4E21A3C21",
            "A4A50A1A30A1G30B0F30",
            ""};

    // Uses some conditions of diceRoll: 4 dices, 2 dices, 1 dice and no dice.
    private String[] DICE_ROLLS = {
            "A0A0A0B1",
            "A1A2A3B0",
            "S1B2",
            "S2",
            "",
    };

    private String[] EXPECTED_MOVES = {
            "A0A20A0A52A0B40B1A41",
            "A1A21A2A51A3C31B0A43",
            "S1A20B2A50",
            "S2C30",
            "",
            "A0B30A0B21A0A22B1A10",
            "A1B30A2B60A3A10B0A23",
            "S1A10B2A20",
            "S2A10",
            "",
            "A0A30A0A21A0B61B1A10",
            "A1A30A2B30A3A10B0A23",
            "S1A10B2A20",
            "S2A10",
            "",
    };
}
