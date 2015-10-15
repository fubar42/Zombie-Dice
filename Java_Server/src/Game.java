import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by s213391244 on 10/15/2015.
 */
public class Game extends Thread {
    private Collection<Player> players;

    public Game(ArrayList<String> handles) {
        for (String handle : handles) {
            players.add(new Player(handle));
        }
    }

    public Collection<Player> getPlayers() {
        return players;
    }
    public void removePlayer(String handle){
        for(Player player : players){
            if(handle.equals(player.getUserHandle())){
                players.remove(player);
            }
        }
    }

    @Override
    public void run() {
        super.run();
    }
}
