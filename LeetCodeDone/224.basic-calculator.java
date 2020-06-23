import java.util.*;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char cur = s.charAt(i);
            if (isNum(cur)) {
                StringBuilder sb = new StringBuilder();
                while (i< s.length() && isNum(s.charAt(i))) { // !!!
                    sb.append(s.charAt(i));
                    i++;
                }
                numStack.push(Integer.parseInt(sb.toString()));
                if (!signStack.isEmpty() && signStack.peek() != '(') { // !!!
                    update(numStack, signStack);
                }
                continue;
            } else if (isSign(cur) || cur == '(') {
                signStack.push(cur);
            } else if (cur == ')') {
                signStack.pop();
                if (!signStack.isEmpty() && isSign(signStack.peek())) {  // !!
                    update(numStack, signStack);
                }
            }
            i++;
        }
        if (!signStack.isEmpty()) {
            update(numStack, signStack);
        }
        return numStack.peek();
    }

    private void update(Stack<Integer> numStack, Stack<Character> signStack) {
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        char sign = signStack.pop();
        int resultNum = calculate(num1, num2, sign);
        numStack.push(resultNum);
    }


    private Integer calculate(int num1, int num2, char sign) {
        if (sign == '+') {
            return num1 + num2;
        }
        return num2 - num1;
    }

    private boolean isNum(char cur) {
        if (cur == '0' || cur == '1' || cur == '2' || cur == '4' || cur == '5' || 
        cur == '6' || cur == '7' || cur == '8' || cur == '9' || cur == '3') {
            return true;
        }
        return false;
    }
    private boolean isSign(char c) {
        if (c == '+' || c== '-') {
            return true;
        }
        return false;
    }
    public static void main(String[] ss) {
        Solution s = new Solution();
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
// @lc code=end

