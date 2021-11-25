import biuoop.DrawSurface;
import java.awt.Color;
/**
 *@author Omer Abargel, id-207041005.
 * The ScoreIndicator class.
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rectangle;
    private java.awt.Color color = new Color(219, 112, 147);
    private Counter scoreCounter;
    /**
     *constructor for ScoreIndicator class.
     * @param rectangle a rectangle.
     * @param scoreCounter score counter
     */
    public ScoreIndicator(Rectangle  rectangle, Counter scoreCounter) {
        this.rectangle = rectangle;
        this.scoreCounter = scoreCounter;
    }

    /**
     * draw the number of scores on the top of the screen, on the given DrawSurface.
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        d.fillRectangle(x, y, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle(x, y, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        String score = "score: " + scoreCounter.getValue();
        d.drawText(250, 15, score, 18);
    }
    /**
     * notify this object tht tome has passed.
     */
    public void timePassed() {
    }
}
