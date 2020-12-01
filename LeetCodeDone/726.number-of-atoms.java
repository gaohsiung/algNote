import java.util.*;
/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */

// @lc code=start
class Solution {
  public String countOfAtoms(String formula) {
    Deque<Map<String, Integer>> stack = new ArrayDeque<>();
    stack.push(new HashMap<>());
    int idx = 0;
    while (idx < formula.length()) {
      if (formula.charAt(idx) == '(') {
        stack.push(new HashMap<>());
        idx++;
      } else if (formula.charAt(idx) == ')') {
        int repeat = 1;
        if (idx+1 < formula.length() && formula.charAt(idx+1) >= '0' && formula.charAt(idx+1) <= '9') {
          int end = idx+1;
          while (end < formula.length() && formula.charAt(end) >= '0' && formula.charAt(end) <= '9') { // [idx+1, end-1] is number
            end++;
          }
          repeat = Integer.valueOf(formula.substring(idx+1, end));
          idx = end;
        } else {
          idx++;
        }
        repeatMap(stack.peek(), repeat);
        Map<String, Integer> tempMap = stack.pop();
        combineMap(stack.peek(), tempMap);
      } else {
        int end = idx;
        while (end < formula.length() && formula.charAt(end) != '(' && formula.charAt(end) != ')') {
          end++;
        }
        countSubstring(formula, idx, end - 1, stack.peek()); // [idx, end-1]
        idx = end;
      }
    }
    return sortMap(stack.peek());
  }
  private String sortMap(Map<String, Integer> map) {
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
      @Override 
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getKey().compareTo(e2.getKey());
    }});
    for (Map.Entry<String, Integer> e: map.entrySet()) {
      minHeap.offer(e);
    }
    StringBuilder sb = new StringBuilder();
    while (!minHeap.isEmpty()) {
      sb.append(minHeap.peek().getKey());
      if (minHeap.peek().getValue() > 1) {
        sb.append(minHeap.peek().getValue());
      }
      minHeap.poll();
    }
    return sb.toString();
  }
  
  private void countSubstring(String formula, int start, int end, Map<String, Integer> map) {
    int idx = start;
    while (idx <= end) {
      StringBuilder sb = new StringBuilder();
      sb.append(formula.charAt(idx));
      idx++;
      while (idx <= end && formula.charAt(idx) >= 'a' && formula.charAt(idx) <= 'z') {
        sb.append(formula.charAt(idx++));
      }
      String key = sb.toString();
      StringBuilder count = new StringBuilder();
      while (idx <= end && formula.charAt(idx) >= '0' && formula.charAt(idx) <= '9') {
        count.append(formula.charAt(idx++));
      }
      int val;
      if (count.length() == 0) {
        val = 1;
      } else {
        val = Integer.valueOf(count.toString());
      }
      map.put(key, map.getOrDefault(key, 0) + val);
    }
  }

  private void combineMap(Map<String, Integer> target, Map<String, Integer> map) {
    for (String key: map.keySet()) {
      target.put(key, target.getOrDefault(key, 0) + map.get(key));
    }

  }
  private void repeatMap(Map<String, Integer> map, int rep) {
    for (String key: map.keySet()) {
      map.put(key, map.get(key) * rep);
    }
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.countOfAtoms("(H)"));
  }
}
// @lc code=end
