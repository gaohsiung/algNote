import java.util.*;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            while(size-- > 0) {
                Node cur = q.poll();
                if(cur == null) {
                    continue;
                }
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return root;
    }
}
// @lc code=end

