import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Game source;

    @BeforeEach
    public void TestEquipment() {
        player1 = new Player(1, "valera", 15);
        player2 = new Player(2, "ultraKnightExtraKill", 10);
        player3 = new Player(3, "A fan of playing in a draw", 10);
        source = new Game();
        source.register(player1);
        source.register(player2);
        source.register(player3);
    }

    @Test
    public void shouldRegister() {
        ArrayList<Player> exp = new ArrayList<>();
        exp.add(player1);
        exp.add(player2);
        exp.add(player3);
        ArrayList<Player> act = source.getPlayers();

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldWinFirst() {
        int exp = 1;
        int act = source.round(player1, player2);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldWinSecond() {
        int exp = 2;
        int act = source.round(player2, player1);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldDraw() {
        int exp = 0;
        int act = source.round(player2, player3);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldThrowException() {
        Player exceptionist = new Player(500, "Exception666", 100_000_000);
        ;
        Assertions.assertThrows(NotRegisteredException.class,
                () -> source.round(player2, exceptionist));
    }

    @Test
    public void onlyFirstRegisteredPlayer() {
        Assertions.assertThrows(NotRegisteredException.class,
                () -> source.round(player2, player4));
    }

    @Test
    public void onlySecondRegisteredPlayer() {
        Assertions.assertThrows(NotRegisteredException.class,
                () -> source.round(player4, player2));
    }
}
