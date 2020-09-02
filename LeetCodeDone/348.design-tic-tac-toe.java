/*
 * @lc app=leetcode id=348 lang=java
 *
 * [348] Design Tic-Tac-Toe
 */

// @lc code=start
class TicTacToe {

    /** Initialize your data structure here. */
    private int[] rows;
    private int[] cols;
    private int diags;
    private int antidiags;
    private int n;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diags = 0;
        this.antidiags = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // move is always valid
        int toAdd;
        if (player == 1) {
            toAdd = 1;
        } else {
            toAdd = -1;
        }
        this.rows[row] += toAdd;
        this.cols[col] += toAdd;

        if (row == col) {
            this.diags += toAdd;
        }
        if (row + col == this.n - 1) {
            this.antidiags += toAdd;
        }
        if (Math.abs(this.rows[row]) == this.n ||
            Math.abs(this.cols[col]) == this.n ||
            Math.abs(this.diags) == this.n ||
            Math.abs(this.antidiags) == this.n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
// @lc code=end

