import java.util.*;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> internalMinStack;
    Stack<Integer> stack;
    public MinStack() {
        this.internalMinStack = new Stack<>();
        this.stack = new Stack<>();
    }
    
    public void push(int x) {
        this.stack.push(x);
        if (this.internalMinStack.isEmpty() || x <= this.internalMinStack.peek()) {
            this.internalMinStack.push(x);
        }
    }
    
    public void pop() {
        if (this.internalMinStack.peek().equals(this.stack.peek())) {
            this.internalMinStack.pop();
        }
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.internalMinStack.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(512);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(512);
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
/*
["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
\n[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
*/
