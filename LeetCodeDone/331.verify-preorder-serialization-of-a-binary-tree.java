/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        int count = 0;
        for(String s: preorder.split(",")) {
            if(s.equals("#")) {
                count++;
            } else {
                if(count >= 1) {
                    return false;
                }
                count--;
            }
        }
        return count == 1;
    }
}
// @lc code=end

