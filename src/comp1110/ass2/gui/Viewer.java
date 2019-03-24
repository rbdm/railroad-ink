package comp1110.ass2.gui;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.TypeTile;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement)
    {
        // FIXME Task 4: implement the simple placement viewer
        //        if (RailroadInk.isBoardStringWellFormed(placement) == false)
        //        {
        //            return;
        //        }
        BorderPane mapPanel = new BorderPane();
        Board board = new Board();
        for (Node node : controls.getChildren())
        {
            if (node.getClass().equals(BorderPane.class))
            {
                controls.getChildren().remove(node);
                break;
            }
        }
        controls.getChildren().add(mapPanel);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                Square square = board.getMap()[i][j];
                String name = URI_BASE + "WALL.png";
                switch (square.type)
                {
                    case EXIT:
                        if (square.top == TypeTile.RAILWAY || square.left == TypeTile.RAILWAY || square.right == TypeTile.RAILWAY || square.bottom == TypeTile.RAILWAY)
                        {
                            name = URI_BASE + "RailExit.png";
                        }
                        else if (square.top == TypeTile.HIGHWAY || square.left == TypeTile.HIGHWAY || square.right == TypeTile.HIGHWAY || square.bottom == TypeTile.HIGHWAY)
                        {
                            {
                                name = URI_BASE + "HighExit.png";
                            }
                        }
                        break;
                    case WALL:
                        name = URI_BASE + "WALL.png";
                        break;
                    case EMPTY:
                        name = URI_BASE + "EMPTY.png";
                        break;
                    default:
                        name = URI_BASE + "Board.jpg";
                        break;
                }
                Image image = new Image(this.getClass().getResource("") + name);
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
        for (int i = 0; i < placement.length(); i += 5)
        {
            String squareString = placement.substring(i, i + 5);
            Square square = board.getSquareFormSquareString(squareString);

            Image image = new Image(this.getClass().getResource("") + URI_BASE + squareString.substring(0, 2) + ".png");
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


    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
