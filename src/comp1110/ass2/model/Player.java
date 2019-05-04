package comp1110.ass2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: u6613739
 * Date: 2019/5/4
 * Time: 14:41
 * Description:
 */
public class Player
{
    /**
     * the uuid of player to identify player.
     */
    private UUID id;
    /**
     * the player name
     */
    private String playerName;
    /**
     * the round index.
     */
    private int round = 0;
    /**
     * the player's board.
     */
    private Board board = new Board();
    /**
     * the square player putted.
     * the element is a list which contains 3 String of placement :like A0B01,XXXXX,XXXXX
     */
    private List<List<String>> roundPlacementList = new ArrayList<>();
    /**
     * the number of used S tile
     */
    private int usedSpeicalTile = 0;
    /**
     * player tpye: AI or HUMAN
     */
    private EnumTypePlayer playerType ;
    /**
     * AI difficulty, only use in AI mode.
     */
    private EnumTypeDifficulty difficulty ;

    public Player(String playerName, String playerType, String difficulty)
    {
        id = UUID.randomUUID();
        if (playerName.equals(""))
        {
            this.playerName = "default";
        }
        else
        {
            this.playerName = playerName;
        }

        if (playerType.toUpperCase().equals("HUMAN"))
        {
            this.playerType = EnumTypePlayer.HUMAN;
        }
        else
        {
            this.playerType = EnumTypePlayer.AI;
        }

        switch (difficulty.toUpperCase())
        {
            case "EASY":
                this.difficulty = EnumTypeDifficulty.EASY;
                break;
            case "HARD":
                this.difficulty = EnumTypeDifficulty.HARD;
                break;
            default:
                this.difficulty = EnumTypeDifficulty.EASY;
                break;
        }

    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id: "+id+"; playerName: "+playerName+"; playerType: "+playerType+"; difficulty: "+difficulty+" ; round: "+round+";");
        return sb.toString();
    }


}
