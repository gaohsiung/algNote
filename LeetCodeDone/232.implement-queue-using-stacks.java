import java.util.*;
/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue { //TODO: generic

    /** Initialize your data structure here. */
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!this.outStack.isEmpty()) {
            return this.outStack.pop();
        }
        if (this.inStack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        while (!this.inStack.isEmpty()) {
            this.outStack.push(this.inStack.pop());
        }
        return this.outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!this.outStack.isEmpty()) {
            return this.outStack.peek();
        }
        if (this.inStack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        while (!this.inStack.isEmpty()) {
            this.outStack.push(this.inStack.pop());
        }
        return this.outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

