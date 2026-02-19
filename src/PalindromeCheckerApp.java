public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App");
        System.out.println("UC4: Character Array Based Palindrome Check");
        System.out.println();

        String word = "level";   // You can change this value
        char[] characters = word.toCharArray();  // Convert string to char[]

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        // Two-pointer approach
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}
