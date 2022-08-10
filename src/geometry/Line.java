/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package geometry;

import java.util.List;

/**
 * create a line with a start and end points.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * a constructor of Geometry.Line class, that gets two points- start and end and initializes a line.
     * <p>
     *
     * @param start the start of the line's point.
     * @param end   the end of the line's point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * a constructor of Geometry.Line class, that gets 4 numbers- two x values and two y .
     * values and initializes a line.
     * <p>
     *
     * @param x1 x value of one point
     * @param x2 x value of other point
     * @param y1 y value of one point
     * @param y2 y value of other point
     */
    public Line(double x1, double y1, double x2, double y2) {
        //creates two points and passes them to the other constructor, that will create a line.
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Return the length of the line.
     * <p>
     *
     * @return a variable from type double that is the length of the line
     */
    public double length() {
        return this.start().distance(this.end());
    }

    /**
     * Returns the middle point of the line.
     * <p>
     *
     * @return a point.
     */
    public Point middle() {
        //finds the x value of the middle point.
        double middleX = (this.start().getX() + this.end().getX()) / 2;
        //finds the y value of the middle point.
        double middleY = (this.start().getY() + this.end().getY()) / 2;
        //creates the middle point and returns it.
        return new Point(middleX, middleY);
    }

    /**
     * Returns the start point of the line.
     * <p>
     *
     * @return a point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     * <p>
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * checks if a given line is vertical to the X axis.
     * <p>
     *
     * @param l a line.
     * @return boolean value, true if the line is vertical and false otherwise.
     */
    public boolean isVertical(Line l) {
        //if the x value of the start point and the end point is equal
        if (l.start().getX() == l.end().getX()) {
            return true;
        }
        //if the x value of the start point and the end point is not equal
        return false;
    }

    /**
     * gets a line and another line that is vertical with the x axis.
     * and returns the optional intersection point.
     * <p>
     *
     * @param line        a line.
     * @param theVertical a line that is vertical with the x axis.
     * @return the optional intersection point.
     */
    public Point pointIntersectSpecialCases(Line line, Line theVertical) {
        //x1- the x value of the start point, y1- the y value of the start point.
        double x1 = line.start().getX();
        double y1 = line.start().getY();
        //x1- the x value of the end point, y1- the y value of the end point.
        double x2 = line.end().getX();
        double y2 = line.end().getY();
        //the x value of the intersection point is the x value of the vertical line.
        double intersectionX = theVertical.start().getX();
        //finding the incline of the line.
        double m = (y1 - y2) / (x1 - x2);
        double b1 = y1 - m * x1;

        /*the y value of the intersection point is the value of the equasion of the line with
         the x value of the intersection point in it. */
        double intersectionY = m * intersectionX + b1;
        //return the optional intersection point.
        return new Point(intersectionX, intersectionY);
    }

    /**
     * get a point that is called theIntersection and another two points and return true if the.
     * two points have different direction relative to the theIntersection point, and false otherwise.
     * <p>
     *
     * @param theIntersection the point that the directions are checked  relative to it.
     * @param p1              one point
     * @param p2              another point
     * @return boolean value, true if p1 and p2 going to different directions relative to theIntersection.
     * otherwise- return false.
     */
    public boolean isDiffDirection(Point theIntersection, Point p1, Point p2) {

        /*p1 is at the right side relative to theIntersection point, and p2 is at the left side relative
        to theIntersection point*/
        if ((p1.getX() > theIntersection.getX()) && (p2.getX() < theIntersection.getX())) {
            return true;
        } else if ((p2.getX() > theIntersection.getX()) && (p1.getX() < theIntersection.getX())) {

            /*p2 is at the right side relative to theIntersection point, and p1 is at the left side relative
            to theIntersection point*/
            return true;
        }
        return false;
    }

    /**
     * checks if a given line and this line that are  parallel have just one intersection point.
     * if they do, return the point. else- return null.
     * <p>
     *
     * @param other a line.
     * @return the intersection point or null.
     */
    public Point isOneIntersectionInParallel(Line other) {
        //if the start point of this line is the start point of the other line.
        if (this.start().equals(other.start())) {
            //if the two other points going to different directions- the lines have just one intersection point.
            if (isDiffDirection(this.start(), other.end(), this.end())) {
                //return the intersection point
                return this.start();
            }
            //the two other points going to the same direction- the lines have more than one intersection point.
            return null;
        } else if (this.start().equals(other.end())) {

            /*if the start point of this line is the end point of the other line, then:
            if the two other points going to different directions- the lines have just one intersection point.*/
            if (isDiffDirection(this.start(), this.end(), other.start())) {
                //return the intersection point
                return this.start();
            }
            //the two other points going to the same direction- the lines have more than one intersection point.
            return null;
        } else if (this.end().equals(other.start())) {

            /*if the end point of this line is the start point of the other line, then:
            if the two other points going to different directions- the lines have just one intersection point.*/
            if (isDiffDirection(this.end(), this.start(), other.end())) {
                //return the intersection point
                return this.end();
            }
            //the two other points going to the same direction- the lines have more than one intersection point.
            return null;
        } else if (this.end().equals(other.end())) {

            /*if the end point of this line is the end point of the other line, then:
            if the two other points going to different directions- the lines have just one intersection point.*/
            if (isDiffDirection(this.end(), this.start(), other.start())) {
                //return the intersection point
                return this.end();
            }
            //the two other points going to the same direction- the lines have more than one intersection point.
            return null;
        }
        //the two lines don't have just one intersection point.
        return null;
    }

    /**
     * returns the intersection point between two lines, or null if there is not.
     * * <p>
     *
     * @param other the other line.
     * @return the intersection point between the lines.
     */
    public Point findIntersection(Line other) {
        //saves in variables the x and the y values of the start and end points of every line.
        double x1 = this.start().getX();
        double y1 = this.start().getY();
        double x2 = this.end().getX();
        double y2 = this.end().getY();
        double x3 = other.start().getX();
        double y3 = other.start().getY();
        double x4 = other.end().getX();
        double y4 = other.end().getY();
        //if the two lines are not in the same domain of the x axis, they don't have intersection point.
        if ((Math.max(x1, x2) < Math.min(x3, x4)) || (Math.max(x3, x4) < Math.min(x1, x2))) {
            return null;
        }
        //finds the incline of the two lines.
        double m1 = (y1 - y2) / (x1 - x2);
        double m2 = (y3 - y4) / (x3 - x4);
        //if the lines are parallel, if they have just one intersection point, return the point. else- return null.
        if (m1 == m2) {
            return isOneIntersectionInParallel(other);
        }
        //finds the rest of the line equations- the b, and the x value of the intersection point.
        double b1 = y1 - m1 * x1;
        double b2 = y3 - m2 * x3;
        double xIntersecting = (b2 - b1) / (m1 - m2);

        /*checks if the x value of the intersection is in the right range of x-es. if the x value of the
         intersection point is smaller than the max value between the two minimal x-es, it means that the
         x of the intersection is not in the range of one line, so it can't be the x value of the intersection.*/
        if ((xIntersecting < Math.max(Math.min(x1, x2), Math.min(x3, x4)))
                || (xIntersecting > Math.min(Math.max(x1, x2), Math.max(x3, x4)))) {
            return null;
        }
        //finds the y value of the intersection by placing the x of the intersection in one line equasion.
        double yIntersecting = m1 * xIntersecting + b1;
        //returns the intersection point.
        return new Point(xIntersecting, yIntersecting);
    }

    /**
     * checks if two lines that one of them is vertical are intersecting.
     * * <p>
     *
     * @param theOther    a line.
     * @param theVertical a line that is vertical with the x axis.
     * @return returns true if they are intersecting, and false otherwise.
     */
    public boolean isIntersectOneVertical(Line theOther, Line theVertical) {
        /*if the x value of the vertical line is bigger than (or equal to) the min value between the
             two x-es of the other line and smaller than(or equal to) the max value between the two x-es
             of the other line, it is in the right range.*/
        if (theVertical.start().getX() >= Math.min(theOther.start().getX(), theOther.end().getX())
                && (theVertical.start().getX() <= Math.max(theOther.start().getX(), theOther.end().getX()))) {

            /*passes the lines to a function that finds their optional intersection point, and the method
             * saves the y value of this point.*/
            double yOptionalIntersecting = pointIntersectSpecialCases(theOther, theVertical).getY();

                /*if the y value of the intersection point is also at the right range. it means-
                if the y value of the intersection point is bigger than (or equal to) the min value between the
                two y-es of the vertical line, and smaller than(or equal to) the max value between the two y-es
                of the vertical line.*/
            if (yOptionalIntersecting >= Math.min(theVertical.start().getY(), theVertical.end().getY())
                    && (yOptionalIntersecting <= Math.max(theVertical.start().getY(), theVertical.end().getY()))) {
                //the lines intersect
                return true;
            }
            //the lines don't have an intersection point.
            return false;
        }
        //the lines don't have an intersection point.
        return false;
    }

    /**
     * check if two line intersect, and returns true if they do, and false otherwise.
     * <p>
     *
     * @param other the other line.
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //if the two lines are equal, they don't have an intersection point.
        if (this.equals(other)) {
            return false;
        } else if ((isVertical(this)) && (isVertical(other))) {
            //if the two lines are vertical with the x axis, they don't have an intersection point.
            return false;
        } else if (isVertical(this)) { //if just one of the lines is vertical
            return isIntersectOneVertical(other, this);
        } else if (isVertical(other)) { //if just the other line is vertical.
            return isIntersectOneVertical(this, other);
        } else if (this.start().equals(this.end())) {
            //if the start and the end points of this line are equal. this line is a point.

            /*if the y value of the optional intersection point is equal to the y of this line(a point)
             * then this is the intersection point, so the lines are intersecting.*/
            if (pointIntersectSpecialCases(other, this).getY() == this.start().getY()) {
                return true;
            }
            return false;
        } else if (other.start().equals(other.end())) {
            //if the start and the end points of the other line are equal. the other line is a point.

            /*if the y value of the optional intersection point is equal to the y of the other line
            (a point) then this is the intersection point, so the lines are intersecting.*/
            if (pointIntersectSpecialCases(this, other).getY() == other.start().getY()) {
                return true;
            }
            return false;
        } else if (findIntersection(other) != null) {
            // if its not one of the cases above, check if there is an intersection point. if there is- return true
            return true;
        }
        //there is not an intersection point, so there is not intersecting.
        return false;
    }

    /**
     * Returns the intersection point if the lines intersecting and null otherwise.
     * <p>
     *
     * @param other the other line.
     * @return Returns the intersection point if the lines intersecting and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //if the lines are not intersecting, so they don't have an intersection point.
        if (!this.isIntersecting(other)) {
            return null;
        } else { //the lines are intersecting
            //if just this line is vertical(if the two lines are vertical, they are not intersect).
            if (isVertical(this)) {
                return pointIntersectSpecialCases(other, this);
            } else if (isVertical(other)) { //if just the other line is vertical
                return pointIntersectSpecialCases(this, other);
            } else if (this.start().equals(this.end())) { //if this line is a point, return it.
                return this.start();
            } else if (other.start().equals(other.end())) { //if the other line is a point, return it.
                return other.start();
            } else { //in other cases, return the point that the method finds.
                return findIntersection(other);
            }
        }
    }

    /**
     * return true is the lines are equal, false otherwise.
     * <p>
     * checks if this line and the other line are equal. if they are the method returns true,
     * and if not, the method returns false.
     *
     * @param other the other line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        // if the start points of the two lines are equal
        if ((this.start().getY() == other.start().getY()) && (this.start().getX() == other.start().getX())) {
            //if the end points of the two lines are equal
            if ((this.end().getY() == other.end().getY()) && (this.end().getX() == other.end().getX())) {
                //the lines are equal
                return true;
            }
        }
        //if the start point of this line is equal to the end point of the other line
        if ((this.start().getY() == other.end().getY()) && (this.start().getX() == other.end().getX())) {
            //if the end point of this line is equal to the start point of the other line
            if ((this.end().getY() == other.start().getY()) && (this.end().getX() == other.start().getX())) {
                //the lines are equal
                return true;
            }
        }
        //the lines are not equal
        return false;
    }

    /**
     * the method returns null if this line does not intersect with the given rectangle.
     * Otherwise, it returns the closest intersection point to the start of the line.
     * <p>
     *
     * @param rect the given rectangle.
     * @return the closest intersection point to the start of the line, or null if there
     * is not intersection points.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //if this line does not intersect with the given rectangle, return null.
        if (rect.intersectionPoints(this).size() == 0) {
            return null;
        } else { //if this line do intersect with the given rectangle
            //save all the intersection points between this line and the rectangle.
            List<Point> points = rect.intersectionPoints(this);
            //initialize the closest intersection point to the start of the line to be the first point at the list.
            Point closestIntersection = points.get(0);
            for (int i = 1; i < points.size(); i++) {

                /*if the distance of the current intersection point from the start of the line is less
                 * than the distance of the closestIntersection that we found from the start of the line, then the
                 *  current intersection point is the new closestIntersection.*/
                if (points.get(i).distance(this.start()) < closestIntersection.distance(this.start())) {
                    closestIntersection = points.get(i);
                }
            }
            //return the closest intersection point to the start of the line
            return closestIntersection;
        }
    }
}
