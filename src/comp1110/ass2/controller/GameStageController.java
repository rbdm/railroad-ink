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
import javafx.scene.control.Button;
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
    @FXML public Label player_type;
    @FXML private Label num_round;
    @FXML private Label num_remainDT;
    @FXML private Label warning;
    @FXML private Button btn_takeBack;

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
    private final double UNPLACED_TILE_SQUARE_SIZE = 59.5;
    private final double SQUARE_SIZE = 60;
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
            this.setFitHeight(UNPLACED_TILE_SQUARE_SIZE);
            this.setFitWidth(UNPLACED_TILE_SQUARE_SIZE);
        }
    }
    /**
    DraggableTile includes 4 normal tiles (decide by the dice) all the special tiles (which haven't been used yet)
    it can be drag and rotate
     */
    public class DraggableTile extends TileImage {
        int homeCol; int homeRow; // it's original position on gridPane
        int rotate; // the last int of a 5 bit tilePlacementString
        double mouseX; double mouseY;
        double homeX; double homeY;

        String tileName; // like A1, B2, S0
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
                    int boardCol = (int) (mouseX - gridPane_board.getLayoutX()) / (int) SQUARE_SIZE;
                    int boardRow = (int) (mouseY - gridPane_board.getLayoutY()) / (int) SQUARE_SIZE;
                    String boardSquareName = board.getBoardSquareNameFromPosition(boardCol, boardRow);
                    String placementString = this.tileName + boardSquareName + this.rotate;

                    if (board.isValidPlacement(board.getSquareFromSquareString(placementString))) {
                        board.putPlacementStringToMap(placementString);
                        System.out.println("displaying boardString: "+getCurrentPlayer().getBoardString());
                        board.printMap();
                        getCurrentPlayer().appendBoardString(placementString);
                        displayTileToBoard(boardCol, boardRow, this.rotate, this.getImage());
                        tilesPlacedThisTurn++;
                        useDiceRoll(this.tileName);

                        if (tileName.charAt(0) == 'S') {
                            roundST=1;
                            gridPane_special.getChildren().remove(this);
                            num_remainST.setText(String.valueOf(remainSTile-1));
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
            return mouseX > (gridPane_board.getLayoutX() + UNPLACED_TILE_SQUARE_SIZE)
                    && mouseX < (gridPane_board.getLayoutX() + gridPane_board.getWidth() - UNPLACED_TILE_SQUARE_SIZE)
                    && mouseY > (gridPane_board.getLayoutY() + UNPLACED_TILE_SQUARE_SIZE)
                    && mouseY < (gridPane_board.getLayoutY() + gridPane_board.getHeight() - UNPLACED_TILE_SQUARE_SIZE);
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

    /**
     * It would generate a new dice roll and place corresponding tiles on the gridPaneDice
     */
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

    /**
     * without changing the dice string, put the 4 normal Tiles to the gridPane again
     */
    void setDTileAgain(){
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


    /**
     * when click the "take back" button, the tiles placed by the current player in this round
     * would go back to home
     */
    @FXML
    void btn_takeBack_click() {
        if (tilesPlacedThisTurn == 0) {
            displayWarning(noTilesPlacedWarning);
        }
        else {
            if (roundST==1){
                roundST=0;
                num_remainST.setText(String.valueOf(remainSTile));
            }
            remainDTile=4;
            num_remainDT.setText(String.valueOf(4));

            takeBackTilesPlacedThisTurn();
            setSTiles();
            setDTileAgain();
            remainingDiceRoll = diceRoll;
        }
    }

    /**
     * When click the "end turn" button, if the user have placed all 4 regular tiles, the game would
     * go to next player or(and) next round. If not, it won't be allowed and would show waring message.
     * The only exception is that the remaining regular tile is not able to be placed on board according to the rules.
     * @param event     mouse click
     * @throws IOException
     */
    @FXML
    void btn_endTurn_click(MouseEvent event) throws IOException
    {
        if (roundST==1){
            StageManager.playerList.get(currentPlayer-1).usedSpeicalTile++;
            roundST=0;
        }
        if (remainDTile>0 && getCurrentPlayer().playerType==EnumTypePlayer.HUMAN && isAbleToMove()){
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
                StageManager.isShownBestScore = false;
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
                player_type.setText(getCurrentPlayer().getPlayerType());
                toggleTakeBackButton();
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
                player_type.setText(getCurrentPlayer().getPlayerType());
                setDiceRoll();
                toggleTakeBackButton();
                removeBoardDisplay();
                loadPlayerBoard();
                displayPlayerBoard();
            }
        }
    }

    /**
     * when there's regular tiles unplaced, judge if there is no valid placement can be made
     * @return true if no valid placement can be made
     */
    private boolean isAbleToMove() {
        return ( ! RailroadInk.generateMove(getCurrentPlayer().getBoardString(), remainingDiceRoll).equals(""));
    }

    private void useDiceRoll(String dice) {
        int usedDice = 0;
        String newDiceRoll = remainingDiceRoll;
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

    private void toggleTakeBackButton() {
        if (getCurrentPlayer().playerType == EnumTypePlayer.AI) {
            btn_takeBack.setDisable(true);
        } else {
            btn_takeBack.setDisable(false);
        }
    }

    private void displayTileToBoard(int col, int row, int rotation, Image image) {
        TileImage tile = new TileImage();
        tile.setFitHeight(SQUARE_SIZE);
        tile.setFitWidth(SQUARE_SIZE);
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
        Image wallImage = new Image(Viewer.class.getResource("")+imageURLPrefix+"WALL"+imageURLSuffix);
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

    private Player getCurrentPlayer() {
        return StageManager.playerList.get(currentPlayer-1);
    }

    private void takeBackTilesPlacedThisTurn() {
        String boardString = getCurrentPlayer().getBoardString();
        String removedPlacementString = boardString.substring(boardString.length() - (tilesPlacedThisTurn * 5));
        String newBoardString = boardString.substring(0, boardString.length() - (tilesPlacedThisTurn * 5));

        getCurrentPlayer().setBoardString(newBoardString);
        removeBoardDisplay();
        board.removeBoardStringFromBoard(removedPlacementString);
        displayPlayerBoard();

        tilesPlacedThisTurn = 0;
    }

    private void removeBoardDisplay() {
        Node grid = gridPane_board.getChildren().get(0);
        Node rectangle = gridPane_board.getChildren().get(1);
        gridPane_board.getChildren().clear();
        gridPane_board.getChildren().add(grid);
        gridPane_board.getChildren().add(rectangle);
        displayWallsAndExits();
    }

    private void loadPlayerBoard() {
        board = getCurrentPlayer().getBoard();
    }

    private void displayPlayerBoard() {
        Player player = StageManager.playerList.get(currentPlayer-1);
        String playerBoardString = player.getBoardString();
        System.out.println("displaying boardString :"+getCurrentPlayer().getBoardString());

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

    /**
     * place the special tiles that can be used by the current player
     */

    void setSTiles(){

        Node grid = gridPane_special.getChildren().get(0);
        gridPane_special.getChildren().clear();
        gridPane_special.getChildren().add(grid);

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
        String boardString = getCurrentPlayer().getBoardString();
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
        //set name, round and player No. and place the tiles 
        num_player.setText(String.valueOf(currentPlayer));
        String name = StageManager.playerList.get(currentPlayer-1).playerName;
        this.name_player.setText(name);
        num_round.setText(String.valueOf(round));
        player_type.setText(getCurrentPlayer().getPlayerType());
        toggleTakeBackButton();
        setDiceRoll();
        setSTiles();
        displayWallsAndExits();
        displayPlayerBoard();
        displayWarning(defaultWarning);
        gridPane_dice.toFront();
        gridPane_special.toFront();
        System.out.println(gridPane_special.getChildren());

        // if the first player is an AI , not place the draggable Tiles
        if (StageManager.playerList.get(currentPlayer-1).playerType==EnumTypePlayer.AI){
            Node gridForDice = gridPane_dice.getChildren().get(0);
            Node gridForSpecial = gridPane_special.getChildren().get(0);
            gridPane_special.getChildren().clear();
            gridPane_dice.getChildren().clear();
            gridPane_dice.getChildren().add(gridForDice);
            gridPane_special.getChildren().add(gridForSpecial);

        }


    }

}
