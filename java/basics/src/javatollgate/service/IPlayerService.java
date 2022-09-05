package javatollgate.service;

import javatollgate.exception.PlayerAlreadyExistsException;
import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;

import java.util.List;

public interface IPlayerService {
    String addPlayer(Player player, String fileName) throws PlayerAlreadyExistsException;
    List<Player> getAllPlayers(String fileName);
    Player findPlayer(String playerId, String fileName) throws PlayerNotFoundException;

}
