package comp1110.ass2.model;


import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Square> squareAList = new ArrayList<>();
    private List<Square> squareBList = new ArrayList<>();
    private List<Square> squareCList = new ArrayList<>();
    private List<Square> squareOtherList = new ArrayList<>();

    public Tile()
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
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S00"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S01"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S02"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S03"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S04"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S05"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S06"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S07"));

        //S1
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S10"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S11"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S12"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S13"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S14"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S15"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S16"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S17"));

        //S2
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S20"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S21"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S22"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S23"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S24"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S25"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S26"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S27"));

        //S3
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S30"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S31"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S32"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S33"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S34"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S35"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S36"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S37"));

        //S4
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S40"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S41"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S42"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S43"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S44"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S45"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S46"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S47"));

        //S5
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S50"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S51"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S52"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S53"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S54"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S55"));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S56"));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S57"));

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
