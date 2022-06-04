// ID: 318811304

package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import objects.GameLevel;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent the background of level four.
 */
public class BackgroundFour implements Sprite {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(51, 153, 255));
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);

       drawSymbol(d);
        drawText(d);
        drawFlame(d);
        drawFlag(d);
    }

    /**
     * Function Name : drawSymbol.
     * Function Operation : draw the olympic symbol.
     * @param d drawSurface.
     */
    private void drawSymbol(DrawSurface d) {
        int bigRadius = 17;
        int smallRadius = 12;
        int firstY = 90;
        int secondY = 105;

        d.setColor(Color.blue);
        d.fillCircle(215, firstY, bigRadius);
        d.setColor(Color.white);
        d.fillCircle(215, firstY, smallRadius);

        d.setColor(Color.black);
        d.fillCircle(248, firstY, bigRadius);
        d.setColor(Color.white);
        d.fillCircle(248, firstY, smallRadius);

        d.setColor(Color.red);
        d.fillCircle(281, firstY, bigRadius);
        d.setColor(Color.white);
        d.fillCircle(281, firstY, smallRadius);

        d.setColor(Color.yellow);
        d.fillCircle(228, secondY, bigRadius);
        d.setColor(Color.white);
        d.fillCircle(228, secondY, smallRadius);

        d.setColor(Color.green);
        d.fillCircle(267, secondY, bigRadius);
        d.setColor(Color.white);
        d.fillCircle(267, secondY, smallRadius);
    }

    /**
     * Function Name : drawFlame.
     * Function Operation : draw the olympic flame.
     * @param d drawSurface.
     */
    private void drawFlame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(70, 420, 10, 150);
        d.setColor(Color.white);
        d.drawRectangle(70, 420, 10, 150);
        d.setColor(Color.yellow);
        d.fillOval(55, 410, 40, 15);

        d.setColor(new Color(255, 174, 37));
        d.drawLine(75, 410, 28, 385);
        int x = 26;
        for (int i = 0; i < 35; i++) {
            d.drawLine(75, 415, x, 385);
            x += 3;
        }

    }

    /**
     * Function Name : drawFlag.
     * Function Operation : draw Israel flag.
     * @param d drawSurface.
     */
    private void drawFlag(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(650, 420, 90, 52);
        d.setColor(Color.blue);
        d.drawRectangle(650, 420, 90, 52);

        d.fillRectangle(650, 425, 90, 5);
        d.fillRectangle(650, 462, 90, 5);

        d.drawLine(675, 458, 694, 431);
        d.drawLine(694, 431, 714, 457);
        d.drawLine(714, 457, 675, 457);
        d.drawLine(714, 440, 675, 440);
        d.drawLine(714, 440, 694, 461);
        d.drawLine(675, 440, 694, 461);
    }

    /**
     * Function Name : drawText.
     * Function Operation : draw the title.
     * @param d drawSurface.
     */
    private void drawText(DrawSurface d) {
        d.setColor(new Color(255, 220, 139));
        d.fillRectangle(310, 70, 350, 45);
        d.setColor(Color.black);
        d.drawRectangle(310, 70, 350, 45);
        d.setColor(Color.black);
        d.drawText(320, 100, "The Olympic Games - Arkanoid 2021", 20);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
