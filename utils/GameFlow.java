// ID: 318811304

package utils;

import biuoop.KeyboardSensor;
import objects.GameOverScreen;
import objects.WinScreen;
import objects.AnimationRunner;
import objects.GameLevel;
import interfaces.LevelInformation;
import java.util.List;

/**
 * @author Ben Levi
 * Class Operation : the class represent util that activate list of levels.
 */
public class GameFlow {

    private final biuoop.KeyboardSensor keyboardSensor;
    private final AnimationRunner animationRunner;
    private final Counter score;

    /**
     * Function Name : GameFlow.
     * Function Operation : constructor.
     * @param ar the runner.
     * @param ks the keyboard.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
    }

    /**
     * Function Name : runLevels.
     * Function Operation : the function run list of levels.
     * @param levels the list.
     */
    public void runLevels(List<LevelInformation> levels) {
        int balls = 0;
        for (LevelInformation levelInfo : levels) {
            // create new level.
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, this.score);
            // initialize the level.
            level.initialize();

            // run the level while have balls and blocks.
            while ((level.getRemainingBalls().getValue() > 0)
                    && (level.getRemainingBlocks().getValue() > 0)) {
                level.run();
            }

            balls = level.getRemainingBalls().getValue();
            // if stop run because balls - game over.
            if (balls == 0) {
                break;
            }
        }
        // open end screen by the number of balls - win or game over screen.
        if (balls == 0) {
            this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new GameOverScreen(this.score.getValue())));
        } else  {
            this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new WinScreen(this.score.getValue())));
        }
    }
}
