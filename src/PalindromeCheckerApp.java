import java.util.*;

// ============================================
// STACK METHOD
// ============================================
class StackPalindrome {

    public static boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// ============================================
// DEQUE METHOD
// ============================================
class DequePalindrome {

    public static boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// ============================================
// MAIN APPLICATION - PERFORMANCE COMPARISON
// ============================================
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.println("UC13: Performance Comparison");

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        // ==============================
        // STACK PERFORMANCE
        // ==============================
        long startStack = System.nanoTime();
        boolean stackResult = StackPalindrome.check(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // ==============================
        // DEQUE PERFORMANCE
        // ==============================
        long startDeque = System.nanoTime();
        boolean dequeResult = DequePalindrome.check(input);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        // ==============================
        // DISPLAY RESULTS
        // ==============================
        System.out.println("\nResults:");
        System.out.println("Stack Method  -> " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method  -> " + dequeResult + " | Time: " + dequeTime + " ns");

        scanner.close();
    }
}