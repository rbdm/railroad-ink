package comp1110.ass2.controller;

import comp1110.ass2.util.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * User: u6613739
 * Date: 2019/5/4
 * Time: 13:22
 * Description:
 */
public class StartFormController implements Initializable
{
    @FXML
    private Button btn_NewGame;

    @FXML
    private Button btn_HighScore;

    @FXML
    private ComboBox comboBox_PlayerNumber;
    @FXML
    private Label label_tip;

    public void btn_NewGame_Click(ActionEvent actionEvent) throws IOException
    {
        if (comboBox_PlayerNumber.getValue() == null)
        {
            label_tip.setText("you should select the number of player");
            return;
        }
        Stage startFormStage = StageManager.stageMap.get("StartFormStage");
        startFormStage.hide();
        StageManager.playerNumber = Integer.valueOf(comboBox_PlayerNumber.getValue().toString());
        GameStageController.totalPlayerNum = Integer.valueOf(comboBox_PlayerNumber.getValue().toString());
        //open a stage
        StageManager.playerNumber--;
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("resource/OptionForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("OptionForm");
        stage.show();
        StageManager.stageMap.put("OptionFormStage", stage);

    }

    /**
     * show the highest score windows
     * @param actionEvent actionEvent
     * @throws IOException exception if read the bestScore.txt failed.
     */
    public void btn_HighScore_Click(ActionEvent actionEvent) throws IOException
    {
        StageManager.isShownBestScore = true;
        Stage curr = StageManager.stageMap.get("StartFormStage");
        curr.hide();
        Stage scoreFormStage = new Stage();
        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("resource/ScoreForm.fxml"));
        Scene scene = new Scene(root);
        scoreFormStage.setScene(scene);
        scoreFormStage.setTitle("BestScoreForm");
        scoreFormStage.show();
        StageManager.stageMap.put("ScoreFormStage",scoreFormStage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        StageManager.controllerMap.put("StartFormStage", this);
        //intialize the item of comboBox_PlayerNumber
        ObservableList<String> playerNumberList = FXCollections.observableArrayList("1", "2", "3", "4");
        comboBox_PlayerNumber.setItems(playerNumberList);

    }
}
