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
 * a class that represent the background of the second level(Wide Easy).
 */
public class WideEasyBackground implements Sprite {
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    static final Color LIGHT_YELLOW = new Color(181721160);
    static final Color DARK_YELLOW = new Color(100000000);
    static final int START_X_OF_FIRST_LINE = 50;
    static final int START_Y_OF_FIRST_LINE = 110;
    static final int END_X_OF_FIRST_LINE = 20;
    static final int END_Y_OF_FIRST_LINE = 110;
    static final int X_OF_CIRCLES = 100;
    static final int Y_OF_CIRCLES = 100;
    static final int RADIUS_OF_BIG_CIRCLE = 52;
    static final int RADIUS_OF_MIDDLE_CIRCLE = 50;
    static final int RADIUS_OF_SMALL_CIRCLE = 40;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        //fill a blue rectangle at the game (the side blocks are reduced)
        d.fillRectangle(WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OF_GAME - 2 * WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        d.setColor(Color.YELLOW);
        d.drawLine(START_X_OF_FIRST_LINE + 60, START_Y_OF_FIRST_LINE + 40,
                END_X_OF_FIRST_LINE + 210, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 70, START_Y_OF_FIRST_LINE + 35,
                END_X_OF_FIRST_LINE + 240, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 80, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 280, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 87, START_Y_OF_FIRST_LINE + 25,
                END_X_OF_FIRST_LINE + 330, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 90, START_Y_OF_FIRST_LINE + 20,
                END_X_OF_FIRST_LINE + 380, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 95, START_Y_OF_FIRST_LINE + 10,
                END_X_OF_FIRST_LINE + 430, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 100, START_Y_OF_FIRST_LINE,
                END_X_OF_FIRST_LINE + 480, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 102, START_Y_OF_FIRST_LINE - 5,
                END_X_OF_FIRST_LINE + 580, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 28, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 180, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 31, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 120, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 25, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 90, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 20, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 70, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 20, START_Y_OF_FIRST_LINE + 30,
                END_X_OF_FIRST_LINE + 50, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 19, START_Y_OF_FIRST_LINE + 29,
                END_X_OF_FIRST_LINE + 30, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 20, START_Y_OF_FIRST_LINE + 29,
                END_X_OF_FIRST_LINE, END_Y_OF_FIRST_LINE + 90);
        d.drawLine(START_X_OF_FIRST_LINE + 12, START_Y_OF_FIRST_LINE + 22,
                END_X_OF_FIRST_LINE, END_Y_OF_FIRST_LINE + 60);
        d.drawLine(START_X_OF_FIRST_LINE + 10, START_Y_OF_FIRST_LINE + 20,
                END_X_OF_FIRST_LINE, END_Y_OF_FIRST_LINE + 40);
        d.drawLine(START_X_OF_FIRST_LINE + 8, START_Y_OF_FIRST_LINE + 10,
                END_X_OF_FIRST_LINE, END_Y_OF_FIRST_LINE + 20);
        d.drawLine(START_X_OF_FIRST_LINE, START_Y_OF_FIRST_LINE, END_X_OF_FIRST_LINE, END_Y_OF_FIRST_LINE);
        d.setColor(LIGHT_YELLOW);
        d.fillCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_OF_BIG_CIRCLE);
        d.setColor(DARK_YELLOW);
        d.fillCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_OF_MIDDLE_CIRCLE);
        d.setColor(Color.YELLOW);
        d.fillCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_OF_SMALL_CIRCLE);
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
