// ID: 318811304

package objects;

import biuoop.GUI;
import biuoop.DrawSurface;
import interfaces.Animation;
import biuoop.Sleeper;

/**
 * @author Ben Levi
 * Class Operation : the class represent object that activate animation.
 */
public class AnimationRunner {

    private final GUI gui;
    private final int framesPerSecond;
    private final Sleeper sleeper;

    /**
     * Function Name : AnimationRunner.
     * Function Operation : constructor.
     * @param gui the gui
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * Function Name : run.
     * Function Operation : the function activate animation.
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
