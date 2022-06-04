// ID: 318811304

package objects;

import interfaces.Animation;
import biuoop.DrawSurface;
import utils.SpriteCollection;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent count down animation before game.
 */
public class CountdownAnimation implements Animation {

    static final int X_NUM = 405;
    static final int Y_NUM = 420;
    static final int X_TEXT = 375;
    static final int Y_TEXT = 425;
    static final int SIZE_TEXT = 60;
    static final int X_BIG_OVAL = 340;
    static final int Y_BIG_OVAL = 325;
    static final int SIZE_BIG_OVAL = 160;
    static final int X_OVAL = 350;
    static final int Y_OVAL = 335;
    static final int SIZE_OVAL = 140;

    private final double numOfSeconds;
    private final int countFrom;
    private final SpriteCollection gameScreen;
    private int index;

    /**
     * Function Name : CountdownAnimation.
     * Function Operation : constructor.
     * @param numOfSeconds the num of seconds for the animation.
     * @param countFrom the number count from it.
     * @param gameScreen the sprites.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.index = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // draw all the sprites.
        gameScreen.drawAllOn(d);

        // draw the oval that contain the text.
        d.setColor(Color.yellow);
        d.fillOval(X_BIG_OVAL, Y_BIG_OVAL, SIZE_BIG_OVAL, SIZE_BIG_OVAL);
        d.setColor(Color.black);
        d.drawOval(X_BIG_OVAL, Y_BIG_OVAL, SIZE_BIG_OVAL, SIZE_BIG_OVAL);
        d.fillOval(X_OVAL, Y_OVAL, SIZE_OVAL, SIZE_OVAL);
        d.setColor(Color.white);

        // write the appropriate text.
        if (index > 0) {
            d.drawText(X_NUM, Y_NUM, Integer.toString(index), SIZE_TEXT);
        } else if (index == 0) {
            d.drawText(X_TEXT, Y_TEXT, "GO", SIZE_TEXT);
        }

        Sleeper sleeper = new Sleeper();
        // activate sleeper just after the 'count from' number.
        if (index != countFrom) {
            sleeper.sleepFor((int) (numOfSeconds * 1000 / countFrom));
        }
        index--;
    }

    @Override
    public boolean shouldStop() {
        if (index < -1) {
            return true;
        }
        return false;
    }
}
