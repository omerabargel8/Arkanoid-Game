import biuoop.DrawSurface;
import java.awt.Color;
/**
 *@author Omer Abargel, id-207041005.
 * The NumberOfLives class
 */
public class NumberOfLives implements Sprite {
    private Counter liveCounter;
    /**
     *constructor for NumberOfLives class.
     * @param liveCounter the lives counter
     */
    public NumberOfLives(Counter liveCounter) {
        this.liveCounter = liveCounter;
    }

    /**
     * draw the number of life that remained in the top of the screen, on the given DrawSurface.
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        String lives = "Lives: " + liveCounter.getValue();
        d.setColor(Color.BLACK);
        d.drawText(350, 15, lives, 18);
    }

    /**
     * notify this object that time has passed.
     */
    public void timePassed() {

    }
}
