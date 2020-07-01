/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            int i = x % 10;
            reverse = reverse * 10 + i;
            x = x / 10;
        }
        if (x == reverse || x == reverse/10) {
            return true;
        }
        return false;



    }
}
// @lc code=end

