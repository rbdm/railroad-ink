package comp1110.ass2;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.util.ExitUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;

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
        board.putPlacementStringToMap("A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11");
        //board.putPlacementStringToMap("A4A10B2B10");
        board.getBonusScoring();
    }

}
