import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the level1 class.
 * @author Omer Abargel, id-207041005.
 */
public class Level4 implements LevelInformation {
    private  int numberOfBalls;
    private  List<Velocity> initialBallVelocities = new ArrayList<>();
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove;

    /**
     * constructor for Level4 class.
     */
    public Level4() {
        numberOfBalls = 2;
        paddleSpeed = 10;
        paddleWidth = 100;
        levelName = "Level 4";
        numberOfBlocksToRemove = 25;
        background = new BackGround4();
        initialBallVelocities.add(new Velocity(3, 3));
        initialBallVelocities.add(new Velocity(3, 3));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                Point p = new Point(35 + j * 80, 50 + i * 40);
                Rectangle rec = new Rectangle(p, 70, 30);
                Block b = new Block(rec, 1);
                b.setColor(Color.pink);
                blocks.add(b);
                Point p2 = new Point(620 + j * 80, 50 + i * 40);
                Rectangle rec2 = new Rectangle(p2, 70, 30);
                Block b2 = new Block(rec2, 1);
                b2.setColor(Color.pink);
                blocks.add(b2);
            }
        }
        for (int p = 0; p < 5; p++) {
            Point p3 = new Point(205 + p * 80, 50);
            Rectangle rec = new Rectangle(p3, 70, 30);
            Block b = new Block(rec, 1);
            b.setColor(Color.pink);
            blocks.add(b);
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
