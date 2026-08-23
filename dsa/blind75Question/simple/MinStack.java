package dsa.blind75Question.simple;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

/*
LC 155
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
class MinStack {


    //Using Priority queue and stack
    /*
    PriorityQueue<Integer> pq;
    Stack<Integer> stack;


    public MinStack() {
        pq=new PriorityQueue<>();
        stack=new Stack<>();

    }

    public void push(int value) {

        pq.add(value);
        stack.push(value);

    }

    public void pop() {

        pq.remove(stack.pop());
    }


    public int top() {

        return stack.peek();

    }

    public int getMin() {
        return pq.peek();
    }
*/


    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        if (minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);

        stack.push(value);

    }

    public void pop() {

        if (Objects.equals(stack.pop(), minStack.peek()))
            minStack.pop();
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }


}
