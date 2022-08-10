/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

import sprites.Ball;
import sprites.Block;

/**
 * an interface that represent that the object that implement it is a listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * <p>
     *
     * @param beingHit the object that the ball hits.
     * @param hitter   the ball that hits the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}