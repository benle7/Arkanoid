// ID: 318811304
package interfaces;

/**
 * @author Ben Levi
 * Interface Operation : the interface represent notifier about hit event.
 */
public interface HitNotifier {

    /**
     * Function Name : addHitListener.
     * Function Operation : add new listener.
     * @param hl listener of the notifier.
     */
    void addHitListener(HitListener hl);

    /**
     * Function Name : removeHitListener.
     * Function Operation : remove exist listener.
     * @param hl listener of the notifier.
     */
    void removeHitListener(HitListener hl);
}
