// ID: 318811304
package utils;

/**
 * @author Ben Levi
 * Class Operation : the class represent counter.
 */
public class Counter {
    private int count;

    /**
     * Function Name : Counter.
     * Function Operation : constructor.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Function Name : Counter.
     * Function Operation : constructor.
     * @param count the game.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * Function Name : increase.
     * Function Operation : increase the current count.
     */
    public void increase() {
        this.count++;
    }

    /**
     * Function Name : increase.
     * Function Operation : increase the current count.
     * @param number the number to addition.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * Function Name : decrease.
     * Function Operation : decrease the current count.
     */
    public void decrease() {
        this.count--;
    }

    /**
     * Function Name : decrease.
     * Function Operation : decrease the current count.
     * @param number the number to decrease.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * Function Name : getValue.
     * Function Operation : return the current value of count.
     * @return : int the current value of count.
     */
    public int getValue() {
        return this.count;
    }
}
