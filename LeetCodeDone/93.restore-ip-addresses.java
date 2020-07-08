import java.util.*;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {

            return res;
        }
        dfs(s, new StringBuilder(), 0, res, 0);
        return res;
    }

    private void dfs(String s, StringBuilder sb, int index, List<String> res, int partNo) {
        if (index == s.length() && partNo == 4) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if (index == s.length() || partNo >= 4) {
            return;
        }
        int sbLen = sb.length();
        for(int i = 1; i <= 3; i++) {
            if (index+ i > s.length()){
                break;
            }
            String curString = s.substring(index, index+i);
            int curValue = Integer.parseInt(curString);
            if (curValue <= 255) {
                sb.append(curString+".");
                dfs(s, sb, index+i, res, partNo+1);
                sb.setLength(sbLen);
            }
            if (curString.equals("0")) {
                break;
            }
        }
    }
}
// @lc code=end

