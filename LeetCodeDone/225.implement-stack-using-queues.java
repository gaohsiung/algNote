import java.util.*;
/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack { // TODO: generic

    /** Initialize your data structure here. */
    Queue<Integer> helperQueue;
    public MyStack() {
        this.helperQueue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int curSize = this.helperQueue.size();
        this.helperQueue.offer(x);
        while(curSize -- > 0) {
            this.helperQueue.offer(this.helperQueue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.helperQueue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return this.helperQueue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.helperQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

