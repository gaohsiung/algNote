import java.util.*;
/*
 * @lc app=leetcode id=1135 lang=java
 *
 * [1135] Connecting Cities With Minimum Cost
 */

// @lc code=start
class Solution {
  public int minimumCost(int n, int[][] connections) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(connections.length, new Comparator<int[]>(){
      @Override
      public int compare(int[] arr1, int[] arr2) {
        return arr1[2] - arr2[2];
      }
    });
    minHeap.addAll(Arrays.asList(connections));

    int cost = 0;
    UnionFind uf = new UnionFind(n);
    while (!minHeap.isEmpty()) {
      int[] curEdge = minHeap.poll();
      if (!uf.find(curEdge[0], curEdge[1])) {
        uf.union(curEdge[0], curEdge[1]);
        cost += curEdge[2];
      }
    }
    return uf.maxSize == n?cost:-1;
  }
  private static class UnionFind {
    private int[] parent;
    private int[] size;
    private int maxSize;

    private UnionFind(int n) {
      this.parent = new int[n+1];
      this.size = new int[n+1];
      this.maxSize = 1;
      for (int i = 1; i <= n; i++) {
        this.parent[i] = i;
        this.size[i] = 1;
      }
    }

    private boolean find(int v1, int v2) {
      int root1 = getRoot(v1);
      int root2 = getRoot(v2);
      return root1 == root2;
    }
    private void union(int v1, int v2) {
      int root1 = getRoot(v1);
      int root2 = getRoot(v2);
      if (size[root1] > size[root2]) {
        parent[root2] = root1;
        size[root1] += size[root2];
        maxSize = Math.max(maxSize, size[root1]);
      } else {
        parent[root1] = root2;
        size[root2] += size[root1];
        maxSize = Math.max(maxSize, size[root2]);
      }
    }

    private int getRoot(int vertex) {
      int cur = vertex;
      while (cur != parent[cur]) {
        parent[cur] = parent[parent[cur]];
        cur = parent[cur];
      }
      parent[vertex] = cur;
      return cur;
    }

  }
}
// @lc code=end
