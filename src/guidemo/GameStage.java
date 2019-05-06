package guidemo;

import com.sun.media.jfxmedia.events.PlayerEvent;
import comp1110.ass2.gui.Viewer;
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
import javafx.scene.layout.GridPane;
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

    public class dragableTiles extends ImageView{
        int homeCol; int homeRow;
        int rotate;
        int mouseX; int mouseY;
        String tilePlacementString;
        String tileName;
        dragableTiles(int homeCol,int homeRow,String tileName){
            this.homeCol=homeCol;
            this.homeRow=homeRow;
            this.tileName=tileName;
            this.setFitHeight(60);
            this.setFitWidth(60);
            setOnMouseClicked(event -> {
                // if not right click ,return.
                if(event.getButton()!= MouseButton.SECONDARY)
                {
                    return;
                }
                System.out.println("right mouse click");
                rotate = (rotate+1)%7;
                this.setRotate((rotate % 4) * 90);
                this.setScaleX((rotate) < 4 ? 1 : - 1);

            });
        }
        dragableTiles(int homeCol,int homeRow){
            this.homeCol=homeCol;
            this.homeRow=homeRow;
            this.setFitHeight(60);
            this.setFitWidth(60);
            setOnMouseClicked(event -> {
                if (rotate!=3&&rotate<7){
                    rotate++;
                    this.setRotate(90);
                }
                else if (rotate==3){
                    rotate++;
                    this.setRotate(90);
                    this.setScaleX(-1);
                }
                else if (rotate==7){
                    rotate=0;
                    this.setRotate(90);
                    this.setScaleX(-1);
                }
                event.consume();
            });
        }

        public void setTileName(String tileName) {
            this.tileName = tileName;
        }



    }

    private dragableTiles tile_s0=new dragableTiles(0,0,"S0");
    private dragableTiles tile_s1=new dragableTiles(1,0,"S1");
    private dragableTiles tile_s2=new dragableTiles(0,1,"S2");
    private dragableTiles tile_s3=new dragableTiles(1,1,"S3");
    private dragableTiles tile_s4=new dragableTiles(0,2,"S4");
    private dragableTiles tile_s5=new dragableTiles(1,2,"S5");
    private dragableTiles dice_1=new dragableTiles(0,0);
    private dragableTiles dice_2=new dragableTiles(1,0);
    private dragableTiles dice_3=new dragableTiles(0,1);
    private dragableTiles dice_4=new dragableTiles(1,1);


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
        Image d1 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(0,2)+".png");
        dice_1.setImage(d1);
        Image d2 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(2,4)+".png");
        dice_2.setImage(d2);
        Image d3 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(4,6)+".png");
        dice_3.setImage(d3);
        Image d4 = new Image(Viewer.class.getResource("")+"assets/"+diceRoll.substring(6,8)+".png");
        dice_4.setImage(d4);
        gridPane_dice.add(dice_1,0,0);
        gridPane_dice.add(dice_2,1,0);
        gridPane_dice.add(dice_3,0,1);
        gridPane_dice.add(dice_4,1,1);
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

    public void initialize(URL location, ResourceBundle resources){
        String name = StageManager.playerList.get(currentPlayer-1).playerName;
        num_player.setText(String.valueOf(currentPlayer));
        this.name_player.setText(name);
        num_round.setText(String.valueOf(round));
        Image s0 = new Image(Viewer.class.getResource("")+"assets/S0.png");
        Image s1 = new Image(Viewer.class.getResource("")+"assets/S1.png");
        Image s2 = new Image(Viewer.class.getResource("")+"assets/S2.png");
        Image s3 = new Image(Viewer.class.getResource("")+"assets/S3.png");
        Image s4 = new Image(Viewer.class.getResource("")+"assets/S4.png");
        Image s5 = new Image(Viewer.class.getResource("")+"assets/S5.png");
        tile_s0.setImage(s0);
        tile_s1.setImage(s1);
        tile_s2.setImage(s2);
        tile_s3.setImage(s3);
        tile_s4.setImage(s4);
        tile_s5.setImage(s5);
        setDiceRoll();
        System.out.println(diceRoll);
        gridPane_special.add(tile_s0,0,0);
        gridPane_special.add(tile_s1,1,0);
        gridPane_special.add(tile_s2,0,1);
        gridPane_special.add(tile_s3,1,1);
        gridPane_special.add(tile_s4,0,2);
        gridPane_special.add(tile_s5,1,2);

    }



}
