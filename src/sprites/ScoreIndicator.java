/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package sprites;

import biuoop.DrawSurface;
import gamesettings.Counter;
import gamesettings.GameLevel;
import interfaces.Sprite;

import java.awt.Color;

/**
 * a class that in charge of drawing the current score on the top of the screen of the game.
 */
public class ScoreIndicator implements Sprite {
    // the x and the y values of the writing of the score are constants.
    static final int X_VAL_OF_TEXT = 360;
    static final int Y_VAL_OF_TEXT = 23;
    // the size of the letters is constant.
    static final int SIZE_OF_LETTERS = 20;

    private Counter scoresCounter;

    /**
     * a constructor that gets a counter of the scores and initializes a ScoreIndicator.
     * <p>
     *
     * @param scoresCounter the counter of the scores.
     */
    public ScoreIndicator(Counter scoresCounter) {
        this.scoresCounter = scoresCounter;
    }

    /**
     * the method that draws the current scores on the top of the game screen.
     * <p>
     *
     * @param d the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        /* when the x value on the screen is 360 and the y value is 23, write- score:
        <the current score>, at size 20.*/
        d.drawText(X_VAL_OF_TEXT, Y_VAL_OF_TEXT, "Score: " + getScoresCounter().getValue(), SIZE_OF_LETTERS);
    }

    /**
     * does nothing currently.
     * <p>
     */
    @Override
    public void timePassed() {
        return;
    }

    /**
     * add the scoreIndicator to the game as a sprite.
     * <p>
     *
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * return the scoresCounter.
     * <p>
     *
     * @return the scoresCounter.
     */
    public Counter getScoresCounter() {
        return scoresCounter;
    }
}
