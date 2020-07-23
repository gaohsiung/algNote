import java.util.*;

/*
 * @lc app=leetcode id=296 lang=java
 *
 * [296] Best Meeting Point
 */

// @lc code=start
class Solution {
    public int minTotalDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> toFindRowMedianList = new ArrayList<>();
        List<Integer> toFindColMedianList = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    toFindRowMedianList.add(i);
                }
            }
        }
        for(int j = 0; j < col; j++) {
            for(int i = 0; i < row; i++) {
                if (grid[i][j] == 1) {
                    toFindColMedianList.add(j);
                }
            }
        }
        int rowMedian = toFindRowMedianList.get(toFindRowMedianList.size() / 2);
        int colMedian = toFindColMedianList.get(toFindColMedianList.size() / 2);
        int sum = 0;
        for (int i: toFindRowMedianList) {
            sum += Math.abs(rowMedian - i);
        }
        for (int j: toFindColMedianList) {
            sum += Math.abs(colMedian - j);
        }
        return sum;
    }
}
// @lc code=end

