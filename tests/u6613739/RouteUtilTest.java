package u6613739;

import comp1110.ass2.model.*;
import comp1110.ass2.util.RouteUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * User: u6613739
 * Date: 2019/5/6
 * Time: 12:44
 * Description:
 */
public class RouteUtilTest
{
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);
    @Test
    public void testGetAccessDirectionNormalHighWay()
    {
        //right
        Square square = new Square(EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,true,"test", EnumTypeSquare.TILE);
        List<RouteUtil.Direction> result = RouteUtil.getAccessDirection(square, EnumTypeTile.HIGHWAY, RouteUtil.Direction.RIGHT);
        assertTrue(result.toString()+" is not equals to expect:[TOP, RIGHT, BOTTOM]",result.toString().equals("[TOP, RIGHT, BOTTOM]"));
        //left
        square = new Square(EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.HIGHWAY, RouteUtil.Direction.LEFT);
        assertTrue(result.toString()+" is not equals to expect:[TOP, BOTTOM, LEFT]",result.toString().equals("[TOP, BOTTOM, LEFT]"));
        //top
        square = new Square(EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.HIGHWAY, RouteUtil.Direction.TOP);
        assertTrue(result.toString()+" is not equals to expect:[TOP, RIGHT, LEFT]",result.toString().equals("[TOP, RIGHT, LEFT]"));
        //bottom
        square = new Square(EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,EnumTypeTile.HIGHWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.HIGHWAY, RouteUtil.Direction.BOTTOM);
        assertTrue(result.toString()+" is not equals to expect:[RIGHT, BOTTOM, LEFT]",result.toString().equals("[RIGHT, BOTTOM, LEFT]"));

    }
    @Test
    public void testGetAccessDirectionNormalRailWay()
    {
        //right
        Square square = new Square(EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,true,"test", EnumTypeSquare.TILE);
        List<RouteUtil.Direction> result = RouteUtil.getAccessDirection(square, EnumTypeTile.RAILWAY, RouteUtil.Direction.RIGHT);
        assertTrue(result.toString()+" is not equals to expect:[TOP, RIGHT, BOTTOM]",result.toString().equals("[TOP, RIGHT, BOTTOM]"));
        //left
        square = new Square(EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.RAILWAY, RouteUtil.Direction.LEFT);
        assertTrue(result.toString()+" is not equals to expect:[TOP, BOTTOM, LEFT]",result.toString().equals("[TOP, BOTTOM, LEFT]"));
        //top
        square = new Square(EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.RAILWAY, RouteUtil.Direction.TOP);
        assertTrue(result.toString()+" is not equals to expect:[TOP, RIGHT, LEFT]",result.toString().equals("[TOP, RIGHT, LEFT]"));
        //bottom
        square = new Square(EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,EnumTypeTile.RAILWAY,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.RAILWAY, RouteUtil.Direction.BOTTOM);
        assertTrue(result.toString()+" is not equals to expect:[RIGHT, BOTTOM, LEFT]",result.toString().equals("[RIGHT, BOTTOM, LEFT]"));

    }

    @Test
    public void testGetAccessDirectionNullOrWall()
    {
        //null
        List<RouteUtil.Direction> result = RouteUtil.getAccessDirection(null, EnumTypeTile.RAILWAY, RouteUtil.Direction.BOTTOM);
        assertTrue(result.toString()+" is not equals to expect:[]",result.toString().equals("[]"));
        //WALL
        Square square = new Square(EnumTypeTile.BLOCK,EnumTypeTile.BLOCK,EnumTypeTile.BLOCK,EnumTypeTile.BLOCK,true,"test", EnumTypeSquare.TILE);
        result = RouteUtil.getAccessDirection(square, EnumTypeTile.RAILWAY, RouteUtil.Direction.RIGHT);
        assertTrue(result.toString()+" is not equals to expect:[]",result.toString().equals("[]"));

    }
    @Test
    public void  testIsLoopNormall()
    {
        List<PositionPoint> trackingList = new ArrayList<>();
        trackingList.add(new PositionPoint(1,1));
        trackingList.add(new PositionPoint(1,2));
        trackingList.add(new PositionPoint(1,3));
        trackingList.add(new PositionPoint(1,4));
        PositionPoint testPoint = new PositionPoint(1,5);
        assertFalse("trackinglist contains point",RouteUtil.isLoop(testPoint,trackingList));

        testPoint = new PositionPoint(1,4);
        assertTrue("trackinglist need contains point ",RouteUtil.isLoop(testPoint,trackingList));

    }
    @Test
    public void testIsLoopEmptyOrNull()
    {
        //empty trackinglist
        List<PositionPoint> trackingList = new ArrayList<>();
        PositionPoint testPoint = new PositionPoint(1,5);
        assertFalse("trackinglist contains point",RouteUtil.isLoop(testPoint,trackingList));

        //null trackinglist
        testPoint = new PositionPoint(1,5);
        assertFalse("trackinglist contains point",RouteUtil.isLoop(testPoint,null));

        //null testPoint
        assertFalse("trackinglist contains point",RouteUtil.isLoop(null,trackingList));

    }
}
