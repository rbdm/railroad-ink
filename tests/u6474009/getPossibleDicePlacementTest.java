package u6474009;

import comp1110.ass2.RailroadInk;
import comp1110.ass2.model.Board;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class getPossibleDicePlacementTest {

    @Test
    public void testNormalBoards() {
        int resultIndex = 0;
        for (String bs : NORMAL_BOARD_STRINGS) {
            for (String d : VALID_DICES) {
                Board board = new Board();
                board.putPlacementStringToMap(bs);
                Assert.assertEquals(EXPECTED_RESULT[resultIndex], board.getPossibleDicePlacement(d));
                resultIndex++;
            }
        }
    }

    /**
     * Checks if always returns empty when board is full.
     */
    @Test
    public void testFullBoard() {
        for (String d : VALID_DICES) {
            Board board = new Board();
            board.putPlacementStringToMap(FULL_BOARD_STRING);
            Assert.assertEquals("", board.getPossibleDicePlacement(d));
        }
    }


    @Test (expected = IllegalArgumentException.class)
    public void testIllegalDice() {
        for (String bs : NORMAL_BOARD_STRINGS) {
            for (String d : INVALID_DICES) {
                Board board = new Board();
                board.putPlacementStringToMap(bs);
                board.getPossibleDicePlacement(d);
            }
        }
    }

    private String[] NORMAL_BOARD_STRINGS = {
            "A3D53A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33B0A30S4E11A4E21A3C21",
            ""
    };

    private String FULL_BOARD_STRING = "A0F00A0B00A0A31B1A14A0B61A0F61A0G32B1D61A0G43A0A62A0E61B1G56S1G60A0E03A0A03B1G12A0G02S0A50A0B50A5D03B1B40A0A40";


    private String[] VALID_DICES = {
            "A0",
            "A1",
            "S5",
            "B2"
    };

    private String[] INVALID_DICES = {
            "A9",
            "S9"
    };

    private String[] EXPECTED_RESULT = {
            "A0A20",
            "A1A21",
            "S5A20",
            "B2A20",
            "A0A30",
            "A1A30",
            "S5A10",
            "B2A10",
    };
}