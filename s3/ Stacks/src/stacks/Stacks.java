/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

class MyStack {
    // Property: lưu trữ giá trị của stack
    private ArrayList<Integer> stackValues;

    // Constructor
    public MyStack() {
        stackValues = new ArrayList<>();
    }

    // Method: push() – thêm 1 phần tử vào stack
    public void push(int value) {
        stackValues.add(value);
        System.out.println("Push: " + value);
    }

    // Method: pop() – lấy ra và xóa phần tử trên cùng
    public int pop() {
        if (stackValues.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stackValues.remove(stackValues.size() - 1);
        System.out.println("Pop: " + value);
        return value;
    }

    // Method: get() – xem phần tử trên cùng (không xóa)
    public int get() {
        if (stackValues.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackValues.get(stackValues.size() - 1);
    }

    // In toàn bộ stack (hỗ trợ demo)
    public void printStack() {
        System.out.println("Stack hiện tại: " + stackValues);
    }
}

// Class demo
public class Stacks {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Demo push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        // Demo get (peek)
        System.out.println("Phần tử trên cùng (get): " + stack.get());

        // Demo pop
        stack.pop();
        stack.printStack();

        // Demo pop tiếp
        stack.pop();
        stack.printStack();
    }
}
