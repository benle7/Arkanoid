// ID: 318811304

package objects;

import interfaces.Animation;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent animation of win screen.
 */
public class WinScreen implements Animation {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;
    static final int X_TEXT = 150;
    static final int Y_TEXT = 300;
    static final int SIZE_TEXT = 35;

    private final boolean stop;
    private final int score;

    /**
     * Function Name : WinScreen.
     * Function Operation : constructor.
     * @param score the score.
     */
    public WinScreen(int score) {
        this.score = score;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);
        d.setColor(Color.cyan);
        d.fillRectangle(X_TEXT - 15, Y_TEXT - 40, 495, 58);
        d.setColor(Color.white);
        d.fillRectangle(X_TEXT - 10, Y_TEXT - 30, 485, 40);
        d.setColor(Color.black);
        d.drawText(X_TEXT, Y_TEXT, "You Win! Your score is "
                + String.valueOf(this.score), SIZE_TEXT);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
