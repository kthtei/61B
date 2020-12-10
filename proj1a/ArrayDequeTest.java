/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	
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
//		System.out.println("Running add/isEmpty/Size test.");
//
//
//		ArrayDeque<String> ad1 = new ArrayDeque<String>();
//
//		boolean passed = checkEmpty(true, ad1.isEmpty());
//
//		ad1.addFirst("front");
//
//		// The && operator is the same as "and" in Python.
//		// It's a binary operator that returns true if both arguments true, and false otherwise.
//		passed = checkSize(1, ad1.size()) && passed;
//		passed = checkEmpty(false, ad1.isEmpty()) && passed;
//
//		ad1.addLast("middle");
//		passed = checkSize(2, ad1.size()) && passed;
//
//		ad1.addLast("back");
//		passed = checkSize(3, ad1.size()) && passed;
//
//		System.out.println("Printing out deque: ");
//		ad1.printDeque();
//
//		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		ArrayDeque<String> ad1 = new ArrayDeque<>();
		// should be empty
		boolean passed = checkEmpty(true, ad1.isEmpty());


		ad1.removeFirst();
		// should be empty
		passed = checkEmpty(true, ad1.isEmpty()) && passed;

		ad1.addLast("a");
		ad1.addLast("b");
		ad1.addFirst("c");
		ad1.addLast("d");
		ad1.addLast("e");
		ad1.addFirst("f");

		//should be [1, 2, 3, 4, 5]

//		ad1.removeFirst();
//		ad1.removeLast();
//		ad1.removeLast();
//		ad1.removeLast();
//		System.out.println(ad1.removeFirst());
//		System.out.println(ad1.removeLast());
//		System.out.println(ad1.removeLast());
//		System.out.println(ad1.removeLast());
//		System.out.println(ad1.removeLast());
//		System.out.println(ad1.removeLast());

		System.out.println("after removed all");
		ad1.printDeque();

		ArrayDeque ad2 = new ArrayDeque(ad1);
		System.out.println("ad2");
		ad2.printDeque();

		ad1.removeFirst();
		ad2.removeLast();

		System.out.println("ad1");
		ad1.printDeque();
		System.out.println("ad2");
		ad2.printDeque();
//		System.out.println(lld1.removeLast());

//		// should be 3
//		System.out.println(ad1.get(2));
//
//		// should be 1
//		System.out.println(ad1.get(0));
//
//		// should be 2
//		System.out.println(ad1.get(1));
//
//		ad1.removeLast();
//		ad1.removeLast();
//		ad1.removeLast();
//		ad1.removeLast();


		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 