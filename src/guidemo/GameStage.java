package guidemo;

import comp1110.ass2.gui.Viewer;
import comp1110.ass2.model.Board;
import comp1110.ass2.RailroadInk;
import comp1110.ass2.model.PositionPoint;
import comp1110.ass2.model.Square;
import comp1110.ass2.util.StageManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class GameStage implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private GridPane gridPane_special;
    @FXML private GridPane gridPane_dice;
    @FXML private Button btn_next;
    @FXML private Button btn_takeBack;
    @FXML private GridPane gridPane_board;
    @FXML private Label num_remainST;
    @FXML private Label num_player;
    @FXML public Label name_player;
    @FXML private Label num_round;
    @FXML private Label num_remainDT;
    @FXML private Label warning;

    public static int totalPlayerNum=1;
    public int currentPlayer=1;
    public int round=1;
    String playerType;
    public String boardString;
    public String roundString;
    public int roundST;
    public int remainSTile;
    public int remainDTile=4;
    public String diceRoll;
    private final int SQUARE_SIZE = 60;
    private String currentTurnBoardString = "";
    private int tilesPlacedThisTurn = 0;
    private String imageURLPrefix = "assets/";
    private String imageURLSuffix = ".jpg";

    private String defaultWarning = "Drag the available tiles to the board, then click End Turn button to end your turn.";
    private String placementWarning = "Invalid tile placement.";
    private String specialTileTurnLimitWarning = "You can only use Special Tile once per turn.";
    private String specialTileGameLimitWarning = "You can only use 3 Special Tiles in one game.";
    private String diceNotPlacedWarning = "You need to put all 4 Regular Tiles on the board first.";
    private String noTilesPlacedWarning = "You have not put any tile this turn";

    /* initialize game board */
    private Board board = new Board();

    public class fixedTile extends ImageView{
        fixedTile(){
            this.setFitHeight(SQUARE_SIZE);
            this.setFitWidth(SQUARE_SIZE);
        }
    }

    public class draggableTiles extends ImageView{

        int homeCol; int homeRow;
        int rotate;
        double mouseX; double mouseY;
        double homeX; double homeY;

        String tilePlacementString;
        String tileName;
        List<draggableTiles> availableTiles = new ArrayList<>();

        private void drag(double movementX, double movementY) {
            setLayoutX(mouseX - homeX);
            setLayoutY(mouseY - homeY);

            this.setTranslateX(getLayoutX());
            this.setTranslateY(getLayoutY());
            this.setOpacity(0.5);
            this.toFront();
        }

        private void moveToHome() {
            this.setTranslateX(0.0);
            this.setTranslateY(0.0);
            this.setOpacity(1);
            this.toFront();
        }

        boolean onBoard() {
            return mouseX > (gridPane_board.getLayoutX() + SQUARE_SIZE)
                    && mouseX < (gridPane_board.getLayoutX() + gridPane_board.getWidth() - SQUARE_SIZE)
                    && mouseY > (gridPane_board.getLayoutY() + SQUARE_SIZE)
                    && mouseY < (gridPane_board.getLayoutY() + gridPane_board.getHeight() - SQUARE_SIZE);
        }
        draggableTiles(int homeCol, int homeRow){
            this.homeCol=homeCol;
            this.homeRow=homeRow;
            this.setFitHeight(SQUARE_SIZE);
            this.setFitWidth(SQUARE_SIZE);

            setOnMousePressed(event -> {
                displayWarning(defaultWarning);
                System.out.println("recording mouse coordinate");
                System.out.println("home :"+event.getSceneX() + ", " + event.getSceneY());
                if (roundST!=0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileTurnLimitWarning);
                }
                else {
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                    homeX = event.getSceneX();
                    homeY = event.getSceneY();
                }
            });

            setOnMouseDragged(event -> {
                if (roundST!=0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileTurnLimitWarning);
                }
                else {
                    this.toFront();
                    double movementX = event.getSceneX() - mouseX;
                    double movementY = event.getSceneY() - mouseY;
                    this.drag(movementX, movementY);
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                }
            });

            setOnMouseReleased(event -> {
                if (roundST!=0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileTurnLimitWarning);
                }
                else if (onBoard()) {
                    this.setOpacity(1);
                    int boardCol = (int) (mouseX - gridPane_board.getLayoutX()) / SQUARE_SIZE;
                    int boardRow = (int) (mouseY - gridPane_board.getLayoutY()) / SQUARE_SIZE;

                    String boardSquareName = board.getBoardSquareNameFromPosition(boardCol, boardRow);
                    String placementString = this.tileName + boardSquareName + this.rotate;
                    if (board.isValidPlacement(board.getSquareFromSquareString(placementString))) {
                        board.putPlacementStringToMap(placementString);
                        StageManager.playerList.get(currentPlayer-1).appendBoardString(placementString);
                        displayTileToBoard(boardCol, boardRow, this.rotate, this.getImage());
                        tilesPlacedThisTurn++;

                        if (tileName.charAt(0) == 'S') {
                            if (roundST==0) {
                                gridPane_special.getChildren().remove(this);
                                StageManager.playerList.get(currentPlayer - 1).usedSpeicalTile++;
                                remainSTile = 3 - StageManager.playerList.get(currentPlayer - 1).usedSpeicalTile;
                                num_remainST.setText(String.valueOf(remainSTile));
                                roundST++;
                            }
                            else {
                                this.moveToHome();
                            }
                        }
                        else {
                            gridPane_dice.getChildren().remove(this);
                            remainDTile--;
                            num_remainDT.setText(String.valueOf(remainDTile));
                        }
                    }
                    else {
                        this.moveToHome();
                        displayWarning(placementWarning);
                    }
                }
                else {
                    this.moveToHome();
                    displayWarning(placementWarning);
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
                displayWarning(defaultWarning);
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

    void setDiceRoll(){
        draggableTiles dice_1=new draggableTiles(0,0);
        draggableTiles dice_2=new draggableTiles(1,0);
        draggableTiles dice_3=new draggableTiles(0,1);
        draggableTiles dice_4=new draggableTiles(1,1);
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
        if (gridPane_dice.getChildren().size()>0){
            gridPane_dice.getChildren().clear();
        }
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);


    }

    void setDTileAgain(){  //set Tiles without changing the dice string
        draggableTiles dice_1=new draggableTiles(0,0);
        draggableTiles dice_2=new draggableTiles(1,0);
        draggableTiles dice_3=new draggableTiles(0,1);
        draggableTiles dice_4=new draggableTiles(1,1);
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
        if (gridPane_dice.getChildren().size()>0){
            gridPane_dice.getChildren().clear();
        }
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);
    }

    @FXML
    void btn_takeBack_click(MouseEvent event) {
        if (tilesPlacedThisTurn == 0) {
            displayWarning(noTilesPlacedWarning);
        }
        else {
            takeBackTilesPlacedThisTurn();
            roundST = 0;
            setSTiles();
            setDTileAgain();
            remainSTile+=roundST;
            StageManager.playerList.get(currentPlayer-1).usedSpeicalTile=remainSTile;
            num_remainST.setText(String.valueOf(remainSTile));
            roundST=0;
            remainDTile=4;
            num_remainDT.setText(String.valueOf(remainDTile));

        }
    }

    @FXML
    void btn_nextTurn_click(MouseEvent event) {
        if (remainDTile>0){
            displayWarning(diceNotPlacedWarning);
        }
        else {
            tilesPlacedThisTurn=0;
            setSTiles();
            roundST=0;
            remainDTile=4;
            num_remainDT.setText("4");
            if (totalPlayerNum==1 && round<7){
                round++;
                num_round.setText(String.valueOf(round));
                setDiceRoll();
            }
            else if (round==7 && totalPlayerNum==currentPlayer){
                //todo:  open the window(stage) of ending OR(And) show the scores
                Stage curr = StageManager.stageMap.get("gameStage");
                curr.hide();
            }
            else if (totalPlayerNum>currentPlayer){
                savePlayerBoard();
                currentPlayer++;
                num_player.setText(Integer.toString(currentPlayer));
                name_player.setText(StageManager.playerList.get(currentPlayer-1).getPlayerName());
                remainSTile=3-StageManager.playerList.get(currentPlayer-1).usedSpeicalTile;
                num_remainST.setText(String.valueOf(remainSTile));
                setDTileAgain();

                removeBoardDisplay();
                loadPlayerBoard();
                displayPlayerBoard();
            }
            else if (totalPlayerNum==currentPlayer){
                savePlayerBoard();
                currentPlayer=1;
                num_player.setText(Integer.toString(currentPlayer));
                round++;
                num_round.setText(String.valueOf(round));
                name_player.setText(StageManager.playerList.get(currentPlayer-1).getPlayerName());
                remainSTile=3-StageManager.playerList.get(currentPlayer-1).usedSpeicalTile;
                num_remainST.setText(String.valueOf(remainSTile));
                setDiceRoll();

                removeBoardDisplay();
                loadPlayerBoard();
                displayPlayerBoard();
            }
        }


    }

    private void displayTileToBoard(int col, int row, int rotation, Image image) {
        fixedTile tile = new fixedTile();
        tile.setImage(image);
        tile.setRotate((rotation % 4) * 90);
        tile.setScaleX((rotation < 4) ? 1 : -1);
        gridPane_board.add(tile, col, row);
    }

    private void displayWarning(String string) {
        warning.setText(string);
        if (string == defaultWarning) warning.setStyle("-fx-border-color: green; -fx-border-width: 2px; -fx-background-color: palegreen");
        else warning.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: lightpink");
    }

    private void displayWallsAndExits() {
        Image wallImage = new Image(Viewer.class.getResource("")+imageURLPrefix+"Wall"+imageURLSuffix);
        Image railwayExitImage = new Image(Viewer.class.getResource("")+imageURLPrefix+"RailExit"+imageURLSuffix);
        Image highwayExitImage = new Image(Viewer.class.getResource("")+imageURLPrefix+"HighExit"+imageURLSuffix);

        for (int row=0; row<9; row++) {
            for (int col=0; col<9; col++) {
                if (col == 0) {
                    if (row == 2 || row == 6) {
                        displayTileToBoard(col, row, 3, railwayExitImage);
                    }
                    else if (row == 4) {
                        displayTileToBoard(col, row, 3, highwayExitImage);
                    }
                    else {
                        displayTileToBoard(col, row, 0, wallImage);
                    }
                }
                if (col == 8) {
                    if (row == 2 || row == 6) {
                        displayTileToBoard(col, row, 1, railwayExitImage);
                    }
                    else if (row == 4) {
                        displayTileToBoard(col, row, 1, highwayExitImage);
                    }
                    else {
                        displayTileToBoard(col, row, 0, wallImage);
                    }
                }
                if (row == 0) {
                    if (col == 2 || col == 6) {
                        displayTileToBoard(col, row, 0, highwayExitImage);
                    }
                    else if (col == 4) {
                        displayTileToBoard(col, row, 0, railwayExitImage);
                    }
                    else {
                        displayTileToBoard(col, row, 0, wallImage);
                    }
                }
                if (row == 8) {
                    if (col == 2 || col == 6) {
                        displayTileToBoard(col, row, 2, highwayExitImage);
                    }
                    else if (col == 4) {
                        displayTileToBoard(col, row, 2, railwayExitImage);
                    }
                    else {
                        displayTileToBoard(col, row, 0, wallImage);
                    }
                }
            }
        }
    }

    private void takeBackTilesPlacedThisTurn() {
        String boardString = StageManager.playerList.get(currentPlayer-1).getBoardString();
        String removedPlacementString = boardString.substring(boardString.length() - (tilesPlacedThisTurn * 5));
        String newBoardString = boardString.substring(0, boardString.length() - (tilesPlacedThisTurn * 5));

        StageManager.playerList.get(currentPlayer-1).setBoardString(newBoardString);
        removeBoardDisplay();
        board.removeBoardStringFromBoard(removedPlacementString);
        StageManager.playerList.get(currentPlayer-1).setBoard(board);
        displayPlayerBoard();

        tilesPlacedThisTurn = 0;
    }

    private void removeBoardDisplay() {
        Node grid = gridPane_board.getChildren().get(0);
        gridPane_board.getChildren().clear();
        gridPane_board.getChildren().add(grid);
        displayWallsAndExits();
    }

    private void savePlayerBoard() {
        StageManager.playerList.get(currentPlayer-1).setBoard(board);
    }

    private void loadPlayerBoard() {
        board = StageManager.playerList.get(currentPlayer-1).getBoard();
    }

    private void displayPlayerBoard() {
        String playerBoardString = StageManager.playerList.get(currentPlayer-1).getBoardString();
        System.out.println("displaying boardString :"+playerBoardString);

        for (int i=0; i<playerBoardString.length(); i+=5) {
            String placementString = playerBoardString.substring(i, i+5);
            PositionPoint pp = board.getPositionFromPlacementString(placementString);
            int rotation = Integer.parseInt(placementString.substring(4));
            Image image = new Image(Viewer.class.getResource("")+imageURLPrefix+placementString.substring(0,2)+imageURLSuffix);

            displayTileToBoard(pp.getY(), pp.getX(), rotation, image);
        }
        board.putPlacementStringToMap(playerBoardString);
        board.printMap();
    }

    void setSTiles(){
        if (gridPane_special.getChildren().size()<6&&gridPane_special.getChildren().size()>0){
            gridPane_special.getChildren().clear();
        }
        draggableTiles tile_s0=new draggableTiles(0,0);
        draggableTiles tile_s1=new draggableTiles(1,0);
        draggableTiles tile_s2=new draggableTiles(0,1);
        draggableTiles tile_s3=new draggableTiles(1,1);
        draggableTiles tile_s4=new draggableTiles(0,2);
        draggableTiles tile_s5=new draggableTiles(1,2);
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
        gridPane_special.add(tile_s0,0,0);
        gridPane_special.add(tile_s1,1,0);
        gridPane_special.add(tile_s2,0,1);
        gridPane_special.add(tile_s3,1,1);
        gridPane_special.add(tile_s4,0,2);
        gridPane_special.add(tile_s5,1,2);
    }

    public void initialize(URL location, ResourceBundle resources){
        String name = StageManager.playerList.get(currentPlayer-1).playerName;
        num_player.setText(String.valueOf(currentPlayer));
        this.name_player.setText(name);
        num_round.setText(String.valueOf(round));
        setDiceRoll();
        setSTiles();
        System.out.println(diceRoll);
        displayWallsAndExits();
        displayWarning(defaultWarning);
        gridPane_dice.toFront();
        gridPane_special.toFront();
        System.out.println(gridPane_board.getChildren().toString());
    }

}
