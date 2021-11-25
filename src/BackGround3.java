import biuoop.DrawSurface;
import java.awt.Color;
/**
 * BackGround3 class - draws the background of the third level.
 * @author Omer Abargel, id-207041005.
 */
public class BackGround3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(209, 252, 252));
        d.fillRectangle(10, 20, 780, 580);
        //grass
        d.setColor(new Color(28, 144, 56));
        d.fillRectangle(10, 530, 780, 70);
        //road
        d.setColor(Color.darkGray);
        d.fillRectangle(10, 430, 780, 100);
        d.setColor(Color.white);
        for (int j = 0; j < 9; j++) {
            d.fillRectangle(20 + 90 * j, 470, 50, 10);
        }
        //grass
        d.setColor(new Color(28, 144, 56));
        d.fillRectangle(10, 360, 780, 70);
        //flowers
        for (int j = 0; j < 8; j++) {
            d.setColor(new Color(243, 252, 100));
            d.fillCircle(50 + 100 * j, 385, 4);
            d.setColor(new Color(252, 121, 165));
            d.fillCircle(50 + 100 * j, 375, 4);
            d.fillCircle(50 + 100 * j, 395, 4);
            d.fillCircle(40 + 100 * j, 380, 4);
            d.fillCircle(40 + 100 * j, 390, 4);
            d.fillCircle(60 + 100 * j, 380, 4);
            d.fillCircle(60 + 100 * j, 390, 4);
        }
        //house
        d.setColor(new Color(235, 165, 68));
        d.fillRectangle(60, 250, 250, 180);
        d.setColor(new Color(96, 67, 28));
        d.fillRectangle(100, 270, 70, 70);
        d.fillRectangle(200, 270, 70, 70);
        d.setColor(new Color(253, 255, 167));
        d.fillRectangle(105, 275, 60, 60);
        d.fillRectangle(205, 275, 60, 60);
        d.setColor(new Color(195, 114, 34));
        for (int i = 0; i < 12; i++) {
            d.drawLine(105, 275 + i * 5, 165, 275 + i * 5);
            d.drawLine(205, 275 + i * 5, 265, 275 + i * 5);
        }
        d.setColor(new Color(96, 67, 28));
        d.fillRectangle(145, 350, 80, 80);
        for (int j = 0; j < 30; j++) {
            d.drawLine(190, 102 + 5 * j, 62 + 4 * j, 250);
            d.drawLine(190, 102 + 5 * j, 62 + 4 * j, 250);
            d.drawLine(190, 103 + 5 * j, 63 + 4 * j, 250);
            d.drawLine(190, 102 + 5 * j, 308 - 4 * j, 250);
            d.drawLine(190, 102 + 5 * j, 308 - 4 * j, 250);
            d.drawLine(190, 103 + 5 * j, 307 - 4 * j, 250);
        }
        d.setColor(new Color(82, 57, 24));
        d.fillRectangle(700, 260, 30, 170);
        d.fillRectangle(580, 220, 40, 210);
        d.setColor(new Color(21, 157, 70));
        d.fillCircle(720, 220, 50);
        d.fillCircle(600, 240, 60);
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
    }

    @Override
    public void timePassed() {
    }
}
