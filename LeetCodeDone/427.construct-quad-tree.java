/*
 * @lc app=leetcode id=427 lang=java
 *
 * [427] Construct Quad Tree
 */

// @lc code=start

// Definition for a QuadTree node.
/*
class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {
    this.val = false;
    this.isLeaf = false;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(boolean val, boolean isLeaf) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.bottomLeft = bottomLeft;
    this.bottomRight = bottomRight;
  }
};
*/
class Solution {

  public Node construct(int[][] grid) {
    return dfs(grid, 0, 0, grid.length-1, grid[0].length-1);
  }
  private Node dfs(int[][] grid, int r1, int c1, int r2, int c2) {
    boolean val = grid[r1][c1] == 1;
    if (r1 == r2 && c1 == c2) {
      return new Node(val, true);
    }
    Node curNode = new Node(val, false);
    Node topLeft = dfs(grid, r1, c1, (r1+r2)/2, (c1+c2)/2);
    Node topRight = dfs(grid, r1, (c1+c2)/2+1, (r1+r2)/2, c2);
    Node bottomLeft = dfs(grid, (r1+r2)/2+1, c1, r2, (c1+c2)/2);
    Node bottomRight = dfs(grid, (r1+r2)/2+1, (c1+c2)/2+1, r2, c2);
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
      ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
        (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
      curNode.isLeaf = true;
      curNode.val = topLeft.val;
      return curNode;
    }
    curNode.topLeft = topLeft;
    curNode.topRight = topRight;
    curNode.bottomLeft = bottomLeft;
    curNode.bottomRight = bottomRight;
    return curNode;
  }
}
// @lc code=end
