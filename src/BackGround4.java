import biuoop.DrawSurface;
import java.awt.Color;
/**
 * BackGround4 class - draws the background of the fourth level.
 * @author Omer Abargel, id-207041005.
 */
public class BackGround4 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(209, 252, 252));
        d.fillRectangle(10, 20, 780, 580);
        //computer
        d.setColor(new Color(134, 132, 142));
        d.fillRectangle(200, 100, 400, 300);
        d.setColor(new Color(134, 132, 142));
        d.fillRectangle(140, 450, 510, 120);
        d.setColor(new Color(77, 75, 81));
        d.fillRectangle(580, 470, 50, 15);
        //keyboard
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 15; j++) {
                d.setColor(Color.black);
                d.drawRectangle(175 + 30 * j, 500 + 20 * i, 20, 10);
                d.setColor(new Color(77, 75, 81));
                d.fillRectangle(175 + 30 * j, 500 + 20 * i, 20, 10);
            }
        }
        d.setColor(new Color(15, 111, 188));
        d.fillCircle(580, 390, 4);
        d.setColor(Color.red);
        d.fillCircle(570, 390, 4);
        //screen
        d.setColor(Color.white);
        d.fillRectangle(220, 120, 360, 260);
        d.setColor(new Color(21, 157, 70));
        d.fillRectangle(280, 150, 270, 10);
        d.fillRectangle(550, 150, 10, 180);
        d.fillRectangle(550, 330, 30, 10);
        d.fillRectangle(280, 150, 10, 140);
        d.fillRectangle(280, 290, 120, 10);
        d.fillRectangle(400, 220, 10, 80);
        d.fillRectangle(400, 220, 60, 10);
        d.fillRectangle(460, 220, 10, 120);
        d.fillRectangle(410, 340, 60, 10);
        d.setColor(Color.red);
        d.fillCircle(390, 341, 5);
        d.setColor(Color.black);
        d.fillCircle(414, 343, 3);
        //mouse
        d.setColor(new Color(134, 132, 142));
        d.fillOval(700, 450, 50, 100);
        d.setColor(Color.black);
        d.drawLine(725, 480, 725, 365);
        d.drawLine(600, 365, 725, 365);
        d.drawLine(705, 480, 750, 480);
    }

    @Override
    public void timePassed() {
    }
}
