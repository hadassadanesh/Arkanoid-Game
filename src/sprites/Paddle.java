/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package sprites;

import gamesettings.GameLevel;
import gamesettings.Velocity;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Sprite;
import java.awt.Color;

/**
 * The Sprites.Paddle is the player in the game.
 * It is a rectangle that is controlled by the arrow keys, and moves according to the player key presses.
 */

public class Paddle implements Sprite, Collidable {
    // every move moves the paddle by 5 steps.
    static final int THE_MOVE = 5;
    // the minimum x of the screen without the big blocks at the sides of the screen, is 25.
    static final int MIN_X = 25;
    // the maximum x of the screen without the big blocks at the sides of the screen, is 775.
    static final int MAX_X = 775;
    // the angles that supposed to be after a hit at the fit region of the paddle.
    static final int NUM_OF_REGIONS = 5;
    static final int ANGLE_REGION_1 = 300;
    static final int ANGLE_REGION_2 = 330;
    static final int ANGLE_REGION_4 = 30;
    static final int ANGLE_REGION_5 = 60;

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int paddleSpeed;

    /**
     * a constructor that gets a rectangle, a color amd a keyboard, and initializes a paddle.
     * <p>
     *
     * @param keyboard    a Keyboard object.
     * @param rectangle   a rectangle.
     * @param color       the paddle's color.
     * @param paddleSpeed the speed of the paddle.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Rectangle rectangle, Color color, int paddleSpeed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * moves the paddle five steps to the left.
     * <p>
     */
    public void moveLeft() {

        /*if after the move, the upper-left point of the rectangle will not reach
         the end of the screen(before the big blocks..)*/
        if (this.getCollisionRectangle().getUpperLeft().getX() - THE_MOVE >= MIN_X) {
            // the x value of the left side of the rectangle.
            double leftPointX = this.getCollisionRectangle().getUpperLeft().getX();
            //the y value of the top line of the rectangle.
            double leftPointY = this.getCollisionRectangle().getUpperLeft().getY();
            //move the upper-left point 5 steps to the left.
            this.getCollisionRectangle().setUpperLeft(new Point(leftPointX - THE_MOVE, leftPointY));
        }
    }

    /**
     * moves the paddle some steps to the left, according to the paddleSpeed.
     * <p>
     *
     * @param thePaddleSpeed number of steps to move the paddle left.
     */
    public void moveLeft(int thePaddleSpeed) {
        double leftPointX = this.getCollisionRectangle().getUpperLeft().getX();
        //the y value of the top line of the rectangle.
        double leftPointY = this.getCollisionRectangle().getUpperLeft().getY();
        //move the upper-left point 5 steps to the left.

        /*if after the move, the upper-left point of the rectangle will not reach
         the end of the screen(before the big blocks..)*/
        if (this.getCollisionRectangle().getUpperLeft().getX() - thePaddleSpeed >= MIN_X) {
            //move the upper-left point paddleSpeed steps to the left.
            this.getCollisionRectangle().setUpperLeft(new Point(leftPointX - thePaddleSpeed, leftPointY));
        } else {
            //move the paddle to the left end of the screen.
            this.getCollisionRectangle().setUpperLeft(new Point(MIN_X, leftPointY));
        }
    }

    /**
     * moves the paddle five steps to the right.
     * <p>
     */
    public void moveRight() {

        /*if after the move, the upper-right point of the rectangle will not reach
         the end of the screen(before the big blocks..)*/
        if (this.getCollisionRectangle().getUpperRight().getX() + THE_MOVE <= MAX_X) {
            // the x value of the left side of the rectangle.
            double leftPointX = this.getCollisionRectangle().getUpperLeft().getX();
            //the y value of the top line of the rectangle.
            double leftPointY = this.getCollisionRectangle().getUpperLeft().getY();
            //move the upper-left point 5 steps to the right.
            this.getCollisionRectangle().setUpperLeft(new Point(leftPointX + THE_MOVE, leftPointY));
        }
    }

    /**
     * moves the paddle some steps to the right, according to the paddleSpeed.
     * <p>
     *
     * @param thePaddleSpeed number of steps to move the paddle right.
     */
    public void moveRight(int thePaddleSpeed) {
        // the x value of the left side of the rectangle.
        double leftPointX = this.getCollisionRectangle().getUpperLeft().getX();
        //the y value of the top line of the rectangle.
        double leftPointY = this.getCollisionRectangle().getUpperLeft().getY();

        /*if after the move, the upper-right point of the rectangle will not reach
         the end of the screen(before the big blocks..)*/
        if (this.getCollisionRectangle().getUpperRight().getX() + thePaddleSpeed <= MAX_X) {
            //move the upper-left point 5 steps to the right.
            this.getCollisionRectangle().setUpperLeft(new Point(leftPointX + thePaddleSpeed, leftPointY));
        } else {
            //move the paddle to the right end of the screen.
            this.getCollisionRectangle().setUpperLeft(new Point(MAX_X - this.rectangle.getWidth(), leftPointY));
        }
    }

    /**
     * the method checks if the "left" or "right" keys are pressed, and if so move it accordingly.
     * <p>
     */
    public void timePassed() {
        //if the left key is pressed, move the paddle to the left.
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft(getPaddleSpeed());
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            //if the right key is pressed, move the paddle to the right.
            moveRight(getPaddleSpeed());
        }
    }

    /**
     * return the speed of the paddle.
     * <p>
     *
     * @return the speed of the block.
     */
    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    /**
     * return the color of the paddle.
     * <p>
     *
     * @return the color of the block.
     */
    public Color getColor() {
        return color;
    }

    /**
     * draw the paddle on the given surface.
     * <p>
     *
     * @param d the surface where the block will be drawn.
     */
    public void drawOn(DrawSurface d) {
        //sets the color to be the paddle's color
        d.setColor(this.getColor());
        // fill a rectangle according to his information.
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
        //draw a black rectangle around the paddle
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
    }

    /**
     * Return the "collision shape" of the object.
     * <p>
     *
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * return the new velocity expected after the hit (based on the force the object inflicted on us.
     * and at which region the hit point is).
     * <p>
     *
     * @param collisionPoint  the point where the collision is going to occur.
     * @param currentVelocity the velocity before the hit.
     * @param hitter          the ball that hit the paddle.
     * @return the velocity after the collision.
     */

    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // the x value of the collision point
        double collisionPointX = collisionPoint.getX();
        // the current dx and dy
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        // the x value at the left side of the rectangle
        double upperLeftX = this.getCollisionRectangle().getUpperLeft().getX();
        //the length of every one of the 5 regions of the paddle.
        double theLengthOfOneRegion = this.getCollisionRectangle().getWidth() / NUM_OF_REGIONS;
        double theCurrentSpeed = Math.sqrt(dy * dy + dx * dx);
        //the x value  at the end of every region
        double firstRegionEnd = theLengthOfOneRegion + upperLeftX;
        double secondRegionEnd = 2 * theLengthOfOneRegion + upperLeftX;
        double thirdRegionEnd = 3 * theLengthOfOneRegion + upperLeftX;
        double fourthRegionEnd = 4 * theLengthOfOneRegion + upperLeftX;
        double fifthRegionEnd = 5 * theLengthOfOneRegion + upperLeftX;

        //if the collision is at the corner of the paddle
        if (isOnTheCorner(collisionPoint)) {
            dx = -dx;
            dy = -dy;
            return new Velocity(dx, dy);
        } else if ((collisionPointX < firstRegionEnd) && (collisionPointX > upperLeftX)) {
            // if the collision is at the first region of the paddle, the angle is 300.
            Velocity newVelocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_1, theCurrentSpeed);
            return newVelocity;
        } else if ((collisionPointX < secondRegionEnd) && (collisionPointX >= firstRegionEnd)) {
            // if the collision is at the second region of the paddle, the angle is 330.
            Velocity newVelocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_2, theCurrentSpeed);
            return newVelocity;
        } else if ((collisionPointX < thirdRegionEnd) && (collisionPointX >= secondRegionEnd)) {
            // if the collision is at the third region of the paddle, the vertical direction is changed.
            dy = -dy;
            return new Velocity(dx, dy);
        } else if ((collisionPointX < fourthRegionEnd) && (collisionPointX >= thirdRegionEnd)) {
            // if the collision is at the fourth region of the paddle, the angle is 30.
            Velocity newVelocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_4, theCurrentSpeed);
            return newVelocity;
        } else if ((collisionPointX < fifthRegionEnd) && (collisionPointX >= fourthRegionEnd)) {
            // if the collision is at the fifth region of the paddle, the angle is 60.
            Velocity newVelocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_5, theCurrentSpeed);
            return newVelocity;
        } else {
            // if the ball hits the left or the right border of the paddle,the horizontal direction is changed.
            dx = -dx;
            return new Velocity(dx, dy);
        }
    }

    /**
     * Add this paddle to the game.
     * <p>
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * return true if the given point is one of the corners of the block, and otherwise-return false.
     * <p>
     *
     * @param p a point.
     * @return true if the given point is one of the corners of the block, and otherwise-return false.
     */
    public boolean isOnTheCorner(Point p) {
        if (p.equals(this.getCollisionRectangle().getUpperLeft())) {
            //if the given point is equal to the upper-left point of the block, return true.
            return true;
        } else if (p.equals(this.getCollisionRectangle().getDownerLeft())) {
            //if the given point is equal to the downer-left point of the block, return true.
            return true;
        } else if (p.equals(this.getCollisionRectangle().getUpperRight())) {
            //if the given point is equal to the upper-right point of the block, return true.
            return true;
        } else if (p.equals(this.getCollisionRectangle().getDownerRight())) {
            // the given point is not on one of the corners, so the method returns false.
            return true;
        }
        // the given point is not on one of the corners, so the method returns false.
        return false;
    }
}
