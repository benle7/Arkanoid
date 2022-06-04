// ID: 318811304

package utils;

import levels.LevelOne;
import levels.LevelTwo;
import levels.LevelThree;
import levels.LevelFour;
import interfaces.LevelInformation;

/**
 * @author Ben Levi
 * Class Operation : the class represent class that build level by number.
 */
public class BuildLevel {

    private final int numLevel;

    /**
     * Function Name : BuildLevel.
     * Function Operation : constructor.
     * @param numLevel the number of the level.
     */
    public BuildLevel(int numLevel) {
        this.numLevel = numLevel;
    }

    /**
     * Function Name : getLevel.
     * Function Operation : return the level information.
     * @return LevelInformation the level information.
     */
    public LevelInformation getLevel() {
        if (numLevel == 1) {
            return new LevelOne();
        }
        if (numLevel == 2) {
            return new LevelTwo();
        }
        if (numLevel == 3) {
            return new LevelThree();
        } else {
            return new LevelFour();
        }
    }

}
