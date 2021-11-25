/**
 *@author Omer Abargel, id-207041005.
 * The HitNotifier interface.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl the lisrener
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the listener
     */
    void removeHitListener(HitListener hl);
}
