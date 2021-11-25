/**
 *@author Omer Abargel, id-207041005.
 * The colidable interface.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     * @return b
     */
    Rectangle getCollisionRectangle();
    /**
     *Notify the object that we collided with it at collisionPoint with
     *a given velocity.
     *The return is the new velocity expected after the hit (based on
     *the force the object inflicted on us).
     * @param collisionPoint bb
     * @param currentVelocity bb
     * @param hitter ,bl;gf
     * @return bb
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
