// ID: 318811304

package utils;

import interfaces.HitListener;
import objects.Block;
import objects.Ball;
import objects.GameLevel;

/**
 * @author Ben Levi
 * Class Operation : the class represent listener that remove balls.
 */
public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBalls;

    /**
     * Function Name : BallRemover.
     * Function Operation : constructor.
     * @param game the game.
     * @param remainingBalls the Counter.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease();
    }
}
