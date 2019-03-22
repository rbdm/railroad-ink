package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Tile> TileA =new ArrayList<>();
    List<Tile> TileB =new ArrayList<>();
    List<Tile> TileS =new ArrayList<>();


    public Square()
    {
        //TODO square.
        //TODO Hao do S0-S5, Hadi do A0-A5, Yue do B0-B2
        addTileA();
        addTileB();
        addTileC();

    }

    private void addTileA()
    {
        //S0
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S00"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S01"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S02"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S03"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S04"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S05"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S06"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S07"));

        //S1
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S10"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S11"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S12"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S13"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S14"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S15"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S16"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S17"));

        //S2
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S20"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S21"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S22"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S23"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S24"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S25"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S26"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S27"));

        //S3
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S30"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S31"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S32"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S33"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S34"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S35"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S36"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S37"));

        //S4
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S40"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S41"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S42"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S43"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S44"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S45"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S46"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S47"));

        //S5
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S50"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S51"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S52"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S53"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S54"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S55"));
        TileA.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S56"));
        TileA.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S57"));

    }

    private void addTileB()
    {

    }
    private void addTileC()
    {

    }
}
