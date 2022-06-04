// ID: 318811304

package interfaces;

import biuoop.DrawSurface;

/**
 * @author Ben Levi
 * Interface Operation : the interface represent Animation.
 */
public interface Animation {

    /**
     * Function Name : doOneFrame.
     * Function Operation : the function do frame \ change of the animation.
     * @param d the DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Function Name : shouldStop.
     * Function Operation : the function return boolean if should stop or not.
     * @return boolean true or false.
     */
    boolean shouldStop();
}
