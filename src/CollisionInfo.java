/**
 *@author Omer Abargel, id-207041005.
 * The class Collision info.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable c;

    /**
     * contractor of the collision info class.
     * @param collisionPoint the collision point
     * @param c the colidable
     */
    public CollisionInfo(Point collisionPoint, Collidable c) {
        this.collisionPoint = collisionPoint;
        this.c = c;
    }
    /**
     * the point at which the collision occurs.
     * @return collision point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }
    /**
     * the collidable object involved in the collision.
     * @return the collidable.
     */
    public Collidable collisionObject() {
        return c;
    }
}