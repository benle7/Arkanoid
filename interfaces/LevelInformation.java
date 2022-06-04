// ID: 318811304

package interfaces;

import utils.Velocity;
import objects.Block;
import java.util.List;

/**
 * @author Ben Levi
 * Interface Operation : the interface represent information about level.
 */
public interface LevelInformation {

    /**
     * Function Name : numberOfBalls.
     * Function Operation : the function return number of balls in the level.
     * @return int the number.
     */
    int numberOfBalls();

    /**
     * Function Name : initialBallVelocities.
     * Function Operation : the function return list of velocities.
     * @return List<Velocity> the list.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Function Name : paddleSpeed.
     * Function Operation : the function return the speed of the paddle.
     * @return int the speed.
     */
    int paddleSpeed();

    /**
     * Function Name : paddleWidth.
     * Function Operation : the function return the width of the paddle.
     * @return int the width.
     */
    int paddleWidth();

    /**
     * Function Name : levelName.
     * Function Operation : the function return the name of the level.
     * @return String the name.
     */
    String levelName();

    /**
     * Function Name : getBackground.
     * Function Operation : the function return the background of the level.
     * @return Sprite the background.
     */
    Sprite getBackground();

    /**
     * Function Name : blocks.
     * Function Operation : the function return list of blocks.
     * @return List<Block> the list.
     */
    List<Block> blocks();

    /**
     * Function Name : numberOfBlocksToRemove.
     * Function Operation : the function return the number of the blocks.
     * @return int the number.
     */
    int numberOfBlocksToRemove();
}
