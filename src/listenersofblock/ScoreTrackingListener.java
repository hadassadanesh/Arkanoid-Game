/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package listenersofblock;

import gamesettings.Counter;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * changes the score when a block is hit.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    static final int POINTS_FOR_EVERY_HIT = 5;

    /**
     * a constructor that gets a counter, and initialize a ScoreTrackingListener.
     * <p>
     *
     * @param scoreCounter a counter that count the current score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * if there is a hit the score is increased by 5.
     * <p>
     *
     * @param beingHit the block that the ball hits.
     * @param hitter   the ball that hits the block..
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        getCurrentScore().increase(POINTS_FOR_EVERY_HIT);
    }

    /**
     * return the score counter.
     * <p>
     *
     * @return the score counter.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}
