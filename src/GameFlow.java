import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * the GameFlow class.
 * this class will be in charge of creating the different levels, and moving from one level to the next.
 *@author Omer Abargel, id-207041005.
 */
public class GameFlow {
    private biuoop.KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private Counter livesCounter = new Counter(7);
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter = new Counter(0);
    /**
     * the constructor for GameFlow class.
     * @param gui a gui
     * @param animationRunner animation runner
     * @param keyboard keyboard sensor
     */
    public GameFlow(GUI gui, AnimationRunner animationRunner, KeyboardSensor keyboard) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboard;
        this.gui = gui;
    }

    /**
     * in charge of running different levels and moving from one level to the next.
     * @param levels a list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean win = true;
        NumberOfLives lives = new NumberOfLives(livesCounter);
        for (LevelInformation levelInfo : levels) {
            blockCounter = new Counter(levelInfo.blocks().size());
            ballCounter = new Counter(levelInfo.numberOfBalls());
            GameLevel level = new GameLevel(levelInfo, keyboardSensor, animationRunner,
                    blockCounter, ballCounter, scoreCounter);
            level.initialize();
            level.addSprite(lives);
            while (livesCounter.getValue() != 0 && blockCounter.getValue() != 0) {
                //gui.getDrawSurface().setColor(Color.red);
                level.playOneTurn();
                ballCounter.increase(levelInfo.numberOfBalls());
                if (blockCounter.getValue() > 0) {
                    livesCounter.decrease(1);
                }
                if (livesCounter.getValue() == 0) {
                  win = false;
                  EndScreen end = new EndScreen(keyboardSensor, win, scoreCounter.getValue());
                  animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, end));
                  gui.close();
                  break;
                }
            }
        }
        EndScreen end = new EndScreen(keyboardSensor, win, scoreCounter.getValue());
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, end));
        gui.close();
    }
}