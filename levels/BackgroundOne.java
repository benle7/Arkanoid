// ID: 318811304

package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import objects.GameLevel;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent the background of level one.
 */
public class BackgroundOne implements Sprite {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;
    static final int RADIUS = 110;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);

        d.setColor(Color.blue);
        d.drawCircle(GUI_WIDTH / 2, GUI_HEIGHT / 4 + 10, RADIUS);
        d.drawCircle(GUI_WIDTH / 2, GUI_HEIGHT / 4 + 10, RADIUS - 20);
        d.drawCircle(GUI_WIDTH / 2, GUI_HEIGHT / 4 + 10, RADIUS - 40);
        d.drawLine(270, GUI_HEIGHT / 4 + 10, 530, GUI_HEIGHT / 4 + 10);
        d.drawLine(GUI_WIDTH / 2, 0, GUI_WIDTH / 2, 280);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
