package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;

public class Square
{
    public TypeTile top;
    public TypeTile right;
    public TypeTile bottom;
    public TypeTile left;
    public Boolean isOverpass;
    public String name;
    public TypeSquare type;
    public PositionPoint positionPoint=new PositionPoint(-1,-1);


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
