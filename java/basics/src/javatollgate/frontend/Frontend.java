package javatollgate.frontend;

import javatollgate.dao.PlayerDao;
import javatollgate.model.Player;
import javatollgate.service.IPlayerService;
import javatollgate.service.PlayerServiceImpl;

import java.util.Collection;
import java.util.List;

public class Frontend {
    public void runUI(){
        Frontend frontend=new Frontend();
        String playerCsvFilePath="D:/JavaFullStackPractice/java/basics/src/javatollgate/resources/player.csv";
        IPlayerService iPlayerService=new PlayerServiceImpl();
        try {
            System.out.println("Registering the player***************************");
            // registering the players
            String  msg1=iPlayerService.addPlayer(new Player("playerid1","Virat Kohli","passowrd1",
                    10),playerCsvFilePath);
            String  msg2=iPlayerService.addPlayer(new Player("playerid2","MS Dhoni","passowrd2",
                    11),playerCsvFilePath);

            System.out.println("*************************");
            //getting all the players
            List<Player> getAllPlayers=iPlayerService.getAllPlayers(playerCsvFilePath);
            frontend.display(getAllPlayers);

        }
        catch (Exception e){
            System.out.println("error occurred");
        }

    }
    private void display(Collection<Player> players){
        for(Player player:players){
            System.out.println(player);

        }
    }

}
