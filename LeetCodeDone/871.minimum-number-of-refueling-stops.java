import java.util.*;
/*
 * @lc app=leetcode id=871 lang=java
 *
 * [871] Minimum Number of Refueling Stops
 */

// @lc code=start
class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    // c.c.
    // e.c.
    if (stations.length == 0) {
      return startFuel >= target?0:-1;
    }
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
      @Override
      public int compare(int[] station1, int[] station2) {
        return station2[1] - station1[1];
      }
    });
    int canReach = startFuel;
    int refuelNo = 0;
    int i = 0;
    while (true) {
      if (canReach >= target) {
        return refuelNo;
      }
      while (i < stations.length && stations[i][0] <= canReach) {
        maxHeap.offer(stations[i]);
        i++;
      }
      while (!maxHeap.isEmpty()) {
        int[] curStation = maxHeap.poll();
        canReach += curStation[1];
        refuelNo++;
        if (canReach >= target) return refuelNo;
        if (i < stations.length && canReach >= stations[i][0]) break;
      }
      if (maxHeap.isEmpty() && (i >= stations.length || canReach < stations[i][0])) {
        return -1;
      }
    }
  }
  // 100\n10\n[[10,60],[20,30],[30,30],[60,40]]
  // 100\n1\n[[10,100]]
}
// @lc code=end
