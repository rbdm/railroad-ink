package u6797258;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.util.ExitUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ExitUtilTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);
    @Test
    public void testGetExitScore(){
        String mapString="A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02";
        Board board = new Board();
        board.putPlacementStringToMap(mapString);
        Square[][] map=board.getMap();
        int exitScore = ExitUtil.getExitScore(map);
        int expect = 28;
        assertTrue(String.format("the expected answer is: %s, while get: %s",expect,exitScore),expect==exitScore);
    }
    @Test
    public void testGetErrorScore(){
        String mapString="A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02";
        Board board = new Board();
        board.putPlacementStringToMap(mapString);
        Square[][] map=board.getMap();
        int exitScore = ExitUtil.getErrorScore(map);
        int expect = 7;
        assertTrue(String.format("the expected answer is: %s, while get: %s",expect,exitScore),expect==exitScore);

    }
    @Test
    public void testGetCenterScore(){
        String mapString="A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02";
        Board board = new Board();
        board.putPlacementStringToMap(mapString);
        Square[][] map=board.getMap();
        int exitScore = ExitUtil.getCenterScore(map);
        int expect = 2;
        assertTrue(String.format("the expected answer is: %s, while get: %s",expect,exitScore),expect==exitScore);

    }
}
