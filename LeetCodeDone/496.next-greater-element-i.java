import java.util.*;
/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> findNextGreaterElement = new HashMap<>();
        Stack<Integer> descStack = new Stack<>();
        for (int n: nums2) {
            if (descStack.isEmpty()) {
                descStack.push(n);
            } else if (descStack.peek() == n) {
                throw new IllegalArgumentException("Duplicates are not allowed");
            } else if (descStack.peek() < n) {
                while (!descStack.isEmpty() && descStack.peek() < n) {
                    findNextGreaterElement.put(descStack.pop(), n);
                }
                descStack.push(n);
            } else if (descStack.peek() > n) {
                descStack.push(n);
            }
        }
        while (!descStack.isEmpty()) {
            findNextGreaterElement.put(descStack.pop(), -1);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = findNextGreaterElement.get(nums1[i]);
        }
        return ret;
    }
}
// @lc code=end

