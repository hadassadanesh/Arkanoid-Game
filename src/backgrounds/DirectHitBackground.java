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
 * a class that represent the background of the first level(Direct Hit).
 */
public class DirectHitBackground implements Sprite {

    //the width and the height of the game are constants.
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    static final int X_OF_CIRCLES = 395;
    static final int Y_OF_CIRCLES = 145;
    static final int RADIUS_CIRCLE_1 = 60;
    static final int RADIUS_CIRCLE_2 = 85;
    static final int RADIUS_CIRCLE_3 = 110;
    // the location of the lines of the direct hit are the same at every DirectHitBackground object.
    static final int X_START_HORIZONAL_LINE_1 = X_OF_CIRCLES + 20;
    static final int X_END_HORIZONAL_LINE_1 = X_START_HORIZONAL_LINE_1 + 115;
    static final int X_START_HORIZONAL_LINE_2 = X_OF_CIRCLES - 20;
    static final int X_END_HORIZONAL_LINE_2 = X_START_HORIZONAL_LINE_2 - 115;
    static final int Y_START_VERTICAL_LINE_1 = Y_OF_CIRCLES + 15;
    static final int Y_END_VERTICAL_LINE_1 = Y_START_VERTICAL_LINE_1 + 115;
    static final int Y_START_VERTICAL_LINE_2 = Y_OF_CIRCLES - 15;
    static final int Y_END_VERTICAL_LINE_2 = Y_START_VERTICAL_LINE_2 - 115;


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        //fill a black rectangle at the game (the side blocks are reduced)
        d.fillRectangle(WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OF_GAME - 2 * WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        d.setColor(Color.blue);
        //draw the circles of the direct hit.
        d.drawCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_CIRCLE_1);
        d.drawCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_CIRCLE_2);
        d.drawCircle(X_OF_CIRCLES, Y_OF_CIRCLES, RADIUS_CIRCLE_3);
        //draw the lines of the direct hit.
        d.drawLine(X_START_HORIZONAL_LINE_1, Y_OF_CIRCLES, X_END_HORIZONAL_LINE_1, Y_OF_CIRCLES);
        d.drawLine(X_START_HORIZONAL_LINE_2, Y_OF_CIRCLES, X_END_HORIZONAL_LINE_2, Y_OF_CIRCLES);
        d.drawLine(X_OF_CIRCLES, Y_START_VERTICAL_LINE_1, X_OF_CIRCLES, Y_END_VERTICAL_LINE_1);
        d.drawLine(X_OF_CIRCLES, Y_START_VERTICAL_LINE_2, X_OF_CIRCLES, Y_END_VERTICAL_LINE_2);
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
