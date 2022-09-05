package javatollgate.model;

import java.io.Serializable;

public class PlayerTeam implements Serializable,Comparable<PlayerTeam> {
    private String playerId;
    private String teamTitle;
    private String season;
    private int experience;

    public PlayerTeam() {
    }

    public PlayerTeam(String playerId, String teamTitle) {
        this.playerId = playerId;
        this.teamTitle = teamTitle;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "PlayerTeam{" +
                "playerId='" + playerId + '\'' +
                ", teamTitle='" + teamTitle + '\'' +
                '}';
    }

    @Override
    public int compareTo(PlayerTeam o) {
        return playerId.compareTo(o.playerId);
    }
}
