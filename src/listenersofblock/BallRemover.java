/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package listenersofblock;

import gamesettings.Counter;
import gamesettings.GameLevel;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * a BallRemover is in charge of removing balls from the game, as well as keeping count.
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * a constructor that gets a game and a counter of balls.
     * and initialize a BallRemover.
     * <p>
     *
     * @param game           the game.
     * @param remainingBalls the counter of the balls in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * balls that are hit are removed from the game. also, this listener is removed from the block.
     * that is being removed from the game.
     * <p>
     *
     * @param beingHit the block that the balls hit.
     * @param hitter   the ball that hits the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(getGame());
        getRemainingBalls().decrease(1);
    }

    /**
     * return the game.
     * <p>
     *
     * @return the game.
     */
    public GameLevel getGame() {
        return game;
    }

    /**
     * return the counter of balls.
     * <p>
     *
     * @return the counter of balls.
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }
}
