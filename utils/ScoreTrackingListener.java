// ID: 318811304

package utils;

import interfaces.HitListener;
import objects.Block;
import objects.Ball;

/**
 * @author Ben Levi
 * Class Operation : the class represent counter that listen
 * to hit events (from blocks), and increase the score.
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * Function Name : ScoreTrackingListener.
     * Function Operation : constructor.
     * @param scoreCounter the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}
