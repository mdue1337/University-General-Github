// Version: 20200917
// Handin done by:
//   AU786751 Martin Due
//   AU806016 Filip Raeburn
//   AU804976 Matthias W. Jensen
// Contributions:
//   Teoretisk snak og diskussion af opgaven udført af alle medlemmer.
//   Implementering udført af Filip Reaburn & Matthias W. Jensen.

import java.io.*;
import java.util.*;
public class ReversePolishCalculator {
    private Stack<Integer> stack = new Stack<>();

    // Add any private fields you might need here
    public void push(int n) {
        stack.push(n);
    }

    public void plus() {
        if( stack.isEmpty()|| stack.size() < 2) {
            throw new IllegalStateException("Not enough elements on the stack to perform addition.");
        }
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a + b);
    }

    public void minus() {
        // Implement your code here to pop two elements and push their difference
        if( stack.isEmpty()|| stack.size() < 2) {
            throw new IllegalStateException("Not enough elements on the stack to perform subtraction.");
        }
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b - a);
    }

    public void times() {
        // Implement your code here to pop two elements and push their product
        if( stack.isEmpty()|| stack.size() < 2) {
            throw new IllegalStateException("Not enough elements on the stack to perform multiplication.");
        }
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a * b);
    }

    public int read() {
        // Implement your code here to read the top element from the stack (without removing it)
        if( stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.peek();
    }
}
