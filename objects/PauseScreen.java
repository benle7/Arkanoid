// ID: 318811304

package objects;

import interfaces.Animation;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent animation of pause screen.
 */
public class PauseScreen implements Animation {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;
    static final int X_TEXT = 30;
    static final int SIZE_TEXT = 40;

    private final boolean stop;

    /**
     * Function Name : PauseScreen.
     * Function Operation : constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);
        d.setColor(Color.blue);
        d.fillRectangle(X_TEXT - 15, 260, 635, 58);
        d.setColor(Color.white);
        d.fillRectangle(X_TEXT - 10, 270, 625, 40);
        d.setColor(Color.black);
        d.drawText(X_TEXT, 300, "paused -- press space to continue", SIZE_TEXT);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
