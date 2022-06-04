// ID: 318811304
package objects;

import utils.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import geometry.Rectangle;
import geometry.Point;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Ben Levi
 * Class Operation : the class represent properties and methods of
 * paddle (user) that controlled by keyboard. the class implements
 * Sprite and Collidable interfaces.
 */
public class Paddle implements Sprite, Collidable {

    static final double START_Y = 575;
    static final double DEFAULT_HEIGHT = 20;
    static final double ANGLE_PART_ONE = 300;
    static final double ANGLE_PART_TWO = 330;
    static final double ANGLE_PART_FOUR = 30;
    static final double ANGLE_PART_FIVE = 60;

    private Rectangle block;
    private final double width;
    private java.awt.Color color;
    private final biuoop.KeyboardSensor keyboard;
    private final double step;
    private final double startX;

    /**
     * Function Name : Paddle.
     * Function Operation : constructor.
     * @param keyboard the KeyboardSensor.
     * @param step the step.
     * @param width the width.
     * @param startX the start x.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, double startX, double width, double step) {
        this.startX = startX;
        this.width = width;
        this.block = new Rectangle(new Point(startX, START_Y),
                width, DEFAULT_HEIGHT);
        this.color = Color.orange;
        this.keyboard = keyboard;
        this.step = step;
    }

    /**
     * Function Name : getStart.
     * Function Operation : return the start point.
     * @return Point the start point.
     */
    public Point getStart() {
        return new Point(this.startX, START_Y);
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        // check that the paddle between the frame blocks.
        checkPlace();
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        // check that the paddle between the frame blocks.
        checkPlace();
        int x = (int) this.block.getUpperLeft().getX();
        int y = (int) this.block.getUpperLeft().getY();
        int height = (int) DEFAULT_HEIGHT;
        d.fillRectangle(x, y, (int) this.width, height);
        d.setColor(Color.black);
        d.drawRectangle(x, y, (int) this.width, height);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double two = 2.0;
        double three = 3.0;
        double four = 4.0;
        double five = 5.0;
        double x = this.block.getUpperLeft().getX();
        double y = this.block.getUpperLeft().getY();
        Block temp = new Block(this.block);
        double startRegionTwo = x + (this.width / five);
        double startRegionThree = x + (two * (this.width / five));
        double startRegionFour = x + (three * (this.width / five));
        double startRegionFive = x + (four * (this.width / five));
        double xCollosion = collisionPoint.getX();
        double yCollosion = collisionPoint.getY();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        // calculate the current speed.
        double speed = Math.sqrt((dx * dx) + (dy * dy));
        double angle;

        // case of collision in the left rib, under the up rib.
        if ((x == xCollosion) && (yCollosion > y)) {
            return temp.hit(hitter, collisionPoint, currentVelocity);

          // case of collision in the right rib, under the up rib.
        } else if ((x + this.width == xCollosion) && (yCollosion > y)) {
            return temp.hit(hitter, collisionPoint, currentVelocity);

          // case of collision in part one.
        } else if ((x <= xCollosion) && (xCollosion < startRegionTwo)) {
            angle = ANGLE_PART_ONE;

          // case of collision in part two.
        } else if ((startRegionTwo <= xCollosion) && (xCollosion < startRegionThree)) {
            angle = ANGLE_PART_TWO;

          // case of collision in part four.
        } else if ((startRegionFour <= xCollosion) && (xCollosion < startRegionFive)) {
            angle = ANGLE_PART_FOUR;

          // case of collision in part five.
        } else if ((startRegionFive <= xCollosion) && (xCollosion <= x + this.width)) {
            angle = ANGLE_PART_FIVE;

          // case of collision in part three (middle).
        } else {
            return temp.hit(hitter, collisionPoint, currentVelocity);
        }
        return Velocity.fromAngleAndSpeed(angle, speed);
    }

    /**
     * Function Name : moveLeft.
     * Function Operation : the function move the paddle one step left.
     */
    public void moveLeft() {
        double newX = this.block.getUpperLeft().getX() - this.step;
        double y = this.block.getUpperLeft().getY();
        this.block = new Rectangle(newX, y, this.width, DEFAULT_HEIGHT);
    }

    /**
     * Function Name : moveRight.
     * Function Operation : the function move the paddle one step right.
     */
    public void moveRight() {
        double newX = this.block.getUpperLeft().getX() + this.step;
        double y = this.block.getUpperLeft().getY();
        this.block = new Rectangle(newX, y, this.width, DEFAULT_HEIGHT);
    }

    /**
     * Function Name : setColor.
     * Function Operation : the function set color to the paddle.
     * @param newColor the color.
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * Function Name : checkPlace.
     * Function Operation : the function check that the
     * paddle between the frame blocks.
     */
    private void checkPlace() {
        double leftEdge = 25;
        double rightEdge = 775;
        double x = this.block.getUpperLeft().getX();
        double y = this.block.getUpperLeft().getY();
        if (x < leftEdge) {
            this.block = new Rectangle(leftEdge, y, this.width, DEFAULT_HEIGHT);
        }
        if (x + this.width > rightEdge) {
            this.block = new Rectangle(rightEdge - this.width, y, this.width, DEFAULT_HEIGHT);
        }
    }
}
