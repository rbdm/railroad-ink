package comp1110.ass2.model;

public class Square
{
    /**
     * top TileType
     */
    public EnumTypeTile top;
    /**
     * right TileType
     */
    public EnumTypeTile right;
    /**
     * bottom TileType
     */
    public EnumTypeTile bottom;
    /**
     * left TileType
     */
    public EnumTypeTile left;
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
    public EnumTypeSquare type;
    /**
     * Square position
     */
    public PositionPoint positionPoint=new PositionPoint(-1,-1);

    /**
     * longestRailwayLength though the square
     */
    public int longestRailWayRouteLength=-1;
    /**
     * longestHighwayLength though the square
     */
    public int longestHighWayRouteLength=-1;
    //TODO : add javadoc here.
    public boolean connectedByTwoWay=false;


    public Square(EnumTypeTile top, EnumTypeTile right, EnumTypeTile bottom, EnumTypeTile left, Boolean isOverpass, String name, EnumTypeSquare type)
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
