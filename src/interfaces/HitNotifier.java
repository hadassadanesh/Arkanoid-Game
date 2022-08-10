/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package interfaces;

/**
 * an interface that represent that the object that implement it is a listener.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * <p>
     *
     * @param hl the listener that the method adds.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * <p>
     *
     * @param hl the listener that the method removes.
     */
    void removeHitListener(HitListener hl);
}