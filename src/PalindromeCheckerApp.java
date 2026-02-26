public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App");
        System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");
        System.out.println();

        String input = "A man a plan a canal Panama";   // You can change this

        // Step 1: Normalize string (remove spaces and convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Check palindrome
        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }
}