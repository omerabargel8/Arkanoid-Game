import biuoop.DrawSurface;
/**
 * @author Omer Abargel, id-207041005..
 * the Sprite interface.
 */
public interface Sprite {
    /**
     *draw the sprite on the screen.
     * @param d a surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}