import java.util.*;

/**
 * Definition for Directed graph. class DirectedGraphNode { int label;
 * ArrayList<DirectedGraphNode> neighbors; DirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<DirectedGraphNode>(); } };
 */
class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};

public class T127 {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        // c.c.

        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Boolean> visited = new HashMap<>();
        for(DirectedGraphNode startV: graph) {
            if (hasCycle(startV, graph, visited, res)) {
                throw new IllegalArgumentException("Hac cycle");
            }
        }
        return res;
    }

	private boolean hasCycle(DirectedGraphNode curVertex, ArrayList<DirectedGraphNode> graph,
			Map<DirectedGraphNode, Boolean> visited, ArrayList<DirectedGraphNode> res) {
        if (visited.containsKey(curVertex)) {
            return visited.get(curVertex);
        }
        visited.put(curVertex, true);

        for(DirectedGraphNode next: curVertex.neighbors) {
            if (hasCycle(next, graph, visited, res)) {
                return true;
            }
        }
        visited.put(curVertex, false);
        res.add(0, curVertex);
		return false;
	}
}
