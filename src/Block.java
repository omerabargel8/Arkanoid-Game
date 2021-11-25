import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Omer Abargel, id-207041005..
 * the Block class.
 * used to Create a game object, initializes and runs it
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private int hitCounter;
    private List<HitListener> hitListeners = new ArrayList<>();
    /**
     *constructor for Block class.
     * @param rectangle a rectangle.
     * @param maxHits max hits of the rectangle.
     */
    public Block(Rectangle rectangle, int maxHits) {
        this.rectangle = rectangle;
        this.hitCounter = maxHits;
    }
    /**
     * Return the "collision shape" of the object.
     * @return  this rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint the point of the collision can be null
     * @param currentVelocity the velocity before the collision
     * @param hitter nlbvnbgl
     * @return the velocity after the collision
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double newDx = currentVelocity.getDx();
        double newDy = currentVelocity.getDy();
        //Collision with upper horizontal line
        if (rectangle.getHorizontalTopLine().inRange(collisionPoint)) {
            newDy = newDy * -1;
        }
        if (rectangle.getHorizontalUnderline().inRange(collisionPoint)) {
            //Collision with lower horizontal line
            newDy = newDy * -1;
        }
        if (rectangle.getLeftVerticalLine().inRange(collisionPoint)) {
            //Collision with left vertical line
            newDx = newDx * -1;
        }
        if (rectangle.getRightVerticalLine().inRange(collisionPoint)) {
            //Collision with right vertical line
            newDx = newDx * -1;
        }
        if (hitCounter > 0) {
            hitCounter--;
        }
        Velocity newVelocity = new Velocity(newDx, newDy);
        this.notifyHit(hitter);
        return newVelocity;
    }
    /**
     * set the color of the block.
     * @param colorC the color
     */
    public void setColor(java.awt.Color colorC) {
        this.color = colorC;
    }

    /**
     * draw the block on the given DrawSurface.
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        d.fillRectangle(x, y, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle(x, y, (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * notify the block that time has passed, (in this assignment nothing).
     */
    public void timePassed() {
    }

    /**
     * adding the block to the game.
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * this method will be called whenever a hit() occurs.
     * and notifiers all of the registered HitListener objects by calling their hitEvent method.
     * @param hitter the Ball that's doing the hitting
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
     /**
     * Add hl as a listener to hit events.
     * @param hl listener object
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl listener object
     */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * returns the number of hits between (0 - max hits).
     * @return the number of hits between (0 - max hits).
     */
    public double getHitPoints() {
        return this.hitCounter;
    }

    /**
     * this method removes this block from the game.
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}
