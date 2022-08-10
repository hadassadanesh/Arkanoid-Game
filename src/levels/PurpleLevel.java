/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package levels;

import backgrounds.PurpleLevelBackground;
import gamesettings.Velocity;
import geometry.Point;
import geometry.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * a class that represent the third level(Purple Level).
 */
public class PurpleLevel implements LevelInformation {
    //those are constants because they are the same at every PurpleLevel object.
    static final int WIDTH_OF_GAME = 800;
    static final int SPEED_OF_BALL = 5;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    //the width and height of every block in this level.
    static final int WIDTH_OF_GAME_BLOCK = 50;
    static final int HEIGHT_OF_GAME_BLOCK = 20;
    //the y value at the first row of blocks is 100 constantly.
    static final int Y_AT_FIRST_ROW = 100;
    static final int NUM_OF_BLOCKS_TO_REMOVE = 40;
    static final int NUM_OF_BALLS = 2;
    static final int PADDLE_SPEED = 6;
    static final int PADDLE_WIDTH = 80;
    static final Color SHADE_OF_PURPLE_1 = new Color(191111311);
    static final Color SHADE_OF_PURPLE_2 = new Color(125, 0, 168);
    static final Color SHADE_OF_PURPLE_3 = new Color(120, 0, 153);
    static final Color SHADE_OF_PURPLE_4 = new Color(120, 0, 182);
    static final Color SHADE_OF_PURPLE_5 = new Color(111153111);

    private PurpleLevelBackground greenLevelBackground;

    /**
     * a constructor that is initializes a new background that matches this level.
     * <p>
     */
    public PurpleLevel() {
        this.greenLevelBackground = new PurpleLevelBackground();
    }

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        // goes over all the balls, and for each ball, add a random velocity to he list.
        for (int i = 0; i < numberOfBalls(); i++) {
            list.add(getV());
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return getGreenLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        return gameBlocks();
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_TO_REMOVE;
    }

    /**
     * return a list with the blocks of this level. there are 5 rows of blocks.
     * every row has a different color.
     * <p>
     *
     * @return a list with the blocks of the level.
     */
    public List<Block> gameBlocks() {
        List<Block> blockList = new ArrayList<>();
        //the number of blocks at the first line is 10.
        int numOfBlocks = 10;
        Color color;
        int number = 0;
        // the method needs to initialize 5 rows.
        for (int j = 0; j < 5; j++) {
            //get a color according to the number
            color = getColor(number);
            //creates a row with numOfBlocks blocks, with the given color.
            List<Block> l = createARow(numOfBlocks, color, j);
            for (int k = 0; k < l.size(); k++) {
                blockList.add(l.get(k));
            }
            // add 1 to the number.
            number += 1;
            //reduce the number of blocks by 1.
            numOfBlocks--;
        }
        //return the list of blocks.
        return blockList;
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
        switch (number) {
            case 0:
                return SHADE_OF_PURPLE_1;
            case 1:
                return SHADE_OF_PURPLE_2;
            case 2:
                return SHADE_OF_PURPLE_3;
            case 3:
                return SHADE_OF_PURPLE_4;
            case 4:
                return SHADE_OF_PURPLE_5;
            default:
                return Color.lightGray;
        }

    }

    /**
     * initialize blocks at the same row, in the same given color and return a list that contains them.
     * the number of the blocks is given.
     * <p>
     *
     * @param numOfBlocks the number of the wanted blocks at the row.
     * @param color       the color of the blocks at the row.
     * @param numOfRow    the number of the current row in all the rows of blocks in the game.
     * @return a list of the blocks in one row.
     */
    public List<Block> createARow(int numOfBlocks, Color color, int numOfRow) {
        List<Block> blockList = new ArrayList<>();
        //the x value of the first block from left.
        double xPoint = WIDTH_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK - WIDTH_OF_GAME_BLOCK * numOfBlocks;
        //the y value of of the first block from left.
        double yPoint = Y_AT_FIRST_ROW + HEIGHT_OF_GAME_BLOCK * numOfRow;

        /* go into the for loop as many times as the number of the wanted blocks at the row. every
         loop creates one block to the right side of the previous block.*/
        for (int i = 0; i < numOfBlocks; i++) {
            //initialize a block
            Block block = new Block(new Rectangle(new Point(xPoint, yPoint), WIDTH_OF_GAME_BLOCK,
                    HEIGHT_OF_GAME_BLOCK), color);
            //add the block to the list of blocks.
            blockList.add(block);

            /* add the width of a block to the x, so the next block will be initialized to the
            right side of the previous block.*/
            xPoint += WIDTH_OF_GAME_BLOCK;
        }
        //return the list of th blocks of th row.
        return blockList;
    }

    /**
     * return a random velocity.
     * <p>
     *
     * @return a random velocity.
     */
    public Velocity getV() {
        Random random = new Random();
        //gets a random angle from -70 to 70.
        double angle = random.nextInt(140) - 70;
        //create a new velocity
        Velocity v = Velocity.fromAngleAndSpeed(angle, SPEED_OF_BALL);
        //return it
        return v;
    }

    /**
     * return the background of this level.
     * <p>
     *
     * @return the background of this level.
     */
    public PurpleLevelBackground getGreenLevelBackground() {
        return this.greenLevelBackground;
    }
}
