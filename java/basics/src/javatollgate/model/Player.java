package javatollgate.model;

import java.io.Serializable;

public class Player implements Serializable,Comparable<Player>{
    private String playerId;
    private String playerName;
    private String password;
    private int yearExpr;
    private String teamTitle;

    public Player() {
    }

    public Player(String playerId, String playerName, String password, int yearExpr) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.password = password;
        this.yearExpr = yearExpr;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYearExpr() {
        return yearExpr;
    }

    public void setYearExpr(int yearExpr) {
        this.yearExpr = yearExpr;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    @Override
    public String toString() {
        if(teamTitle==null || teamTitle.isEmpty()){
            return "Player{" +
                    "playerId='" + playerId + '\'' +
                    ", playerName='" + playerName + '\'' +
                    ", yearExpr=" + yearExpr + '\'' +
                    '}';

        }
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", yearExpr=" + yearExpr +
                ", teamTitle='" + teamTitle + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        return this.playerId.compareTo(o.playerId);
    }
}
