/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Robot Room Cleaner
 */

// @lc code=start
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static class Cell {
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31*x + y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Cell) {
                Cell that = (Cell) o;
                return this.x == that.x && this.y == that.y;
            } else {
                return false;
            }
        }
    }

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, new HashSet<Cell>());

    }
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    private void dfs(Robot robot, curX, curY, HashSet<Cell>() visited) {
        

    }

}
// @lc code=end

