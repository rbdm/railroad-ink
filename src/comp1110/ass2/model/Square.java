package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;

public class Square
{
    public TypeTile top;
    public TypeTile right;
    public TypeTile bottom;
    public TypeTile left;
    public Boolean isStation;
    public String name;
    public TypeSquare type;

    public Square(TypeTile top, TypeTile right, TypeTile bottom, TypeTile left, Boolean isStation, String name,TypeSquare type)
    {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
        this.isStation = isStation;
        this.name = name;
        this.type = type;
    }

}
