package javatollgate.service;

import javatollgate.dao.PlayerDao;
import javatollgate.dao.PlayerDaoImpl;
import javatollgate.exception.InvalidIdException;
import javatollgate.exception.PlayerAlreadyExistsException;
import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;

import java.util.List;

public class PlayerServiceImpl implements IPlayerService {
    PlayerDao playerDao=new PlayerDaoImpl();
    @Override
    public String addPlayer(Player player, String fileName) throws PlayerAlreadyExistsException {
        validate(player.getPlayerId());
        boolean msg=playerDao.addPlayer(player,fileName);
        if(msg){
            return "Player added";
        }
        return "some error occurred while adding the Player";
    }

    private void validate(String playerId) throws InvalidIdException {
        if(playerId==null || playerId.isEmpty() || playerId.length()<0){
            throw new InvalidIdException("Invalid id ");
        }
    }

    @Override
    public List<Player> getAllPlayers(String fileName) {
        List<Player> players=playerDao.getAllPlayers(fileName);
        return players;
    }

    @Override
    public Player findPlayer(String playerId, String fileName) throws PlayerNotFoundException {
        Player player=playerDao.findPlayer(playerId,fileName);
        return player;
    }
}
