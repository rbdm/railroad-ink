package u6613739;

import comp1110.ass2.model.Player;
import comp1110.ass2.util.PlacementUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: u6613739
 * Date: 2019/5/9
 * Time: 11:59
 * Description:
 */
public class GreedyTest
{
//    @Rule
//    public Timeout globalTimeout = Timeout.millis(2000);
    @Test
    public void testGreedyNormal()
    {
        Player x =new Player("123","AI","Hard");
        x.round=0;
        x.usedSpeicalTile=0;
        String map ="";
        String diceRoll = "A3A0B2";
        String ref = "A4E41";
        String result = PlacementUtil.getResults(map,diceRoll,x);
        assertTrue(String.format("the expected ref is: %s, while the res is: %s",ref,result),ref.equals(result));


    }
//    @Test
//    public void testSpecial()
//    {
//        String map ="A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31";
//        String diceRoll = "";
//        String ref = "S5F11";
//        String result = PlacementUtil.getPlacementByGreedyAlgorithm(map,diceRoll,false);
//        assertTrue(String.format("the expected ref is: %s, while the res is: %s",ref,result),ref.equals(result));
//
//    }
//    @Test
//    public void testGreedyCanNotPut()
//    {
//
//        String map ="A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11A4C41A4F21A4A50A4G50A4F50A4E50";
//        String diceRoll = "A4";
//        String ref = "";
//        String result = PlacementUtil.getPlacementByGreedyAlgorithm(map,diceRoll,false);
//        assertTrue(String.format("the expected ref is: %s, while the res is: %s",ref,result),ref.equals(result));
//    }
//    @Test
//    public void testGreedyEmpty()
//    {
//        String ref = "A1A30";
//        String result = PlacementUtil.getPlacementByGreedyAlgorithm("","A1",false);
//        assertTrue(String.format("the expected ref is: %s, while the res is: %s",ref,result),ref.equals(result));
//
//        ref = "";
//        result = PlacementUtil.getPlacementByGreedyAlgorithm("","",false);
//        assertTrue(String.format("the expected ref is: %s, while the res is: %s",ref,result),ref.equals(result));
//
//    }
}
