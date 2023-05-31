import java.util.HashMap;

public class Game {
    private final HashMap<String, Player> players = new HashMap<>();

    public void register(Player person) {
        players.put(person.getName(), person);
    }

    public int round(String personName1, String personName2) {
        if (players.containsKey(personName1) && players.containsKey(personName2)) {
            if (players.get(personName1).getStrength() > players.get(personName2).getStrength()) {
                return 1;
            } else if (players.get(personName2).getStrength() > players.get(personName1).getStrength()) {
                return 2;
            } else {
                return 0;
            }
        } else {
            throw new NotRegisteredException();
        }
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
