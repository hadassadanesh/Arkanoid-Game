/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import geometry.Point;
import interfaces.Collidable;

/**
 * has the information about the closest collision.
 */
public class CollisionInfo {
    private Collidable collidableObject;
    private Point collisionPoint;

    /**
     * gets a collidable object and the collision point, and
     * initialize the collisionInfo with this information.
     * <p>
     *
     * @param collidableObject the collidable object involved in the collision.
     * @param collisionPoint   the point at which the collision occurs.
     */
    public CollisionInfo(Collidable collidableObject, Point collisionPoint) {
        this.collidableObject = collidableObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * returns the point at which the collision occurs.
     * <p>
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * returns the collidable object involved in the collision.
     * <p>
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidableObject;
    }
}
