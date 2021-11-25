import java.util.ArrayList;
import java.util.List;
/**
 *@author Omer Abargel, id-207041005.
 * The class Rectangle.
 */
public class Rectangle {
     private Point upperLeft;
     private double width;
     private double height;
     private Point upperRight;
     private Point lowerLeft;
     private Point lowerRight;
     private Line horizontalTopLine;
     private Line horizontalUnderline;
     private Line leftVerticalLine;
     private Line rightVerticalLine;

    /**
     * constructor for Rectangle class.
     * Create a new rectangle with location and width, height.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //set all the rectangles points
        this.upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        this.lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);
        this.lowerRight = new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height);
        //set all the lines of the rectangle
        this.horizontalTopLine = new Line(upperLeft, upperRight);
        this.horizontalUnderline = new Line(lowerLeft, lowerRight);
        this.leftVerticalLine = new Line(upperLeft, lowerLeft);
        this.rightVerticalLine = new Line(upperRight, lowerRight);
    }
    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * this method checks and returns a list of intersection points.
     * of a specified line with the rectangle.
     * @param line -the line with which we will examine intersection points.
     * @return list of intersection point (possibly empty).
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        if (horizontalTopLine.intersectionWith(line) != null) {
            intersectionPoints.add(horizontalTopLine.intersectionWith(line));
        }
        if (horizontalUnderline.intersectionWith(line) != null) {
            intersectionPoints.add(horizontalUnderline.intersectionWith(line));
        }
        if (leftVerticalLine.intersectionWith(line) != null) {
            intersectionPoints.add(leftVerticalLine.intersectionWith(line));
        }
        if (rightVerticalLine.intersectionWith(line) != null) {
            intersectionPoints.add(rightVerticalLine.intersectionWith(line));
        }
        return intersectionPoints;
    }

    /**
     * accessor of the width of the rectangle.
     * @return the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * accessor of the height of the rectangle.
     * @return the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * accessor of the upper left point of the rectangle.
     * @return the upper left point.
     */
    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return upperLeft;
    }
    /**
     * accessor of the upper right point of the rectangle.
     * @return the upper right point.
     */
    // Returns the upper-left point of the rectangle.
    public Point getUpperRight() {
        return upperRight;
    }
    /**
     * accessor of lower left point of the rectangle.
     * @return the lower left point.
     */
    // Returns the upper-left point of the rectangle.
    public Point getLowerLeft() {
        return lowerLeft;
    }
    /**
     * accessor of lower Right point of the rectangle.
     * @return the lower right point.
     */
    // Returns the upper-left point of the rectangle.
    public Point getLowerRight() {
        return lowerRight;
    }

    /**
     * accessor of Horizontal Top Line of the rectangle.
     * @return the Horizontal Top Line
     */
    public Line getHorizontalTopLine() {
        return this.horizontalTopLine;
    }
    /**
     * accessor of Horizontal Under Line of the rectangle.
     * @return the Horizontal Under Line
     */
    public Line getHorizontalUnderline() {
        return this.horizontalUnderline;
    }
    /**
     * accessor of Left Vertical Line of the rectangle.
     * @return the Left Vertical Line
     */
    public Line getLeftVerticalLine() {
        return this.leftVerticalLine;
    }
    /**
     * accessor of Right Vertical Line of the rectangle.
     * @return the Right Vertical Line
     */
    public Line getRightVerticalLine() {
        return this.rightVerticalLine;
    }
}