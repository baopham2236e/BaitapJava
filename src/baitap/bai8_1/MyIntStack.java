package bai8_1;

import java.util.ArrayList;

public class MyIntStack {
    private ArrayList<Integer> stack;

    public MyIntStack() {
        stack = new ArrayList<>();
    }

    // Thêm một phần tử vào đỉnh stack
    public void push(int value) {
        stack.add(value);
    }

    // Lấy phần tử ở đỉnh stack và xóa nó
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack.remove(stack.size() - 1);
    }

    // Lấy phần tử ở đỉnh stack mà không xóa
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack.get(stack.size() - 1);
    }

    // Kiểm tra stack có rỗng không
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Lấy số phần tử trong stack
    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "Stack: " + stack.toString();
    }
}

