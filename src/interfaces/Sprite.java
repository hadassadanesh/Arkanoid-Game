/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

import gamesettings.GameLevel;
import biuoop.DrawSurface;

/**
 * a interfaces.Sprite is a game object that can be drawn to the screen.
 */
public interface Sprite {

    /**
     * draw the sprite on the given surface.
     * <p>
     *
     * @param d the surface where the sprite will be drawn.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed. for a ball-move the ball one step, for a block- currently nothing.
     * <p>
     */
    void timePassed();

    /**
     * add this sprite to the given game.
     * <p>
     *
     * @param g the given game.
     */
    void addToGame(GameLevel g);
}
