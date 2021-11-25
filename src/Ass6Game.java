import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Omer Abargel, id-207041005.
 * the Ass6Game class.
 * used to start a game with 4 levels.
 */
public class Ass6Game {
    /**
     * the main method of this class.
     * @param args the arguments of the program.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        List<LevelInformation> levels = new ArrayList<>();
        List<LevelInformation> argsLevels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        if (args.length != 0) {
            int[] levelNumbers = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                try {
                    levelNumbers[i] = Integer.parseInt(args[i]);
                } catch (Exception e) {
                    ;
                }
            }
            for (int j = 0; j < levelNumbers.length; j++) {
                switch (levelNumbers[j]) {
                    case 1:
                        argsLevels.add(new Level1());
                        break;
                    case 2:
                        argsLevels.add(new Level2());
                        break;
                    case 3:
                        argsLevels.add(new Level3());
                        break;
                    case 4:
                        argsLevels.add(new Level4());
                        break;
                    default:
                }
            }
            if (!argsLevels.isEmpty()) {
                levels = argsLevels;
            }
        }
        AnimationRunner animationRunner = new AnimationRunner(gui);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(gui, animationRunner, keyboard);
        gameFlow.runLevels(levels);
    }
}