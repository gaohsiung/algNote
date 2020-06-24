import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.children != null) {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }

        return res;
    }
    public static void main(String[] sss) {
        Solution sol = new Solution();
        ArrayList<Node> alist;

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        alist = new ArrayList<>();
        Collections.addAll(alist, n3, n2, n4);
        n1.children = alist;
        alist = new ArrayList<>();
        Collections.addAll(alist, n5, n6);
        n3.children = alist;

        System.out.println(sol.preorder(n1).toString());

    }
}
// @lc code=end

