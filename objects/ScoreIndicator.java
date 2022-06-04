// ID: 318811304
package objects;

import biuoop.DrawSurface;
import interfaces.Sprite;
import utils.Counter;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent display of the score.
 */
public class ScoreIndicator implements Sprite {

    static final int X_TEXT = 350;
    static final int Y_TEXT = 18;
    static final int SIZE = 15;

    private final Counter score;

    /**
     * Function Name : ScoreIndicator.
     * Function Operation : constructor.
     * @param score the Counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(X_TEXT, Y_TEXT, "Score: " + String.valueOf(this.score.getValue()), SIZE);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
