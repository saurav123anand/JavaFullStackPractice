package javatollgate.dao;

import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;
import javatollgate.model.PlayerTeam;

import java.io.*;
import java.util.*;

public class PlayerTeamDaoImpl implements PlayerTeamDao{
    TreeSet<PlayerTeam> playerTeamSet;
    PlayerDao playerDao;
    public PlayerTeamDaoImpl(){
        playerTeamSet=new TreeSet<>();
        playerDao=new PlayerDaoImpl();
    }

    @Override
    public boolean addPlayerToTeam(Player player, String teamFileName, String playerFileName) throws PlayerNotFoundException {
        if(player.getTeamTitle()==null){
            return false;
        }
        playerDao.findPlayer(player.getPlayerId(),playerFileName);
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;

        try {
            outputStream=new FileOutputStream(teamFileName);
            objectOutputStream=new ObjectOutputStream(outputStream);
            PlayerTeam playerTeam=new PlayerTeam(player.getPlayerId(),player.getTeamTitle());
            objectOutputStream.writeObject(playerTeam);
            playerTeamSet.add(playerTeam);
            outputStream.close();
            objectOutputStream.close();
            return true;
        }
        catch (IOException e){
            try {
                outputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                objectOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        }
        return false;
    }
    @Override
    public Set<PlayerTeam> getAllPlayerTeams(String fileName) {
        Set<PlayerTeam> players=new HashSet<>();
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            inputStream=new FileInputStream(fileName);
            objectInputStream=new ObjectInputStream(inputStream);
            PlayerTeam playerTeam=(PlayerTeam) objectInputStream.readObject();
            if(playerTeam!=null){
                players.add(playerTeam);
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        } finally {
            close(inputStream);
            close(objectInputStream);
        }
        return players;
    }
    private void close(InputStream inputStream){
        if(inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void close(ObjectInputStream objectInputStream){
        if(objectInputStream!=null){
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle, String fileName) {
        Set<PlayerTeam> teams=new HashSet<>();
        Set<PlayerTeam> playerTeams=getAllPlayerTeams(fileName);
        for(PlayerTeam playerTeam:playerTeams){
            if(playerTeam.getTeamTitle().equalsIgnoreCase(teamTitle)){
                teams.add(playerTeam);
            }
        }
        return teams;
    }
}
