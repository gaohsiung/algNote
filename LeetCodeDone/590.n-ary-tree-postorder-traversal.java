import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stackNode = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();

        Node cur = root;
        stackNode.push(root);
        while (!stackNode.isEmpty()) {
            cur = stackNode.pop();
            stackVal.push(cur.val);
            if (cur.children != null) {
                for (int i = 0; i < cur.children.size(); i++) {
                    stackNode.push(cur.children.get(i));
                }
            }
        }
        while (!stackVal.isEmpty()) {
            res.add(stackVal.pop());
        }
        return res;
        
    }
}
// @lc code=end

