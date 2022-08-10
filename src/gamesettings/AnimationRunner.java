/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/**
 * a class that can run animations.
 */
public class AnimationRunner {
    //the width and the height of the game are constants.
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;

    private GUI gui;
    private int framesPerSecond;

    /**
     * a constructor that initializes a gui with the width and height of the game.
     * initializes framesPerSecond to be 60.
     * <p>
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", WIDTH_OF_GAME, HEIGHT_OF_GAME);
        this.framesPerSecond = 60;
    }

    /**
     * runs the animation.
     * <p>
     *
     * @param animation the animation.
     */
    public void run(Animation animation) {
        //initialize a new Sleeper object.
        Sleeper sleeper = new Sleeper();
        //the time that each frame in the animation will last.
        int millisecondsPerFrame = 1000 / getFramesPerSecond();

        // while the animation doesn't need to stop.
        while (!animation.shouldStop()) {
            // the start time of the animation.
            long startTime = System.currentTimeMillis(); // timing

            //initialize new surface and set the color to be blue.
            DrawSurface d = getGui().getDrawSurface();

            //run one frame of the animation
            animation.doOneFrame(d);

            // show the surface.
            getGui().show(d);

            //subtract the time it takes to do the work from the sleep time of
            // millisecondsPerFrame milliseconds.
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * return the gui.
     * <p>
     *
     * @return the gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * return framesPerSecond.
     * <p>
     *
     * @return the framesPerSecond.
     */
    public int getFramesPerSecond() {
        return this.framesPerSecond;
    }
}
