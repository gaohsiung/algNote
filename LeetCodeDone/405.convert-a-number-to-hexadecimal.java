/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, digToHex(num & 15));
            num >>>= 4;
        }
        return sb.toString();

    }

    private String digToHex(int i) {
        if (i < 10) {
            return Integer.toString(i);
        }
        if (i == 10) {
            return "a";
        }
        if (i == 11) {
            return "b";
        }
        if (i == 12) {
            return "c";
        }
        if (i == 13) {
            return "d";
        }
        if (i == 14) {
            return "e";
        }
        if (i == 15) {
            return "f";
        }
        return "Wrong";
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.toHex(26));
    }
}
// @lc code=end

