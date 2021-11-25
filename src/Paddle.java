import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

/**
 *@author Omer Abargel, id-207041005.
 * The class Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    private List<HitListener> hitListeners;
    private int paddleSpeed;

    /**
     * constructor of the paddle class.
     * @param rectangle a rectangle
     * @param keyboard keyboard sensor
     * @param paddleSpeed the paddlespeed.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, int paddleSpeed) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.paddleSpeed = paddleSpeed;
    }
    /**
     * used to move the paddle left.
     */
    public void moveLeft() {
        double newX = rectangle.getUpperLeft().getX() - paddleSpeed;
        //if the paddle reached to the left border
        if (newX < 15) {
            newX = 15;
        }
        Point newUpperLeft = new Point(newX, rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * used to move the paddle right.
     */
    public void moveRight() {
         double newX = rectangle.getUpperLeft().getX() + paddleSpeed;
         //if the paddle reaches to the right border
         if (newX > 800 - rectangle.getWidth() - 15) {
             newX = 800 - rectangle.getWidth() - 15;
        }
        Point newUpperLeft = new Point(newX, rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(newUpperLeft, rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * notify the paddle that time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle on the given DrawSurface.
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        int xUpperLeft = (int) rectangle.getUpperLeft().getX();
        int yUpperLeft = (int) rectangle.getUpperLeft().getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        d.setColor(Color.ORANGE);
        d.fillRectangle(xUpperLeft, yUpperLeft, width, height);
    }

    /**
     * return the Collidable of thr collision.
     * @return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * Notify the paddle that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the location on the paddle
     * @param collisionPoint the collision point
     * @param currentVelocity the velocity before the collision occurs
     * @param hitter mklm;l
     * @return the velocity after the collision
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
         double paddleScope = rectangle.getHorizontalTopLine().length();
         //divide the paddle to 5
         double oneRegion = paddleScope / 5;
         double xValue = collisionPoint.getX();
         double collisionPart = 0;
         double paddleLocation = rectangle.getHorizontalTopLine().start().getX();
         double speed = currentVelocity.getSpeed();
         //checks in which part of the paddle the collision occurred
         for (int i = 0; i < 5; i++) {
         if ((xValue >= paddleLocation + (i * oneRegion)) && (xValue <= paddleLocation + (oneRegion + i * oneRegion))) {
                 collisionPart = i + 1;
             }
         }
         if (collisionPart == 1) {
             Velocity v = Velocity.fromAngleAndSpeed(300, speed);
             return v;
         }
         if (collisionPart == 2) {
             Velocity v = Velocity.fromAngleAndSpeed(330, speed);
             return v;
         }
         if (collisionPart == 3) {
             Velocity v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
             return v;
         }
         if (collisionPart == 4) {
             Velocity v = Velocity.fromAngleAndSpeed(30, speed);
             return v;
         } else {
             Velocity v = Velocity.fromAngleAndSpeed(60, speed);
             return v;
         }
    }
    /**
     * Add this paddle to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}