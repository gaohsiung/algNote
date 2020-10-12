/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        Integer curFirst = null;
        Integer curSecond = null;
        Integer curThird = null;
        for (Integer n: nums) {
            if (n.equals(curFirst) || n.equals(curSecond) || n.equals(curThird)) continue;
            if (curFirst == null || n > curFirst) {
                curThird = curSecond;
                curSecond = curFirst;
                curFirst = n;
            } else if (curSecond == null || n > curSecond) {
                curThird = curSecond;
                curSecond = n;
            } else if (curThird == null || n > curThird) {
                curThird = n;
            }
        }
        return curThird == null? curFirst: curThird;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.thirdMax(new int[]{3,2,1});
    }
}
// @lc code=end

