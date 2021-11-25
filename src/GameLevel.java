import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 *@author Omer Abargel, id-207041005.
 * The class GameLevel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private LevelInformation levelInfo;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;

    /**
     * constructor of the Game class.
     * @param levelInfo a level info.
     * @param k - keyboard sensor.
     * @param r - animation runner.
     * @param blocks block counter.
     * @param balls ball counter.
     * @param scores score counter.
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor k, AnimationRunner r, Counter blocks, Counter balls,
                     Counter scores) {
     sprites = new SpriteCollection();
     environment = new GameEnvironment();
     this.levelInfo = levelInfo;
     this.keyboard = k;
     this.runner = r;
     this.blockCounter = blocks;
     this.ballCounter = balls;
     this.scoreCounter = scores;
    }
    /**
     *  adding a new collidable to the game.
     * @param c colidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * adding a new sprite to the game.
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }
    /**
     * remove collidable from the game.
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * remove a sprite from the game.
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     *Initialize a new GameLevel: create the Blocks.
     *and add them to the game.
     */
    public void initialize() {
        this.addSprite(levelInfo.getBackground());
        //initialize the listeners
        BlockRemover blockListener = new BlockRemover(this, blockCounter);
        BallRemover ballListener = new BallRemover(this, ballCounter);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(scoreCounter);
        //initialize the score indicator - we want to display the score at the top of the screen
        Point pScore = new Point(0, 0);
        Rectangle recScore = new Rectangle(pScore, 800, 20);
        ScoreIndicator scores = new ScoreIndicator(recScore, scoreCounter);
        this.addSprite(scores);
        //initialize the blocks
        //upper block
        int borderWidth = 15;
        Point p1 = new Point(10, 20);
        Rectangle rec1 = new Rectangle(p1, 800, borderWidth);
        Block upperBlock = new Block(rec1, 1);
        upperBlock.setColor(Color.darkGray);
        upperBlock.addToGame(this);
        //lower block
        Point p2 = new Point(10, 599);
        Rectangle rec2 = new Rectangle(p2, 800, 1);
        Block lowerBlock = new Block(rec2, 1);
        lowerBlock.setColor(Color.white);
        lowerBlock.addToGame(this);
        //adding to the lower block a listener because he is a "death region"
        lowerBlock.addHitListener(ballListener);
        //left block
        Point p3 = new Point(0, 20);
        Rectangle rec3 = new Rectangle(p3, borderWidth, 600);
        Block leftBlock = new Block(rec3, 1);
        leftBlock.setColor(Color.darkGray);
        leftBlock.addToGame(this);
        //right block
        Point p4 = new Point(785, 20);
        Rectangle rec4 = new Rectangle(p4, borderWidth, 600);
        Block rightBlock = new Block(rec4, 1);
        rightBlock.setColor(Color.darkGray);
        rightBlock.addToGame(this);
        for (int i = 0; i < levelInfo.numberOfBlocksToRemove(); i++) {
            Block rowBlock = levelInfo.blocks().get(i);
            rowBlock.addToGame(this);
            rowBlock.addHitListener(blockListener);
            rowBlock.addHitListener(scoreListener);
        }
    }
    /**
     * Run one turn of this game.
     */
    public void playOneTurn() {
        //initialize the balls and the paddle
        Paddle paddle = initializeBallsPaddle();
        this.runner.run(new CountdownAnimation(2.0D, 3, this.sprites, levelInfo.levelName()));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
        //after that one turn ended we need to remove the paddle.
        // because he needs to be in a different location in the next turn.
        this.removeSprite(paddle);
        this.removeCollidable(paddle);
    }

    /**
     * initialize the balls and the paddle.
     * @return the paddle
     */
   private Paddle initializeBallsPaddle() {
       for (int i = 0; i < levelInfo.numberOfBalls(); i++) {
           Ball ball = new Ball(400 + 20 * i, 450, 7, java.awt.Color.BLACK);
           ball.setVelocity(levelInfo.initialBallVelocities().get(i));
           ball.setGameEnvironment(environment);
           ball.addToGame(this);
       }
       // Create a paddle
       Point paddleStart = new Point((800 - levelInfo.paddleWidth()) / 2, 580);
       Rectangle rectangle = new Rectangle(paddleStart, levelInfo.paddleWidth(), 15);
       Paddle p = new Paddle(rectangle, keyboard, levelInfo.paddleSpeed());
       p.addToGame(this);
       return p;
   }

    @Override
    public void doOneFrame(DrawSurface d) {
       if (this.keyboard.isPressed("p")) {
           PauseScreen pauseScreen = new PauseScreen(this.keyboard);
            runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, pauseScreen));
        }
        //play the game until all the blocks removed or all balls removed
        if (blockCounter.getValue() != 0  && ballCounter.getValue() != 0) {
            this.sprites.drawAllOn(d);
            d.setColor(Color.black);
            d.drawText(450, 15, "level Name: " + levelInfo.levelName(), 18);
            this.sprites.notifyAllTimePassed();
            //if all the blocks removed we need to increase 100 points
            if (blockCounter.getValue() == 0) {
                scoreCounter.increase(100);
            }
        } else {
            this.running = false;
        }
    }
    @Override
    public boolean shouldStop() {
       return !this.running;
    }
}