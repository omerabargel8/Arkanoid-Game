import biuoop.DrawSurface;
import java.awt.Color;

/**
 * BackGround1 class - draws the background of the first level.
 * @author Omer Abargel, id-207041005.
 */
public class BackGround1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(176, 252, 252));
        d.fillRectangle(10, 20, 780, 580);
        //legs
        d.setColor(new Color(12, 116, 35));
        d.fillOval(250, 300, 100, 250);
        d.fillOval(450, 300, 100, 250);
        //body
        d.setColor(new Color(10, 153, 39));
        d.fillOval(290, 280, 220, 300);
        //belly
        d.setColor(new Color(169, 175, 34));
        d.fillOval(315, 360, 170, 250);
        //feet
        d.setColor(new Color(12, 116, 35));
        d.fillCircle(275, 565, 55);
        d.fillCircle(522, 565, 55);
        d.setColor(Color.black);
        d.drawCircle(275, 565, 55);
        d.drawCircle(522, 565, 55);
        d.setColor(new Color(209, 252, 252));
        d.fillRectangle(220, 570, 400, 110);

        d.setColor(new Color(12, 116, 35));
        d.fillCircle(315, 565, 40);
        d.fillCircle(500, 565, 40);
        d.setColor(Color.black);
        d.drawCircle(315, 565, 40);
        d.drawCircle(500, 565, 40);
        d.setColor(new Color(209, 252, 252));
        d.fillRectangle(220, 570, 400, 110);

        d.setColor(Color.black);
        for (int i = 0; i < 4; i++) {
            d.drawText(120 + i, 550 + i, "Put the ball in the frog's mouth\n", 40);
        }

        //d.fillRectangle(467, 570, 110, 110);
        //head
        d.setColor(new Color(10, 153, 39));
        d.fillOval(200, 40, 390, 290);
        //eyes
        d.setColor(Color.white);
        d.fillOval(290, 25, 80, 130);
        d.fillOval(420, 25, 80, 130);
        d.setColor(Color.black);
        d.drawOval(290, 25, 80, 130);
        d.drawOval(420, 25, 80, 130);
        d.setColor(Color.black);
        d.fillOval(300, 53, 60, 100);
        d.fillOval(430, 53, 60, 100);
        d.setColor(Color.white);
        d.fillCircle(325, 70, 10);
        d.fillCircle(455, 70, 10);
        //mouth
        d.setColor(new Color(73, 20, 4));
        d.fillOval(235, 155, 320, 140);
        d.setColor(Color.red);
        d.fillOval(340, 135, 100, 200);
        d.setColor(new Color(10, 153, 39));
        d.fillRectangle(230, 155, 330, 70);
        d.setColor(new Color(10, 153, 39));
        d.fillRectangle(360, 130, 70, 70);
        d.fillOval(360, 170, 10, 20);
        d.fillOval(410, 170, 10, 20);
        //nose
        d.setColor(Color.black);
        d.fillOval(360, 170, 10, 20);
        d.fillOval(410, 170, 10, 20);
        //butterflies
        d.setColor(new Color(247, 161, 201));
        d.fillCircle(63, 65, 15);
        d.fillCircle(63, 90, 15);
        d.fillCircle(98, 65, 15);
        d.fillCircle(98, 90, 15);
        d.setColor(new Color(255, 116, 139));
        d.fillOval(68, 48, 25, 65);
        d.setColor(Color.black);
        d.drawLine(72, 40, 78, 48);
        d.drawLine(90, 40, 85, 49);
        d.setColor(new Color(247, 161, 201));
        d.fillCircle(63, 400, 15);
        d.fillCircle(63, 425, 15);
        d.fillCircle(98, 400, 15);
        d.fillCircle(98, 425, 15);
        d.setColor(new Color(255, 116, 139));
        d.fillOval(68, 383, 25, 65);
        d.setColor(Color.black);
        d.drawLine(72, 379, 78, 385);
        d.drawLine(90, 378, 85, 385);
        d.setColor(new Color(247, 161, 201));
        d.fillCircle(663, 400, 15);
        d.fillCircle(663, 425, 15);
        d.fillCircle(698, 400, 15);
        d.fillCircle(698, 425, 15);
        d.setColor(new Color(255, 116, 139));
        d.fillOval(668, 383, 25, 65);
        d.setColor(Color.black);
        d.drawLine(672, 379, 678, 385);
        d.drawLine(690, 378, 685, 385);
        d.setColor(new Color(247, 161, 201));
        d.fillCircle(663, 65, 15);
        d.fillCircle(663, 90, 15);
        d.fillCircle(698, 65, 15);
        d.fillCircle(698, 90, 15);
        d.setColor(new Color(255, 116, 139));
        d.fillOval(668, 48, 25, 65);
        d.setColor(Color.black);
        d.drawLine(672, 40, 678, 48);
        d.drawLine(690, 40, 685, 49);
    }
    @Override
    public void timePassed() {
    }
}
