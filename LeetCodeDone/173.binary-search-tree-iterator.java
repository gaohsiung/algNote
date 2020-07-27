/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode root;
    Stack<TreeNode> helperStack;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.helperStack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            this.helperStack.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = this.helperStack.pop();
        int ret = cur.val;
        cur = cur.right;
        while(cur != null) {
            this.helperStack.push(cur);
            cur = cur.left;
        }
        return ret;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.helperStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

