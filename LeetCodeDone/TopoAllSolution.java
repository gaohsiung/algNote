import java.util.*;

public class TopoAllSolution {

    public void helper(List<List<Integer>> graph, List<List<Integer>> res, List<Integer> path, int[] indegrees, int N, boolean[] visited) {
        for (int v = 0; v < N; v++) {
            if (indegrees[v] == 0 && !visited[v]) {
                
                for (int next: graph.get(v)) {
                    indegrees[next]--;
                }

                path.add(v);
                visited[v] = true;

                helper(graph, res, path, indegrees, N, visited);

                for (int next: graph.get(v)) {
                    indegrees[next]++;
                }

                path.remove(path.size() - 1);
                visited[v] = false;
            }
        }

        if (path.size() == N) {
            res.add(new ArrayList<>(path));
        }
    }

    public List<List<Integer>> findAllTopologicalOrders(List<List<Integer>> graph) {

        int n = graph.size();

        int[] indegrees = new int[n];

        for (List<Integer> node : graph) {
            for (Integer p : node) {
                indegrees[p]++;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        helper(graph, res, new ArrayList<>(), indegrees, n, new boolean[n]);

        return res;
    }
    public static void main(String[] args) {
        TopoAllSolution sol = new TopoAllSolution();
        Integer[][] arrayInput = new Integer[][]{{1},{2,5},{3},{},{1},{6},{}};
        List<List<Integer>> graph = new ArrayList<>();
        for(Integer[] edge: arrayInput) {
            graph.add(Arrays.asList(edge));
        }
        System.out.println(graph);
        System.out.println(sol.findAllTopologicalOrders(graph));

    }
}