import java.util.*;
/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<int[]> intervals = transferToInterval(s);
        List<int[]> mergedIntervals = mergeInterval(intervals);
        for(int[] mitv: mergedIntervals) {
            res.add(mitv[1]-mitv[0]+1);
        }

        return res;
    }
    private List<int[]> mergeInterval(List<int[]> intervals) {
        Collections.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        List<int[]> ret = new ArrayList<>();
        int[] cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (cur[1] < intervals.get(i)[0]) {
                ret.add(cur);
                cur = intervals.get(i);
            } else if (cur[1] > intervals.get(i)[0] && cur[1] < intervals.get(i)[1]) {
                cur[1] = intervals.get(i)[1];
            }
        }
        ret.add(cur);
        return ret;
    }

    private List<int[]> transferToInterval(String s) {
        int[][] counts = new int[26][2];
        for (int[] count: counts) {
            count[0] = -1;
            count[1] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counts[c-'a'][0] == -1) {
                counts[c-'a'][0] = i;
            }
            counts[c-'a'][1] = i;
        }
        List<int[]> ret = new ArrayList<>();
        for(int[] count: counts) {
            if (count[0] != -1) {
                ret.add(count);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
// @lc code=end

