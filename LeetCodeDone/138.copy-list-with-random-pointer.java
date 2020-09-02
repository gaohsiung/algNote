import java.util.*;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> originToCopy = new HashMap<>();
        Node cur = head;
        Node dummy = new Node(0);
        Node copyCur = dummy;

        while (cur != null) {
            Node node;
            if (originToCopy.containsKey(cur)) {
                node = originToCopy.get(cur);
            } else {
                node = new Node(cur.val);
                originToCopy.put(cur, node);
            }
            copyCur.next = node;

            Node ranNode;
            if (cur.random == null) {
                ranNode = null;
            } else if (originToCopy.containsKey(cur.random)) {
                ranNode = originToCopy.get(cur.random);
            } else {
                ranNode = new Node(cur.random.val);
                originToCopy.put(cur.random, ranNode);
            }
            node.random = ranNode;
            copyCur = copyCur.next;
            cur = cur.next;
        }
        return dummy.next;

    }
}
// @lc code=end

