import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the Level2 class.
 * @author Omer Abargel, id-207041005.
 */
public class Level2 implements LevelInformation {
    private  int numberOfBalls;
    private  List<Velocity> initialBallVelocities = new ArrayList<>();
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove;

    /**
     * constructor for Level2 class.
     */
    public Level2() {
        numberOfBalls = 3;
        paddleSpeed = 10;
        paddleWidth = 400;
        levelName = "Level 2";
        numberOfBlocksToRemove = 21;
        background = new BackGround2();
        initialBallVelocities.add(new Velocity(3, -3));
        initialBallVelocities.add(new Velocity(-3, -3));
        initialBallVelocities.add(new Velocity(0, -3));

        List<Color> colorList = new ArrayList<>();
        colorList.add(new Color(176, 252, 252));
        colorList.add(new Color(88, 202, 231));
        colorList.add(new Color(78, 152, 213));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                Point p = new Point(15 + j * 110, 320 + i * 30);
                Rectangle rec = new Rectangle(p, 110, 30);
                Block b = new Block(rec, 1);
                b.setColor(colorList.get(i));
                blocks.add(b);
            }
        }
    }
    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelName;
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}
