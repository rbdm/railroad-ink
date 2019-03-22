package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;

public class Square
{
    private List<Tile> tileAList = new ArrayList<>();
    private List<Tile> tileBList = new ArrayList<>();
    private List<Tile> tileCList = new ArrayList<>();
    private List<Tile> tileOtherList = new ArrayList<>();

    public Square()
    {
        //TODO Hao do S0-S5, Hadi do A0-A5, Yue do B0-B2
        addTileA();
        addTileB();
        addTileC();

    }

    private void addTileA()
    {
        //TODO : Yue check.
        //S0
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S00"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S01"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S02"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S03"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S04"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S05"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S06"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S07"));

        //S1
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S10"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S11"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S12"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S13"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S14"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S15"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S16"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S17"));

        //S2
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S20"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S21"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S22"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S23"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S24"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S25"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S26"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S27"));

        //S3
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S30"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S31"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S32"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S33"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S34"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S35"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S36"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S37"));

        //S4
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S40"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S41"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S42"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S43"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S44"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S45"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S46"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S47"));

        //S5
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S50"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S51"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S52"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S53"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S54"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S55"));
        tileAList.add(new Tile(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S56"));
        tileAList.add(new Tile(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S57"));

    }

    private void addTileB()
    {
        //TODO: Hao check
    }

    private void addTileC()
    {
        //TODO: Hadi check
    }
}
