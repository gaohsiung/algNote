import java.util.*;

/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int trapRainWater(int[][] heightMap) {
        // c.c.
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        // some parameters
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        //initialize heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                int row1 = i1 / col;
                int col1 = i1 % col;
                int row2 = i2 / col;
                int col2 = i2 % col;
                return heightMap[row1][col1] - heightMap[row2][col2];
            }
        });
        // add boundary
        for(int i = 0; i < row; i++) {
            // first column
            heap.offer(i*col + 0);
            visited[i][0] = true;
            // last column
            heap.offer(i*col + col - 1);
            visited[i][col - 1] = true;
        }
        for (int j = 1; j < col-1; j++) {
            // first row
            heap.offer(0*col + j);
            visited[0][j] = true;
            // last row
            heap.offer((row-1)*col + j);
            visited[row-1][j] = true;
        }
        //bfs
        int result = 0;
        int curMax = Integer.MIN_VALUE;
        while(!heap.isEmpty()) {
            int cur = heap.poll();
            int i = cur / col;
            int j = cur % col;
            if (heightMap[i][j] > curMax) {
                curMax = heightMap[i][j];
            }
            for (int[] dir: DIRECTIONS) {
                int ii = dir[0] + i;
                int jj = dir[1] + j;
                if (ii >= 0 && ii < row && jj >= 0 && jj < col
                    && visited[ii][jj] == false) {
                    visited[ii][jj] = true;
                    result += Math.max(0, curMax - heightMap[ii][jj]);
                    heap.offer(ii*col+jj);
                }
            }
        }
        return result;

    }
}
// @lc code=end

