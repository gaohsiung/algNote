import java.util.*;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        
        Map<Character, Set<Character>> graph = buildGraph(words);
        StringBuilder sb = new StringBuilder();
        Boolean[] visited = new Boolean[26];
        for (Map.Entry<Character, Set<Character>> e : graph.entrySet()) {
            if (e.getValue().contains('\0') || hasCycle(e.getKey(), graph, sb, visited)) {
                return "";
            }
        }
        sb.reverse();
        addOtherChar(sb, words);
        return sb.toString();
    }

    

    private void addOtherChar(StringBuilder sb, String[] words) {
        for(String s: words) {
            for (char c: s.toCharArray()) {
                if (sb.indexOf(String.valueOf(c)) == -1){
                    sb.append(c);
                }
            }
        }
    }

    private boolean hasCycle(Character cur, Map<Character, Set<Character>> graph, 
                             StringBuilder sb, Boolean[] visited) {
        if(visited[cur - 'a'] != null) {
            return visited[cur - 'a'];
        }
        visited[cur - 'a'] = true;
        if (graph.containsKey(cur)) {
            for(Character c: graph.get(cur)) {
                if(c == '\0' || hasCycle(c, graph, sb, visited)) {
                    return true;
                }
            }
        }
        visited[cur - 'a']  =false;
        sb.append(cur);
        return false;
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for(int i = 0; i < words.length;i++) {
            for(int j = i + 1; j < words.length; j++) {
                char[] edge = getEdge(words, i, j);
                if (edge == null) continue;
                if (!graph.containsKey(edge[0])) {
                    graph.put(edge[0], new HashSet<Character>());
                }
                graph.get(edge[0]).add(edge[1]);
            }
        }
        return graph;
    }

    private char[] getEdge(String[] words, int i, int j) {
        String word1 = words[i];
        String word2 = words[j];
        int p;
        for(p = 0; p < word1.length() && p < word2.length(); p++) {
            if (word1.charAt(p) == word2.charAt(p)) {
                continue;
            }
            return new char[]{word1.charAt(p), word2.charAt(p)};
        }
        if (word1.length() == word2.length() || p == word1.length()) { // special case: ["abc","ab"]
            return null;
        }
        return new char[]{word1.charAt(p),'\0'};
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.alienOrder(new String[]{"xryjf","occk","qh","nala","iagpveiwrf","x","svfvd","zznqadu","nfma","tbdqe","myn","cwz","zmp","sjltjsraqs","rhbajevcg","yejxsblxa","gwra","tbltkce"}));
    }
}
// @lc code=end

// 注意special case: ["abc","ab"]，这里c在' '的前面，所以是不valid的情况！一般得clarify ’ ‘和char的关系，这里默认’ ‘是一定要排在所有char的前面！

