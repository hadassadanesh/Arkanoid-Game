/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

/**
 * a class that can represent the number of things.
 */
public class Counter {
    private int count;
    // the number that is in the counter when we initializes is the same at every object of Count- 0.
    static final int START_NUMBER = 0;

    /**
     * a constructor that initializes a Counter object to have the number 0.
     * <p>
     */
    public Counter() {
        this.count = START_NUMBER;
    }

    /**
     * the method adds number to the current count.
     * <p>
     *
     * @param number the number to add.
     */
    public void increase(int number) {
        setCount(getValue() + number);
    }

    /**
     * the method subtracts number from current count.
     * <p>
     *
     * @param number the number to subtract.
     */
    public void decrease(int number) {
        setCount(getValue() - number);
    }

    /**
     * the method returns the current count.
     * <p>
     *
     * @return the current count.
     */
    public int getValue() {
        return count;
    }

    /**
     * changes the current count to be the given number.
     * <p>
     *
     * @param newCount the number that the method changes the count field to be.
     */
    private void setCount(int newCount) {
        this.count = newCount;
    }
}