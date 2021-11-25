/**
 *@author Omer Abargel, id-207041005.
 * The class Point
 */
public class Point {
    private double x;
    private double y;
    /**
     * constructor for Point class.
     * @param x the x value.
     * @param y the y value.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * return the distance of this point to the other point.
     * @param other the point to calculate the distance from this point.
     * @return the distance between this point to the other.
     */
    public double distance(Point other) {
        double distance;
        double xDistance = this.getX() - other.getX();
        xDistance = Math.pow(xDistance, 2); //Calculates the X value differences in the square
        double yDistance = this.getY() - other.getY();
        yDistance = Math.pow(yDistance, 2); //Calculates the y value differences in the square
        distance = Math.sqrt(xDistance + yDistance);
        return distance;
    }
    /**
     * return true is the points are equal, false otherwise.
     * @param other The point to compare to this point
     * @return true if equals else return false.
     */
    public boolean equals(Point other) {
        if (other != null && this.x == other.getX() && this.y == other.getY()) {
            return true;
        }
        return false;
    }
    /**
     *Return the x value of this point.
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * return the y value of this point.
     * @return return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}
