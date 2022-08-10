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
 * a class that represent the background of the fourth level(Final Four).
 */
public class FinalFourBackground implements Sprite {
    //the width and the height of the game are constants.
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    //the speed and radius of a ball are constantly 5.
    static final Color LIGHT_BLUE = new Color(51, 153, 255);
    //constants of th first cloud.
    static final int Y_OF_START_OF_LINE = 400;
    static final int Y_OF_END_OF_LINE = 600;
    static final int X_OF_START_OF_FIRST_LINE = 120;
    static final int X_OF_END_OF_FIRST_LINE = 90;
    static final Color SHADE_OF_GREY = new Color(170, 170, 170);
    static final int X_OF_CIRCLE_1 = 120;
    static final int Y_OF_CIRCLE_1 = 400;
    static final int RADIUS_OF_CIRCLE_1 = 25;
    static final int X_OF_CIRCLE_2 = 140;
    static final int Y_OF_CIRCLE_2 = 425;
    static final int RADIUS_OF_CIRCLE_2 = 25;
    static final int X_OF_CIRCLE_3 = 160;
    static final int Y_OF_CIRCLE_3 = 395;
    static final int RADIUS_OF_CIRCLE_3 = 30;
    static final int X_OF_CIRCLE_4 = 190;
    static final int Y_OF_CIRCLE_4 = 400;
    static final int RADIUS_OF_CIRCLE_4 = 35;
    static final int X_OF_CIRCLE_5 = 175;
    static final int Y_OF_CIRCLE_5 = 430;
    static final int RADIUS_OF_CIRCLE_5 = 20;
    //constants of the second cloud
    static final int Y_OF_START_OF_LINE_SEC_CLOUD = 530;
    static final int Y_OF_END_OF_LINE_SEC_CLOUD = 600;
    static final int X_OF_START_OF_FIRST_LINE_SEC_CLOUD = 600;
    static final int X_OF_END_OF_FIRST_LINE_SEC_CLOUD = 585;
    static final int X_OF_CIRCLE_1_SEC_CLOUD = 590;
    static final int Y_OF_CIRCLE_1_SEC_CLOUD = 500;
    static final int RADIUS_OF_CIRCLE_1_SEC_CLOUD = 20;
    static final int X_OF_CIRCLE_2_SEC_CLOUD = 620;
    static final int Y_OF_CIRCLE_2_SEC_CLOUD = 530;
    static final int RADIUS_OF_CIRCLE_2_SEC_CLOUD = 25;
    static final int X_OF_CIRCLE_3_SEC_CLOUD = 630;
    static final int Y_OF_CIRCLE_3_SEC_CLOUD = 500;
    static final int RADIUS_OF_CIRCLE_3_SEC_CLOUD = 30;
    static final int X_OF_CIRCLE_4_SEC_CLOUD = 650;
    static final int Y_OF_CIRCLE_4_SEC_CLOUD = 520;
    static final int RADIUS_OF_CIRCLE_4_SEC_CLOUD = 25;
    static final int X_OF_CIRCLE_5_SEC_CLOUD = 680;
    static final int Y_OF_CIRCLE_5_SEC_CLOUD = 510;
    static final int RADIUS_OF_CIRCLE_5_SEC_CLOUD = 35;


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(LIGHT_BLUE);
        //fill a blue rectangle at the game (the side blocks are reduced)
        d.fillRectangle(WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OF_GAME - 2 * WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);

        //draw the lines of the rain of the first cloud
        d.setColor(Color.WHITE);
        d.drawLine(X_OF_START_OF_FIRST_LINE, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 10, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 10, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 20, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 20, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 30, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 30, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 40, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 40, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 50, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 50, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 60, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 60, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 70, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 70, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 80, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 80, Y_OF_END_OF_LINE);
        d.drawLine(X_OF_START_OF_FIRST_LINE + 90, Y_OF_START_OF_LINE,
                X_OF_END_OF_FIRST_LINE + 90, Y_OF_END_OF_LINE);
        //draw the lines of the first cloud
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(X_OF_CIRCLE_1, Y_OF_CIRCLE_1, RADIUS_OF_CIRCLE_1);
        d.fillCircle(X_OF_CIRCLE_2, Y_OF_CIRCLE_2, RADIUS_OF_CIRCLE_2);
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(X_OF_CIRCLE_3, Y_OF_CIRCLE_3, RADIUS_OF_CIRCLE_3);
        d.setColor(SHADE_OF_GREY);
        d.fillCircle(X_OF_CIRCLE_4, Y_OF_CIRCLE_4, RADIUS_OF_CIRCLE_4);
        d.fillCircle(X_OF_CIRCLE_5, Y_OF_CIRCLE_5, RADIUS_OF_CIRCLE_5);

        //second cloud
        d.setColor(Color.WHITE);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 10, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 10, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 20, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 20, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 30, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 30, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 40, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 40, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 50, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 50, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 60, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 60, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 70, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 70, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 80, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 80, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.drawLine(X_OF_START_OF_FIRST_LINE_SEC_CLOUD + 90, Y_OF_START_OF_LINE_SEC_CLOUD,
                X_OF_END_OF_FIRST_LINE_SEC_CLOUD + 90, Y_OF_END_OF_LINE_SEC_CLOUD);
        d.setColor(Color.lightGray);
        d.fillCircle(X_OF_CIRCLE_1_SEC_CLOUD, Y_OF_CIRCLE_1_SEC_CLOUD, RADIUS_OF_CIRCLE_1_SEC_CLOUD);
        d.fillCircle(X_OF_CIRCLE_2_SEC_CLOUD, Y_OF_CIRCLE_2_SEC_CLOUD, RADIUS_OF_CIRCLE_2_SEC_CLOUD);
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(X_OF_CIRCLE_3_SEC_CLOUD, Y_OF_CIRCLE_3_SEC_CLOUD, RADIUS_OF_CIRCLE_3_SEC_CLOUD);
        d.setColor(SHADE_OF_GREY);
        d.fillCircle(X_OF_CIRCLE_4_SEC_CLOUD, Y_OF_CIRCLE_4_SEC_CLOUD, RADIUS_OF_CIRCLE_4_SEC_CLOUD);
        d.fillCircle(X_OF_CIRCLE_5_SEC_CLOUD, Y_OF_CIRCLE_5_SEC_CLOUD, RADIUS_OF_CIRCLE_5_SEC_CLOUD);
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
