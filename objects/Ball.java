// ID: 318811304
package objects;

import utils.Velocity;
import utils.GameEnvironment;
import utils.CollisionInfo;
import interfaces.Collidable;
import interfaces.Sprite;
import geometry.Point;
import geometry.Line;
import biuoop.DrawSurface;
import java.awt.Color;


/**
 * @author Ben Levi
 * Class Operation : the class represent properties and methods of ball.
 */
public class Ball implements Sprite {

    static final int DEFAULT_VELOCITY = 1;

    private Point center;
    private final int r;
    private final java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment environment;

    /**
     * Function Name : Ball.
     * Function Operation : constructor.
     * @param x the x center value.
     * @param y the y center value.
     * @param r the radius.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(DEFAULT_VELOCITY, DEFAULT_VELOCITY);
        this.environment = new GameEnvironment();
    }

    /**
     * Function Name : Ball.
     * Function Operation : constructor.
     * @param center the center point.
     * @param r the radius.
     * @param color the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(DEFAULT_VELOCITY, DEFAULT_VELOCITY);
        this.environment = new GameEnvironment();
    }

    /**
     * Function Name : Ball.
     * Function Operation : constructor(another option).
     * @param x the x value of center.
     * @param y the y value of center.
     * @param r the radius.
     * @param color the color of the ball.
     * @param environment the collidables of the environment.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(DEFAULT_VELOCITY, DEFAULT_VELOCITY);
        this.environment = environment;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle((int) this.getX(), (int) this.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Function Name : removeFromGame.
     * Function Operation : remove the ball from the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * Function Name : getX.
     * Function Operation : the function return x value of center.
     * @return : double x value of center.
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * Function Name : getY.
     * Function Operation : the function return y value of center.
     * @return : double y value of center.
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * Function Name : getSize.
     * Function Operation : the function return the radius.
     * @return : int radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Function Name : getColor.
     * Function Operation : the function return the color.
     * @return : java.awt.Color the color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Function Name : getVelocity.
     * Function Operation : the function return the velocity.
     * @return : Velocity the velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Function Name : getEnvironment.
     * Function Operation : the function return the environment.
     * @return : GameEnvironment the environment.
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Function Name : setVelocity.
     * Function Operation : the function set velocity.
     * @param v the velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Function Name : setVelocity.
     * Function Operation : the function set velocity(another option).
     * @param dx the change x value.
     * @param dy the change y value.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Function Name : setEnvironment.
     * Function Operation : the function set environment.
     * @param gameEnvironment the environment.
     */
    public void setEnvironment(GameEnvironment gameEnvironment) {
        this.environment = gameEnvironment;
    }

    /**
     * Function Name : moveOneStep.
     * Function Operation : the function move the ball by his velocity and environment.
     */
    public void moveOneStep() {
        double x = this.getX();
        double y = this.getY();

        // compute the trajectory with the next step.
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
        CollisionInfo collision = this.environment.getClosestCollision(trajectory);
        // if have no collisions.
        if (collision == null) {
            this.center = this.velocity.applyToPoint(this.center);
            return;
        }
        Collidable collisionObject = collision.collisionObject();
        Point collisionPoint = collision.collisionPoint();
        Point upperLeft = collisionObject.getCollisionRectangle().getUpperLeft();
        double width = collisionObject.getCollisionRectangle().getWidth();
        double height = collisionObject.getCollisionRectangle().getHeight();

        // move the ball to almost the hit point.
        if (collisionPoint.getX() == upperLeft.getX()) {
            x = collisionPoint.getX() - this.r;
        }
        if (collisionPoint.getX() == upperLeft.getX() + width) {
            x = collisionPoint.getX() + this.r;
        }
        if (collisionPoint.getY() == upperLeft.getY()) {
            y = collisionPoint.getY() - this.r;
        }
        if (collisionPoint.getY() == upperLeft.getY() + height) {
            y = collisionPoint.getY() + this.r;
        }
        this.center = new Point(x, y);
        setVelocity(collisionObject.hit(this, collisionPoint, this.velocity));
    }
}
