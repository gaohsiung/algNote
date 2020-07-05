/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    private int[][] matrix;
    private boolean isValid;
    private int[][] sums;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            isValid = false;
            return;
        } else {
            isValid = true;
        }
        sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sums[i][j] = sums[i][j-1] + matrix[i][j];
                } else if (j == 0) {
                    sums[i][j] = sums[i-1][j] + matrix[i][j];
                } else {
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
                }
            }
        }
        return;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!isValid) {
            return -1;
        }
        if (row1 - 1 < 0 && col1 - 1 < 0) {
            return sums[row2][col2];
        } else if (row1 - 1 < 0) {
            return sums[row2][col2] - sums[row2][col1-1];
        } else if (col1 - 1 < 0) {
            return sums[row2][col2] - sums[row1 - 1][col2];
        } else {
            return sums[row2][col2] - sums[row2][col1-1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
        }
    }
    public static void main(String[] args) {
        NumMatrix sol = new NumMatrix(new int[][]{{3,0,1,4,2},
                                                  {5,6,3,2,1},
                                                  {1,2,0,1,5},
                                                  {4,1,0,1,7},
                                                  {1,0,3,0,5}});
        System.out.println(sol.sumRegion(2, 1, 4, 3));

    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

