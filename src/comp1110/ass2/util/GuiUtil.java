package comp1110.ass2.util;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.EnumTypeTile;
import comp1110.ass2.model.Square;
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
        initialEmptyBoardGui(mapPanel, board, rootImgUrl);
        //check placement
        updateBoardGuiByPlacementString(board, placementString, rootImgUrl);
        return mapPanel;
    }

    private static void updateBoardGuiByPlacementString(Board board, String placementString, String rootImgUrl)
    {
        for (int i = 0; i < placementString.length(); i += 5)
        {
            String squareString = placementString.substring(i, i + 5);
            Square square = board.getSquareFromSquareString(squareString);

            Image image = new Image( rootImgUrl + squareString.substring(0, 2) + ".jpg");
            ImageView imageView = board.imageViews[square.positionPoint.getX()][square.positionPoint.getY()];
            imageView.setImage(image);
            imageView.setRotate(((squareString.charAt(4) - '0') % 4) * 90);
            imageView.setScaleX((squareString.charAt(4) - '0') < 4 ? 1 : - 1);
        }
    }

    private static void initialEmptyBoardGui(BorderPane mapPanel, Board board, String rootImgUrl)
    {
        for (int i = 0; i < board.getMap().length; i++)
        {
            for (int j = 0; j < board.getMap().length; j++)
            {
                Square square = board.getMap()[i][j];
                String name = rootImgUrl + "WALL.jpg";
                switch (square.type)
                {
                    case EXIT:
                        if (square.top == EnumTypeTile.RAILWAY || square.left == EnumTypeTile.RAILWAY || square.right == EnumTypeTile.RAILWAY || square.bottom == EnumTypeTile.RAILWAY)
                        {
                            name = rootImgUrl + "RailExit.jpg";
                        }
                        else if (square.top == EnumTypeTile.HIGHWAY || square.left == EnumTypeTile.HIGHWAY || square.right == EnumTypeTile.HIGHWAY || square.bottom == EnumTypeTile.HIGHWAY)
                        {
                            {
                                name = rootImgUrl + "HighExit.jpg";
                            }
                        }
                        break;
                    case WALL:
                        name = rootImgUrl + "WALL.jpg";
                        break;
                    case EMPTY:
                        name = rootImgUrl + "EMPTY.jpg";
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

                if (square.top != EnumTypeTile.BLOCK)
                {
                    imageView.setRotate(0);
                }
                else if (square.left != EnumTypeTile.BLOCK)
                {
                    imageView.setRotate(270);
                }
                else if (square.bottom != EnumTypeTile.BLOCK)
                {
                    imageView.setRotate(180);
                }
                else if (square.right != EnumTypeTile.BLOCK)
                {
                    imageView.setRotate(90);
                }
                board.imageViews[i][j] = imageView;
                mapPanel.getChildren().add(imageView);
            }
        }
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
