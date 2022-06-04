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
 * Class Operation : the class represent level two.
 */
public class LevelTwo implements LevelInformation {

    static final int GUI_WIDTH = 800;
    static final double SHORT_LENGTH = 25;
    static final double WIDTH_REGULAR_BLOCK = 50;
    static final double DX = 2;
    static final double DY = -5;
    static final int NUM_BALLS = 10;
    static final int PADDLE_SPEED = 4;
    static final int PADDLE_WIDTH = 600;
    static final int Y_START_BLOCKS = 200;
    static final int NUM_BLOCKS = 15;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        double dx = DX;
        double dy = DY;
        double changeX = 0.3;
        double changeY = 0.2;
        for (int i = 1; i <= numberOfBalls(); i++) {
            if (i == (numberOfBalls() / 2) + 1) {
                dx = -DX;
                dy = DY;
                changeX *= (-1);
            }
            list.add(new Velocity(dx, dy));
            dx += changeX;
            dy += changeY;
        }
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
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundTwo();
    }

    /**
     * Function Name : generateColor.
     * Function Operation : the function return color.
     * @param i index.
     * @return Color the color.
     */
    private Color generateColor(int i) {
        Color[] colors = {Color.red, Color.red, Color.orange,
                Color.orange, Color.yellow, Color.yellow, Color.green,
                Color.green, Color.green, Color.blue, Color.blue,
                Color.pink, Color.pink, Color.cyan, Color.cyan};
        return colors[i];
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        int indexBlock = 0;
        for (int j = (int) SHORT_LENGTH; j <= GUI_WIDTH - (2 * SHORT_LENGTH);
             j += WIDTH_REGULAR_BLOCK) {
            Block block = new Block(new Point(j, Y_START_BLOCKS),
                    WIDTH_REGULAR_BLOCK, SHORT_LENGTH, generateColor(indexBlock));
            list.add(block);
            indexBlock++;
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_BLOCKS;
    }
}
