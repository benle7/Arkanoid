// ID: 318811304

package interfaces;

import objects.Ball;
import utils.Velocity;
import geometry.Rectangle;
import geometry.Point;

/**
 * @author Ben Levi
 * Interface Operation : the interface represent game object that
 * can be collided with.
 */
public interface Collidable {

    /**
     * Function Name : getCollisionRectangle.
     * Function Operation : the function return the shape of the collidable.
     * @return : Rectangle the shape.
     */
    Rectangle getCollisionRectangle();

    /**
     * Function Name : hit.
     * Function Operation : the function return to the object
     * new velocity after the collision.
     * @param hitter the hitter object (ball).
     * @param collisionPoint the collision point.
     * @param currentVelocity the velocity of the object that collided.
     * @return Velocity the new velocity after collision.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
