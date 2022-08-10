/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

import biuoop.DrawSurface;

/**
 * this class id=s in charge of one animation. the logic and the stopping condition of the animation.
 */
public interface Animation {
    /**
     * this method is in charge of the logic of the animation.
     * like displaying the sprites and notifying them time has passed,
     * and keeping track of the number of balls and blocks
     * <p>
     *
     * @param d the draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method is in charge of the stopping condition of the animation.
     * <p>
     *
     * @return true if the animation should stop, and false if it is not.
     */
    boolean shouldStop();
}
