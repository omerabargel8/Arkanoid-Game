import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * the EndScreen class.
 * @author Omer Abargel, id-207041005.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean win;
    private int score;
    /**
     * the constructor for EndScreen class.
     * @param k keyboard sensor.
     * @param win true if the player if the player won the game, false if he lost.
     * @param score the number of score in the end of the game.
     */
    public EndScreen(KeyboardSensor k, boolean win, int score) {
        this.keyboard = k;
        this.stop = false;
        this.win = win;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!win) {
            d.setColor(Color.black);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(new Color(250, 27, 17));
            for (int i = 0; i < 10; i++) {
                d.drawText(120 + i, 200, "G ", 80);
                d.drawText(182 + i, 200, "A ", 80);
                d.drawText(242 + i, 200, "M ", 80);
                d.drawText(310 + i, 200, "E ", 80);
                d.drawText(390 + i, 200, "O ", 80);
                d.drawText(450 + i, 200, "V", 80);
                d.drawText(510 + i, 200, "E", 80);
                d.drawText(570 + i, 200, "R", 80);
            }
            d.setColor(Color.red);
            d.fillCircle(400, 400, 120);
            d.setColor(Color.black);
            d.fillCircle(400, 400, 115);
            d.setColor(Color.red);
            d.drawText(320, 380, "X   X", 75);
            d.fillCircle(400, 440, 50);
            for (int i = 0; i < 2; i++) {
                d.drawText(250 + i, 250 + i, "Your score is: " + score, 40);
            }
        } else {
            d.setColor(new Color(209, 252, 252));
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(new Color(32, 181, 188));
            for (int i = 0; i < 20; i++) {
                d.drawText(180 + i, 200, "Y ", 80);
                d.drawText(240 + i, 200, "O ", 80);
                d.drawText(315 + i, 200, "U ", 80);
                d.drawText(410 + i, 200, "W ", 80);
                d.drawText(505 + i, 200, "I ", 80);
                d.drawText(540 + i, 200, "N", 80);
                d.drawText(620 + i, 200, "!", 80);
            }
            d.setColor(Color.black);
            for (int i = 0; i < 2; i++) {
                d.drawText(250 + i, 250 + i, "Your score is: " + score, 40);
            }
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