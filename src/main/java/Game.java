import java.util.ArrayList;

public class Game {
    private static final ArrayList<Player> players = new ArrayList<>();

    public void register(Player person) {
        players.add(person);
    }

    public int round(Player person1, Player person2) {
        if (players.contains(person1) && players.contains(person2)) {
            if (person1.getStrength() > person2.getStrength()) return 1;
            else if (person2.getStrength() > person1.getStrength()) return 2;
            else return 0;
        } else {
            throw new NotRegisteredException();
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
