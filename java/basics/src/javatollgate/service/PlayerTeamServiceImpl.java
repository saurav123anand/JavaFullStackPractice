package javatollgate.service;

import javatollgate.dao.PlayerTeamDao;
import javatollgate.dao.PlayerTeamDaoImpl;
import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;
import javatollgate.model.PlayerTeam;

import java.util.Set;

public class PlayerTeamServiceImpl implements IPlayerTeamService{
    PlayerTeamDao playerTeamDao=new PlayerTeamDaoImpl();
    @Override
    public String addPlayerToTeam(Player player, String teamFileName, String playerFileName) throws PlayerNotFoundException {
        boolean msg=playerTeamDao.addPlayerToTeam(player,teamFileName,playerFileName);
        if(msg){
            return "Player has been added to the team";
        }
        return "some problem occurred while adding the player into the team";
    }

    @Override
    public Set<PlayerTeam> getAllPlayerTeams(String fileName) {
        Set<PlayerTeam> playerTeams= playerTeamDao.getAllPlayerTeams(fileName);
        return playerTeams;
    }

    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle, String fileName) {
        Set<PlayerTeam> playerTeams=playerTeamDao.getPlayerSetByTeamTitle(teamTitle,fileName);
        return playerTeams;
    }
}
