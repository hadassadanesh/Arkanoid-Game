/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */
package sprites;

import gamesettings.CollisionInfo;
import gamesettings.GameLevel;
import gamesettings.GameEnvironment;
import geometry.Line;
import geometry.Point;
import biuoop.DrawSurface;
import interfaces.Collidable;
import interfaces.Sprite;
import gamesettings.Velocity;


import java.awt.Color;

/**
 * create a ball with a center, color, size and velocity.
 */
public class Ball implements Sprite {

    /*an "almost at the hit point" point is one step before the hit point
     to the direction of the currnet velocity. it is not changed.*/
    static final int THE_MOVE = 1;

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor of the class Sprites.Ball.
     * <p>
     *
     * @param center the point at the middle of the ball.
     * @param r      the radius of the ball.
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        //initialize the velocity to be 0,0
        this.velocity = new Velocity(0, 0);
    }

    /**
     * constructor of the class Sprites.Ball.
     * <p>
     *
     * @param center          the center of the ball.
     * @param r               the radius of the ball.
     * @param color           the color of the ball.
     * @param gameEnvironment the game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this(center, r, color);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * constructor of the class Sprites.Ball.
     * <p>
     *
     * @param x     the x value of the center of the ball.
     * @param y     the y value of the center of the ball.
     * @param r     the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this(new Point(x, y), r, color);
    }


    /**
     * return the x value of the center of the ball.
     * <p>
     *
     * @return int, the x value of the center of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * return the y value of the center of the ball.
     * <p>
     *
     * @return int, the x value of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * return the radius of the ball.
     * <p>
     *
     * @return return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * return the color of the ball.
     * <p>
     *
     * @return return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     * <p>
     *
     * @param surface the DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        //set the color to be the ball's color.
        surface.setColor(this.getColor());
        //create a ball with the wanted size and location.
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * set the velocity to be v.
     * <p>
     *
     * @param v the method changes the original GameSettings.Velocity to be this v.
     */
    public void setVelocity(Velocity v) {
        //set the dx to be the dx of v, and the dy to be the dy of v.
        velocity.setDx(v.getDx());
        velocity.setDy(v.getDy());
    }

    /**
     * set the velocity to be dx and dy.
     * <p>
     *
     * @param dx the method changes the original dx to be this dx.
     * @param dy the method changes the original dy to be this dy.
     */
    public void setVelocity(double dx, double dy) {
        //set the dx to be the dx and the dy to be the dy.
        velocity.setDx(dx);
        velocity.setDy(dy);
    }

    /**
     * return the velocity of the ball.
     * <p>
     *
     * @return GameSettings.Velocity, the velocity of the ball.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * return the center point of the ball.
     * <p>
     *
     * @return the center point of the ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * set the center point of the ball to be the given point.
     * <p>
     *
     * @param newCenter the new center.
     */
    public void setCenter(Point newCenter) {
        this.center = newCenter;
    }

    /**
     * if moving the ball one step wont hit anything- then the method moves the ball one step.
     * otherwise, the method  move the ball to "almost" the hit point, and update the velocity
     * to the new velocity that the method expected to have after the collision.
     * <p>
     */
    public void moveOneStep() {

        //finds the point where the velocity will take the ball if no collisions will occur
        Point endPointWithoutObstacles = new Point(getCenter().getX()
                + getVelocity().getDx(), getCenter().getY() + getVelocity().getDy());
        //compute the ball trajectory
        Line trajectory = new Line(getCenter(), endPointWithoutObstacles);
        //finds what is the closest collision of collidables with the trajectory.
        CollisionInfo collisionInfo = getGameEnvironment().getClosestCollision(trajectory);
        //if moving the ball on the trajectory will hit anything
        if (collisionInfo != null) {
            //finds the hit point
            Point hitPoint = collisionInfo.collisionPoint();
            //finds the object that the ball collide with.
            Collidable collidableObj = collisionInfo.collisionObject();
            //find a point that is "almost" the hit point, but just slightly before it.
            Point beforeTheHit = findAClosePoint(hitPoint, this.getVelocity());
            //move the ball to almost the hit point
            setCenter(beforeTheHit);
            //finds the velocity that we expect the ball to have after the hit
            Velocity newVelocity = collidableObj.hit(this, hitPoint, getVelocity());
            //update the velocity to be the new velocity.
            this.setVelocity(newVelocity);
        } else {

            /*if moving the ball on the trajectory will not hit something,
            the ball is moved to the end of the trajectory.*/
            setCenter(this.getVelocity().applyToPoint(getCenter()));
        }
    }

    /**
     * returns a point that is "almost" the hit point, but just slightly before it.
     * this point is one step before or after the hit point, according to the velocity.
     * <p>
     *
     * @param hitPoint the point where the collision suppose to occur.
     * @param v        the current velocity.
     * @return a point that is "almost" the hit point
     */
    public Point findAClosePoint(Point hitPoint, Velocity v) {
        //the x value of the hit point
        double x = hitPoint.getX();
        //the y value of the hit point
        double y = hitPoint.getY();
        if (v.getDx() > 0 && v.getDy() > 0) {

            /*if the dx and the dy are positive, the returning point's x and y values are
            smaller from the hit point's x and y by 1.*/
            return new Point(x - THE_MOVE, y - THE_MOVE);
        } else if (v.getDx() > 0 && v.getDy() < 0) {

            /*if the dx is positive and the dy is negative, the x value of the returning point
            is smaller than the x value of the hit point, and the y value is bigger.*/
            return new Point(x - THE_MOVE, y + THE_MOVE);
        } else if (v.getDx() < 0 && v.getDy() > 0) {

            /*if the dx is negative and the dy is positive, the x value of the returning point
            is bigger than the x value of the hit point, and the y value is smaller.*/
            return new Point(x + THE_MOVE, y - THE_MOVE);
        } else if (v.getDx() < 0 && v.getDy() < 0) {

            /*if the dx is negative and the dy is negative, the x value of the returning point
            is bigger than the x value of the hit point, and the y value is also bigger.*/
            return new Point(x + THE_MOVE, y + THE_MOVE);
        } else if (v.getDx() == 0 && v.getDy() > 0) {

            /*if the dx is 0 and the dy is positive, the x value of the returning point
            is the same as the x value of the hit point, and the y value is smaller.*/
            return new Point(x, y - THE_MOVE);
        } else if (v.getDx() == 0 && v.getDy() < 0) {

            /*if the dx is 0 and the dy is negative, the x value of the returning point
            is the same as the x value of the hit point, and the y value is bigger.*/
            return new Point(x, y + THE_MOVE);
        } else if (v.getDx() > 0 && v.getDy() == 0) {

            /*if the dx is positive and the dy is 0, the x value of the returning point
            is smaller than the x value of the hit point, and the y value is the same.*/
            return new Point(x - THE_MOVE, y);
        } else if (v.getDx() < 0 && v.getDy() == 0) {

            /*if the dx is negative and the dy is 0, the x value of the returning point
            is bigger than the x value of the hit point, and the y value is the same.*/
            return new Point(x + THE_MOVE, y);
        } else {
            //if the dx and the dy are 0, return the hit point.
            return hitPoint;
        }
    }

    /**
     * returns the game environment.
     * <p>
     *
     * @return the game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * move the ball one step.
     * <p>
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * add the ball to the given game.
     * <p>
     *
     * @param g the given game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * remove the ball from the given game..
     * <p>
     *
     * @param game the given game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}