package comp1110.ass2.util;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Player;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.Tile;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: u6613739
 * Date: 2019/5/7
 * Time: 15:41
 * Description:
 */
public class PlacementUtil
{
    static String currentPlacment = null;
    static String bestPlacement = "";
    static Integer bestScore = Integer.MIN_VALUE;
    static Board board = new Board();
    private static void initialize()
    {
        currentPlacment = null;
        bestPlacement = "";
        bestScore = Integer.MIN_VALUE;
        board = new Board();
    }
    public static String getResults(String currentPlacementString, String diceRoll,Player player)
    {
        int remainRound = 7 - player.round;
        int remainSp = 4 - player.usedSpeicalTile;
        Map<String,Integer>placementToScoreMap = new HashMap<>();

        String bestPlacement = getResult(currentPlacementString,diceRoll);
        Board board = new Board();
        board.putPlacementStringToMap(currentPlacementString+bestPlacement);
        placementToScoreMap.put(bestPlacement,board.getBonusScoring());
        if(remainSp==0)
        {
            return bestPlacement;
        }


        for(int i=0;i<=5;i++)
        {
            String spDice = "S"+String.valueOf(i);

            String placement = getResult(currentPlacementString,diceRoll+spDice);
            Board newBoard = new Board();
            newBoard.putPlacementStringToMap(currentPlacementString+placement);
            int bestScore = newBoard.getBonusScoring();
            placementToScoreMap.put(placement,bestScore);
        }
        String aiPlacement = softmax(placementToScoreMap);
        updatePlayerUsedSp(player,aiPlacement);
        return aiPlacement;
    }
    private  static  void updatePlayerUsedSp(Player player,String aiPlacement)
    {
        for(int i=0;i<aiPlacement.length();i+=5)
        {
            char ch = aiPlacement.charAt(i);
            if(ch=='S')
            {
                player.usedSpeicalTile++;
            }
        }
    }


    private static String softmax(Map<String,Integer>placementToScoreMap)
    {
        double total = 0;

        //select the placement which score is bigger than 0 and put the e^value to value
        Map<String,Double> placementToSoftmaxMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry : placementToScoreMap.entrySet())
        {
            if(entry.getValue()>0)
            {
                double value = (double)entry.getValue();
                value = Math.pow(Math.E,value);
                placementToSoftmaxMap.put(entry.getKey(),value);
                total+=value;
            }
        }
        //softmax it
        for(Map.Entry<String,Double> entry : placementToSoftmaxMap.entrySet())
        {
            entry.setValue(entry.getValue()/total);
        }
        Random random = new Random();
        double flag = random.nextDouble();
        for(Map.Entry<String,Double> entry : placementToSoftmaxMap.entrySet())
        {
            flag-=entry.getValue();
            if(flag <=0)
            {
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     * get result in greedy method. the diceroll will spilt into n part, and find the best score ,and then find the n-1 part.
     * @param currentPlacementString
     * @param diceRoll
     * @return
     */
    private static String getResult(String currentPlacementString, String diceRoll)
    {
        String result = "";
        List<String> diceList = new ArrayList<>();
        String patternString = "[A-Z][0-9]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher m = pattern.matcher(diceRoll);
        while(m.find())
        {
            diceList.add(m.group());
        }

        while(diceList.size()!=0)
        {
            Map<String, Integer> diceToScoreMap = new HashMap<>();
            for (String dice : diceList)
            {
                String placement = getPlacementByGreedyAlgorithm(currentPlacementString, dice, false);
                Integer score = bestScore.intValue();
                diceToScoreMap.put(placement, score);
            }
            String selectPlacement = findHighestScorePlacement(diceToScoreMap);
            if(selectPlacement.equals(""))break;
            result+=selectPlacement;
            currentPlacementString+=selectPlacement;
            diceList.remove(selectPlacement.substring(0,2));
        }
        return result;

    }
    private static String findHighestScorePlacement(Map<String,Integer> diceToScoreMap)
    {
        int highestScore  = Integer.MIN_VALUE;
        String highestScorePlacement = "";
        for(Map.Entry<String,Integer> entry :diceToScoreMap.entrySet())
        {
            if(entry.getValue()>highestScore)
            {
                highestScorePlacement = entry.getKey();
            }
        }
        return highestScorePlacement;
    }

    private static String getPlacementByGreedyAlgorithm(String currentPlacementString,String diceRoll,boolean CanSpeicalTile)
    {
        initialize();
        currentPlacment = currentPlacementString;
        Tile tile = new Tile();
        List<String> diceList = new ArrayList<>();
        String patternString = "[A-Z][0-9]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher m = pattern.matcher(diceRoll);
        while(m.find())
        {
            diceList.add(m.group());
        }
        board.putPlacementStringToMap(currentPlacementString);
        oneStep(0,diceList,new String());
        System.out.println(bestPlacement);
        return bestPlacement;
    }
    private static void oneStep(int deepth, List<String> diceList,String combination)
    {
        if(deepth == diceList.size())
        {
            int score = evaluation(combination);
            board.removeBoardStringFromBoard(combination);
            //System.out.println("the current combination is: "+combination+", and it scores: "+score);
            if(score>bestScore)
            {
                bestScore = score;
                bestPlacement = combination;
            }
            return;
        }
        String dice = diceList.get(deepth);
        for(char i='A';i<='G';i++)
        {
            for(int j=0;j<=6;j++)
            {
                if(!isCorrectPosition(currentPlacment,String.valueOf(i)+String.valueOf(j)))
                {
                    continue;
                }
                for(int r=0;r<=7;r++)
                {
                    oneStep(deepth+1,diceList,combination+dice+String.valueOf(i)+String.valueOf(j)+String.valueOf(r));
                }
            }
        }
    }
    private static boolean isCorrectPosition(String currentPlacementString, String positionString)
    {
        for(int i=0;i<currentPlacementString.length();i+=5)
        {
            String pos = currentPlacementString.substring(i+2,i+4);
            if(pos.equals(positionString))
            {
                return false;
            }
        }
        return true;
    }


    private static int evaluation(String combination)
    {
        if(!board.isValidBoardStringPlacement(combination))
        {
            return Integer.MIN_VALUE;
        }
        return board.getBonusScoring();
    }
}
