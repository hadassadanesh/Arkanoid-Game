/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package geometry;

/**
 * create a point with x and y values.
 */
public class Point {
    private double x;
    private double y;

    /**
     * a constructor of Geometry.Point class, that gets two numbers- x and y and initializes the point.
     * <p>
     *
     * @param x is the x value of the point.
     * @param y is the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the method returns the distance of this point to the other point.
     * <p>
     *
     * @param other the other point.
     * @return a number from double type.
     */
    public double distance(Point other) {
        //finds the x and y values of this point and the other point.
        double xOfThis = getX();
        double xOfOther = other.getX();
        double yOfThis = getY();
        double yOfOther = other.getY();
        //calculates the distance between this point and the other point, and returns it.
        return Math.sqrt((xOfThis - xOfOther) * (xOfThis - xOfOther) + (yOfThis - yOfOther) * (yOfThis - yOfOther));
    }

    /**
     * the method returns true is this point and the other point are equal, false otherwise.
     * <p>
     *
     * @param other the other point.
     * @return true if equals and false if not.
     */
    public boolean equals(Point other) {
        if (other.getX() == this.getX()) {
            //if the y value of this point and the other point is also the same.
            if (other.getY() == this.getY()) {
                //the points are equal
                return true;
            }
            return false;
        }
        //the points are not equal
        return false;
    }

    /**
     * the method returns the x value of this point.
     * <p>
     *
     * @return the value of x of this point. the returning value type is double
     */
    public double getX() {
        return this.x;
    }

    /**
     * the method returns the y value of this point.
     * <p>
     *
     * @return the value of y of this point. the returning value type is double
     */
    public double getY() {
        return this.y;
    }
}
