package comp1110.ass2.util;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeTile;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * User: u6613739
 * Date: 2019/4/3
 * Time: 14:24
 * Description: It's a class to controll GUI
 */
public class GuiUtil
{
    /**
     * update the viewer window and the Board by Placement String
     * @param mapPanel all the square's ImageView will place in this panel
     * @param board the Board
     * @param placementString the current placement in String
     * @param rootImgUrl the root URI of Images.
     * @return
     */
    public static BorderPane updateGuiByPlacementString(BorderPane mapPanel, Board board, String placementString,String rootImgUrl)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                Square square = board.getMap()[i][j];
                String name = rootImgUrl + "WALL.png";
                switch (square.type)
                {
                    case EXIT:
                        if (square.top == TypeTile.RAILWAY || square.left == TypeTile.RAILWAY || square.right == TypeTile.RAILWAY || square.bottom == TypeTile.RAILWAY)
                        {
                            name = rootImgUrl + "RailExit.png";
                        }
                        else if (square.top == TypeTile.HIGHWAY || square.left == TypeTile.HIGHWAY || square.right == TypeTile.HIGHWAY || square.bottom == TypeTile.HIGHWAY)
                        {
                            {
                                name = rootImgUrl + "HighExit.png";
                            }
                        }
                        break;
                    case WALL:
                        name = rootImgUrl + "WALL.png";
                        break;
                    case EMPTY:
                        name = rootImgUrl + "EMPTY.png";
                        break;
                    default:
                        name = rootImgUrl + "Board.jpg";
                        break;
                }
                Image image = new Image( name);
                ImageView imageView = new ImageView(image);
                imageView.setX(j * 80);
                imageView.setY(i * 80);
                imageView.setFitHeight(80);
                imageView.setFitWidth(80);

                if (square.top != TypeTile.BLOCK)
                {
                    imageView.setRotate(0);
                }
                else if (square.left != TypeTile.BLOCK)
                {
                    imageView.setRotate(270);
                }
                else if (square.bottom != TypeTile.BLOCK)
                {
                    imageView.setRotate(180);
                }
                else if (square.right != TypeTile.BLOCK)
                {
                    imageView.setRotate(90);
                }
                board.imageViews[i][j] = imageView;
                mapPanel.getChildren().add(imageView);
            }
        }
        //check placement
        for (int i = 0; i < placementString.length(); i += 5)
        {
            String squareString = placementString.substring(i, i + 5);
            Square square = board.getSquareFormSquareString(squareString);

            Image image = new Image( rootImgUrl + squareString.substring(0, 2) + ".png");
            ImageView imageView = board.imageViews[square.positionPoint.getX()][square.positionPoint.getY()];
            imageView.setImage(image);

            switch (squareString.charAt(4))
            {
                case '0':
                    imageView.setRotate(0);
                    imageView.setScaleX(1);
                    break;
                case '1':
                    imageView.setRotate(90);
                    imageView.setScaleX(1);
                    break;
                case '2':
                    imageView.setRotate(180);
                    imageView.setScaleX(1);
                    break;
                case '3':
                    imageView.setRotate(270);
                    imageView.setScaleX(1);
                    break;
                case '4':
                    imageView.setRotate(0);
                    imageView.setScaleX(- 1);
                    break;
                case '5':
                    imageView.setRotate(90);
                    imageView.setScaleX(- 1);
                    break;
                case '6':
                    imageView.setRotate(180);
                    imageView.setScaleX(- 1);
                    break;
                case '7':
                    imageView.setRotate(270);
                    imageView.setScaleX(- 1);
                    break;
            }
        }
        return mapPanel;
    }

    /**
     * clean the canvas
     * @param canvas canvas
     */
    public static void cleanCanvas(Group canvas)
    {

        for (Node node : canvas.getChildren())
        {
            if (node.getClass().equals(BorderPane.class))
            {
                canvas.getChildren().remove(node);
                break;
            }
        }
    }
}