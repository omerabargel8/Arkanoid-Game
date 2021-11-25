/**
 *@author Omer Abargel, id-207041005.
 * The class Line
 */
public class Line {
    private Point start;
    private Point end;
    /**
     * constructor for Line class.
     * @param start The starting point of the line.
     * @param end The end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }
    /**
     * constructor for Line class.
     * @param x1 x value of the stating point.
     * @param y1 y value of the stating point.
     * @param x2 x value of the end point.
     * @param y2 x value of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * return the length of the line.
     * @return the length of the line.
     */
    public double length() {
        return start.distance(end);
    }
    /**
     * returns the middle point of the line.
     * @return the middle point of the line.
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(midX, midY);
        return middle;
    }
    /**
     * returns the start point of the line.
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * returns the end point of the line.
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * returns true if the lines intersect, false otherwise.
     * @param other the line with which we will examine intersecting.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        Point intersectionPoint = this.getIntersectionPoint(other);
        if (intersectionPoint == null) {
            return false;
        }
        if (this.inRange(intersectionPoint) && other.inRange(intersectionPoint)) {
            return true;
        }
        return false;
    }
    /**
     * checks and return the intersecting point. if doesn't exist return null.
     @param other the line with which we will check and find the intersection point.
     @return intersection point if the lines intersect, and null otherwise
     */
    public Point getIntersectionPoint(Line other) {
        double xIntersect, yIntersect;
        //if the lines are parallel- there is no intersection
        if (other.slope() == this.slope()) {
            return null;
        }
        //if this line is vertical
        if (this.isVertical()) {
            xIntersect = this.start.getX();
            yIntersect = (other.slope() * xIntersect) - (other.slope() * other.end.getX()) + other.end.getY();
            return new Point(Math.round(xIntersect), Math.round(yIntersect));
        }
        //if the other line is vertical
        if (other.isVertical()) {
            xIntersect = other.start.getX();
            yIntersect = (this.slope() * xIntersect) - (this.slope() * this.end.getX()) + this.end.getY();
            return new Point(Math.round(xIntersect), Math.round(yIntersect));
        }
        //finds the X value according to the lines equation
        xIntersect = (((other.slope() * other.start.getX()) - other.start.getY()
                + this.start().getY() - (this.slope() * this.start.getX())) / (other.slope() - this.slope()));
        //finds the Y value according to the lines equation
        yIntersect = (this.slope() * xIntersect) - (this.slope() * this.start.getX()) + this.start.getY();
        return new Point(Math.round(xIntersect), Math.round(yIntersect));

    }
    /**
     * checks and return the intersecting point if exist.
     * @param other the line with which we will check and find the intersection point.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other)) {
            return null;
        }
        Point intersectionPoint = getIntersectionPoint(other);
        return intersectionPoint;
    }
    /**
     * check if two lines are equals.
     * @param other the line with which equality will be examined.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start == other.start && this.end == other.end && this.length() == other.length()) {
            return true;
        }
        return false;
    }
    /**
     * calculate the slope of this line.
     * @return the slope of this line.
     */
    public double slope() {
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
    }
    /**
     * checks if a given point is in the line range.
     * @param p the point.
     * @return true if the point is on the line, false otherwise.
     */
    public boolean inRange(Point p) {
        double x = p.getX();
        double y = p.getY();
        if ((this.start.getX() <= x && this.end.getX() >= x) || (this.start.getX() >= x && this.end.getX() <= x)) {
            if ((this.start.getY() <= y && this.end.getY() >= y) || (this.start.getY() >= y && this.end.getY() <= y)) {
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * checks if one or two lines are verticals.
     * @return true if one or two lines are verticals, fale otherwise.
     */
    public boolean isVertical() {
        if (this.start.getX() == this.end.getX()) {
            return true;
        }
        return false;
    }
    /**
     *if this line does not intersect with the rectangle, return null.
     *Otherwise, return the closest intersection point to the
     *start of the line.
     * @param rect a rectangle
     * @return the closest intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point closestPoint = null;
        double distance = Double.MAX_VALUE;
        //check if intersect with the horizontal top line
        Point intersection = this.intersectionWith(rect.getHorizontalTopLine());
        if (intersection != null && intersection.distance(start) < distance) {
            distance = intersection.distance(start);
            closestPoint = intersection;
        }
        //check if intersect with the horizontal under line
        intersection = this.intersectionWith(rect.getHorizontalUnderline());
        if (intersection != null && intersection.distance(start) < distance) {
            distance = intersection.distance(start);
            closestPoint = intersection;
        }
        //check if intersect with the Left vertical line
        intersection = this.intersectionWith(rect.getLeftVerticalLine());
        if (intersection != null && intersection.distance(start) < distance) {
            distance = intersection.distance(start);
            closestPoint = intersection;
        }
        //check if intersect with the right vertical line
        intersection = this.intersectionWith(rect.getRightVerticalLine());
        if (intersection != null && intersection.distance(start) < distance) {
            distance = intersection.distance(start);
            closestPoint = intersection;
        }
        return closestPoint;
    }
}