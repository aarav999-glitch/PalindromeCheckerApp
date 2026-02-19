import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }

        scanner.close();
    }
}
