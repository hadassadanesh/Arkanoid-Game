/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * a shape that is defines=d by upper-left point, width and height.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     * <p>
     *
     * @param upperLeft the location of the rectangle, the upper point at the left side of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * find intersection points with the specified line, and return a list of those points.
     * <p>
     *
     * @param line the line that we check if the rectangle intersects with it.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //create a list of points.
        List<Point> thePoints = new ArrayList<Point>();
        // create the top line of the rectangle, the bottom line, and the lines at the left and right sides.
        Line topLine = new Line(this.getUpperLeft(), this.getUpperRight());
        Line bottomLine = new Line(this.getDownerLeft(), this.getDownerRight());
        Line rightLine = new Line(this.getUpperRight(), this.getDownerRight());
        Line leftLine = new Line(this.getUpperLeft(), this.getDownerLeft());

        if (topLine.isIntersecting(line)) {

            /* if the given line intersect with the top line of the rectangle, find the intersection point
             * and add it to the list of the points.*/
            Point intersection = topLine.intersectionWith(line);
            thePoints.add(intersection);
        }
        if (bottomLine.isIntersecting(line)) {

            /* if the given line intersect with the bottom line of the rectangle, find the intersection point
             * and add it to the list of the points.*/
            Point intersection = bottomLine.intersectionWith(line);
            thePoints.add(intersection);
        }
        if (rightLine.isIntersecting(line)) {

            /* if the given line intersect with the right line of the rectangle, find the intersection point
             * and add it to the list of the points.*/
            Point intersection = rightLine.intersectionWith(line);
            thePoints.add(intersection);
        }
        if (leftLine.isIntersecting(line)) {

            /* if the given line intersect with the left line of the rectangle, find the intersection point
             * and add it to the list of the points.*/
            Point intersection = leftLine.intersectionWith(line);
            thePoints.add(intersection);
        }
        // return the list.
        return thePoints;
    }

    /**
     * Return the width of the rectangle.
     * <p>
     *
     * @return Return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the height of the rectangle.
     * <p>
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     * <p>
     *
     * @return the upper point at the left side of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Returns the upper-right point of the rectangle.
     * <p>
     *
     * @return the upper point at the right side of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(getUpperLeft().getX() + getWidth(), getUpperLeft().getY());
    }

    /**
     * Returns the downer-left point of the rectangle.
     * <p>
     *
     * @return the downer point at the left side of the rectangle.
     */
    public Point getDownerLeft() {
        return new Point(getUpperLeft().getX(), getUpperLeft().getY() + getHeight());
    }

    /**
     * Returns the downer-right point of the rectangle.
     * <p>
     *
     * @return the downer point at the right side of the rectangle.
     */
    public Point getDownerRight() {
        return new Point(getUpperLeft().getX() + getWidth(), getUpperLeft().getY() + getHeight());
    }

    /**
     * set the upper-left point to be the given point.
     * <p>
     *
     * @param newUpperLeft the point that the upper left point need to be.
     */
    public void setUpperLeft(Point newUpperLeft) {
        this.upperLeft = newUpperLeft;
    }
}