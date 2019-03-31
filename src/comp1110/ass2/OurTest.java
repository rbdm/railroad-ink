package comp1110.ass2;

import comp1110.ass2.model.Board;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

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
        board.putPlacementStringToMap("A4A10A1A30B2A40A1B01B2B10A1B21S1B32B1B44A4C10A5C31A4C41A5C53A4D01A3D13A5D23A3D50A4D61A4E20B1E31S2E40S4E50A1F01A2F11B1F24A1F30A0F51A1F61B0G12A2G30A1G41B1G52");
        //board.putPlacementStringToMap("A4A10B2B10");
        board.getBonusScoring();
    }
}
