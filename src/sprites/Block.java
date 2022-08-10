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
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a block at the game that includes a rectangle and a color.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * gets a rectangle and a color, and initialize a block with this information.
     * <p>
     *
     * @param rectangle the given rectangle
     * @param color     the given color.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
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
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  the point where the collide will be.
     * @param currentVelocity the given velocity
     * @param hitter          the ball that hit the block.
     * @return the new velocity expected after the hit
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // the x and y values of the collision point.
        double x = collisionPoint.getX();
        double y = collisionPoint.getY();
        // the current dx and dy.
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        // the x value of the upper left point of the rectangle.
        double uppeLeftX = this.getCollisionRectangle().getUpperLeft().getX();
        //notify to the listener about the hit.
        this.notifyHit(hitter);

        /*if the collision point is on one corner of the rectangle, the vertical
         direction and the horizontal direction are changed.*/
        if (isOnTheCorner(collisionPoint)) {
            dx = -dx;
            dy = -dy;
            return new Velocity(dx, dy);
        } else if (x > uppeLeftX && x < uppeLeftX + this.getCollisionRectangle().getWidth()) {

            /*if the x value of the collision point is on horizontal edge of the block,
             the vertical direction is changed.*/
            dy = -dy;
            return new Velocity(dx, dy);
        } else {

            /*if the x value of the collision point is on vertical edge of the block,
            the horizontal direction is changed.*/
            dx = -dx;
            return new Velocity(dx, dy);
        }
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
            //if the given point is equal to the downer-right point of the block, return true.
            return true;
        }
        // the given point is not on one of the corners, so the method returns false.
        return false;
    }

    /**
     * return the color of the block.
     * <p>
     *
     * @return the color of the block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * draw the block on the given surface.
     * <p>
     *
     * @param surface the surface where the block will be drawn.
     */
    public void drawOn(DrawSurface surface) {
        //sets the color to be the block's color
        surface.setColor(this.getColor());
        // fill a rectangle according to his information.
        surface.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(), (int) getCollisionRectangle().getHeight());
        //draw a black rectangle around the block.
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(), (int) getCollisionRectangle().getHeight());
    }

    /**
     * currently do nothing.
     * <p>
     */
    public void timePassed() {
        return;
    }

    /**
     * add this ball to the given game.
     * <p>
     *
     * @param g the given game.
     */
    public void addToGame(GameLevel g) {
        //a block is a sprite object and a collidable, so the method adds it as a sprite and as a collidable.
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove the block from the game.
     * <p>
     *
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * add the given listener as a block listener.
     * <p>
     *
     * @param hl the added listener.
     */
    public void addHitListener(HitListener hl) {
        getHitListeners().add(hl);
    }

    /**
     * remove the given listener from the list of the block listener.
     * <p>
     *
     * @param hl the removed listener.
     */
    public void removeHitListener(HitListener hl) {
        getHitListeners().remove(hl);
    }

    /**
     * notify all listeners about a hit event.
     * <p>
     *
     * @param hitter the ball that hits the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(getHitListeners());
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * return the list of listeners.
     * <p>
     *
     * @return the list of listeners.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }
}
