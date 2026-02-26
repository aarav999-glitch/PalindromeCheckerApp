import java.util.*;

// ============================================
// INTERFACE - PalindromeStrategy
// Defines contract for all palindrome algorithms
// ============================================
interface PalindromeStrategy {
    boolean check(String input);
}

// ============================================
// CLASS - StackStrategy
// Uses LIFO stack to reverse characters
// ============================================
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Compare by popping
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// ============================================
// CLASS - DequeStrategy
// Uses double-ended queue for comparison
// ============================================
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

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
// CONTEXT CLASS - PalindromeChecker
// Allows dynamic strategy selection
// ============================================
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.check(input);
    }
}

// ============================================
// MAIN APPLICATION
// ============================================
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Palindrome Checker App");
        System.out.println("UC12: Strategy Pattern for Palindrome Algorithms");

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        // Inject strategy dynamically
        if (choice == 1) {
            checker.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            checker.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        boolean result = checker.checkPalindrome(input);

        System.out.println("Is Palindrome? " + result);

        scanner.close();
    }
}