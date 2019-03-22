package comp1110.ass2.model;

public class Board {
    private static final int MAX_HEIGHT = 9;
    private static final int MAX_WITDH = 9;
    private Square[][] map = new Square[MAX_HEIGHT][MAX_WITDH];

    public Board()
    {
        InitialMap();
    }
    private void InitialMap()
    {
        //add wall
        for(int i=0;i<MAX_WITDH;i++)
        {

        }
    }

}
