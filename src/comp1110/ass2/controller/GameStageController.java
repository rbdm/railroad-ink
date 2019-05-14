package comp1110.ass2.controller;

import comp1110.ass2.RailroadInk;
import comp1110.ass2.gui.Viewer;
import comp1110.ass2.model.Board;
import comp1110.ass2.model.EnumTypePlayer;
import comp1110.ass2.model.Player;
import comp1110.ass2.model.PositionPoint;
import comp1110.ass2.util.PlacementUtil;
import comp1110.ass2.util.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameStageController implements Initializable {

    @FXML private GridPane gridPane_special;
    @FXML private GridPane gridPane_dice;
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
    public int remainSTile=3;
    public int remainDTile=4;
    public String diceRoll;
    private final int SQUARE_SIZE = 60;
    private String currentTurnBoardString = "";
    private int tilesPlacedThisTurn = 0;
    private String imageURLPrefix = "assets/";
    private String imageURLSuffix = ".jpg";
    private String remainingDiceRoll;

    private String defaultWarning = "Drag the available tiles to the board, then click End Turn button to end your turn.";
    private String invalidPlacementWarning = "Invalid tile placement.";
    private String specialTileTurnLimitWarning = "You can only use Special Tile once per turn.";
    private String specialTileGameLimitWarning = "You can only use 3 Special Tiles in one game.";
    private String diceNotPlacedWarning = "You need to put all 4 Regular Tiles on the board first.";
    private String noTilesPlacedWarning = "You have not put any tile this turn";
    private String noMoreMoveAvailableWarning = "No more Regular Tile can be placed, you are now allowed to click Next Turn";

    /* initialize game board */
    private Board board = new Board();

    public class TileImage extends ImageView {
        TileImage(){
            this.setFitHeight(SQUARE_SIZE);
            this.setFitWidth(SQUARE_SIZE);
        }
    }

    public class DraggableTile extends TileImage {
        int homeCol; int homeRow;
        int rotate;
        double mouseX; double mouseY;
        double homeX; double homeY;

        String tilePlacementString;
        String tileName;

        DraggableTile(int homeCol, int homeRow){
            this.homeCol=homeCol;
            this.homeRow=homeRow;

            setOnMousePressed(event -> {
                displayWarning(defaultWarning);
                System.out.println("recording mouse coordinate");
                System.out.println("home :"+event.getSceneX() + ", " + event.getSceneY());
                if (roundST!=0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileTurnLimitWarning);
                }
                else if (remainSTile==0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileGameLimitWarning);
                }
                else if ( ! isAbleToMove() && ( ! this.tileName.substring(0,1).equals("S"))) {
                    displayWarning(noMoreMoveAvailableWarning);
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                    homeX = event.getSceneX();
                    homeY = event.getSceneY();
                }
                else {
                    displayWarning(defaultWarning);
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
                else if (remainSTile==0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileGameLimitWarning);
                }
                else {
                    this.toFront();
                    this.drag();
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                }
            });

            setOnMouseReleased(event -> {
                if (roundST!=0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileTurnLimitWarning);
                }
                else if (remainSTile==0 && this.tileName.substring(0,1).equals("S")){
                    displayWarning(specialTileGameLimitWarning);
                }
                else if ( ! isAbleToMove() && ( ! this.tileName.substring(0,1).equals("S"))) {
                    displayWarning(noMoreMoveAvailableWarning);
                    this.moveToHome();
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
                        useDiceRoll(this.tileName);

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
                        displayWarning(invalidPlacementWarning);
                    }
                }
                else {
                    this.moveToHome();
                    displayWarning(invalidPlacementWarning);
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

        private void drag() {
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

        private boolean onBoard() {
            return mouseX > (gridPane_board.getLayoutX() + SQUARE_SIZE)
                    && mouseX < (gridPane_board.getLayoutX() + gridPane_board.getWidth() - SQUARE_SIZE)
                    && mouseY > (gridPane_board.getLayoutY() + SQUARE_SIZE)
                    && mouseY < (gridPane_board.getLayoutY() + gridPane_board.getHeight() - SQUARE_SIZE);
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

    private void setDiceRoll(){
        DraggableTile dice_1=new DraggableTile(0,0);
        DraggableTile dice_2=new DraggableTile(1,0);
        DraggableTile dice_3=new DraggableTile(0,1);
        DraggableTile dice_4=new DraggableTile(1,1);
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
            Node grid = gridPane_dice.getChildren().get(0);
            gridPane_dice.getChildren().clear();
            gridPane_dice.getChildren().add(grid);
        }
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);

        StageManager.diceRollList.add(diceRoll);
        remainingDiceRoll = diceRoll;
    }

    void setDTileAgain(){  //set Tiles without changing the dice string
        DraggableTile dice_1=new DraggableTile(0,0);
        DraggableTile dice_2=new DraggableTile(1,0);
        DraggableTile dice_3=new DraggableTile(0,1);
        DraggableTile dice_4=new DraggableTile(1,1);
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
            Node grid = gridPane_dice.getChildren().get(0);
            gridPane_dice.getChildren().clear();
            gridPane_dice.getChildren().add(grid);
        }
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);
    }

    @FXML
    void btn_takeBack_click() {
        if (tilesPlacedThisTurn == 0) {
            displayWarning(noTilesPlacedWarning);
        }
        else {
            takeBackTilesPlacedThisTurn();
            setSTiles();
            setDTileAgain();
            remainingDiceRoll = diceRoll;
            remainSTile+=roundST;
            StageManager.playerList.get(currentPlayer-1).usedSpeicalTile=remainSTile;
            num_remainST.setText(String.valueOf(remainSTile));
            roundST=0;
            remainDTile=4;
            num_remainDT.setText(String.valueOf(remainDTile));
        }
    }

    @FXML
    void btn_endTurn_click(MouseEvent event) throws IOException
    {
        if (remainDTile>0 && StageManager.playerList.get(currentPlayer-1).playerType==EnumTypePlayer.HUMAN && isAbleToMove()){
            displayWarning(diceNotPlacedWarning);
        }
        else {
            tilesPlacedThisTurn=0;
            roundST=0;
            remainDTile=4;
            num_remainDT.setText("4");
            remainingDiceRoll = diceRoll;
            displayWarning(defaultWarning);

            if (round==7 && totalPlayerNum==currentPlayer){
                //todo:  open the window(stage) of ending OR(And) show the scores
                Stage curr = StageManager.stageMap.get("gameStage");
                curr.hide();
                Stage scoreFormStage = new Stage();
                Parent root = FXMLLoader.load(ClassLoader.getSystemResource("resource/ScoreForm.fxml"));
                Scene scene = new Scene(root);
                scoreFormStage.setScene(scene);
                scoreFormStage.setTitle("ScoreForm");
                scoreFormStage.show();
                StageManager.stageMap.put("ScoreFormStage",scoreFormStage);
            }
            else if (totalPlayerNum>currentPlayer){
                currentPlayer++;
                num_player.setText(Integer.toString(currentPlayer));
                name_player.setText(StageManager.playerList.get(currentPlayer-1).getPlayerName());
                remainSTile=3-StageManager.playerList.get(currentPlayer-1).usedSpeicalTile;
                num_remainST.setText(String.valueOf(remainSTile));
                setDTileAgain();
                setSTiles();
                removeBoardDisplay();
                loadPlayerBoard();
                displayPlayerBoard();
            }
            else if (totalPlayerNum==currentPlayer){
                currentPlayer=1;
                num_player.setText(Integer.toString(currentPlayer));
                round++;
                setSTiles();
                StageManager.playerList.get(currentPlayer-1).round++;
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

    private boolean isAbleToMove() {
        System.out.println(StageManager.playerList.get(currentPlayer-1).getBoardString());
        System.out.println(remainingDiceRoll);
        System.out.println( ! RailroadInk.generateMove(StageManager.playerList.get(currentPlayer-1).getBoardString(), remainingDiceRoll).equals(""));
        return ( ! RailroadInk.generateMove(StageManager.playerList.get(currentPlayer-1).getBoardString(), remainingDiceRoll).equals(""));
    }

    private void useDiceRoll(String dice) {
        int usedDice = 0;
        String newDiceRoll = diceRoll;
        if ( ! dice.substring(0,1).equals("S")) {
            for (int i=0; i<remainingDiceRoll.length() && usedDice == 0; i+=2) {
                String diceInDiceRoll = remainingDiceRoll.substring(i, i+2);
                if (diceInDiceRoll.equals(dice)) {
                    String frontPart = remainingDiceRoll.substring(0, i);
                    String rearPart = remainingDiceRoll.substring(i+2);
                    newDiceRoll = frontPart + rearPart;
                    usedDice++;
                }
            }
        }
        remainingDiceRoll = newDiceRoll;
    }

    private void displayTileToBoard(int col, int row, int rotation, Image image) {
        TileImage tile = new TileImage();
        tile.setImage(image);
        tile.setRotate((rotation % 4) * 90);
        tile.setScaleX((rotation < 4) ? 1 : -1);
        gridPane_board.add(tile, col, row);
    }

    private void displayWarning(String message) {
        warning.setText(message);
        if (message.equals(defaultWarning)) warning.setStyle("-fx-border-color: green; -fx-border-width: 2px; -fx-background-color: palegreen");
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
        displayPlayerBoard();

        tilesPlacedThisTurn = 0;
    }

    private void removeBoardDisplay() {
        Node grid = gridPane_board.getChildren().get(0);
        gridPane_board.getChildren().clear();
        gridPane_board.getChildren().add(grid);
        displayWallsAndExits();
    }

    private void loadPlayerBoard() {
        board = StageManager.playerList.get(currentPlayer-1).getBoard();
    }

    private void displayPlayerBoard() {
        Player player = StageManager.playerList.get(currentPlayer-1);
        String playerBoardString = player.getBoardString();
        System.out.println("displaying boardString :"+playerBoardString);

        if(player.playerType== EnumTypePlayer.AI)
        {
            String diceRoll = StageManager.diceRollList.get(StageManager.diceRollList.size()-1);
            String aiPlacement = PlacementUtil.getResults(playerBoardString,diceRoll,player);
            playerBoardString += aiPlacement;
            Node gridForDice = gridPane_dice.getChildren().get(0);
            Node gridForSpecial = gridPane_special.getChildren().get(0);
            gridPane_dice.getChildren().clear();
            gridPane_special.getChildren().clear();
            gridPane_dice.getChildren().add(gridForDice);
            gridPane_special.getChildren().add(gridForSpecial);
            //TODO: clean the UI of ImageView
        }

        for (int i=0; i<playerBoardString.length(); i+=5) {
            String placementString = playerBoardString.substring(i, i+5);
            PositionPoint pp = board.getPositionFromPlacementString(placementString);
            int rotation = Integer.parseInt(placementString.substring(4));
            Image image = new Image(Viewer.class.getResource("")+imageURLPrefix+placementString.substring(0,2)+imageURLSuffix);

            displayTileToBoard(pp.getY(), pp.getX(), rotation, image);
        }

        board.putPlacementStringToMap(playerBoardString);
        player.setBoardString(playerBoardString);
        board.printMap();


    }

    void setSTiles(){
        if (gridPane_special.getChildren().size()<=6 && gridPane_special.getChildren().size()>0){
            Node grid = gridPane_special.getChildren().get(0);
            gridPane_special.getChildren().clear();
            gridPane_special.getChildren().add(grid);
        }
        DraggableTile tile_s0=new DraggableTile(0,0);
        DraggableTile tile_s1=new DraggableTile(1,0);
        DraggableTile tile_s2=new DraggableTile(0,1);
        DraggableTile tile_s3=new DraggableTile(1,1);
        DraggableTile tile_s4=new DraggableTile(0,2);
        DraggableTile tile_s5=new DraggableTile(1,2);
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
        String boardString = StageManager.playerList.get(currentPlayer-1).getBoardString();
        List<String> list = new ArrayList<>();
        int num = boardString.length();
        for (int i=0;i<num;i+=5){
            list.add(boardString.substring(i,i+2));
        }

        if (list.contains("S0")){
            gridPane_special.getChildren().remove(tile_s0);
        }
        if (list.contains("S1")){
            gridPane_special.getChildren().remove(tile_s1);
        }
        if (list.contains("S2")){
            gridPane_special.getChildren().remove(tile_s2);
        }
        if (list.contains("S3")){
            gridPane_special.getChildren().remove(tile_s3);
        }
        if (list.contains("S4")){
            gridPane_special.getChildren().remove(tile_s4);
        }
        if (list.contains("S5")){
            gridPane_special.getChildren().remove(tile_s5);
        }

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
