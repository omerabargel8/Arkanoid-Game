import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * the AnimationRunner class.
 * @author Omer Abargel, id-207041005.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper = new biuoop.Sleeper();
    /**
     * constructor for AnimationRunner class.
     * @param gui a gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        framesPerSecond = 60;
    }

    /**
     * takes an Animation object and runs it.
     * @param animation an animation object.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        //runs the animation until shouldstop returns true
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}