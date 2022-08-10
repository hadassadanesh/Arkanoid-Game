/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import interfaces.Animation;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen.
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */

public class CountdownAnimation implements Animation {
    // the location of the name level
    static final int X_VAL_OF_TEXT = 550;
    static final int Y_VAL_OF_TEXT = 23;
    static final int SIZE_OF_LETTERS = 20;
    // the location of the countDown
    static final int X_VAL_OF_NUM = 375;
    static final int Y_VAL_OF_NUM = 330;
    static final int SIZE_OF_NUMBERS = 52;


    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int currentCount;
    private String levelName;

    /**
     * a constructor.
     * <p>
     *
     * @param numOfSeconds the number of second that this animation should stay.
     * @param countFrom    the number to count back from it.
     * @param gameScreen   a list of th sprites of the level.
     * @param levelName    the name of the level.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen, String levelName) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.currentCount = countFrom;
        this.levelName = levelName;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        // draw the sprites.
        getGameScreen().drawAllOn(d);

        //draw the level name
        d.drawText(X_VAL_OF_TEXT, Y_VAL_OF_TEXT, "Level Name: " + getLevelName(), SIZE_OF_LETTERS);
        d.setColor(Color.RED);
        //draw the number
        d.drawText(X_VAL_OF_NUM, Y_VAL_OF_NUM, "" + getCurrentCount() + "", SIZE_OF_NUMBERS);

        //if it is not the first number, use sleepFor
        if (getCurrentCount() != getCountFrom()) {
            sleeper.sleepFor((long) ((getNumOfSeconds() / getCountFrom()) * 1000));
        }
        // reduce the current count by 1.
        setCurrentCount(getCurrentCount() - 1);
    }

    @Override
    public boolean shouldStop() {
        // if the current count is -1, the animation should stop.
        if (getCurrentCount() == -1) {
            return true;
        }
        return false;
    }

    /**
     * return the current number that is played.
     * <p>
     *
     * @return the current number that is played.
     */
    public int getCurrentCount() {
        return currentCount;
    }

    /**
     * return the current number of seconds that the animation should play.
     * <p>
     *
     * @return numOfSeconds.
     */
    public double getNumOfSeconds() {
        return numOfSeconds;
    }

    /**
     * return the gameScreen.
     * <p>
     *
     * @return gameScreen.
     */
    public SpriteCollection getGameScreen() {
        return gameScreen;
    }

    /**
     * return the gameScreen.
     * <p>
     *
     * @return gameScreen.
     */
    public int getCountFrom() {
        return countFrom;
    }

    /**
     * return the levelName.
     * <p>
     *
     * @return levelName.
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * set the current count to be the given one.
     * <p>
     *
     * @param newCurrentCount the number that needs to be the current count.
     */
    private void setCurrentCount(int newCurrentCount) {
        this.currentCount = newCurrentCount;
    }
}
