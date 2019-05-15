package comp1110.ass2.util;

import comp1110.ass2.model.*;

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

    /**
     * initialize all the static variable to original state.
     */
    private static void initialize()
    {
        currentPlacment = null;
        bestPlacement = "";
        bestScore = Integer.MIN_VALUE;
        board = new Board();
    }

    /**
     * get the placement result of a AI player.
     * @param currentPlacementString
     * @param diceRoll
     * @param player
     * @return
     */
    public static String getResults(String currentPlacementString, String diceRoll, Player player)
    {
        int remainRound = 7 - player.round;
        int remainSp = 3 - player.usedSpeicalTile;

        //if is Easy model, just use random
        if(player.getDifficulty()== EnumTypeDifficulty.EASY)
        {
            String aiPlacement =getPlacementRandom(currentPlacementString,diceRoll,player, remainSp > 0);
            System.out.println(String.format("Player: %s's placement is: %s",player.playerName,aiPlacement));
            return aiPlacement;
        }
        //if is Hard model, use Greedy method.
        Map<String, Integer> placementToScoreMap = new HashMap<>();
        //get the best result with greedy method.
        String bestPlacement = getResult(currentPlacementString, diceRoll);
        Board board = new Board();
        board.putPlacementStringToMap(currentPlacementString + bestPlacement);
        placementToScoreMap.put(bestPlacement, board.getBonusScoring());

        //check if we have remain Special tile.
        if (remainSp == 0)
        {
            return bestPlacement;
        }

        //find the best Sp tile.
        for (int i = 0; i <= 5; i++)
        {
            String spDice = "S" + String.valueOf(i);
            if(isSpUsed(player,spDice))
            {
                continue;
            }

            String placement = getResult(currentPlacementString, diceRoll + spDice);
            Board newBoard = new Board();
            newBoard.putPlacementStringToMap(currentPlacementString + placement);
            int bestScore = newBoard.getBonusScoring();
            placementToScoreMap.put(placement, bestScore);
        }
        String aiPlacement = softmax(placementToScoreMap);
        updatePlayerUsedSp(player, aiPlacement);

        System.out.println(String.format("Player: %s's placement is: %s",player.playerName,aiPlacement));
        return aiPlacement;
    }

    /**
     * get a placement radomly
     * @param currentPlacementString the current placement
     * @param diceRoll all dice roll ,like A0A2A3B0
     * @param player the player
     * @param canUseSp can we use sp tile
     * @return a Ai placement lie A0D21A2C33A3B40B0C01
     */
    private static String getPlacementRandom(String currentPlacementString, String diceRoll, Player player,boolean canUseSp)
    {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i=0;i<diceRoll.length();i+=2)
        {
            List<String> possibleList = getAllPossiblePlacement(currentPlacementString,diceRoll.substring(i,i+2));
            int index = random.nextInt(possibleList.size());
            currentPlacementString+=possibleList.get(index);
            sb.append(possibleList.get(index));
        }
        if(random.nextInt(2)==1)
        {
            String sp = "S" + Integer.valueOf(random.nextInt(6));
            List<String> possibleList = getAllPossiblePlacement(currentPlacementString,sp);
            int index = random.nextInt(possibleList.size());
            sb.append(possibleList.get(index));
        }
        return sb.toString();

    }

    /**
     * get all possible placement of a dice
     * @param currentPlacment currentplacement
     * @param diceRoll a dice roll like A0
     * @return the list of all possible placement.
     */
    private static List<String> getAllPossiblePlacement(String currentPlacment,String diceRoll)
    {

        List<String> list = new ArrayList<>();
        for (char i = 'A'; i <= 'G'; i++)
        {
            for (int j = 0; j <= 6; j++)
            {
                if (! isCorrectPosition(currentPlacment, String.valueOf(i) + String.valueOf(j)))
                {
                    continue;
                }
                for (int r = 0; r <= 7; r++)
                {
                    Board board = new Board();
                    if (board.isValidBoardStringPlacement(currentPlacment + diceRoll + String.valueOf(i) + String.valueOf(j) + String.valueOf(r)))
                    {
                        list.add(diceRoll + String.valueOf(i) + String.valueOf(j) + String.valueOf(r));
                    }
                }
            }
        }

        return list;

    }

    /**
     * to check if the Special tile is used.
     * @param player player
     * @param sp the string of special tile
     * @return is used?
     */
    private static boolean isSpUsed(Player player,String sp)
    {
        String currentPlacement = player.getBoardString();
        for(int i=0;i<currentPlacement.length();i+=5)
        {
            if(currentPlacement.substring(i,i+2).equals(sp))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * update the detail of usedSptile in player.
     * @param player player
     * @param aiPlacement the ai's placement.
     */
    private static void updatePlayerUsedSp(Player player, String aiPlacement)
    {
        for (int i = 0; i < aiPlacement.length(); i += 5)
        {
            char ch = aiPlacement.charAt(i);
            if (ch == 'S')
            {
                player.usedSpeicalTile++;
            }
        }
    }

    /**
     * use softmax to avoid all ai make the same move.
     * also it is a method to try to make the ai select the highest score placement (max possibility).
     * @param placementToScoreMap the placement with their score map
     * @return a softmax placement.
     */
    private static String softmax(Map<String, Integer> placementToScoreMap)
    {
        double total = 0;

        //select the placement which score is bigger than 0 and put the e^value to value
        Map<String, Double> placementToSoftmaxMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : placementToScoreMap.entrySet())
        {
            if (entry.getValue() > 0)
            {
                double value = (double) entry.getValue();
                value = Math.pow(Math.E, value);
                placementToSoftmaxMap.put(entry.getKey(), value);
                total += value;
            }
        }
        //softmax it
        for (Map.Entry<String, Double> entry : placementToSoftmaxMap.entrySet())
        {
            entry.setValue(entry.getValue() / total);
        }
        Random random = new Random();
        double flag = random.nextDouble();
        for (Map.Entry<String, Double> entry : placementToSoftmaxMap.entrySet())
        {
            flag -= entry.getValue();
            if (flag <= 0)
            {
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     * get result in greedy method. the diceroll will spilt into n part, and find the best score ,and then find the n-1 part.
     *
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
        while (m.find())
        {
            diceList.add(m.group());
        }

        while (diceList.size() != 0)
        {
            Map<String, Integer> diceToScoreMap = new HashMap<>();
            for (String dice : diceList)
            {
                String placement = getPlacementByGreedyAlgorithm(currentPlacementString, dice, false);
                Integer score = bestScore.intValue();
                diceToScoreMap.put(placement, score);
            }
            String selectPlacement = findHighestScorePlacement(diceToScoreMap);
            if (selectPlacement.equals(""))
                break;
            result += selectPlacement;
            currentPlacementString += selectPlacement;
            diceList.remove(selectPlacement.substring(0, 2));
        }
        return result;

    }

    /**
     * find the highest score placement
     * @param diceToScoreMap the dice and the socre map.
     * @return the highest score placement.
     */
    private static String findHighestScorePlacement(Map<String, Integer> diceToScoreMap)
    {
        int highestScore = Integer.MIN_VALUE;
        String highestScorePlacement = "";
        for (Map.Entry<String, Integer> entry : diceToScoreMap.entrySet())
        {
            if (entry.getValue() > highestScore)
            {
                highestScorePlacement = entry.getKey();
            }
        }
        return highestScorePlacement;
    }

    /**
     * use greedy method to get placment.
     * @param currentPlacementString the current placement.
     * @param diceRoll the dice roll
     * @param CanSpeicalTile can we use speical tile
     * @return a placement.
     */
    private static String getPlacementByGreedyAlgorithm(String currentPlacementString, String diceRoll, boolean CanSpeicalTile)
    {
        initialize();
        currentPlacment = currentPlacementString;
        Tile tile = new Tile();
        List<String> diceList = new ArrayList<>();
        String patternString = "[A-Z][0-9]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher m = pattern.matcher(diceRoll);
        while (m.find())
        {
            diceList.add(m.group());
        }
        board.putPlacementStringToMap(currentPlacementString);
        oneStep(0, diceList, new String());
        System.out.println(bestPlacement);
        return bestPlacement;
    }

    /**
     * the recurison of 4 dice.
     * but currently, I find with 4 dice it will cost to much time on recursion,
     * so it just make 1 dice when the method is called.
     * that means, i don't use the recursion.
     * I try to cut some branch to fasten it .
     * But it performance is still bad.
     * I will learn the CSPs and try to use minium value method to solve it.
     *
     * @param deepth the deepth of recursion
     * @param diceList the dicelist
     * @param combination the placement combination we have selected.
     */
    private static void oneStep(int deepth, List<String> diceList, String combination)
    {
        if (deepth == diceList.size())
        {
            int score = evaluation(combination);
            board.removeBoardStringFromBoard(combination);
            //System.out.println("the current combination is: "+combination+", and it scores: "+score);
            if (score > bestScore)
            {
                bestScore = score;
                bestPlacement = combination;
            }
            return;
        }
        String dice = diceList.get(deepth);
        for (char i = 'A'; i <= 'G'; i++)
        {
            for (int j = 0; j <= 6; j++)
            {
                if (! isCorrectPosition(currentPlacment, String.valueOf(i) + String.valueOf(j)))
                {
                    continue;
                }
                for (int r = 0; r <= 7; r++)
                {
                    oneStep(deepth + 1, diceList, combination + dice + String.valueOf(i) + String.valueOf(j) + String.valueOf(r));
                }
            }
        }
    }

    /**
     * to check if this position can be put a tile
     * @param currentPlacementString currentPlacement
     * @param positionString the position.
     * @return can put?
     */
    private static boolean isCorrectPosition(String currentPlacementString, String positionString)
    {
        for (int i = 0; i < currentPlacementString.length(); i += 5)
        {
            String pos = currentPlacementString.substring(i + 2, i + 4);
            if (pos.equals(positionString))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * to evaluaton the combination's score
     * @param combination the aiplacement
     * @return the score.
     */
    private static int evaluation(String combination)
    {
        if (! board.isValidBoardStringPlacement(combination))
        {
            return Integer.MIN_VALUE;
        }
        return board.getBonusScoring();
    }
}
