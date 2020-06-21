/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // if (n <= 0) throw new Exception;
        // if (isBadVersion(n)) throw new IllegalArgumentException();
        
        int left = 0;
        int right = n;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return isBadVersion(left)? left:right;
    }
}
// @lc code=end

