/**
 *@author Omer Abargel, id-207041005.
 * The class BallRemover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * constructor for BallRemover class.
     * @param game the game
     * @param removedBalls the counter of removed balls
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the game.
     * @param beingHit the Block that hit
     * @param hitter the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
        }
    }
