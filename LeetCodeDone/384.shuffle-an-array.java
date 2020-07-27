import java.util.*;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffles = new int[this.nums.length];
        for(int i = 0; i < this.nums.length; i++) {
            shuffles[i] = nums[i];
        }
        for(int i = 0; i < shuffles.length; i++) {
            Random rand = new Random();
            int next = rand.nextInt(i+1);
            int temp = shuffles[i];
            shuffles[i] = shuffles[next];
            shuffles[next] = temp;
        }
        return shuffles;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

