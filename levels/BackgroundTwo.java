// ID: 318811304

package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import objects.GameLevel;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent the background of level two.
 */
public class BackgroundTwo implements Sprite {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0, 153, 148));
        d.fillRectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);

        drawSky(d);
        drawClouds(d);
        drawSun(d);
    }

    /**
     * Function Name : drawSky.
     * Function Operation : draw the sky.
     * @param d drawSurface.
     */
    private void drawSky(DrawSurface d) {
        d.setColor(new Color(51, 153, 255));
        d.fillOval(0, 0, 300, 130);
        d.setColor(new Color(51, 153, 255));
        d.fillOval(250, 0, 300, 130);
        d.setColor(new Color(51, 153, 255));
        d.fillOval(500, 0, 300, 130);
    }

    /**
     * Function Name : drawClouds.
     * Function Operation : draw the clouds.
     * @param d drawSurface.
     */
    private void drawClouds(DrawSurface d) {
        d.setColor(new Color(208, 207, 207));
        d.fillOval(590, 100, 110, 80);
        d.setColor(Color.gray.brighter());
        d.fillOval(590, 70, 110, 55);
        d.setColor(Color.lightGray);
        d.fillOval(620, 95, 120, 70);
        d.setColor(new Color(208, 207, 207));
        d.fillOval(550, 90, 100, 70);
    }

    /**
     * Function Name : drawSun.
     * Function Operation : draw the sun.
     * @param d drawSurface.
     */
    private void drawSun(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillCircle(100, 120, 45);
        d.setColor(new Color(255, 201, 28));
        d.fillCircle(100, 120, 40);
        d.setColor(new Color(241, 241, 102));
        d.fillCircle(100, 120, 35);

        int endX = 60;
        int g = 246;
        d.setColor(new Color(246, g, 108));
        for (int i = 0; i < 70; i++) {
            d.drawLine(95, 158, endX, 200);
            d.setColor(new Color(246, g, 108));
            g--;
            endX += 10;
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
