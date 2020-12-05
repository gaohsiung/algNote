import java.util.*;
/*
 * @lc app=leetcode id=1136 lang=java
 *
 * [1136] Parallel Courses
 */

// @lc code=start
class Solution {
  public int minimumSemesters(int n, int[][] relations) {
    Map<Integer, List<Integer>> preToCourse = new HashMap<>();
    int[] indegree = new int[n+1];
    for (int[] relation: relations) {
      if (!preToCourse.containsKey(relation[0])) {
        preToCourse.put(relation[0], new ArrayList<>());
      }
      preToCourse.get(relation[0]).add(relation[1]);
      indegree[relation[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int semester = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int curCourse = queue.poll();
        if (!preToCourse.containsKey(curCourse)) {
          continue;
        }
        for (int nextCourse: preToCourse.get(curCourse)) {
          indegree[nextCourse]--;
          if (indegree[nextCourse] == 0) {
            queue.offer(nextCourse);
          }
        }
        preToCourse.remove(curCourse);
      }
      semester++;
    }
    return preToCourse.size() == 0 ? semester:-1;
  }
}
// @lc code=end
