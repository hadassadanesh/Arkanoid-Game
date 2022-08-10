/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */
package gamesettings;

import geometry.Point;

/**
 * create a velocity to a ball, with dx and dy.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor to the class GameSettings.Velocity.
     * <p>
     *
     * @param dx the change in position on the `x` axe.
     * @param dy the change in position on the `y` axe.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * a method that gets an angle and speed and changes them into dx and dy.
     * then, the method creates a new GameSettings.Velocity with those parameters.
     * <p>
     *
     * @param angle an angle.
     * @param speed a speed.
     * @return a new GameSettings.Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //change the angles to radians.
        double angleInRadians = Math.toRadians(angle);
        // find dx
        double dx = Math.sin(angleInRadians) * speed;
        // find dy
        double dy = Math.cos(angleInRadians) * (-1) * speed;
        //return the new GameSettings.Velocity.
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * <p>
     *
     * @param p a point with position (x,y).
     * @return a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * set the dx to be the given otherDx.
     * <p>
     *
     * @param otherDx the method changes the dx to be this otherDx.
     */
    public void setDx(double otherDx) {
        this.dx = otherDx;
    }

    /**
     * set the dy to be the given otherDy.
     * <p>
     *
     * @param otherDy the method changes the dy to be this otherDy.
     */
    public void setDy(double otherDy) {
        this.dy = otherDy;
    }

    /**
     * return the dx of the GameSettings.Velocity.
     * <p>
     *
     * @return the dx of the GameSettings.Velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * return the dy of the GameSettings.Velocity.
     * <p>
     *
     * @return dy of the GameSettings.Velocity.
     */
    public double getDy() {
        return this.dy;
    }

}