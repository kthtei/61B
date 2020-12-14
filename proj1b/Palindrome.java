public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int length = word.length();
        Deque<Character> ans = new LinkedListDeque<>();

        for (int i = 0; i < length; i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

//    public boolean isPalindrome(String word) {
//        Palindrome palindrome = new Palindrome();
//        Deque<Character> deque = palindrome.wordToDeque(word);
//        if (deque.size() <= 1) {
//            return true;
//        }
//        while (!deque.isEmpty()) {
//            if (deque.removeFirst() != deque.removeLast()) {
//                return false;
//            }
//        }
//        return false;
//    }

    public boolean isPalindrome(String word) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> deque = palindrome.wordToDeque(word);

        return palindromeHelper(deque);
    }

    private boolean palindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        if (deque.removeFirst() != deque.removeLast()) {
            return false;
        }
        return palindromeHelper(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> deque = palindrome.wordToDeque(word);

        return palindromeHelperOffByOne(deque, cc);
    }

    private boolean palindromeHelperOffByOne(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return false;
        }
        return palindromeHelperOffByOne(deque, cc);
    }
}
