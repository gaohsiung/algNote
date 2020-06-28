/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 */

// @lc code=start
class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
        reverseSeparate(s);
        return;
        
    }

    private void reverseSeparate(char[] s) {
        int slow = 0;
        int fast = 0;
        while (fast < s.length) {
            while (fast+1 < s.length && s[fast + 1] != ' ') {
                fast++;
            }
            reverse(s, slow, fast);
            if (fast + 1 == s.length) {
                break;
            }
            slow++;
            fast++;
            while (slow == 0 || s[slow - 1] != ' ') {
                slow++;
            }
        }
    }

    private void reverse(char[] s, int left, int right) {
        while (left <= right) {
            swap(s, left++, right--);
        }
        
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] arr = new char[]{'r','e','v',' ','w','o','r','d'};
        sol.reverseWords(arr);
    }
}
// @lc code=end

