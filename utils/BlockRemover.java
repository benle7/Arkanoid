// ID: 318811304
package utils;

import interfaces.HitListener;
import objects.Block;
import objects.Ball;
import objects.GameLevel;

/**
 * @author Ben Levi
 * Class Operation : the class represent listener that remove blocks.
 */
public class BlockRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * Function Name : BlockRemover.
     * Function Operation : constructor.
     * @param game the game.
     * @param remainingBlocks the Counter.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease();
    }
}
