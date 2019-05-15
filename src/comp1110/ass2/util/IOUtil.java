package comp1110.ass2.util;

import comp1110.ass2.model.EnumTypePlayer;
import comp1110.ass2.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: u6613739
 * Date: 2019/5/15
 * Time: 20:10
 * Description:
 */
public class IOUtil
{
    public static class ScoreRecoder
    {
        public String playerName;
        public int score;
    }

    public static void updateBestGameScore()
    {
        List<ScoreRecoder> list = readBestScoreFromFile();


        for(Player player : StageManager.playerList)
        {
            if(player.playerType== EnumTypePlayer.AI)
            {
                continue;
            }
            ScoreRecoder scoreRecoder = new ScoreRecoder();
            scoreRecoder.playerName = player.playerName;
            scoreRecoder.score = player.getFinalScore();
            list.add(scoreRecoder);
        }
        list = list.stream().sorted((Comparator.comparingInt(o -> o.score))).collect(Collectors.toList());
        if(list.size()>5)
        {
            list = list.subList(0, 5);
        }
        writeBestGameScore(list);

    }

    private static void writeBestGameScore(List<ScoreRecoder> list)
    {

        File file = new File("bestScore.txt");
        if (file.exists() && file.isFile())
        {
            file.delete();
        }

        StringBuilder sb  = new StringBuilder();
        for(ScoreRecoder item : list)
        {
            sb.append(item.playerName+"\t"+String.valueOf(item.score)+"\r\n");
        }
        String result = sb.toString();
        try
        {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bestScore.txt"),"utf-8"));
            out.write(result.trim());
            out.flush();
            out.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static List<ScoreRecoder> readBestScoreFromFile()
    {
        //TODO; may change it with Json. but it will improt Gson.jar.
        List<ScoreRecoder> list = new ArrayList<>();
        try
        {

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("bestScore.txt"),"utf-8"));
        String str = null;

        while((str = in.readLine())!=null)
        {

            String[] strs = str.split("\t");
            ScoreRecoder scoreRecoder = new ScoreRecoder();
            scoreRecoder.playerName = strs[0];
            scoreRecoder.score = Integer.valueOf(strs[1]);
            list.add(scoreRecoder);
        }
        in.close();
        }
        catch (Exception e)
        {
            System.out.println("read bestScore.txt file error!");
            System.out.println(e.toString());
        }
        return list;
    }
}
