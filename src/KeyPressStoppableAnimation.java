import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the KeyPressStoppableAnimation class.
 *@author Omer Abargel, id-207041005.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop = false;
    private boolean isAlreadyPressed = true;

    /**
     * constructor for KeyPressStoppableAnimation class.
     * @param sensor keyboard sensor
     * @param key a keyboard key
     * @param animation animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed(key) && !isAlreadyPressed) {
            stop = true;
        }
        isAlreadyPressed = false;
        animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}