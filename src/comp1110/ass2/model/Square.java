package comp1110.ass2.model;

import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Tile> TileA =new ArrayList<>();
    List<Tile> TileB =new ArrayList<>();
    List<Tile> TileS =new ArrayList<>();


    public Square()
    {
        //TODO Hao do S0-S5, Hadi do A0-A5, Yue do B0-B2
        addTileS();
        addTileA();
        addTileB();

    }

    private void addTileS()
    {
        //checked by Yue
        //S0
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S00"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S01"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S02"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S03"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S04"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S05"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S06"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S07"));

        //S1
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S10"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S11"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S12"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S13"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S14"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S15"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S16"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S17"));

        //S2
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S20")); // no station
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S21"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S22"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S23"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S24"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S25"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S26"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,false,"S27"));

        //S3
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S30")); // no station
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S31"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S32"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S33"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S34"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S35"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S36"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,false,"S37"));

        //S4
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S40"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S41"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S42"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S43"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,true,"S44"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S45"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.HIGHWAY,true,"S46"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S47"));

        //S5
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S50"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S51"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S52"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S53"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S54"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S55"));
        TileS.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"S56"));
        TileS.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"S57"));

    }

    private void addTileA()
    {
        //TODO: Hao check
    }
    private void addTileB()
    {
        //TODO: Hadi check
        //B0
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B00"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B01"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B02"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B03"));
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B04"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B05"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B06"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B07"));

        //B1
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,true,"B10"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B11"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B12"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B13"));
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B14"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,true,"B15"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B16"));
        TileB.add(new Tile(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B17"));

        //B2
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B20"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B21"));
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B22"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B23"));
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B24"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B25"));
        TileB.add(new Tile(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B26"));
        TileB.add(new Tile(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B27"));
    }
}
