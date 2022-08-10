/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package levels;

import backgrounds.WideEasyBackground;

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
 * a class that represent the second level(Wide Easy).
 */
public class WideEasyLevel implements LevelInformation {
    static final int NUM_OF_BLOCKS_TO_REMOVE = 15;
    static final int NUM_OF_BALLS = 10;
    static final int PADDLE_SPEED = 3;
    static final int PADDLE_WIDTH = 650;
    static final int X_VALUE_OF_THE_FIRST_BLOCK = 25;
    static final int Y_VALUE_OF_THE_BLOCK = 200;
    static final int HEIGHT_OF_THE_BLOCK = 25;
    static final int WIDTH_OF_THE_BLOCK = 50;

    private WideEasyBackground wideEasyBackground;

    /**
     * a constructor that is initializes a new background that matches this level.
     * <p>
     */
    public WideEasyLevel() {
        this.wideEasyBackground = new WideEasyBackground();
    }


    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {

            /*when i=2 the angle is 90, and when i=8 the angle is 270. we don't want the ball to
            bounce on the paddle so we initialize the velocity at those cases separately.*/
            if (i != 2 && i != 8) {
                list.add(Velocity.fromAngleAndSpeed(30 + (30 * i), 5));
            } else if (i == 2) {
                list.add(Velocity.fromAngleAndSpeed(85, 5));
            } else { //i=8
                list.add(Velocity.fromAngleAndSpeed(275, 5));
            }
        }
        return list;
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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return getWideEasyBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            //create the rectangle of the block
            Rectangle rectangle = new Rectangle(new Point(X_VALUE_OF_THE_FIRST_BLOCK + WIDTH_OF_THE_BLOCK * i,
                    Y_VALUE_OF_THE_BLOCK), WIDTH_OF_THE_BLOCK, HEIGHT_OF_THE_BLOCK);
            //create a block
            Block block = new Block(rectangle, getColor(i));
            //add it to the list of blocks.
            blockList.add(block);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_TO_REMOVE;
    }

    /**
     * gets a number and returns the color that is specified with this number.
     * <p>
     *
     * @param number a number.
     * @return a color.
     */
    public Color getColor(int number) {
        //returns a specific color according to the given number.
        if (number == 0 || number == 1) {
            return Color.RED;
        } else if (number == 2 || number == 3) {
            return Color.orange;
        } else if (number == 4 || number == 5) {
            return Color.YELLOW;
        } else if (number == 6 || number == 7 || number == 8) {
            return Color.GREEN;
        } else if (number == 9 || number == 10) {
            return Color.BLUE;
        } else if (number == 11 || number == 12) {
            return Color.PINK;
        } else {
            return Color.CYAN;
        }
    }

    /**
     * return the background of this level.
     * <p>
     *
     * @return the background of this level.
     */
    public WideEasyBackground getWideEasyBackground() {
        return this.wideEasyBackground;
    }
}
