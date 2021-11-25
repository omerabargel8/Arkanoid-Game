/**
 *@author Omer Abargel, id-207041005.
 * The class BlockRemover.
 * in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * constructor for BlockRemover class.
     * @param game the game
     * @param removedBlocks the counter of removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the game.
     * @param beingHit the Block that hit
     * @param hitter the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            beingHit.removeFromGame(game);
            beingHit.removeHitListener(this);
            remainingBlocks.decrease(1);

        }
    }
}