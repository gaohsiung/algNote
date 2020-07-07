import java.util.*;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        //c.c.
        if (target == null || target.equals("0000")) {
            return 0;
        }
        return -1;

    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
       

    }
}
// @lc code=end

