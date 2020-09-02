import java.util.Stack;

/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stackForL1 = new Stack<>();
        Stack<Integer> stackForL2 = new Stack<>();
        while(l1 != null) {
            stackForL1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stackForL2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode cur = new ListNode(0);
        while (!stackForL1.isEmpty() || !stackForL2.isEmpty()) {
            if (!stackForL1.isEmpty()) {
                sum += stackForL1.pop();
            }
            if (!stackForL2.isEmpty()) {
                sum += stackForL2.pop();
            }
            ListNode head = new ListNode((cur.val + sum)/10);
            cur.val = (cur.val + sum)%10;
            head.next = cur;
            cur = head;
            sum = 0;
        }
        return cur.val == 0? cur.next: cur;
    }
}
// @lc code=end

