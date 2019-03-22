package comp1110.ass2.model;


public class Tile {
    public TypeTile top;
    public TypeTile right;
    public TypeTile bottom;
    public TypeTile left;
    public Boolean isStation;
    public String name;

    public Tile(TypeTile top, TypeTile right, TypeTile bottom, TypeTile left, Boolean isStation, String name)
    {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
        this.isStation = isStation;
        this.name = name;
    }
}
