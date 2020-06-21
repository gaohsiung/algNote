import java.util.*;

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new ArrayList<Integer>();
        }

        int closestInd = findClosestIndex(arr, x);
        return findK(arr, closestInd, k, x);
    }

    private int findClosestIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
            return left;
        } else {
            return right;
        }
    }

    private List<Integer> findK(int[] arr, int closestInd, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = closestInd;
        int end = closestInd;
        int count = 1;
        while (count < k) {
            if (start == 0 && end == arr.length - 1) {
                break;
            } else if (start == 0) {
                end++;
            } else if (end == arr.length - 1) {
                start--;
            } else {
                if (Math.abs(arr[start - 1] - x) <= Math.abs(arr[end + 1] - x)) {
                    start--;
                } else {
                    end++;
                }
            }
            count++;
        }
        for (int i = start; i <= end; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[] {1,3};
        int k = 1;
        int x = 2;
        System.out.println(sol.findClosestElements(arr, k, x).toString());
    }

}
// @lc code=end

