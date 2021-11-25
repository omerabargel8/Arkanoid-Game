import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Omer Abargel, id-207041005.
 * * the Sprite collection class.
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection = new ArrayList<>();
    /**
     * adding a new sprite to the collection.
     * @param s a sprite
     */
    public void addSprite(Sprite s) {
        spriteCollection.add(s);
    }

    /**
     * jnl.
     * @param s nkl.
     */
    public void removeSprite(Sprite s) {

        spriteCollection.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        //for (Sprite s : spriteCollection) {
            //s.timePassed();
        //}
        spriteCollection.get(0).timePassed();
        for (int i = 1; i < spriteCollection.size(); i++) {
            spriteCollection.get(i).timePassed();
        }
    }
    /**
     * call drawOn(d) on all sprites.
     * @param d surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteCollection) {
            s.drawOn(d);
        }
    }
    /**
     * returns a list of sprites.
     * @return a lost od sprite
     */
    public List<Sprite> spirtesList() {
        return spriteCollection;
    }
}