/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            swap(s, left, right);
            left++;
            right--;
        }
        return;
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }


}
// @lc code=end

