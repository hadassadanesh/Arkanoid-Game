/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The GameSettings.GameEnvironment class is a collection of objects that a
 * Sprites.Ball can collide with.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * initialize a game environment by creating a new list of collidables.
     * <p>
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }


    /**
     * add the given collidable to the environment.
     * <p>
     *
     * @param c the given collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * return the list of the collidables.
     * <p>
     *
     * @return a list of collidables.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * the method assumes that an object is moving on the trajectory.
     * if this object will not collide with any of the collidables in this collection,
     * the method returns null. Else, it returns the information
     * about the closest collision that is going to occur.
     * <p>
     *
     * @param trajectory the line.
     * @return Collision information about the closest collision, or null if there is not collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // initializes a flag and a rectangle.
        int flag = 0;
        Rectangle rect;

        /* pass over all the collidables and check if they have intersection points with the
         trajectory line. if the trajectory line is intersecting a collidable,
         the flag is changed to be 1, and the loop is stopped. */
        List<Collidable> theCollidables = new ArrayList<Collidable>(getCollidables());
        for (Collidable c : theCollidables) {
            rect = c.getCollisionRectangle();
            if (rect.intersectionPoints(trajectory).size() != 0) {
                flag = 1;
                break;
            }
        }

        /* if the flag is 1, then the trajectory line has intersection with at list one collidable,
         * then find the collisionInfo of the closest collision and return it. */
        if (flag == 1) {
            return findCollisionInfoOfClosestCollision(trajectory);
        }
        //the flag is still 0, so the trajectory line doesn't have intersection with any
        // collidable,so return null.
        return null;
    }

    /**
     * the method gets a line and return the collisionInfo of the closest collidable
     * that collide with the line.
     * <p>
     *
     * @param trajectory the line.
     * @return Collision information about the closest collision.
     */
    public CollisionInfo findCollisionInfoOfClosestCollision(Line trajectory) {
        //initializes the collision point to be (0,0)
        Point collisionPoint = new Point(0, 0);
        //initializes the collision object to be the first collidable.
        Collidable collidableObject = getCollidables().get(0);
        // initialize the distance between a line and a collision object to be 0.
        double minDistanceLineAndCollision = 0;

        /*a for loop that goes over all the collidables. at the first collidable that has intersection
         with the line, the method changes the collision point to be this point, and the method save
          the distance between this point and the start of the line. the for loop is stopped.*/
        for (int i = 0; i < getCollidables().size(); i++) {
            // get the current collidable.
            collidableObject = getCollidables().get(i);
            // get the current collidable's rectangle.
            Rectangle currentRectangle = collidableObject.getCollisionRectangle();
            if (currentRectangle.intersectionPoints(trajectory).size() != 0) {

                /*if this rectangle has an intersection points with the line, then: find the closest
                 intersection point and calculate the distance between it and the start of the line.
                  then, stop.*/
                collisionPoint = trajectory.closestIntersectionToStartOfLine(currentRectangle);
                minDistanceLineAndCollision = trajectory.start().distance(collisionPoint);
                break;
            }
        }

        /*pass over all the collidables and check if they have an intersection points with the line. if
        a collidable has an intersection points with the line, check if the distance between the collision
        point and the start of the line is smaller than the minimum distance that was found. if yes,
        update the minimum distance, the collision point and the collision object.*/
        Rectangle thisRectangle;
        for (int j = 0; j < getCollidables().size(); j++) {
            Collidable thisCollidable = getCollidables().get(j);
            // get the current collidable's rectangle.
            thisRectangle = thisCollidable.getCollisionRectangle();
            if (thisRectangle.intersectionPoints(trajectory).size() != 0) {

                /*if this rectangle has an intersection points with the line, then: find the closest
                 intersection point and calculate the distance between it and the start of the line.*/
                Point currentCollisionPoint = trajectory.closestIntersectionToStartOfLine(thisRectangle);
                double theCurrentDis = trajectory.start().distance(currentCollisionPoint);

                if (theCurrentDis < minDistanceLineAndCollision) {

                    /*if the distance between the collision
                     point and the start of the line is smaller than the minimum distance that was found. if yes,
                     update the minimum distance, the collision point and the collision object to be this object.*/
                    minDistanceLineAndCollision = theCurrentDis;
                    collidableObject = thisCollidable;
                    collisionPoint = currentCollisionPoint;
                }
            }
        }
        //return the collisionInfo of the closest collision.
        return new CollisionInfo(collidableObject, collisionPoint);
    }
}
