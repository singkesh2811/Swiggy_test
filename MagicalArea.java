import java.util.Random;

public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Game game = new Game(playerA, playerB);
        game.start();
    }
}

class Player {
    int health;
    int strength;
    int attack;

    Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    boolean isAlive() {
        return health > 0;
    }
}

class Game {
    Player playerA;
    Player playerB;
    Random random = new Random();

    Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    void start() {
        Player attacker = playerA.health <= playerB.health ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            int attackRoll = rollDice();
            int defendRoll = rollDice();
            int attackDamage = attacker.attack * attackRoll;
            int defendStrength = defender.strength * defendRoll;
            int damage = Math.max(0, attackDamage - defendStrength);
            defender.health -= damage;

            System.out.println(attacker == playerA ? "Player A" : "Player B" + " attacks with roll " + attackRoll +
                    ", Player " + (defender == playerA ? "A" : "B") + " defends with roll " + defendRoll +
                    ". Damage: " + damage + ". Health left: " + defender.health);

            // Switch roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Game Over! " + (playerA.isAlive() ? "Player A wins!" : "Player B wins!"));
    }

    int rollDice() {
        return random.nextInt(6) + 1;
    }
}
