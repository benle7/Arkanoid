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
 * Class Operation : the class represent level three.
 */
public class LevelThree implements LevelInformation {

    static final int GUI_WIDTH = 800;
    static final double SHORT_LENGTH = 25;
    static final double WIDTH_REGULAR_BLOCK = 50;
    static final double DX = 3.5;
    static final double DY = -5.5;
    static final int NUM_BALLS = 2;
    static final int PADDLE_SPEED = 8;
    static final int PADDLE_WIDTH = 90;
    static final int X_START_BLOCKS = 275;
    static final int Y_START_BLOCKS = 140;
    static final int NUM_ROWS = 5;
    static final int NUM_BLOCKS = 40;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(DX, DY));
        list.add(new Velocity(-DX, DY));
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
        return "Level 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundThree();
    }

    /**
     * Function Name : generateColor.
     * Function Operation : the function return color.
     * @param i index.
     * @return Color the color.
     */
    private Color generateColor(int i) {
        Color[] colors = {Color.gray, Color.red, Color.yellow,
                Color.blue, Color.white};
        return colors[i];
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        int currentRow = 0;
        for (int i = Y_START_BLOCKS; currentRow < NUM_ROWS; i += SHORT_LENGTH) {
            for (int j = X_START_BLOCKS + (currentRow * (int) WIDTH_REGULAR_BLOCK);
                 j < GUI_WIDTH - SHORT_LENGTH; j += WIDTH_REGULAR_BLOCK) {
                Block block = new Block(new Point(j, i),
                        WIDTH_REGULAR_BLOCK, SHORT_LENGTH,
                        generateColor(currentRow));
                    list.add(block);
            }
            currentRow++;
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_BLOCKS;
    }
}
