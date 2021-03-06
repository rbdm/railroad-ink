package comp1110.ass2.controller;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Player;
import comp1110.ass2.util.IOUtil;
import comp1110.ass2.util.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User: u6613739
 * Date: 2019/5/13
 * Time: 17:51
 * Description:
 */


public class ScoreFormController implements Initializable
{

    @FXML
    private Button btn_BackToWelcome;

    @FXML
    private Label label_Score;

    @FXML
    private Label label_Player;

    @FXML
    void backToWelcome(ActionEvent event)
    {
        Object obj = StageManager.stageMap.get("StartFormStage");
        if (obj == null)
        {
            System.out.println("can't get StartFormStage from StageManager");
            return;
        }

        Stage startFormstage = (Stage) obj;
        startFormstage.show();

        for (Map.Entry<String, Stage> entry : StageManager.stageMap.entrySet())
        {
            if (! entry.getKey().equals("StartFormStage"))
            {
                entry.getValue().close();
                StageManager.stageMap.remove(entry);
            }
        }
        StageManager.playerNumber = 1;
        StageManager.playerList.clear();
        StageManager.diceRollList.clear();
        StageManager.controllerMap.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if(StageManager.isShownBestScore)
        {
            initializeBestGameScore();
        }
        else
        {
            initializeCurrentGameScore();
        }
    }

    /**
     * to set the text of label if it shows the best score.
     */
    private void initializeBestGameScore()
    {
        label_Score.setText("Score");
        label_Player.setText("Player");
        String scoreText = "Score\r\n\r\n";
        String playerText = "Player\r\n\r\n";

        List<IOUtil.ScoreRecoder> list =  IOUtil.readBestScoreFromFile();

        for(IOUtil.ScoreRecoder item : list)
        {
            scoreText += (item.score + "\r\n\r\n");
            playerText += (item.playerName + "\r\n\r\n");
        }
        label_Score.setText(scoreText);
        label_Player.setText(playerText);

    }

    /**
     * to set the text of label if it shows the current score after a game.
     */
    private void initializeCurrentGameScore()
    {
        label_Score.setText("Score");
        label_Player.setText("Player");
        String scoreText = "Score\r\n\r\n";
        String playerText = "Player\r\n\r\n";
        for (Player player : StageManager.playerList)
        {

            Board board = new Board();
            board.putPlacementStringToMap(player.getBoardString());
            player.setFinalScore(board.getBonusScoring());
        }

        StageManager.playerList = StageManager.playerList.stream().sorted(Comparator.comparingInt(Player :: getFinalScore)).collect(Collectors.toList());
        Collections.reverse(StageManager.playerList);
        for (Player player : StageManager.playerList)
        {
            scoreText += (player.getFinalScore() + "\r\n\r\n");
            playerText += (player.playerName + "\r\n\r\n");
        }
        label_Score.setText(scoreText);
        label_Player.setText(playerText);
        IOUtil.updateBestGameScore();
    }



}

