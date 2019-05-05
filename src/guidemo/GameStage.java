package guidemo;

import com.sun.media.jfxmedia.events.PlayerEvent;
import comp1110.ass2.model.Player;
import comp1110.ass2.RailroadInk;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class GameStage implements Initializable {

    public static int totalPlayerNum=1;
    public int currentPlayer=1;
    public String boardString;
    List<Integer> usedSpecialTile=new ArrayList<>();
    public String diceRoll;

    void setDiceRoll(){
        diceRoll=RailroadInk.generateDiceRoll();
    }


    @FXML
    private GridPane gridPane_special;

    @FXML
    private ImageView tile_s0;

    @FXML
    private ImageView tile_s1;

    @FXML
    private ImageView tile_s2;

    @FXML
    private ImageView tile_s3;

    @FXML
    private ImageView tile_s4;

    @FXML
    private ImageView tile_s5;

    @FXML
    private GridPane gridPane_dice;

    @FXML
    private ImageView dice_1;

    @FXML
    private ImageView dice_2;

    @FXML
    private ImageView dice_3;

    @FXML
    private ImageView dice_4;

    @FXML
    private Button btn_next;

    @FXML
    private GridPane gridPane_board;

    @FXML
    private Label num_remainST;

    @FXML
    private Label num_player;

    @FXML
    private Label name_player;

    @FXML
    private Label num_round;

    @FXML
    void btn_nextTurn_click(MouseEvent event) {


    }

    public void initialize(URL location, ResourceBundle resources){
        setDiceRoll();
        System.out.println(diceRoll);
        Image d1 = new Image(this.getClass().getResource("")+"pic/"+diceRoll.substring(0,2)+".png");
        dice_1.setImage(d1);
        Image d2 = new Image(this.getClass().getResource("")+"pic/"+diceRoll.substring(2,4)+".png");
        dice_2.setImage(d2);
        Image d3 = new Image(this.getClass().getResource("")+"pic/"+diceRoll.substring(4,6)+".png");
        dice_3.setImage(d3);
        Image d4 = new Image(this.getClass().getResource("")+"pic/"+diceRoll.substring(6,8)+".png");
        dice_4.setImage(d4);
    }

}
