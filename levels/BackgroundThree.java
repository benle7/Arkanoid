// ID: 318811304

package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import objects.GameLevel;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent the background of level three.
 */
public class BackgroundThree implements Sprite {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(38, 205, 117));
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);

        drawFlag(d);
        drawLines(d);
    }

    /**
     * Function Name : drawFlag.
     * Function Operation : draw race flag.
     * @param d drawSurface.
     */
    private void drawFlag(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(40, 320, 10, 220);
        d.setColor(Color.white);
        d.drawRectangle(40, 320, 10, 220);

        d.fillRectangle(40, 320, 70, 60);
        d.setColor(Color.black);
        d.drawRectangle(40, 320, 70, 60);
    }

    /**
     * Function Name : drawLines.
     * Function Operation : draw the lines on the flag.
     * @param d drawSurface.
     */
    private void drawLines(DrawSurface d) {
        d.setColor(Color.black);
        int y = 325;
        for (int i = 0; i < 6; i++) {
            d.fillRectangle(40, y, 70, 3);
            y += 10;
        }
        int x = 45;
        for (int i = 0; i < 7; i++) {
            d.fillRectangle(x, 320, 3, 60);
            x += 10;
        }
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
