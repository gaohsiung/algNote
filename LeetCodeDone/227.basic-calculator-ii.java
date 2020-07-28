import javax.management.RuntimeErrorException;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int prevVal = 0;
        Character sign = null;
        int i = 0;
        while(i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int val = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                if (sign != null) {
                    int[] tempRes = calculate(sign, val, prevVal, sum);
                    sum = tempRes[0];
                    prevVal = tempRes[1];
                } else {
                    sum = val;
                    prevVal = val;
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                sign = s.charAt(i);
                i++;
            } else {
                i++;
            }
        }
        return sum;
    }

    private int[] calculate(Character sign, int curVal, int prevVal, int sum) {
        if (sign == '+') {
            return new int[]{sum+curVal, curVal};
        } else if (sign == '-') {
            return new int[]{sum-curVal, -curVal}; // notice!!! negative sign!!!
        } else if (sign == '*') {
            return new int[]{(sum-prevVal)+prevVal*curVal, prevVal*curVal};
        } else if (sign == '/') {
            return new int[]{(sum-prevVal)+prevVal/curVal, prevVal/curVal};
        } else {
            throw new IllegalArgumentException("???");
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculate("12-3*4"));
    }
}
// @lc code=end

