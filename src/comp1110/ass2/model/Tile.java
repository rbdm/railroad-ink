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
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S00",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S01",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S02",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S03",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S04",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S05",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S06",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S07",TypeSquare.TILE));

        //S1
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S10",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S11",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S12",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S13",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S14",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S15",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S16",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S17",TypeSquare.TILE));

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
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S40",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S41",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S42",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S43",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "S44",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S45",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "S46",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S47",TypeSquare.TILE));

        //S5
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S50",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S51",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S52",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S53",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S54",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S55",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, false, "S56",TypeSquare.TILE));
        squareSList.add(new Square(TypeTile.RAILWAY, TypeTile.HIGHWAY, TypeTile.RAILWAY, TypeTile.HIGHWAY, false, "S57",TypeSquare.TILE));

    }

    private void addSquareA()
    {
        //check by Hao
        //A0
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A00", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "A01", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A02", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A03", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "A04", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A05", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A06", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A07", TypeSquare.TILE));

        //A1
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A10", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A11", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A12", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A13", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A14", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A15", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A16", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A17", TypeSquare.TILE));

        //A2
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A20", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A21", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A22", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A23", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A24", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, TypeTile.RAILWAY, false, "A25", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.BLOCK, false, "A26", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.RAILWAY, TypeTile.RAILWAY, TypeTile.RAILWAY, false, "A27", TypeSquare.TILE));

        //A3
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A30", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A31", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A32", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A33", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A34", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A35", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A36", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A37", TypeSquare.TILE));

        //A4
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A40", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A41", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A42", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A43", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A44", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A45", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A46", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A47", TypeSquare.TILE));

        //A5
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A50", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "A51", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A52", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A53", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, false, "A54", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, TypeTile.BLOCK, false, "A55", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, TypeTile.HIGHWAY, false, "A56", TypeSquare.TILE));
        squareAList.add(new Square(TypeTile.HIGHWAY, TypeTile.BLOCK, TypeTile.BLOCK, TypeTile.HIGHWAY, false, "A57", TypeSquare.TILE));
    }

    private void addSquareB()
    {
        //Checked by Hadi
        //B0
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,false,"B00",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,false,"B01",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,false,"B02",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,false,"B03",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,false,"B04",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.RAILWAY,false,"B05",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.BLOCK,false,"B06",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.HIGHWAY,false,"B07",TypeSquare.TILE));

        //B1
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,false,"B10",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.BLOCK,false,"B11",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,TypeTile.RAILWAY,false,"B12",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.HIGHWAY,false,"B13",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,false,"B14",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,TypeTile.BLOCK,false,"B15",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.BLOCK,false,"B16",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.BLOCK,TypeTile.BLOCK,TypeTile.RAILWAY,TypeTile.HIGHWAY,false,"B17",TypeSquare.TILE));

        //B2
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B20",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B21",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B22",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B23",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B24",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B25",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,true,"B26",TypeSquare.TILE));
        squareBList.add(new Square(TypeTile.RAILWAY,TypeTile.HIGHWAY,TypeTile.RAILWAY,TypeTile.HIGHWAY,true,"B27",TypeSquare.TILE));

    }

    public List<Square> getSquareList(char dice)
    {
        switch (dice)
        {
            case 'A':return squareAList;
            case 'B':return  squareBList;
            case 'S':return  squareSList;
            default:return null;
        }
    }

}
