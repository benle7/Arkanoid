// ID: 318811304

package objects;

import utils.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import interfaces.HitNotifier;
import interfaces.HitListener;
import geometry.Rectangle;
import geometry.Point;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Ben Levi
 * Class Operation : the class represent properties and methods of
 * Block. the class implements Sprite and Collidable interfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier  {

    private final Rectangle block;
    private final java.awt.Color color;
    private final List<HitListener> hitListeners;

    /**
     * Function Name : Block.
     * Function Operation : constructor.
     * @param block the properties of the block (rectangle).
     * @param color the color.
     */
    public Block(Rectangle block, java.awt.Color color) {
        this.block = block;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Function Name : Block.
     * Function Operation : constructor.
     * @param upperLeft point.
     * @param width the width.
     * @param height the height.
     * @param color the color.
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color) {
        this.block = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Function Name : Block.
     * Function Operation : constructor.
     * @param block the properties of the block (rectangle).
     */
    public Block(Rectangle block) {
        this.block = block;
        this.color = Color.black;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if ((collisionPoint.getX() == block.getUpperLeft().getX())
            || (collisionPoint.getX() == block.getUpperLeft().getX() + block.getWidth())) {
            dx = -dx;
        }
        if ((collisionPoint.getY() == block.getUpperLeft().getY())
                || (collisionPoint.getY() == block.getUpperLeft().getY() + block.getHeight())) {
            dy = -dy;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * Function Name : notifyHit.
     * Function Operation : notify all the listeners about hit event.
     * @param hitter the ball hitter.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int x = (int) this.block.getUpperLeft().getX();
        int y = (int) this.block.getUpperLeft().getY();
        int width = (int) this.block.getWidth();
        int height = (int) this.block.getHeight();
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.black);
        surface.drawRectangle(x, y, width, height);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Function Name : removeFromGame.
     * Function Operation : remove the block from the game.
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
