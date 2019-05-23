package u6613739;

import comp1110.ass2.util.PlacementUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

/**
 * User: u6613739
 * Date: 2019/5/23
 * Time: 23:09
 * Description:
 */
public class SoftMaxTest
{
    @Test
    public void SoftMaxNormalTest()
    {
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        String result = PlacementUtil.softmax(map);
        assertTrue("the result is: "+result+" while the ref is: A",result.equals("A"));
    }
    @Test
    public void SoftMaxEmptyTest()
    {
        Map<String, Integer> map = new HashMap<>();
        String result = PlacementUtil.softmax(map);
        assertTrue("the result is: "+result+" while the ref is: A",result.equals(""));
    }


}
