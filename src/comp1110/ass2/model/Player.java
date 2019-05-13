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
    public String playerName;
    /**
     * the round index.
     */
    public int round = 0;
    /**
     * the player's board.
     */
    private Board board = new Board();
    /**
     * the player's boardString.
     */
    private String boardString = "";
    /**
     * the square player putted.
     * the element is a list which contains 3 String of placement :like A0B01,XXXXX,XXXXX
     */
    private List<List<String>> roundPlacementList = new ArrayList<>();
    /**
     * the number of used S tile
     */
    public int usedSpeicalTile = 0;
    /**
     * player tpye: AI or HUMAN
     */
    public EnumTypePlayer playerType ;
    /**
     * AI difficulty, only use in AI mode.
     */
    private EnumTypeDifficulty difficulty ;
    /**
     * final score.
     */
    private int finalScore;

    public void setFinalScore(int finalScore)
    {
        this.finalScore = finalScore;
    }
    public int getFinalScore()
    {
        return this.finalScore;
    }

    public String getPlayerName(){
        return playerName;
    }

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

    public String getBoardString() {
        return this.boardString;
    }


    public void appendBoardString(String placementString) {
        this.boardString += placementString;
    }

    public void setBoardString(String newBoardString) {
        this.boardString = newBoardString;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board newBoard) {
        this.board = newBoard;
    }



}
