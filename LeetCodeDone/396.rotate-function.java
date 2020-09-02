/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max += i*arr[i];
        }
        int curSum = max;
        for (int i = len - 1; i >= 1; i--) {
            curSum = curSum + sum - len*arr[i];
            max = Math.max(max, curSum);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
// @lc code=end

