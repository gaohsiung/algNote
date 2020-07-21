import java.util.*;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    private class Vertex {
        int id;
        Vertex dad;
        int size;
        Vertex(int id) {
            this.id = id;
            this.size = 1;
            this.dad = this;
        }
    }
    private class UnionFind {
        List<Vertex> accounts;
        UnionFind(){
            this.accounts = new LinkedList<>();
        }
        boolean find(Vertex v1, Vertex v2) {
            return getRoot(v1) == getRoot(v2);
        }
        Vertex getRoot(Vertex v) {
            Vertex cur = v;
            while(cur.dad != cur) {
                cur.dad = cur.dad.dad;
                cur = cur.dad;
            }
            v.dad = cur;
            return cur;
        }
        void union(Vertex v1, Vertex v2) {
            Vertex root1 = getRoot(v1);
            Vertex root2 = getRoot(v2);
            if (root1.size > root2.size) {
                root2.dad = root1;
                root1.size += root2.size;
            } else {
                root1.dad = root2;
                root2.size += root1.size;
            }
        }
        void addVetex(Vertex v) {
            this.accounts.add(v);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // c.c.
        UnionFind uf = new UnionFind();
        Map<String, Vertex> emailToVertex = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            Vertex v = new Vertex(i);
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToVertex.containsKey(email)) {
                    uf.union(v, emailToVertex.get(email));
                } else {
                    emailToVertex.put(email, v);
                }
            }
            uf.addVetex(v);
        }
        
        Map<Vertex, Set<String>> vertexToEmail = new HashMap<>();
        for(Vertex v: uf.accounts) {
            Vertex dad = uf.getRoot(v);
            List<String> account = accounts.get(v.id);
            if (!vertexToEmail.containsKey(dad)) {
                Set<String> set =  new HashSet<>();
                vertexToEmail.put(dad, set);
            }
            for(int i = 1; i < account.size(); i++) {
                vertexToEmail.get(dad).add(account.get(i));
            }
        }
        List<List<String>> res = new LinkedList<>();
        for(Map.Entry<Vertex, Set<String>> e: vertexToEmail.entrySet()) {
            List<String> curList = new LinkedList<>();
            for(String s: e.getValue()) {
                curList.add(s);
            }
            Collections.sort(curList);
            curList.add(0, accounts.get(e.getKey().id).get(0));
            res.add(curList);
        }
        return res;


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] array = new String[][]{{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for(String[] a: array) {
            accounts.add(Arrays.asList(a));
        }
        System.out.println(sol.accountsMerge(accounts));
    }
}
// @lc code=end

