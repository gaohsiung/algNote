import java.util.*;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // c.c.
        if (nums == null || nums.length == 0) return nums;
        if (k >= nums.length) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }

        int[] results = new int[nums.length - k + 1];
        // initialize maxStack
        Deque<Integer> maxStack = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            addNewToMaxStack(maxStack, nums, i);
        }
        results[0] = nums[maxStack.peek()];
        for(int i = 1; i < nums.length - k + 1; i++) {
            if (maxStack.peekFirst() == i-1) {
                maxStack.pollFirst();
            }
            addNewToMaxStack(maxStack, nums, i+k-1);
            results[i] = nums[maxStack.peekFirst()];
        }
        return results;
    }

    private void addNewToMaxStack(Deque<Integer> maxStack, int[] nums, int i) {
        if (maxStack.isEmpty()) {
            maxStack.offerLast(i);
            return;
        }
        if (nums[maxStack.peekLast()] < nums[i]) {
            while(!maxStack.isEmpty() && nums[maxStack.peekLast()] < nums[i]) {
                maxStack.pollLast();
            }
            maxStack.offerLast(i);
        } else {
            maxStack.offerLast(i);
        }
    }
}
// @lc code=end

