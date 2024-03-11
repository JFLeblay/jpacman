package nl.tudelft.jpacman.game;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;

import com.google.common.collect.ImmutableList;
import nl.tudelft.jpacman.points.PointCalculator;

/**
 * A game with one player and a single level.
 *
 * @author Jeroen Roosen 
 */
public class SinglePlayerGame extends Game {

    /**
     * The Launcher of this game.
     */
    private final Launcher launcher;

    /**
     * The player of this game.
     */
    private final Player player;

    /**
     * The level of this game.
     */
    private Level level;

    /**
     * Create a new single player game for the provided level and player.
     *
     * @param player
     *            The player.
     * @param level
     *            The level.
     * @param pointCalculator
     *            The way to calculate points upon collisions.
     */
    protected SinglePlayerGame(Launcher launcher, Player player, Level level, PointCalculator pointCalculator) {
        super(pointCalculator);

        assert player != null;
        assert level != null;

        this.launcher = launcher;
        this.player = player;
        this.level = level;
        this.level.registerPlayer(player);
    }

    @Override
    public List<Player> getPlayers() {
        return ImmutableList.of(player);
    }

    @Override
    public Level getLevel() {
        return level;
    }

    /**
     * Continues the game after the Pacman was killed and remaining lives > 0
     */
    @Override
    public void resetGame() {
        if (getPlayers().get(0).getRemainingLives() > 0) {

            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

            executorService.schedule(() -> {
                getPlayers().get(0).setAlive(true);
                this.level = launcher.makeLevel();
                this.level.registerPlayer(getPlayers().get(0));
            }, 3, TimeUnit.SECONDS);

        }
    }
}
