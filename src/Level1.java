import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the Level1 class.
 * @author Omer Abargel, id-207041005.
 */
public class Level1 implements LevelInformation {
    private  int numberOfBalls;
    private  List<Velocity> initialBallVelocities = new ArrayList<>();
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove;

    /**
     * the constructor for Level1 class.
     */
    public Level1() {
        numberOfBalls = 1;
        paddleSpeed = 10;
        paddleWidth = 100;
        levelName = "Level 1";
        numberOfBlocksToRemove = 1;
        //Point p =new Point(10, 20);
        background = new BackGround1();
        initialBallVelocities.add(new Velocity(0, -3));
        Point p = new Point(360, 222);
        Rectangle rec = new Rectangle(p, 60, 95);
        Block b = new Block(rec, 1);
        b.setColor(Color.pink);
        blocks.add(b);
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
