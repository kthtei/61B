/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
      * finally printing the results.
      *
      * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        lld1.addFirst(3);
        lld1.addLast(4);
        lld1.addLast(5);
        lld1.addFirst(2);
        lld1.addFirst(1);
        lld1.removeLast();

        //should be [1, 2, 3, 4, 5]
        lld1.printDeque();
        System.out.println(lld1.removeLast());

        // should be 3
        System.out.println(lld1.get(2));

        // should be 1
        System.out.println(lld1.get(0));

        // should be 2
        System.out.println(lld1.get(1));

        LinkedListDeque lld2 = new LinkedListDeque(lld1);

        System.out.println("lld1");

        lld1.printDeque();
        System.out.println("-----");
        System.out.println("lld2");
        lld2.printDeque();
        System.out.println("removing lld2 last: " + lld2.removeLast());
        System.out.println("removing lld2 first: " + lld2.removeFirst());
        lld2.printDeque();


        printTestStatus(passed);

    }

    public static void getRecursiveTest() {
        System.out.println("Get Recursive test.");


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());


        lld1.addFirst("10");
        lld1.addFirst("9");
        lld1.addFirst("8");
        lld1.addFirst("7");
        lld1.addFirst("6");
        lld1.addFirst("5");
        lld1.addFirst("4");
        lld1.addFirst("3");
        lld1.addFirst("2");
        lld1.addFirst("1");
        lld1.addFirst("0");

        System.out.println("normal get----");
        System.out.println(lld1.get(0));
        System.out.println(lld1.get(1));
        System.out.println(lld1.get(2));
        System.out.println(lld1.get(3));
        System.out.println(lld1.get(4));
        System.out.println(lld1.get(5));
        System.out.println(lld1.get(6));
        System.out.println(lld1.get(7));
        System.out.println(lld1.get(8));
        System.out.println(lld1.get(9));
        System.out.println(lld1.get(10));
        System.out.println(lld1.get(15));

        System.out.println("recursive get----");
        System.out.println(lld1.getRecursive(0));
        System.out.println(lld1.getRecursive(1));
        System.out.println(lld1.getRecursive(2));
        System.out.println(lld1.getRecursive(3));
        System.out.println(lld1.getRecursive(4));
        System.out.println(lld1.getRecursive(5));
        System.out.println(lld1.getRecursive(6));
        System.out.println(lld1.getRecursive(7));
        System.out.println(lld1.getRecursive(8));
        System.out.println(lld1.getRecursive(9));
        System.out.println(lld1.getRecursive(10));
        System.out.println(lld1.getRecursive(15));

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getRecursiveTest();
    }
}
