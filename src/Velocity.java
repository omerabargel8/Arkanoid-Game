/**
 *@author Omer Abargel, id-207041005.
 *Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * the constructor of the Velocity class.
     * @param dx the change in position on the 'x' axes.
     * @param dy the change in position on the 'y' axes.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this method creates a velocity object through angel and speed.
     * @param angle the angel of the velocity.
     * @param speed the speed of the velocity.
     * @return the velocity created.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        Velocity v = new Velocity(dx, dy);
        return v;
    }

    /**
     * accessor of the dx.
     * @return the dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * accessor to the dy.
     * @return the dy of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy).
     * @param p the given point.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        Point newP = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newP;
    }

    /**
     * returns the speed according to the equation a^2 + b^2 = c^2.
     * @return the speed
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}