import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the level1 class.
 * @author Omer Abargel, id-207041005.
 */
public class Level3 implements LevelInformation {
    private  int numberOfBalls;
    private  List<Velocity> initialBallVelocities = new ArrayList<>();
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove;

    /**
     * constructor for Level3 class.
     */
    public Level3() {
        numberOfBalls = 1;
        paddleSpeed = 10;
        paddleWidth = 100;
        levelName = "Level 3";
        numberOfBlocksToRemove = 18;
        background = new BackGround3();
        initialBallVelocities.add(new Velocity(3, 3));
        List<Color> colorList = new ArrayList<>();
        colorList.add(new Color(72, 209, 204));
        colorList.add(new Color(149, 230, 225));
        colorList.add(new Color(181, 250, 248));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7 - i; j++) {
                Point p = new Point(15 + j * 90, 100 + 30 * i);
                Rectangle rec = new Rectangle(p, 90, 30);
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
