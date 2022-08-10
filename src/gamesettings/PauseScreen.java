/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import biuoop.DrawSurface;
import interfaces.Animation;

import java.awt.Color;

/**
 * this class is in charge of printing the method "paused -- press space to continue".
 * when the player pauses the game.
 */
public class PauseScreen implements Animation {
    static final int X_VALUE_OF_TEXT = 185;
    static final int SIZE_OF_LETTERS = 32;

    @Override
    public void doOneFrame(DrawSurface d) {
        int yOfText = d.getHeight() / 2;
        d.setColor(Color.blue);
        // draw the message "paused -- press space to continue"
        d.drawText(X_VALUE_OF_TEXT, yOfText, "paused -- press space to continue", SIZE_OF_LETTERS);
    }

    /**
     * return false, because we want this screen to run forever if a key is not pressed.
     * <p>
     *
     * @return false, the animation should not stop.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
