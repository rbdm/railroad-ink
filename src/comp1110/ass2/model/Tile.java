package comp1110.ass2.model;


import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Square> squareSList = new ArrayList<>();
    private List<Square> squareAList = new ArrayList<>();
    private List<Square> squareBList = new ArrayList<>();

    public Tile()
    {
        //TODO Hao do S0-S5, Hadi do A0-A5, Yue do B0-B2
        addSquareS();
        addSquareA();
        addSquareB();


    }

    private void addSquareS()
    {
        //check by Yue
        //S0
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S00",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S01",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S02",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S03",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S04",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S05",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S06",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S07",TypeSquare.TILE));

        //S1
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S10",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S11",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S12",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S13",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S14",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S15",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S16",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S17",TypeSquare.TILE));

        //S2
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S20",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S21",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S22",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S23",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S24",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S25",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S26",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S27",TypeSquare.TILE));

        //S3
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S30",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S31",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S32",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S33",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S34",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S35",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S36",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S37",TypeSquare.TILE));

        //S4
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S40",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S41",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S42",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S43",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, true, "S44",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S45",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, true, "S46",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S47",TypeSquare.TILE));

        //S5
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S50",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S51",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S52",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S53",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S54",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S55",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, true, "S56",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, true, "S57",TypeSquare.TILE));

    }

    private void addSquareA()
    {
        //TODO: Hao check
    }

    private void addSquareB()
    {
        //TODO: Hadi check
        //TODO: Hadi check
        //B0
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B00",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B01",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B02",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B03",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B04",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B05",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B06",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B07",TypeSquare.TILE));

        //B1
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,true,"B10",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,true,"B11",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B12",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,true,"B13",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,true,"B14",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,true,"B15",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,true,"B16",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B17",TypeSquare.TILE));

        //B2
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B20",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B21",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B22",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B23",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B24",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B25",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B26",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B27",TypeSquare.TILE));

    }

}
