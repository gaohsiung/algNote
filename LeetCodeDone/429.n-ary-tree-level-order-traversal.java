import java.util.*;

import List;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node cur;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                curLevel.add(cur.val);
                if (cur.children != null) {
                    for(Node n: cur.children) {
                        queue.offer(n);
                    }
                }

            }
            res.add(curLevel);

        }
        return res;
    }
}
// @lc code=end

