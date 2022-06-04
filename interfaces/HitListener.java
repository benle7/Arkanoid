// ID: 318811304
package interfaces;

import objects.Ball;
import objects.Block;

/**
 * @author Ben Levi
 * Interface Operation : the interface represent listener to hit event.
 */
public interface HitListener {

    /**
     * Function Name : hitEvent.
     * Function Operation : the listener acts after he listen about hit event.
     * @param beingHit the block that being hitting.
     * @param hitter the ball hitter.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
