/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package backgrounds;

import biuoop.DrawSurface;
import gamesettings.GameLevel;

import interfaces.Sprite;


import java.awt.Color;

/**
 * a class that represent the background of the third level(Purple Level).
 */
public class PurpleLevelBackground implements Sprite {
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    static final Color PURPLE_COLOR = new Color(102, 0, 153);
    static final int THE_FINAL_X_OF_THE_FIRST_FLOWR = 50;

    // the constants of the first butterfly
    static final int X_LEFT_CIRCLE = 100;
    static final int Y_LEFT_CIRCLE_UP = 150;
    static final int Y_LEFT_CIRCLE_DOWN = 180;
    static final int X_RIGHT_CIRCLE = 130;
    static final int Y_RIGHT_CIRCLE_UP = 150;
    static final int Y_RIGHT_CIRCLE_DOWN = 180;
    static final int RADIUS_OF_CIRCLES_BIG_BUTTERFLY = 20;
    static final int X_OF_BIG_RECTANGLE = 113;
    static final int Y_OF_BIG_RECTANGLE = 130;
    static final int WIDTH_OF_BIG_RECTANGLE = 5;
    static final int HEIGHT_OF_BIG_RECTANGLE = 70;
    static final int X_AT_START_OF_LINE_ON_TOP = 115;
    static final int Y_AT_START_OF_LINE_ON_TOP = 130;
    static final int Y_AT_END_OF_LINE_ON_TOP = 115;
    static final int X_AT_END_OF_LINE_ON_TOP_RIGHT = 130;
    static final int X_AT_END_OF_LINE_ON_TOP_LEFT = 100;

    // the constants of the second butterfly
    static final int X_LEFT_CIRCLE_SEC_BUTTERFLY = 160;
    static final int Y_LEFT_CIRCLE_UP_SEC_BUTTERFLY = 200;
    static final int Y_LEFT_CIRCLE_DOWN_SEC_BUTTERFLY = 210;
    static final int X_RIGHT_CIRCLE_SEC_BUTTERFLY = 170;
    static final int Y_RIGHT_CIRCLE_UP_SEC_BUTTERFLY = 200;
    static final int Y_RIGHT_CIRCLE_DOWN_SEC_BUTTERFLY = 210;
    static final int RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY = 10;
    static final int X_OF_SMALL_RECTANGLE = 164;
    static final int Y_OF_SMALL_RECTANGLE = 190;
    static final int WIDTH_OF_SMALL_RECTANGLE = 3;
    static final int HEIGHT_OF_SMALL_RECTANGLE = 30;
    static final int X_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY = 165;
    static final int Y_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY = 190;
    static final int Y_AT_END_OF_LINE_ON_TOP_SEC_BUTTERFLY = 180;
    static final int X_AT_END_OF_LINE_ON_TOP_RIGHT_SEC_BUTTERFLY = 175;
    static final int X_AT_END_OF_LINE_ON_TOP_LEFT_SEC_BUTTERFLY = 155;


    // those fields can not be a static variables, because they are changed after creating every flower.
    private int xOfMiddleCircleOfFlower;
    private int yOfMiddleCircleOfFlower;
    private int radiusOfLittleCircles;

    /**
     * a constructor that initializes the y value of the big circle of every flower to be 50.
     * the y to be 570, and the radius of all the little circles around the big circle is 5.
     * <p>
     */
    public PurpleLevelBackground() {
        this.xOfMiddleCircleOfFlower = 50;
        this.yOfMiddleCircleOfFlower = 570;
        this.radiusOfLittleCircles = 5;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.pink);
        //fill a blue rectangle at the game (the side blocks are reduced)
        d.fillRectangle(WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OF_GAME - 2 * WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        // create 20 flowers.
        createFlowers(d);
        //create butterfly (the big one)
        d.setColor(Color.BLACK);
        d.drawCircle(X_LEFT_CIRCLE, Y_LEFT_CIRCLE_UP, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.drawCircle(X_RIGHT_CIRCLE, Y_RIGHT_CIRCLE_UP, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.drawCircle(X_LEFT_CIRCLE, Y_LEFT_CIRCLE_DOWN, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.drawCircle(X_RIGHT_CIRCLE, Y_RIGHT_CIRCLE_DOWN, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.setColor(PURPLE_COLOR);
        d.fillCircle(X_LEFT_CIRCLE, Y_LEFT_CIRCLE_UP, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.fillCircle(X_RIGHT_CIRCLE, Y_RIGHT_CIRCLE_UP, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.fillCircle(X_LEFT_CIRCLE, Y_LEFT_CIRCLE_DOWN, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        d.fillCircle(X_RIGHT_CIRCLE, Y_RIGHT_CIRCLE_DOWN, RADIUS_OF_CIRCLES_BIG_BUTTERFLY);
        // draw the rectangle at the middle of the butterfly
        d.setColor(Color.YELLOW.brighter());
        d.fillRectangle(X_OF_BIG_RECTANGLE, Y_OF_BIG_RECTANGLE,
                WIDTH_OF_BIG_RECTANGLE, HEIGHT_OF_BIG_RECTANGLE);
        //two lines on the top
        d.drawLine(X_AT_START_OF_LINE_ON_TOP, Y_AT_START_OF_LINE_ON_TOP,
                X_AT_END_OF_LINE_ON_TOP_RIGHT, Y_AT_END_OF_LINE_ON_TOP);
        d.drawLine(X_AT_START_OF_LINE_ON_TOP, Y_AT_START_OF_LINE_ON_TOP,
                X_AT_END_OF_LINE_ON_TOP_LEFT, Y_AT_END_OF_LINE_ON_TOP);


        //create second butterfly (little one)
        d.setColor(Color.BLACK);
        d.drawCircle(X_LEFT_CIRCLE_SEC_BUTTERFLY, Y_LEFT_CIRCLE_UP_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.drawCircle(X_RIGHT_CIRCLE_SEC_BUTTERFLY, Y_RIGHT_CIRCLE_UP_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.drawCircle(X_LEFT_CIRCLE_SEC_BUTTERFLY, Y_LEFT_CIRCLE_DOWN_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.drawCircle(X_RIGHT_CIRCLE_SEC_BUTTERFLY, Y_RIGHT_CIRCLE_DOWN_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.setColor(PURPLE_COLOR);
        d.fillCircle(X_LEFT_CIRCLE_SEC_BUTTERFLY, Y_LEFT_CIRCLE_UP_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.fillCircle(X_RIGHT_CIRCLE_SEC_BUTTERFLY, Y_RIGHT_CIRCLE_UP_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.fillCircle(X_LEFT_CIRCLE_SEC_BUTTERFLY, Y_LEFT_CIRCLE_DOWN_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);
        d.fillCircle(X_RIGHT_CIRCLE_SEC_BUTTERFLY, Y_RIGHT_CIRCLE_DOWN_SEC_BUTTERFLY,
                RADIUS_OF_CIRCLES_LITTLE_BUTTERFLY_SEC_BUTTERFLY);

        d.setColor(Color.YELLOW);
        d.fillRectangle(X_OF_SMALL_RECTANGLE, Y_OF_SMALL_RECTANGLE,
                WIDTH_OF_SMALL_RECTANGLE, HEIGHT_OF_SMALL_RECTANGLE);
        d.drawLine(X_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY, Y_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY,
                X_AT_END_OF_LINE_ON_TOP_RIGHT_SEC_BUTTERFLY, Y_AT_END_OF_LINE_ON_TOP_SEC_BUTTERFLY);
        d.drawLine(X_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY, Y_AT_START_OF_LINE_ON_TOP_SEC_BUTTERFLY,
                X_AT_END_OF_LINE_ON_TOP_LEFT_SEC_BUTTERFLY, Y_AT_END_OF_LINE_ON_TOP_SEC_BUTTERFLY);
    }

    /**
     * create 20 flowers on the bottom of the screen.
     * <p>
     *
     * @param d the draw surface.
     */
    public void createFlowers(DrawSurface d) {
        for (int i = 0; i < 20; i++) {
            d.setColor(Color.green);
            d.drawLine(getxOfMiddleCircleOfFlower(), getyOfMiddleCircleOfFlower() + 7,
                    getxOfMiddleCircleOfFlower(), getyOfMiddleCircleOfFlower() + 30);
            d.drawLine(getxOfMiddleCircleOfFlower() + 1, getyOfMiddleCircleOfFlower() + 7,
                    getxOfMiddleCircleOfFlower() + 1, getyOfMiddleCircleOfFlower() + 30);
            d.drawLine(getxOfMiddleCircleOfFlower() - 1, getyOfMiddleCircleOfFlower() + 7,
                    getxOfMiddleCircleOfFlower() - 1, getyOfMiddleCircleOfFlower() + 30);
            d.setColor(PURPLE_COLOR);
            d.fillCircle(getxOfMiddleCircleOfFlower() - 5, getyOfMiddleCircleOfFlower() - 9,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() + 3, getyOfMiddleCircleOfFlower() - 10,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() + 8, getyOfMiddleCircleOfFlower() - 5,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() + 9, getyOfMiddleCircleOfFlower() + 2,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() + 7, getyOfMiddleCircleOfFlower() + 5,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() + 6, getyOfMiddleCircleOfFlower() + 8,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() - 2, getyOfMiddleCircleOfFlower() + 10,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() - 7, getyOfMiddleCircleOfFlower() + 5,
                    getRadiusOfLittleCircles());
            d.fillCircle(getxOfMiddleCircleOfFlower() - 10, getyOfMiddleCircleOfFlower() - 2,
                    getRadiusOfLittleCircles());
            d.setColor(Color.yellow);
            d.fillCircle(getxOfMiddleCircleOfFlower(), getyOfMiddleCircleOfFlower(),
                    getRadiusOfLittleCircles() + 2);
            // the next flower will be created with the middle big circle 37 steps to the right.
            setxOfMiddleCircleOfFlower(getxOfMiddleCircleOfFlower() + 37);
        }

        /* after all the flowers are drawn, we ned to set the middle of the first flower to be 50 again,
         * in purpose that the flower will not go out the screen.*/
        setxOfMiddleCircleOfFlower(THE_FINAL_X_OF_THE_FIRST_FLOWR);
    }

    /**
     * set the x value of the point of the middle circle to be newXOfFlower.
     * <p>
     *
     * @param newXOfFlower the new value.
     */
    public void setxOfMiddleCircleOfFlower(int newXOfFlower) {
        this.xOfMiddleCircleOfFlower = newXOfFlower;
    }

    /**
     * return the x value of the big circle of the flower.
     * <p>
     *
     * @return xOfMiddleCircleOfFlower
     */
    public int getxOfMiddleCircleOfFlower() {
        return this.xOfMiddleCircleOfFlower;
    }

    /**
     * return the y value of the big circle of the flower.
     * <p>
     *
     * @return YOfMiddleCircleOfFlower
     */
    public int getyOfMiddleCircleOfFlower() {
        return this.yOfMiddleCircleOfFlower;
    }

    /**
     * return the radius of the little circles of the flower.
     * <p>
     *
     * @return radiusOfLittleCircles
     */
    public int getRadiusOfLittleCircles() {
        return this.radiusOfLittleCircles;
    }

    /**
     * does nothing.
     * <p>
     */
    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
