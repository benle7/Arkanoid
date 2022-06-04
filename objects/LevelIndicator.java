// ID: 318811304

package objects;

import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent display of the level.
 */
public class LevelIndicator implements Sprite {

    static final int X_LIVES = 100;
    static final int X_LEVEL = 550;
    static final int Y_TEXT = 18;
    static final int SIZE = 15;

    private final String level;
    private final int lives;

    /**
     * Function Name : LevelIndicator.
     * Function Operation : constructor.
     * @param level the level name.
     * @param lives the lives counter.
     */
    public LevelIndicator(String level, int lives) {
        this.level = level;
        this.lives = lives;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(X_LIVES, Y_TEXT, "Lives: "
                + String.valueOf(this.lives), SIZE);
        d.drawText(X_LEVEL, Y_TEXT, "Level Name: " + this.level, SIZE);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
