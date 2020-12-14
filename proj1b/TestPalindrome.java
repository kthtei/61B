import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("madam"));
        assertTrue(palindrome.isPalindrome("mesem"));
        assertTrue(palindrome.isPalindrome("minim"));
        assertTrue(palindrome.isPalindrome("murdrum"));
        assertFalse(palindrome.isPalindrome("Racecar"));
    }

    @Test
    public void testOffByOnePalindrome() {
        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("racecar", offByOne));
        assertFalse(palindrome.isPalindrome("murdrum", offByOne));
        assertFalse(palindrome.isPalindrome("mesem", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("abab", offByOne));
        assertTrue(palindrome.isPalindrome("unpot", offByOne));
    }

    @Test
    public void testOffByNPalindrome() {
        OffByN offByN = new OffByN(5);
        assertTrue(palindrome.isPalindrome("toto", offByN));
        assertTrue(palindrome.isPalindrome("totty", offByN));
        assertTrue(palindrome.isPalindrome("toty", offByN));
        assertTrue(palindrome.isPalindrome("unrip", offByN));
        assertTrue(palindrome.isPalindrome("upsup", offByN));
        assertFalse(palindrome.isPalindrome("aba", offByN));
        assertFalse(palindrome.isPalindrome("ccc", offByN));
        assertTrue(palindrome.isPalindrome("c", offByN));
        assertTrue(palindrome.isPalindrome("", offByN));


    }
}
