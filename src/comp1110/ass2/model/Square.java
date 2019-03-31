package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;

public class Square
{
    /**
     * top TileType
     */
    public TypeTile top;
    /**
     * right TileType
     */
    public TypeTile right;
    /**
     * bottom TileType
     */
    public TypeTile bottom;
    /**
     * left TileType
     */
    public TypeTile left;
    /**
     * is the center overpass?
     */
    public Boolean isOverpass;
    /**
     * Square name such as A0
     */
    public String name;
    /**
     * Square Type
     */
    public TypeSquare type;
    /**
     * Square position
     */
    public PositionPoint positionPoint=new PositionPoint(-1,-1);

    public int longestRailWayRouteLength=-1;

    public int longestHighWayRouteLength=-1;


    public Square(TypeTile top, TypeTile right, TypeTile bottom, TypeTile left, Boolean isOverpass, String name,TypeSquare type)
    {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
        this.isOverpass = isOverpass;
        this.name = name;
        this.type = type;
    }


}
