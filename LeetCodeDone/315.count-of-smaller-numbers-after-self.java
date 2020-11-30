import java.util.*;
/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
  private static class SegmentTreeNode {
    private int leftBound;
    private int rightBound;
    private int leftSize;
    private SegmentTreeNode left;
    private SegmentTreeNode right;

    private SegmentTreeNode(int leftBound, int rightBound, int leftSize) {
      this.leftBound = leftBound;
      this.rightBound = rightBound;
      this.leftSize = leftSize;
      this.left = null;
      this.right = null;
    }
  }
  private int countLeftSize(SegmentTreeNode root, int idx) {
    SegmentTreeNode cur = root;
    int res = 0;
    while (cur != null) {
      int left = cur.leftBound;
      int right = cur.rightBound;
      int mid = left + (right - left) / 2;
      if (idx <= mid) {
        cur.leftSize--;
        cur = cur.left;
      } else {
        res += cur.leftSize;
        cur = cur.right;
      }
    }
    return res;
  }
  
  public List<Integer> countSmaller(int[] nums) {
    int len = nums.length;
    Integer[] sortedIdx = getSortedIdx(nums);
    SegmentTreeNode root = constructSegmentTree(0, len - 1);
    int[] res = new int[len];

    for (int i = 0; i < len; i++) {
      int curIdx = sortedIdx[i];
      res[curIdx] = countLeftSize(root, len - 1 - curIdx);
    }

    List<Integer> ret = new ArrayList<Integer>();
    for (int i: res) {
      ret.add(i);
    }
    return ret;
  }

  private SegmentTreeNode constructSegmentTree(int leftBound, int rightBound) {
    if (leftBound > rightBound) return null;
    if (leftBound == rightBound) {
      return new SegmentTreeNode(leftBound, rightBound, 1);
    }
    int mid = leftBound + (rightBound - leftBound) / 2;
    SegmentTreeNode root = new SegmentTreeNode(leftBound, rightBound, mid - leftBound + 1);
    root.left = constructSegmentTree(leftBound, mid);
    root.right = constructSegmentTree(mid+1, rightBound);
    return root;
  }

  private Integer[] getSortedIdx(int[] nums) {
    Integer[] ret = new Integer[nums.length];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = i;
    }
    Arrays.sort(ret, new Comparator<Integer>(){
      @Override
      public int compare(Integer i1, Integer i2) {
        if (nums[i1] != nums[i2]) {
          return nums[i2] - nums[i1];
        }
        return i2 - i1;
      }
    });
    return ret;


  }
}
// @lc code=end
