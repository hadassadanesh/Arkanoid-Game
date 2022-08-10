/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

import gamesettings.Velocity;
import geometry.Point;
import geometry.Rectangle;
import sprites.Ball;

/**
 * The interfaces.Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     * <p>
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter          the ball that hit the collidable.
     * @param collisionPoint  the point where the collide will be.
     * @param currentVelocity the given velocity
     * @return the new velocity expected after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}