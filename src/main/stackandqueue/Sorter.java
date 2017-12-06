package stackandqueue;

import java.util.Stack;

//3.5
public class Sorter {

    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(22);
        stack.push(15);
        stack.push(1);
        stack.push(88);
        stack.push(4);
        System.out.println(sort(stack));
    }
}
