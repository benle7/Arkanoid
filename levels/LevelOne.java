// ID: 318811304

package levels;

import geometry.Point;
import interfaces.LevelInformation;
import interfaces.Sprite;
import objects.Block;
import utils.Velocity;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Levi
 * Class Operation : the class represent level one.
 */
public class LevelOne implements LevelInformation {

    static final double LENGTH_BLOCK = 30;
    static final int NUM_BALLS = 1;
    static final int PADDLE_SPEED = 6;
    static final int PADDLE_WIDTH = 90;
    static final int X_START_BLOCKS = 385;
    static final int Y_START_BLOCKS = 150;
    static final int NUM_BLOCKS = 1;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        double angle = 0;
        double speed = 5.0;
        Velocity velocity = Velocity.fromAngleAndSpeed(angle, speed);
        List<Velocity> list = new ArrayList<>();
        list.add(velocity);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundOne();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block = new Block(new Point(X_START_BLOCKS, Y_START_BLOCKS),
                LENGTH_BLOCK, LENGTH_BLOCK, Color.red);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_BLOCKS;
    }
}
