/*
 * @lc app=leetcode id=369 lang=java
 *
 * [369] Plus One Linked List
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
    public ListNode plusOne(ListNode head) {
        int carry =  isCarry(head);
        if (carry == 0) {
            return head;
        } else {
            ListNode newHead = new ListNode(1, head);
            return newHead;
        }
    }
    
    
    private int isCarry(ListNode head) {
        if (head == null) {
            return 1;
        }
        int carry = isCarry(head.next);
        if (carry == 0) {
            return 0;
        } else {
            int oldVal = head.val;
            head.val = (oldVal + carry) % 10;
            return (oldVal + carry) / 10;
        }

    }

    public static void main(String[] sss) {
        Solution s = new Solution();
        ListNode l5 = new ListNode(9, null);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(9, l4);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(2, l2); 
        s.plusOne(l1);
    }

}
// @lc code=end

