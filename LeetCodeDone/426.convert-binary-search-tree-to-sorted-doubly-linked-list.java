/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
// class Node {
//     public int val;
//     public Node left;
//     public Node right;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val,Node _left,Node _right) {
//         val = _val;
//         left = _left;
//         right = _right;
//     }
// };

class Solution {
    private Node head = null;
    private Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        inorder(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        inorder(root.right);
    }
}
// @lc code=end

