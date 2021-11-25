import biuoop.DrawSurface;
import java.awt.Color;
/**
 * the CountdownAnimation class.
 * display the given gameScreen ,for numOfSecond second, and on top of them it will show.
 * a countdown from countFrom back to 1, where each number will.
 * @author Omer Abargel, id-207041005.
 */
public class CountdownAnimation implements Animation {
    private double numOfSecond;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private long startTime;
    private String levelName;
    /**
     * the constructor for the CountdownAnimation class.
     * @param numOfSecond number of second to display the count down animation.
     * @param countFrom the number to count from.
     * @param gameScreen the game screen to displat the count from animation on it.
     * @param levelName the level name.
     */
    public CountdownAnimation(double numOfSecond, int countFrom, SpriteCollection gameScreen, String levelName) {
        this.numOfSecond = numOfSecond;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        startTime = System.currentTimeMillis(); // timing
        this.levelName = levelName;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(220, 220, 220));
        d.fillRectangle(10, 20, 780, 590);
        this.gameScreen.drawAllOn(d);
        long currentTime = System.currentTimeMillis();
        double timePerEach = this.numOfSecond / (double) this.countFrom;
        double temp = (double) (currentTime - this.startTime) / (timePerEach * 1000.0D);
        int currentNumber = (int) ((double) (1 + this.countFrom) - temp);
        if (currentNumber > 0) {
            d.setColor(new Color(181, 250, 248));
            for (int i = 0; i < 3; i++) {
                d.drawText(380 + i, 100 + i, "" + currentNumber, 60);
            }
            d.setColor(Color.black);
            d.drawText(383, 103, "" + currentNumber, 60);
        }
        if ((double) (currentTime - this.startTime) > this.numOfSecond * 1000.0D) {
            this.stop = true;
        }
        d.setColor(Color.black);
        d.drawText(450, 15, "level Name: " + levelName, 18);
        }
    @Override
    public boolean shouldStop() {
        return stop;
    }
}