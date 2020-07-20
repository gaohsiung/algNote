import java.util.*;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        newNode.neighbors = new ArrayList<>();
        for(Node next: node.neighbors) {
            newNode.neighbors.add(cloneGraph(next));
        }
        return newNode;
    }
}
// @lc code=end

