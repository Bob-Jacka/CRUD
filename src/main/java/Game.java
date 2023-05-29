import java.util.HashMap;

public class Game {
    private static final HashMap<String, Player> players = new HashMap<>();

    public void register(Player person) {
        players.put(person.getName(), person);
    }

    public int round(Player person1, Player person2) {
        if (players.containsKey(person1.getName())
                && players.containsKey(person2.getName())) {
            if (person1.getStrength() > person2.getStrength()) return 1;
            else if (person2.getStrength() > person1.getStrength()) return 2;
            else return 0;
        } else {
            throw new NotRegisteredException();
        }
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
