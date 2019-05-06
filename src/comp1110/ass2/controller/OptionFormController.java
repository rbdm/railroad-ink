package comp1110.ass2.controller;

import comp1110.ass2.model.Player;
import comp1110.ass2.util.StageManager;
import guidemo.GameStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * User: u6613739
 * Date: 2019/5/4
 * Time: 14:18
 * Description:
 */
public class OptionFormController implements Initializable
{

    @FXML
    private TextField textFiled_PlayerName;

    @FXML
    private RadioButton radio_btn_Human;

    @FXML
    private ToggleGroup player_type;

    @FXML
    private RadioButton radio_btn_AI;

    @FXML
    private ComboBox combox_Difficulty;

    @FXML
    private Button btn_Next;

    @FXML
    private Button btn_Clear;

    @FXML
    private Label label_InputNumber;

    @FXML
    void btn_Clear_Click(ActionEvent event)
    {
        textFiled_PlayerName.setText("");
        radio_btn_Human.setSelected(true);
        radio_btn_AI.setSelected(false);
        combox_Difficulty.setDisable(true);
        combox_Difficulty.setPromptText("Easy");

    }

    @FXML
    void btn_Next_Click(ActionEvent event) throws IOException
    {
        String playerType = "HUMAN";
        if(radio_btn_AI.isSelected())
        {
            playerType = "AI";
        }
        String difficulty = "Easy";
        if(combox_Difficulty.getValue()!=null)
        {
            difficulty = combox_Difficulty.getValue().toString();
        }
        Player player = new Player(textFiled_PlayerName.getText(),playerType,difficulty);
        System.out.println(player.toString());
        StageManager.playerList.add(player);


        if(StageManager.playerNumber==0)
        {
            System.out.println("finish option selection");
            //TODO get the new windows
            Stage gameStageOne = new Stage();
            Parent rootOne = FXMLLoader.load(ClassLoader.getSystemResource("guidemo/gameStage.fxml"));
            Scene sceneOne = new Scene(rootOne);
            gameStageOne.setScene(sceneOne);
            gameStageOne.setTitle("gameStage");
            StageManager.stageMap.put("gameStage",gameStageOne);

            Stage optionFormStage = StageManager.stageMap.get("OptionFormStage");
            optionFormStage.hide();
            gameStageOne.show();


        }
        StageManager.playerNumber--;
        int number = Integer.valueOf(label_InputNumber.getText().toString());
        label_InputNumber.setText(String.valueOf(number+1));
        btn_Clear_Click(event);
    }
    @FXML
    void radio_btn_Human_Click(ActionEvent event) {
        combox_Difficulty.setDisable(true);
    }
    @FXML
    void radio_btn_AI_Click(ActionEvent event) {
        combox_Difficulty.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        //intialize the item of comboBox_PlayerNumber
        ObservableList<String> playerNumberList = FXCollections.observableArrayList("Easy", "Hard");
        combox_Difficulty.setItems(playerNumberList);
        StageManager.controllerMap.put("OptionFormStage",this);
        label_InputNumber.setText("1");

    }

}
