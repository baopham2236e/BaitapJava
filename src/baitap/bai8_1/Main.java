package bai8_1;

public class Main {
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack); // Output: Stack: [10, 20, 30]

        System.out.println("Peek: " + stack.peek()); // Output: 30
        System.out.println("Pop: " + stack.pop());   // Output: 30
        System.out.println(stack); // Output: Stack: [10, 20]

        System.out.println("Stack size: " + stack.size()); // Output: 2
        System.out.println("Is empty? " + stack.isEmpty()); // Output: false
    }
}
