import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * the PauseScreen class.
 *@author Omer Abargel, id-207041005.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor for the PauseScreen class.
     * @param k keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(73, 102, 153));
        for (int i = 0; i < 20; i++) {
            d.drawText(200 + i, 200, "P ", 80);
            d.drawText(260 + i, 200, "A ", 80);
            d.drawText(320 + i, 200, "U ", 80);
            d.drawText(380 + i, 200, "S ", 80);
            d.drawText(440 + i, 200, "E ", 80);
            d.drawText(500 + i, 200, "D", 80);

        }
        d.fillRectangle(320, 250, 50, 120);
        d.fillRectangle(400, 250, 50, 120);

        d.setColor(new Color(210, 250, 250));
        d.fillRectangle(325, 256, 40, 110);
        d.fillRectangle(405, 256, 40, 110);
        d.setColor(new Color(73, 102, 153));
        for (int i = 0; i < 3; i++) {
            d.drawText(170 + i, 550 + i, "press space to continue", 40);
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}