// ID: 318811304

package utils;

import geometry.Point;

/**
 * @author Ben Levi
 * Class Operation : the class represent properties and methods of Velocity,
 * the change in position of x and y.
 */
public class Velocity {
    // change x value.
    private final double dx;
    // change y value.
    private final double dy;

    /**
     * Function Name : Velocity.
     * Function Operation : constructor.
     * @param dx the change x.
     * @param dy the change y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Function Name : getDx.
     * Function Operation : the function return dx value of this velocity.
     * @return : double dx.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Function Name : getDy.
     * Function Operation : the function return dy value of this velocity.
     * @return : double dy.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Function Name : fromAngleAndSpeed.
     * Function Operation : the static function get angle and speed,
     * and return velocity from type of dx, dy.
     * @param angle the direction of the change.
     * @param speed the size of the change.
     * @return : Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle);
        // by trigonometry in right triangle we find the dx, dy values.
        double dx = speed * (Math.sin(angleRad));
        double dy = -speed * (Math.cos(angleRad));
        return new Velocity(dx, dy);
    }

    /**
     * Function Name : applyToPoint.
     * Function Operation : the function get point position,
     * and return new position after the velocity change.
     * @param p the point.
     * @return : Point new position.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}
