package comp1110.ass2.model;

/**
 * User: u6613739
 * Date: 2019/3/22
 * Time: 22:08
 * Description:
 */
public class PositionPoint
{
    private int x;
    private int y;

    public PositionPoint(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void setPositionPoint(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}
