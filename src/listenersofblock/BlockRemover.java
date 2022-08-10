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
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count.
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * a constructor that gets a game and a counter of blocks.
     * and initialize a blockRemover.
     * <p>
     *
     * @param game            the game.
     * @param remainingBlocks the counter of the blocks in the game.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Blocks that are hit are removed from the game. also, this listener is removed from the block.
     * that is being removed from the game.
     * <p>
     *
     * @param beingHit the block that the balls hit.
     * @param hitter   the ball that hits the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(getGame());
        //if a block is hit, the number of blocks in the game is decreased by 1.
        getRemainingBlocks().decrease(1);
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
     * return the counter of blocks.
     * <p>
     *
     * @return the counter of blocks.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }
}