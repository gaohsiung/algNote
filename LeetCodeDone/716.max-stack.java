import java.util.*;
/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 */

// @lc code=start
class MaxStack {

  /** initialize your data structure here. */
  private static class ListNode {
    private int val;
    private ListNode prev;
    private ListNode next;
    private ListNode(int val) {
      this.val = val;
      this.prev = null;
      this.next = null;
    }
  }
  private ListNode dummyHead;
  private ListNode cur;
  private TreeMap<Integer, List<ListNode>> bst;
  public MaxStack() {
    this.dummyHead = new ListNode(0);
    cur = this.dummyHead;
    this.bst = new TreeMap<>();
  }

  public void push(int x) {
    ListNode newNode = new ListNode(x);
    newNode.prev = cur;
    cur.next = newNode;
    cur = newNode;
    if (!this.bst.containsKey(x)) {
      this.bst.put(x, new ArrayList<>());
    }
    this.bst.get(x).add(newNode);
    
  }

  public int pop() {
    if (cur == this.dummyHead) {
      return 0;
    }
    ListNode deleteNode = cur;
    cur = cur.prev;
    cur.next = null;
    this.bst.get(deleteNode.val).remove(this.bst.get(deleteNode.val).size() - 1);
    if (this.bst.get(deleteNode.val).size() == 0) {
      this.bst.remove(deleteNode.val);
    }
    return deleteNode.val;
  }

  public int top() {
    return this.cur.val;
  }

  public int peekMax() {
    return this.bst.lastKey();
  }

  public int popMax() {
    if (this.cur == this.dummyHead) return 0;
    int maxVal = peekMax();
    if (this.cur.val == maxVal) {
      return pop();
    }
    ListNode deleteNode = this.bst.get(maxVal).remove(this.bst.get(maxVal).size() - 1);
    if (this.bst.get(deleteNode.val).size() == 0) {
      this.bst.remove(deleteNode.val);
    }
    deleteNode.prev.next = deleteNode.next;
    if (deleteNode.next != null) {
      deleteNode.next.prev = deleteNode.prev;
    }
    return maxVal;

  }
  public static void main(String[] args) {
    MaxStack m = new MaxStack();
    m.push(5);
    m.push(1);
    m.push(5);
    m.top();
    m.popMax();
    m.top();
    m.popMax();
    m.pop();
    m.top();
  }
}

/**
 * Your MaxStack object will be instantiated and called as such: MaxStack obj =
 * new MaxStack(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.top(); int param_4 = obj.peekMax(); int param_5 = obj.popMax();
 */
// @lc code=end
