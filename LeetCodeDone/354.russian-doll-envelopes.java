import java.util.*;

/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 ||
        envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1]; // strict increasing
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });

        List<Integer> helperList = new ArrayList<>();
        helperList.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int cur = envelopes[i][1];
            if (cur > helperList.get(helperList.size() - 1)) {
                helperList.add(cur);
                continue;
            }
            helperList.set(findMaxSmaller(helperList, cur), cur);
        }
        return helperList.size();

    }
    private int findMaxSmaller(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

