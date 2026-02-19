public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App");
        System.out.println("UC3: Palindrome Check Using String Reverse");
        System.out.println();

        String original = "racecar";   // You can change this value
        String reversed = "";

        // Reverse string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed string
        if (original.equals(reversed)) {
            System.out.println("Original String: " + original);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Original String: " + original);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}
