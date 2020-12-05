import java.util.*;
/*
 * @lc app=leetcode id=267 lang=java
 *
 * [267] Palindrome Permutation II
 */

// @lc code=start
class Solution {
  public List<String> generatePalindromes(String s) {
    // initialize
    HashMap<Character, Integer> counts = new HashMap<>();
    List<String> res = new ArrayList<>();
    for (char c: s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    // pre check and get permu list
    int oddNumber = 0;
    Character oddChar = null;
    List<Character> permutation = new ArrayList<>();
    for (char key: counts.keySet()) {
      if (oddNumber == 0 && counts.get(key) % 2 == 1) {
        oddNumber = 1;
        oddChar = key;
      } else if (counts.get(key) % 2 == 1) {
        return res;
      } else { // even counts
        for (int i = 1; i <= counts.get(key)/2; i++) {
          permutation.add(key);
        }
      }
    }
    if (oddNumber == 1) {
      for (int i = 1; i <= counts.get(oddChar)/2; i++) {
        permutation.add(oddChar);
      }
    }
    // get all permutation
    Collections.sort(permutation);
    List<StringBuilder> tempRes = new ArrayList<>();
    dfs(permutation, 0, tempRes);
    for (StringBuilder sb: tempRes) {

      if (oddNumber == 0) {
        StringBuilder newSb = new StringBuilder(sb);
        sb.append(newSb.reverse());
        res.add(sb.toString());
      } else {
        StringBuilder newSb = new StringBuilder(sb);
        sb.append(oddChar);
        sb.append(newSb.reverse());
        res.add(sb.toString());
      }
    }
    return res;


  }
  private void dfs(List<Character> permList, int idx, List<StringBuilder> res) {
    if (idx == permList.size()) {
      StringBuilder sb = new StringBuilder();
      for (Character c: permList) {
        sb.append(c);
      }
      res.add(sb);
      return;
    }
    Set<Character> checkDups = new HashSet<>();
    for (int i = idx; i < permList.size(); i++) {
      if (checkDups.contains(permList.get(i))) {
        continue;
      }
      checkDups.add(permList.get(i));
      swap(permList, i, idx);
      dfs(permList, idx+1, res);
      swap(permList, i, idx); 
    }
  }
  private void swap(List<Character> list, int i1, int i2) {
    Character temp = list.get(i1);
    list.set(i1, list.get(i2));
    list.set(i2, temp);
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.generatePalindromes("aabb");
  }
}
// @lc code=end
