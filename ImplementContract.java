import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the Contract interface with some interesting behavior.
 */
public class ImplementContract implements Contract {

    private Map<String, String> inventory;
    private int size;

    public ImplementContract() {
        inventory = new HashMap<>();
        size = 0;
    }

    /**
     * Add an item to the inventory.
     *
     * @param item the item to grab
     */
    @Override
    public void grab(String item) {
        inventory.put(item, "In inventory");
        size++;
        System.out.println("You grabbed " + item);
    }

    /**
     * Remove an item from the inventory and drop it.
     *
     * @param item the item to drop
     * @return a message indicating the item has been dropped
     */
    @Override
    public String drop(String item) {
        String droppedItem = inventory.remove(item);
        if (droppedItem != null) {
            size--;
            return "You dropped " + item;
        } else {
            return "You don't have " + item + " in your inventory";
        }
    }

    /**
     * Examine an item from the inventory.
     *
     * @param item the item to examine
     */
    @Override
    public void examine(String item) {
        String status = inventory.get(item);
        if (status != null) {
            System.out.println(item + ": " + status);
        } else {
            System.out.println("You don't have " + item + " in your inventory");
        }
    }

    /**
     * Use an item from the inventory.
     *
     * @param item the item to use
     */
    @Override
    public void use(String item) {
        System.out.println("You used " + item);
    }

    /**
     * Walk in a direction.
     *
     * @param direction the direction to walk
     * @return always true
     */
    @Override
    public boolean walk(String direction) {
        System.out.println("You walked " + direction);
        return true;
    }

    /**
     * Fly to coordinates (x, y).
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return always true
     */
    @Override
    public boolean fly(int x, int y) {
        System.out.println("You flew to coordinates (" + x + ", " + y + ")");
        return true;
    }

    /**
     * Shrink something.
     *
     * @return the new size after shrinking
     */
    @Override
    public Number shrink() {
        System.out.println("You shrink something");
        return size / 2;
    }

    /**
     * Grow something.
     *
     * @return the new size after growing
     */
    @Override
    public Number grow() {
        System.out.println("You grow something");
        return size * 2;
    }

    /**
     * Take a rest.
     */
    @Override
    public void rest() {
        System.out.println("You took a rest");
    }

    /**
     * Undo the last action.
     */
    @Override
    public void undo() {
        System.out.println("Undoing last action");
    }
    

    public static void main(String[] args) {
        // Create an instance of InterestingContract
        ImplementContract contract = new ImplementContract();

        // Perform some actions
        contract.grab("Pen");
        contract.grab("Apple");
        contract.examine("Pen");
        contract.drop("Pen");
        contract.examine("Pen");

        // Perform other actions...
    }
}
