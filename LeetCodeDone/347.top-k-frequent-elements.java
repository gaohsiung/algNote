import java.util.*;


/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
        new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				return e1.getValue()-e2.getValue();
        }});

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) { // offer to greter than size k, then poll!
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
            
    }
    public static void main(String[] ss) {
        Solution s = new Solution();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(s.topKFrequent(nums, k)));
    }

}
// @lc code=end

