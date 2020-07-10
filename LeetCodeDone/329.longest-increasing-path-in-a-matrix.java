/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int max = -1;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, mem));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int rIndex, int cIndex, int[][] mem) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (mem[rIndex][cIndex] > 0) {
            return mem[rIndex][cIndex];
        }
        int ret = 1;
        for(int[] dir: DIRECTIONS) {
            int i = dir[0] + rIndex;
            int j = dir[1] + cIndex;
            if (i >= 0 && i < row && j >= 0 && j < col && matrix[i][j] > matrix[rIndex][cIndex]) {
                ret = Math.max(ret, 1 + dfs(matrix, i, j, mem));
            }
        }
        mem[rIndex][cIndex] = ret;
        return mem[rIndex][cIndex];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
// @lc code=end

