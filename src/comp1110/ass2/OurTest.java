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

    @Test
    public void testTask8() {
        Board board = new Board();

        board.putPlacementStringToMap("A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02");
        board.getBasicScoring();
        /** Square[][] map = board.getMap();
        List<Square> X = ExitUtil.getConnectedExit(map[6][0],map);
        int xxex = getExitScore(map);
        int xxer=getErrorScore(map);
        int xxce=getCenterScore(map);
        System.out.print(xxex+","+xxer+","+xxce);
        //List<Square> X = ExitUtil.getConnectedNeighbour(map[0][2],map,TypeTile.BLOCK);
        //List<Square> X = ExitUtil.allRoute(map[1][6], map, map[0][6], new ArrayList<>());
        //System.out.println(conType(map[2][2],map[2][1]));
        //System.out.println(map[0][2].positionPoint.getY());
        for (Square i : X) {
            System.out.print("[" + i.positionPoint.getX() + "," + i.positionPoint.getY() + "]");
        }
        System.out.println(); */

    }

}
