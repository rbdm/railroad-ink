package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoreGenerateMoveTest {

    /**
     * Tests running task 10 (generateMove) with some predefined boardString and diceRoll
     * Then checks if the output string equals to EXPECTED_MOVES using assertEquals method
     * Compared to generateMoveTest, it added a test for one EXPECTED_MOVES option
     */
    @Test
    public void testOneOption() {
        int indexOfExpectedMove = 0;
        for (String bs : BOARD_STRINGS) {
            for (String dr : DICE_ROLLS) {
                assertEquals(EXPECTED_MOVES[indexOfExpectedMove], RailroadInk.generateMove(bs, dr));
                indexOfExpectedMove++;
            }
        }
    }

    /*
    @Test (expected = StringIndexOutOfBoundsException.class)
    public void testTask10OB() {
        RailroadInk.generateMove("A3D53A0", "A3");
    }
    */


    // Uses some conditions of board string: filled, rarely filled, and empty.
    private String[] BOARD_STRINGS = {
            "A3D53A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33B0A30S4E11A4E21A3C21",
            "A4A50A1A30A1G30B0F30",
            ""
    };

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