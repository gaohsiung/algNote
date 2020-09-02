/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 */

// @lc code=start
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // c.c.
        if (s == null && t == null) return true;
        if (s.equals(t)) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        if (t.length() - s.length() > 1) return false;
        return isOneEditDistance(s, t, 0);
    }
    

    private boolean isOneEditDistance(String s, String t, int i) {
        if ((s.length()-i) == 0 && (t.length()-i) == 0) return true;
        if ((s.length()-i) == 0 && (t.length()-i) == 1) return true;
        if (s.charAt(i) == t.charAt(i)) return isOneEditDistance(s, t, i+1);
        if (delete(s, i, t)) return true;
        if (replace(s, i, t)) return true;
        return false;
    }

    private boolean replace(String s, int i, String t) {
        return s.substring(i+1).equals(t.substring(i+1));
    }

    private boolean delete(String s, int i, String t) {
        return s.substring(i).equals(t.substring(i+1));
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isOneEditDistance("", ""));
    }
    
}
// @lc code=end

