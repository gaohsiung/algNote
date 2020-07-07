import java.util.*;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];
        Queue<Integer> q = new LinkedList<>();
        preparePacStart(matrix, q, pac);
        bfs(matrix, pac, atl, q, res);
        prepareAtlStart(matrix, q, atl);
        bfs(matrix, atl, pac, q, res);
        return res;
    }

    private void prepareAtlStart(int[][] matrix, Queue<Integer> q, boolean[][] atl) {
        int col = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            q.offer(i*col + col-1);
            atl[i][col-1] = true;
        }
        for (int j = 0; j < col-1; j++) {
            q.offer((row - 1) * col + j);
            atl[row - 1][j] = true;
        }
    }

    private void preparePacStart(int[][] matrix, Queue<Integer> q, boolean[][] pac) {
        for (int i = 0; i < matrix.length; i++) {
            q.offer(i*matrix[0].length + 0);
            pac[i][0] = true;
        }
        for (int j = 1; j < matrix[0].length; j++) {
            q.offer(0 + j);
            pac[0][j] = true;
        }
    }

    private void bfs(int[][] matrix, boolean[][] selfy, boolean[][] other, Queue<Integer> q, List<List<Integer>> res) {
        int row = matrix.length;
        int col = matrix[0].length;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int i = cur / col;
            int j = cur % col;
            if (other[i][j] == true) {
                List<Integer> coordinate = new LinkedList<>();
                coordinate.add(i);
                coordinate.add(j);
                res.add(coordinate);
            }
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col 
                    && selfy[ii][jj] == false && matrix[i][j] <= matrix[ii][jj]) {
                    selfy[ii][jj] = true;
                    q.offer(ii * col + jj);
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pacificAtlantic(new int[][] {{1,2,2,3,5},
        {3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
}
// @lc code=end

