import java.util.*;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    private class Vertex {
        String name;
        double val;
        Vertex dad;
        int size;
        Vertex(String name, double val) {
            this.name = name;
            this.val = val;
            this.dad = this;
            this.size = 1;
        }
    }
    private class UnionFind {
        Map<String,Vertex> vertexMap;
        
        UnionFind(){
            this.vertexMap = new HashMap<>();
        }

        Vertex getVertex(String s) {
            if (!vertexMap.containsKey(s)) {
                vertexMap.put(s, new Vertex(s, 1));
            }
            return vertexMap.get(s);
        }

        boolean find(Vertex v1, Vertex v2) {
            return getRoot(v1) == getRoot(v2);
        }

        private Vertex getRoot(Vertex v) {
            Vertex cur = v;
            double multiple = v.val;
            while(cur.dad != cur) {
                multiple *= cur.dad.val;
                cur.dad = cur.dad.dad;
                cur = cur.dad;
            }
            v.dad = cur;
            v.val = multiple;
            return cur;
        }

        public void union(Vertex v1, Vertex v2, double val) {
            Vertex dad1 = getRoot(v1);
            Vertex dad2 = getRoot(v2);
            if (dad1.size > dad2.size) {
                dad2.dad = dad1;
                dad1.size += dad2.size;
                dad2.val = val * v1.val / v2.val;
            } else {
                dad1.dad = dad2;
                dad2.size += dad1.size;
                dad1.val = v2.val / v1.val / val;
            }
        }
        public boolean containsVertex(String s) {
            return vertexMap.containsKey(s);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        // c.c.
        if (equations.size() != values.length) return res;

        UnionFind uf = new UnionFind();
        for(int i = 0; i < equations.size(); i++) {
            Vertex v1 = uf.getVertex(equations.get(i).get(0));
            Vertex v2 = uf.getVertex(equations.get(i).get(1));
            if(!uf.find(v1, v2)) {
                uf.union(v1, v2, values[i]);
            }
        }
        for(int i = 0; i < queries.size(); i++) {
            if ((!uf.containsVertex(queries.get(i).get(0))) || (!uf.containsVertex(queries.get(i).get(1)))) {
                res[i] = -1;
                continue;
            }
            Vertex v1 = uf.getVertex(queries.get(i).get(0));
            Vertex v2 = uf.getVertex(queries.get(i).get(1));
            if(!uf.find(v1, v2)) {
                res[i] = -1;
            } else {
                res[i] = v2.val / v1.val;
            }
        }
        return res;
    }
}
// @lc code=end

