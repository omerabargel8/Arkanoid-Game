import biuoop.DrawSurface;
import java.awt.Color;

/**
 * BackGround2 class - draws the background of the second level.
 * @author Omer Abargel, id-207041005.
 */
public class BackGround2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(209, 252, 252));
        d.fillRectangle(10, 20, 780, 580);
        //sea
        d.setColor(new Color(50, 101, 153));
        d.fillRectangle(10, 410, 780, 200);
        d.setColor(new Color(78, 152, 213));
        d.fillRectangle(10, 380, 780, 30);
        d.setColor(new Color(88, 202, 231));
        d.fillRectangle(10, 350, 780, 30);
        d.setColor(new Color(176, 252, 252));
        d.fillRectangle(10, 320, 780, 30);
        //boat
        d.setColor(new Color(252, 107, 83));
        d.fillCircle(550, 280, 40);
        d.setColor(new Color(209, 252, 252));
        d.fillCircle(550, 240, 60);
        //sun
        d.setColor(new Color(209, 210, 88));
        for (int i = 0; i < 150; i++) {
            //d.drawLine(59, 70, 10 + 5*i, 320);
            d.drawLine(60, 70, 10 + 8 * i, 320);
        }
        d.setColor(Color.black);
        d.fillCircle(550, 280, 5);
        d.drawLine(550, 280, 550, 320);
        d.drawLine(550, 288, 558, 293);
        d.drawLine(550, 288, 542, 293);
        d.setColor(new Color(252, 250, 124));
        d.fillCircle(70, 100, 100);
        d.setColor(new Color(247, 252, 132));
        d.fillCircle(70, 100, 100);
        d.setColor(new Color(226, 228, 94));
        d.fillCircle(70, 100, 80);
        d.setColor(new Color(252, 250, 124));
        d.fillCircle(70, 100, 60);
        //birds
        d.setColor(new Color(41, 1, 7));
        d.fillCircle(600, 70, 20);
        d.fillCircle(620, 70, 20);
        d.setColor(new Color(209, 252, 252));
        d.fillCircle(599, 80, 22);
        d.fillCircle(621, 80, 22);
        d.setColor(new Color(41, 1, 7));
        d.fillCircle(630, 100, 20);
        d.fillCircle(650, 100, 20);
        d.setColor(new Color(209, 252, 252));
        d.fillCircle(629, 110, 22);
        d.fillCircle(651, 110, 22);
        //flowers
        for (int j = 0; j < 8; j++) {
            d.setColor(new Color(252, 152, 119));
            d.fillCircle(50 + 100 * j, 575, 4);
            d.setColor(new Color(243, 252, 100));
            d.fillCircle(50 + 100 * j, 565, 4);
            d.fillCircle(50 + 100 * j, 585, 4);
            d.fillCircle(40 + 100 * j, 570, 4);
            d.fillCircle(40 + 100 * j, 580, 4);
            d.fillCircle(60 + 100 * j, 570, 4);
            d.fillCircle(60 + 100 * j, 580, 4);
        }
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 7; q++) {
                    d.setColor(new Color(251, 252, 250));
                    d.fillCircle(63 + q * 110, 335 + p * 30, 3);
                }
            }
    }

    @Override
    public void timePassed() {
    }
}
