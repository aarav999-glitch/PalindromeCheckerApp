public class UseCase8PalindromeChecker {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        System.out.println("Palindrome Checker App");
        System.out.println("UC8: Linked List Based Palindrome Checker");
        System.out.println();

        String word = "racecar";   // You can change this value

        // Step 1: Convert string to linked list
        Node head = null;
        Node tail = null;

        for (int i = 0; i < word.length(); i++) {
            Node newNode = new Node(word.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 4: Compare both halves
        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}