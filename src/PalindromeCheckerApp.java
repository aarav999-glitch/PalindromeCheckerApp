public class PalindromeCheckerUC9 {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App");
        System.out.println("UC9: Recursive Palindrome Checker");
        System.out.println();

        String word = "madam";   // You can change this value

        boolean result = isPalindrome(word, 0, word.length() - 1);

        if (result) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }

    // Recursive method
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}