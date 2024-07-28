import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testGame() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Game game = new Game(playerA, playerB);

        // Simulate a few rounds
        playerA.health = 0; // Simulate playerA losing
        assertFalse(playerA.isAlive());
        assertTrue(playerB.isAlive());
    }
}
