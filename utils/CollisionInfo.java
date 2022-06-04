// ID: 318811304

package utils;

import interfaces.Collidable;
import geometry.Point;

/**
 * @author Ben Levi
 * Class Operation : the class represent information about collision point.
 */
public class CollisionInfo {
    private final Collidable collisionObject;
    private final Point collisionPoint;

    /**
     * Function Name : CollisionInfo.
     * Function Operation : constructor.
     * @param collisionObject the object.
     * @param collisionPoint the point.
     */
    public CollisionInfo(Collidable collisionObject, Point collisionPoint) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * Function Name : collisionPoint.
     * Function Operation : the function return the collision Point.
     * @return : Point the collision Point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Function Name : collisionObject.
     * Function Operation : the function return the collision object.
     * @return : Collidable the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
