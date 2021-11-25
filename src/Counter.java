/**
 * @author Omer Abargel, id-207041005.
 * the class counter
 */
public class Counter {
    private int counter;
    /**
     * constructor for the counter class.
     * @param num the initial number
     */
    public Counter(int num) {
        this.counter = num;
    }
    /**
     * add number to current count.
     * @param number the number to add to the counter
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * subtract number from current count.
     * @param number the number to subtract from the counter.
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * get current count.
     * @return integer value of counter
     */
    public int getValue() {
        return counter;
    }
}