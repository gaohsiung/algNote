/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length % 2 == 0) {
            ListNode[] firstHalf = new ListNode[lists.length / 2];
            ListNode[] secondHalf = new ListNode[lists.length / 2];
            for (int i = 0; i < lists.length / 2; i++) {
                firstHalf[i] = lists[i];
            }
            for (int i = 0; i < lists.length / 2; i++) {
                secondHalf[i] = lists[lists.length / 2 + i];
            }

            return merge2List(mergeKLists(firstHalf), mergeKLists(secondHalf));
        } else {
            ListNode[] firstHalf = new ListNode[lists.length / 2 + 1];
            ListNode[] secondHalf = new ListNode[lists.length / 2];
            for (int i = 0; i < lists.length / 2 + 1; i++) {
                firstHalf[i] = lists[i];
            }
            for (int i = 0; i < lists.length / 2; i++) {
                secondHalf[i] = lists[lists.length / 2 + 1 + i];
            }
            return merge2List(mergeKLists(firstHalf), mergeKLists(secondHalf));
        }
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2:l1;
        }
        if (l1.val <= l2.val) {
            ListNode subHead = merge2List(l1.next, l2);
            l1.next = subHead;
            return l1;
        } else {
            ListNode subHead = merge2List(l1, l2.next);
            l2.next = subHead;
            return l2;
        }
    }
}
// @lc code=end

