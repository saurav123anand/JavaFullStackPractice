package javatollgate.dao;

import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;
import javatollgate.model.PlayerTeam;

import java.util.Set;

public interface PlayerTeamDao {
    boolean addPlayerToTeam(Player player, String teamFileName, String playerFileName) throws PlayerNotFoundException;

    Set<PlayerTeam> getAllPlayerTeams(String fileName);

    Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle, String fileName);

}
