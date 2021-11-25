import java.util.ArrayList;
import java.util.List;
/**
 *@author Omer Abargel, id-207041005.
 * The class Game Environment.
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<>();
    /**
     * add the given collidable to the environment.
     * @param c colidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    /**
     * remove the givven collidable from the environment.
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }
    /**
     *Assume an object moving from line.start() to line.end().
     *If this object will not collide with any of the collidables
     *in this collection, return null. Else, return the information
     *about the closest collision that is going to occur.
     * @param trajectory line
     * @return the collision info
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point collisionPoint;
        Point closestCollisionPoint = null;
        Collidable closestColidable = null;
        double distance =  Double.MAX_VALUE;
        for (Collidable c : collidables) {
            collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collisionPoint != null && collisionPoint.distance(trajectory.start()) < distance) {
                distance = collisionPoint.distance(trajectory.start());
                closestCollisionPoint = collisionPoint;
                closestColidable = c;
            }
        }
        if (closestCollisionPoint != null) {
            CollisionInfo info = new CollisionInfo(closestCollisionPoint, closestColidable);
            return info;
        }
        return null;
    }

}
