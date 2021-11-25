import biuoop.DrawSurface;

/**
 *@author Omer Abargel, id-207041005.
 * The class Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Velocity v;
    private Point startPoint;
    private Point endPoint;
    private java.awt.Color color;
    private GameEnvironment gameEnvironment;

    /**
     * constructor for Ball class.
     * @param center represent the point of the ball center.
     * @param r the size of the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        // set the default for the start point and end point.
        this.setStartPoint(10, 30);
        this.setEndPoint(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    /**
     * constructor for Ball class.
     * @param x the x value of the center of the ball.
     * @param y the y value of the center of the ball.
     * @param r the size of the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.setStartPoint(10, 30);
        this.setEndPoint(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    /**
     * accessor of the x value of the center.
     * @return the x value of the center.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * accessor of the y value of the center.
     * @return the y value of the center.
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * set the start point of the frame.
     * @param x the x value.
     * @param y the y value.
     */
    public void setStartPoint(double x, double y) {
        this.startPoint = new Point(x, y);
    }

    /**
     * set the end point of the frame.
     * @param x the x value.
     * @param y the y value.
     */
    public void setEndPoint(double x, double y) {
        this.endPoint = new Point(x, y);
    }

    /**
     * accessor of the size of the radius of the ball.
     * @return the size of the radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * accessor of the color of the ball.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * set the velocity of tha ball.
     * @param v1 the velocity.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * set the velocity of the ball.
     * @param dx the change on the x values.
     * @param dy thee chane on the y values.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * accessor of the velocity.
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * set the ball environment.
     * @param environment the environment
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }
    /**
     * this method moves the ball one step according to his velocity.
     * checks if its reaches to his boundaries or blocks and handles.
     */
    public void moveOneStep() {
        //finds the end point of the trajectory, create the trajectory line and find his collision info.
        int dxSign = 0, dySign = 0;
        Point nextPoint;
        //Checks Moving direction
        if (this.getVelocity().getDx() > 0) {
            dxSign = 1;
        } else if (this.getVelocity().getDx() < 0) {
            dxSign = -1;
        }
        if (this.getVelocity().getDy() > 0) {
            dySign = 1;
        } else if (this.getVelocity().getDy() < 0) {
            dySign = -1;
        }
        Point pointAfterOneStep = this.getVelocity().applyToPoint(this.center);
        nextPoint = new Point(pointAfterOneStep.getX() + dxSign * r, pointAfterOneStep.getY() + dySign * r);
        Line trajectory = new Line(center, nextPoint);
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null || collisionInfo.collisionPoint() == null) {
            //if there is no collision check the regular borders.
            this.center = this.getVelocity().applyToPoint(this.center);
            //If x value is smaller than the starting point- change the ball direction
            if (this.getX() - this.r <= this.startPoint.getX()) {
                this.setVelocity(-1 * this.getVelocity().getDx(), this.getVelocity().getDy());
                Point p1 = new Point(this.startPoint.getX() + this.r, this.getY());
                this.center = p1;
            }
            //If x value is bigger than the end point- change the ball direction
            if (this.getX() + this.r >= this.endPoint.getX()) {
                this.setVelocity(-1 * this.getVelocity().getDx(), this.getVelocity().getDy());
                Point p1 = new Point(this.endPoint.getX() - this.r, this.getY());
                this.center = p1;
            }
            ////If y value is smaller than the starting point- change the ball direction
            if (this.getY() - this.r <= this.startPoint.getY()) {
                this.setVelocity(this.getVelocity().getDx(), -1 * this.getVelocity().getDy());
                Point p3 = new Point(this.getX(), this.startPoint.getY() + this.r);
                this.center = p3;
            }
            //If y value is bigger than the end point- change the ball direction
            if (this.getY() + this.getSize() >= this.endPoint.getY()) {
                this.setVelocity(this.getVelocity().getDx(), -1 * this.getVelocity().getDy());
                Point p4 = new Point(this.getX(), this.endPoint.getY() - this.r);
                this.center = p4;
            }
        } else {
            //If there is a collision
            Point collisionPoint = collisionInfo.collisionPoint();
            Collidable collisionObject = collisionInfo.collisionObject();
            double newX = collisionPoint.getX();
            double newY = collisionPoint.getY();
            if (this.getVelocity().getDx() > 0) {
                //check the moving direction to know where will be it next point
                newX = newX - r - 1;
            } else {
                newX = newX + r + 1;
            }
            if (this.getVelocity().getDy() > 0) {
                //check the moving direction to know where will be it next point
                newY = newY - r - 1;
            } else {
                newY = newY + r + 1;
            }
            try {
                Paddle paddle = (Paddle) collisionInfo.collisionObject();
                newY = paddle.getCollisionRectangle().getUpperLeft().getY() - r - 1;
            } catch (Exception e) {
                newY = newY;
            }
            //create new center and initialize the new velocity after the collision.
            this.center = new Point(newX, newY);
            this.setVelocity(collisionObject.hit(this, collisionPoint, this.getVelocity()));
        }
    }
    /**
     *notify the ball that time has passed.
     */
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * adding the ball to the game.
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
    /**
     * removing the ball from the game.
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
