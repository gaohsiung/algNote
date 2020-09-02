import java.util.*;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        // c.c.
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Map<MySlope, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            int duplicateNo = 1;
            for(int j = i+1; j< points.length;j++) {
                if ((points[i][0] == points[j][0]) && (points[i][1] == points[j][1])) {
                    duplicateNo++;
                    continue;
                }
                MySlope curSlope;
                if (points[i][0] == points[j][0]) {
                    curSlope = new MySlope((double) Integer.MAX_VALUE);
                } else {
                    curSlope = new MySlope(((double)(points[j][1] - points[i][1]))/((double)(points[j][0] - points[i][0])));
                }
                int counts = map.getOrDefault(curSlope, 0) + 1;
                map.put(curSlope, counts);
            }
            max = Math.max(duplicateNo, max);
            for (Map.Entry<MySlope, Integer> e: map.entrySet()){
                max = Math.max(e.getValue()+duplicateNo, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        float f1 = 0.0f;
        float f2 = -0.0f;
        float f3 = -0.0f + 0.0f;
        System.out.println(f1 == f2); // true
        System.out.println(((Float)(f1)).equals(f2)); // false
        Set<Float> testSet = new HashSet<>();
        testSet.add(f1);
        testSet.add(f3);
        System.out.println(testSet.size()); // 1
        testSet.add(f2);
        System.out.println(testSet.size()); // 2
        System.out.println("-----------------------");
        double d1 = ((double)(94911150))/((double)(94911151));
        double d2 = ((double)(94911151))/((double)(94911152));
        System.out.println(d1 == d2); // true
        System.out.println(((Double)d1).equals(d2)); // true
        System.out.println(((Double)d1).equals((Double)d2)); // true
    }
}
class MySlope {
    double val;

    MySlope(double val){
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MySlope)) {
            return false;
        }
        MySlope that = (MySlope) o;
        return Math.abs(this.val - that.val) <= 0.01;
    }

    @Override
    public int hashCode(){
        return ((int) this.val)*31;
    }

}
// @lc code=end

