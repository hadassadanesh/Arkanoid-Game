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
 * this class is in charge of printing the method "Game Over. Your score is X".
 * when the player lost the game.
 */
public class GameOver implements Animation {
    static final int X_VALUE_OF_TEXT = 185;
    static final int SIZE_OF_LETTERS = 32;

    private Counter score;

    /**
     * a constructor that gets the score of the game, and initializes the field 'score' with it.
     * <p>
     *
     * @param score the score of the game.
     */
    public GameOver(Counter score) {
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int yOfText = d.getHeight() / 2;
        d.setColor(Color.blue);
        // draw "Game Over. Your score is X".
        d.drawText(X_VALUE_OF_TEXT, yOfText, "Game Over. Your score is "
                + getScore().getValue(), SIZE_OF_LETTERS);
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

    /**
     * return the score.
     * <p>
     *
     * @return the score.
     */
    public Counter getScore() {
        return score;
    }
}
