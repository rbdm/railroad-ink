package comp1110.ass2.model;


import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Square> squareAList = new ArrayList<>();
    private List<Square> squareBList = new ArrayList<>();
    private List<Square> squareCList = new ArrayList<>();

    public Tile()
    {
        //TODO Hao do S0-S5, Hadi do A0-A5, Yue do B0-B2
        addSquareA();
        addSquareB();
        addSquareC();


    }

    private void addSquareA()
    {
        //TODO : Yue check.
        //S0
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S00",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S01",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S02",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S03",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S04",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S05",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S06",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S07",TypeSquare.TILE));

        //S1
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S10",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S11",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S12",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S13",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S14",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S15",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S16",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S17",TypeSquare.TILE));

        //S2
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S20",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S21",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S22",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S23",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S24",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S25",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S26",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S27",TypeSquare.TILE));

        //S3
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S30",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S31",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S32",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S33",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S34",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S35",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S36",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S37",TypeSquare.TILE));

        //S4
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S40",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S41",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S42",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S43",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S44",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S45",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S46",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S47",TypeSquare.TILE));

        //S5
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S50",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S51",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S52",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S53",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S54",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S55",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S56",TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S57",TypeSquare.TILE));

    }

    private void addSquareB()
    {
        //TODO: Hao check
    }

    private void addSquareC()
    {
        //TODO: Hadi check
    }

}
