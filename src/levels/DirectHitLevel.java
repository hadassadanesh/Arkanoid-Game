/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package levels;

import backgrounds.DirectHitBackground;
import gamesettings.Velocity;
import geometry.Point;
import geometry.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that represent the first level(Direct Hit).
 */
public class DirectHitLevel implements LevelInformation {
    //those are constants because they are the same at every DirectHit object.
    static final int NUM_OF_BLOCKS_TO_REMOVE = 1;
    static final int NUM_OF_BALLS = 1;
    static final int PADDLE_SPEED = 5;
    static final int PADDLE_WIDTH = 80;
    static final int X_VALUE_OF_THE_BLOCK = 380;
    static final int Y_VALUE_OF_THE_BLOCK = 130;
    static final int HEIGHT_OF_THE_BLOCK = 30;
    static final int WIDTH_OF_THE_BLOCK = 30;

    private DirectHitBackground directHitBackground;

    /**
     * a constructor that is initializes a new background that matches this level.
     * <p>
     */
    public DirectHitLevel() {
        this.directHitBackground = new DirectHitBackground();
    }

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        // there is one ball, so the method initializes his velocity.
        velocityList.add(new Velocity(0, -7));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return getDirectHitBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        //the rectangle of the block.
        Rectangle theRectangle = new Rectangle(new Point(X_VALUE_OF_THE_BLOCK, Y_VALUE_OF_THE_BLOCK),
                WIDTH_OF_THE_BLOCK, HEIGHT_OF_THE_BLOCK);
        // create the block
        Block theBlock = new Block(theRectangle, Color.RED);
        // add it to the list
        blockList.add(theBlock);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_TO_REMOVE;
    }

    /**
     * return the background of this level.
     * <p>
     *
     * @return the background of this level.
     */
    public DirectHitBackground getDirectHitBackground() {
        return this.directHitBackground;
    }
}
