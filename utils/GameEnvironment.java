// ID: 318811304

package utils;

import interfaces.Collidable;
import geometry.Point;
import geometry.Line;
import java.util.ArrayList;

/**
 * @author Ben Levi
 * Class Operation : the class represent list of collisions.
 */
public class GameEnvironment {
    private  final java.util.List<Collidable> collisions;

    /**
     * Function Name : GameEnvironment.
     * Function Operation : constructor.
     */
    public GameEnvironment() {
        this.collisions = new ArrayList<>();
    }

    /**
     * Function Name : addCollidable.
     * Function Operation : the function add collidable to the list.
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        this.collisions.add(c);
    }

    /**
     * Function Name : removeCollidable.
     * Function Operation : the function remove collidable from the list.
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collisions.remove(c);
    }

    /**
     * Function Name : getClosestCollision.
     * Function Operation : the function return closest collision.
     * @param trajectory the line.
     * @return : CollisionInfo information about the collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.collisions.isEmpty()) {
            return null;
        }
        Collidable collisionObject = collisions.get(0);
        Point collisionPoint = trajectory.
                closestIntersectionToStartOfLine(collisionObject.
                        getCollisionRectangle());
        double distance = -1;
        // if collision, save the information (distance).
        if (collisionPoint != null) {
            distance = collisionPoint.distance(trajectory.start());
        }
        double tempDistance;
        for (int i = 1; i < this.collisions.size(); i++) {
            Collidable tempCollision = collisions.get(i);
            Point tempPoint = trajectory.
                    closestIntersectionToStartOfLine(tempCollision.
                            getCollisionRectangle());
            if (tempPoint != null) {
                tempDistance = tempPoint.distance(trajectory.start());
                // save the closer.
                if (((distance != -1) && (tempDistance < distance)) || (distance == -1)) {
                    distance = tempDistance;
                    collisionObject = tempCollision;
                    collisionPoint = tempPoint;
                }
            }
        }
        // if have no collisions.
        if (distance == -1) {
            return null;
        }
        return new CollisionInfo(collisionObject, collisionPoint);
    }
}
