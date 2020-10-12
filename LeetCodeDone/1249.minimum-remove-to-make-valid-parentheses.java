/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] charArr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                count++;
            } else if (charArr[i] == ')' && count == 0) {
                charArr[i] = '0';
            } else if (charArr[i] == ')') {
                count--;
            } else {
                continue;
            }
        }
        count = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] == ')') {
                count++;
            } else if (charArr[i] == '(' && count == 0) {
                charArr[i] = '0';
            } else if (charArr[i] == '(') {
                count--;
            } else {
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: charArr) {
            if (c != '0') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

