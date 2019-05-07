package comp1110.ass2.util;

import comp1110.ass2.model.Board;
import comp1110.ass2.model.Square;
import comp1110.ass2.model.Tile;

import java.util.ArrayList;
import java.util.List;
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
    static String bestPlacement = null;
    static Integer bestScore = Integer.MIN_VALUE;
    public static String getPlacementByGreedyAlgorithm(String currentPlacementString,String diceRoll,boolean CanSpeicalTile)
    {
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
        oneStep(0,diceList,new String());
        return bestPlacement;
    }
    private static void oneStep(int deepth, List<String> diceList,String combination)
    {
        if(deepth == diceList.size())
        {
            int score = evaluation(combination);
            System.out.println("the current combination is: "+combination+", and it scores: "+score);
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
                for(int r=0;r<=7;r++)
                {
                    oneStep(deepth+1,diceList,combination+dice+String.valueOf(i)+String.valueOf(j)+String.valueOf(r));
                }
            }
        }
    }
    private static int evaluation(String combination)
    {
        Board board = new Board();
        if(!board.isValidBoardStringPlacement(currentPlacment+combination))
        {
            return Integer.MIN_VALUE;
        }
        return board.getBonusScoring();
    }
}
