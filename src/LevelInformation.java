import java.util.List;
/**
 * the LevelInformation interface.
 * @author Omer Abargel, id-207041005.
 */
public interface LevelInformation {
    /**
     * returns the number of balls in this level.
     * @return number of balls.
     */
    int numberOfBalls();
    /**
     * return a list of The initial velocity of each ball.
     * @return list of balls velocities.
     */
    List<Velocity> initialBallVelocities();
    /**
     * return the paddle speed.
     * @return paddle speed.
     */
    int paddleSpeed();
    /**
     * return the paddle width.
     * @return paddle width.
     */
    int paddleWidth();
    /**
     * return the level name will be displayed at the top of the screen.
     * @return the level name.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * list of blocks that make up this level, each block contains.
     * its size, color and location.
     * @return list of blocks.
     */
    List<Block> blocks();

    /**
     * return the number of levels that should be removed.
     * before the level is considered to be "cleared".
     * @return number of blocks.
     */
    int numberOfBlocksToRemove();
}