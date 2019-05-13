package comp1110.ass2.util;

import comp1110.ass2.model.Player;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: u6613739
 * Date: 2019/5/4
 * Time: 15:26
 * Description:
 */
public class StageManager
{
    public static int playerNumber = 1;
    public static List<Player> playerList = new ArrayList<>();
    public static Map<String, Stage> stageMap=new HashMap<String, Stage>();
    public static Map<String, Object> controllerMap=new HashMap<String, Object>();
    public static List<String> diceRollList = new ArrayList<>();


}
