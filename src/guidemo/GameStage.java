package guidemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;

public class GameStage {

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
    private ImageView dice_1;

    @FXML
    private ImageView dice_2;

    @FXML
    private ImageView dice_3;

    @FXML
    private ImageView dice_4;

    @FXML
    private GridPane pane_board;

    @FXML
    private Label lb_specTile;

    @FXML
    void btn_nextTurn_click(MouseEvent event) {

    }

    @FXML
    void tileRotateFlip(ScrollEvent event) {

    }

}

