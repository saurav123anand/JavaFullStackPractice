package javatollgate.dao;

import javatollgate.exception.PlayerAlreadyExistsException;
import javatollgate.exception.PlayerNotFoundException;
import javatollgate.model.Player;

import java.io.*;
import java.util.*;

public class PlayerDaoImpl implements PlayerDao{
    List<Player> playerList;
    public PlayerDaoImpl(){
        playerList=new ArrayList<>();
    }
    @Override
    public boolean addPlayer(Player player, String fileName) throws PlayerAlreadyExistsException{
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;
        if(player==null || player.getPassword().length()<6 || player.getYearExpr()<=0 ){
            return false;
        }
        if(playerList.contains(player)){
            throw new PlayerAlreadyExistsException("Player already present");
        }
        try {
            outputStream=new FileOutputStream(fileName);
            objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(player);
            playerList.add(player);
            objectOutputStream.flush();
            outputStream.close();
            objectOutputStream.close();
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
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
        }
        return false;
    }

    @Override
    public List<Player> getAllPlayers(String fileName) {
        List<Player> players=new ArrayList<>();
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            inputStream=new FileInputStream(fileName);
            objectInputStream=new ObjectInputStream(inputStream);
            Player player=(Player)objectInputStream.readObject();
            if(player!=null){
                players.add(player);
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
    public Player findPlayer(String playerId, String fileName) throws PlayerNotFoundException {
        if(playerId==null || playerId.trim().isEmpty()){
            throw new PlayerNotFoundException("Id is invalid");
        }
        List<Player> players=getAllPlayers(fileName);
        for(Player player:players){
            if(player.getPlayerId()==playerId){
                return player;
            }
        }
        throw new PlayerNotFoundException("Player Not found");
    }
}
