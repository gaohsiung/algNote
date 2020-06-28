/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        char[] arr = s.toCharArray();
        arr = removeExtraSpace(arr);
        if (arr.length == 0) {
            return "";
        }
        reverse(arr, 0, arr.length - 1);
        reverseSeparate(arr);

        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        int left = i;
        int right = j;
        while (left <= right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void reverseSeparate(char[] arr) {
        int left = 0;
        int right = 0;
        while (right < arr.length - 1) {
            while (right+1 < arr.length && arr[right+1] != ' ') {
                right++;
            }
            reverse(arr, left, right);
            left++;
            while (left < arr.length && (left == 0 || arr[left-1] != ' ')) {
                left++;
            }
            if (right >= arr.length - 1) {
                break;
            }
            right++;
        }
    }


    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private char[] removeExtraSpace(char[] arr) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            while (fast < arr.length && (arr[fast] == ' ' && (fast == 0 || arr[fast-1] == ' '))) {
                fast++;
            }
            if (fast == arr.length) {
                break;
            }
            arr[slow++] = arr[fast++];
        }
        int newLength;
        if (slow == 0) {
            return new char[0];
        }
        if (arr[slow-1] == ' ') {
            newLength = slow - 1;
        } else {
            newLength = slow;
        }
        char[] res = new char[newLength];
        for (int i = 0; i < newLength; i++) {
            res[i] = arr[i];
        }
        return res;

    }
    public static void main(String[] ss) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("  reverse the   word "));
    }
}
// @lc code=end

