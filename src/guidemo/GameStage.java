package guidemo;

import com.sun.media.jfxmedia.events.PlayerEvent;
import comp1110.ass2.gui.Viewer;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.Player;
import comp1110.ass2.RailroadInk;
import comp1110.ass2.model.Tile;
import comp1110.ass2.util.StageManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class GameStage implements Initializable {
    public static int totalPlayerNum=1;
    public int currentPlayer=1;
    public int round=1;
    String playerType;
    public String boardString;
    public String roundString;
    List<Integer> usedSpecialTile=new ArrayList<>();
    public String diceRoll;
    private final int SQUARE_SIZE = 60;

    /* initialize game board */
    private Board board = new Board();

    public class fixedTile extends ImageView{
        fixedTile(){
            this.setFitHeight(SQUARE_SIZE);
            this.setFitWidth(SQUARE_SIZE);

        }

    }

    public class dragableTiles extends ImageView{

        int homeCol; int homeRow;
        int rotate;
        double mouseX; double mouseY;
        double homeX; double homeY;

        String tilePlacementString;
        String tileName;
        List<dragableTiles> availableTiles = new ArrayList<>();

        private void drag(double movementX, double movementY) {
            setLayoutX(mouseX - homeX);
            setLayoutY(mouseY - homeY);
            System.out.println("dragging to"+ getLayoutX()+movementX + ", "+ getLayoutY()+movementY);

            this.setTranslateX(getLayoutX());
            this.setTranslateY(getLayoutY());
            //this.setOpacity(0.5);
            this.toFront();
        }

        private void moveToHome() {
            setLayoutX(0.0);
            setLayoutY(0.0);

            this.setTranslateX(getLayoutX());
            this.setTranslateY(getLayoutY());
            this.setOpacity(1);
            this.toFront();
        }

        boolean onBoard() {
            return mouseX > (gridPane_board.getLayoutX() + SQUARE_SIZE)
                    && mouseX < (gridPane_board.getLayoutX() + gridPane_board.getWidth() - SQUARE_SIZE)
                    && mouseY > (gridPane_board.getLayoutY() + SQUARE_SIZE)
                    && mouseY < (gridPane_board.getLayoutY() + gridPane_board.getHeight() - SQUARE_SIZE);
        }
        dragableTiles(int homeCol,int homeRow){
            this.homeCol=homeCol;
            this.homeRow=homeRow;
            this.setFitHeight(SQUARE_SIZE);
            this.setFitWidth(SQUARE_SIZE);

            setOnMousePressed(event -> {
                this.toFront();
                System.out.println("recording mouse coordinate");

                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
                homeX = event.getSceneX();
                homeY = event.getSceneY();

                System.out.println("initial :"+event.getSceneX() + ", " + event.getSceneY());

            });

            setOnMouseDragged(event -> {
                this.toFront();
                double movementX = event.getSceneX() - mouseX;
                double movementY = event.getSceneY() - mouseY;
                this.drag(movementX, movementY);
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
            });

            setOnMouseReleased(event -> {
                System.out.println("gridPane layouts: "+gridPane_board.getLayoutX() + ", "+ gridPane_board.getLayoutY());
                System.out.println("gridPane height: "+gridPane_board.getHeight());
                System.out.println("gridPane width: "+gridPane_board.getWidth());

                if (onBoard()) {
                    this.setOpacity(1);
                    int boardCol = (int) (mouseX - gridPane_board.getLayoutX()) / SQUARE_SIZE;
                    int boardRow = (int) (mouseY - gridPane_board.getLayoutY()) / SQUARE_SIZE;

                    System.out.println("board col: "+boardCol);
                    System.out.println("board row: "+boardRow);

                    String boardSquareName = board.getBoardSquareNameFromPosition(boardCol, boardRow);
                    String placementString = this.tileName + boardSquareName + this.rotate;
                    if (board.isValidPlacement(board.getSquareFormSquareString(placementString))) {
                        board.putPlacementStringToMap(placementString);

                        if (tileName.charAt(0) == 'S') {
                            gridPane_special.getChildren().remove(this);
                        }
                        else {
                            gridPane_dice.getChildren().remove(this);
                        }

                        setTile(boardCol, boardRow, this.rotate * 90, this.getImage());
                    }
                    else {
                        this.moveToHome();
                    }
                }
                else {
                    this.moveToHome();
                }
            });

            setOnMouseClicked(event -> {
                // if not right click ,return.
                if(event.getButton()!= MouseButton.SECONDARY)
                {
                    return;
                }
                System.out.println("right mouse click");
                if(rotate<7){rotate++;}
                else if (rotate==7){rotate=0;}
                this.setRotate((rotate % 4) * 90);
                this.setScaleX((rotate) < 4 ? 1 : - 1);

                event.consume();

            });
        }

        public void setTileName(String tileName) {
            this.tileName = tileName;
        }
        public void setRotateToZero(){
            this.rotate=0;
            this.setRotate((rotate % 4) * 90);
            this.setScaleX((rotate) < 4 ? 1 : - 1);
        }
    }

    private dragableTiles tile_s0=new dragableTiles(0,0);
    private dragableTiles tile_s1=new dragableTiles(1,0);
    private dragableTiles tile_s2=new dragableTiles(0,1);
    private dragableTiles tile_s3=new dragableTiles(1,1);
    private dragableTiles tile_s4=new dragableTiles(0,2);
    private dragableTiles tile_s5=new dragableTiles(1,2);
    private dragableTiles dice_1=new dragableTiles(0,0);
    private dragableTiles dice_2=new dragableTiles(1,0);
    private dragableTiles dice_3=new dragableTiles(0,1);
    private dragableTiles dice_4=new dragableTiles(1,1);

    @FXML
    private AnchorPane rootPane;

    @FXML
    private GridPane gridPane_special;

    @FXML
    private GridPane gridPane_dice;

    @FXML
    private Button btn_next;

    @FXML
    private GridPane gridPane_board;

    @FXML
    private Label num_remainST;

    @FXML
    private Label num_player;

    @FXML
    public Label name_player;

    @FXML
    private Label num_round;

    @FXML
    private Label num_remainDT;

    void setDiceRoll(){
        diceRoll=RailroadInk.generateDiceRoll();
        Image d1 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(0,2)+".jpg");
        dice_1.setImage(d1);
        Image d2 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(2,4)+".jpg");
        dice_2.setImage(d2);
        Image d3 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(4,6)+".jpg");
        dice_3.setImage(d3);
        Image d4 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(6,8)+".jpg");
        dice_4.setImage(d4);
        dice_1.setRotateToZero();
        dice_2.setRotateToZero();
        dice_3.setRotateToZero();
        dice_4.setRotateToZero();
        dice_1.setTileName(diceRoll.substring(0,2));
        dice_2.setTileName(diceRoll.substring(2,4));
        dice_3.setTileName(diceRoll.substring(4,6));
        dice_4.setTileName(diceRoll.substring(6,8));
        gridPane_dice.getChildren().removeAll();

    }

    @FXML
    void btn_nextTurn_click(MouseEvent event) {


        if (totalPlayerNum==1){
            round++;
            num_round.setText(String.valueOf(round));
            setDiceRoll();
        }
        else if (totalPlayerNum>currentPlayer){
            currentPlayer++;
            name_player.setText(StageManager.playerList.get(currentPlayer-1).getPlayerName());
        }
        else if (totalPlayerNum==currentPlayer){
            currentPlayer=1;
            round++;
            num_round.setText(String.valueOf(round));
            name_player.setText(StageManager.playerList.get(currentPlayer-1).getPlayerName());
            setDiceRoll();
        }

    }

    void setTile(int col, int row, int rotation, Image image) {
        fixedTile tile = new fixedTile();
        tile.setImage(image);
        tile.setRotate(rotation);
        gridPane_board.add(tile, col, row);

    }

    void displayWallsAndExits() {
        Image wallImage = new Image(Viewer.class.getResource("")+"assets/Wall.jpg");
        Image railwayExitImage = new Image(Viewer.class.getResource("")+"assets/RailExit.jpg");
        Image highwayExitImage = new Image(Viewer.class.getResource("")+"assets/HighExit.jpg");

        for (int row=0; row<9; row++) {
            for (int col=0; col<9; col++) {
                if (col == 0) {
                    if (row == 2 || row == 6) {
                        setTile(col, row, 270, railwayExitImage);
                    }
                    else if (row == 4) {
                        setTile(col, row, 270, highwayExitImage);
                    }
                    else {
                        setTile(col, row, 0, wallImage);
                    }
                }
                if (col == 8) {
                    if (row == 2 || row == 6) {
                        setTile(col, row, 90, railwayExitImage);
                    }
                    else if (row == 4) {
                        setTile(col, row, 90, highwayExitImage);
                    }
                    else {
                        setTile(col, row, 0, wallImage);
                    }
                }
                if (row == 0) {
                    if (col == 2 || col == 6) {
                        setTile(col, row, 0, highwayExitImage);
                    }
                    else if (col == 4) {
                        setTile(col, row, 0, railwayExitImage);
                    }
                    else {
                        setTile(col, row, 0, wallImage);
                    }
                }
                if (row == 8) {
                    if (col == 2 || col == 6) {
                        setTile(col, row, 180, highwayExitImage);
                    }
                    else if (col == 4) {
                        setTile(col, row, 180, railwayExitImage);
                    }
                    else {
                        setTile(col, row, 0, wallImage);
                    }
                }
            }
        }
    }


    public void initialize(URL location, ResourceBundle resources){
        String name = StageManager.playerList.get(currentPlayer-1).playerName;
        num_player.setText(String.valueOf(currentPlayer));
        this.name_player.setText(name);
        num_round.setText(String.valueOf(round));
        Image s0 = new Image(Viewer.class.getResource("")+"assets/S0.jpg");
        Image s1 = new Image(Viewer.class.getResource("")+"assets/S1.jpg");
        Image s2 = new Image(Viewer.class.getResource("")+"assets/S2.jpg");
        Image s3 = new Image(Viewer.class.getResource("")+"assets/S3.jpg");
        Image s4 = new Image(Viewer.class.getResource("")+"assets/S4.jpg");
        Image s5 = new Image(Viewer.class.getResource("")+"assets/S5.jpg");

        tile_s0.setImage(s0);
        tile_s1.setImage(s1);
        tile_s2.setImage(s2);
        tile_s3.setImage(s3);
        tile_s4.setImage(s4);
        tile_s5.setImage(s5);
        tile_s0.setTileName("S0");
        tile_s1.setTileName("S1");
        tile_s2.setTileName("S2");
        tile_s3.setTileName("S3");
        tile_s4.setTileName("S4");
        tile_s5.setTileName("S5");

        setDiceRoll();
        System.out.println(diceRoll);
        gridPane_special.add(tile_s0,0,0);
        gridPane_special.add(tile_s1,1,0);
        gridPane_special.add(tile_s2,0,1);
        gridPane_special.add(tile_s3,1,1);
        gridPane_special.add(tile_s4,0,2);
        gridPane_special.add(tile_s5,1,2);
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);

        displayWallsAndExits();
        gridPane_dice.toFront();
        gridPane_special.toFront();
    }



}
