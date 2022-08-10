/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

import gamesettings.Velocity;
import sprites.Block;

import java.util.List;

/**
 * an interface with all the information that needs to be filled about every level.
 */
public interface LevelInformation {

    /**
     * return the number of balls in this level.
     * <p>
     *
     * @return the number of balls in this level.
     */
    int numberOfBalls();

    /**
     * the method returns a list with the initial velocity of each ball of the level.
     * <p>
     *
     * @return Description text text text.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the speed of the paddle in this level.
     * <p>
     *
     * @return the speed of the paddle in this level.
     */
    int paddleSpeed();

    /**
     * return the speed of the paddle in this level.
     * <p>
     *
     * @return the width of the paddle in this level.
     */
    int paddleWidth();

    /**
     * return the level's name, that will be displayed at the top of the screen.
     * <p>
     *
     * @return the level's name.
     */
    String levelName();


    /**
     * Returns a sprite with the background of the level.
     * <p>
     *
     * @return a sprite with the background of the level
     */
    Sprite getBackground();


    /**
     * return the blocks that make up this level.
     * each block contains its size, color and location.
     * <p>
     *
     * @return a list with the blocks of this level.
     */
    List<Block> blocks();

    /**
     * return the number of blocks that should be removed before the level is considered to be "cleared".
     * <p>
     *
     * @return the number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}