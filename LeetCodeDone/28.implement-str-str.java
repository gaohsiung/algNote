/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int hayLen = haystack.length();
        int neeLen = needle.length();
        if (neeLen > hayLen) {
            return -1;
        }
        long hayHash = 0;
        long neeHash = 0;
        long base = 26;
        long modulus = (long)Math.pow(2,31);
        for (int i = 0; i < neeLen; i++) {
            hayHash = (hayHash*base + haystack.charAt(i) - 'a') % modulus;
            neeHash = (neeHash*base + needle.charAt(i) - 'a') % modulus;
        }
        if (neeHash == hayHash) {
            return 0;
        }
        long highBase = 1;
        for (int i = 1; i <= neeLen; i++) {
            highBase = (highBase * base) % modulus;
        }
        for (int i = 1; i < hayLen - neeLen + 1; i++) {
            hayHash = (hayHash * base - highBase * (haystack.charAt(i-1) - 'a')
                    + (haystack.charAt(i + neeLen - 1) - 'a')) % modulus;
            if (hayHash == neeHash) {
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("hello", "ll"));
    }
}
// @lc code=end

