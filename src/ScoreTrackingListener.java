/**
 *@author Omer Abargel, id-207041005.
 * The ScoreTrackingListener class.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor for ScoreTrackingListener class.
     * @param scoreCounter score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * And adds points to the score counter according to the hit
     * @param beingHit the Block that hit
     * @param hitter the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
        if (beingHit.getHitPoints() == 0) {
            currentScore.increase(5);
        }
    }
}