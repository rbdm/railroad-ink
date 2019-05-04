package comp1110.ass2.model;


import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Square> squareSList = new ArrayList<>();
    private List<Square> squareAList = new ArrayList<>();
    private List<Square> squareBList = new ArrayList<>();

    public Tile()
    {
        addSquareS();
        addSquareA();
        addSquareB();
    }

    private void addSquareS()
    {
        //check by Yue
        //S0
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S00", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S01", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S02", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S03", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S04", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S05", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S06", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S07", EnumTypeSquare.TILE));

        //S1
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S10", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S11", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S12", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S13", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S14", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S15", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S16", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S17", EnumTypeSquare.TILE));

        //S2
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S20", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S21", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S22", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S23", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S24", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S25", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S26", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S27", EnumTypeSquare.TILE));

        //S3
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S30", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S31", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S32", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S33", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S34", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S35", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S36", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S37", EnumTypeSquare.TILE));

        //S4
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S40", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S41", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S42", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S43", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "S44", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S45", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "S46", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S47", EnumTypeSquare.TILE));

        //S5
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S50", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S51", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S52", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S53", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S54", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S55", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, false, "S56", EnumTypeSquare.TILE));
        squareSList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, false, "S57", EnumTypeSquare.TILE));

    }

    private void addSquareA()
    {
        //check by Hao
        //A0
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A00", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, false, "A01", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A02", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A03", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, false, "A04", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A05", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A06", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A07", EnumTypeSquare.TILE));

        //A1
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A10", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A11", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A12", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A13", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A14", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A15", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A16", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A17", EnumTypeSquare.TILE));

        //A2
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A20", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A21", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A22", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A23", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A24", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, false, "A25", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, false, "A26", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, EnumTypeTile.RAILWAY, false, "A27", EnumTypeSquare.TILE));

        //A3
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A30", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A31", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A32", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A33", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A34", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A35", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A36", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A37", EnumTypeSquare.TILE));

        //A4
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A40", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A41", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A42", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A43", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A44", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A45", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A46", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A47", EnumTypeSquare.TILE));

        //A5
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A50", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, false, "A51", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A52", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A53", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, false, "A54", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, false, "A55", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.HIGHWAY, false, "A56", EnumTypeSquare.TILE));
        squareAList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, false, "A57", EnumTypeSquare.TILE));
    }

    private void addSquareB()
    {
        //Checked by Hadi
        //B0
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK,false,"B00", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY,false,"B01", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK,false,"B02", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY,false,"B03", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK,false,"B04", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY,false,"B05", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK,false,"B06", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY,false,"B07", EnumTypeSquare.TILE));

        //B1
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK,false,"B10", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK,false,"B11", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY,false,"B12", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.HIGHWAY,false,"B13", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY,false,"B14", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK, EnumTypeTile.BLOCK,false,"B15", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.BLOCK,false,"B16", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.BLOCK, EnumTypeTile.BLOCK, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY,false,"B17", EnumTypeSquare.TILE));

        //B2
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY,true,"B20", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY,true,"B21", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY,true,"B22", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY,true,"B23", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY,true,"B24", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY,true,"B25", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY,true,"B26", EnumTypeSquare.TILE));
        squareBList.add(new Square(EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY, EnumTypeTile.RAILWAY, EnumTypeTile.HIGHWAY,true,"B27", EnumTypeSquare.TILE));

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
