import java.util.*;

/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    // c.c.

    ListNode[] res = new ListNode[k];
    for (int i = 0; i < k; i++) { // generate dummy
      res[i] = new ListNode(0);
    }

    int len = getLenOfLinkedList(root);
    int base = len / k;
    int remainder = len % k;
    ListNode cur = root;
    for (int i = 0; i < k; i++) {
      if (cur == null) {
        break;
      }
      ListNode localCur = res[i];
      for(int j = 0; j < base; j++) {
        localCur.next = new ListNode(cur.val);
        localCur = localCur.next;
        cur = cur.next;
      }
      if (remainder > 0) {
        localCur.next = new ListNode(cur.val);
        cur = cur.next;
        remainder--;
      }
    }
    for (int i = 0; i < k; i++) {
      if (res[i].next == null) {
        res[i] = null;
      } else {
        res[i] = res[i].next;
      }
    }
    return res;
    

  }
  private int getLenOfLinkedList(ListNode root) {
    int count = 0;
    while (root != null) {
      count++;
      root = root.next;
    }
    return count;
  }

}
// @lc code=end
