import java.util.*;

/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // c.c.

        Map<Character, Integer> signLevel = new HashMap<>();
        signLevel.put('+', 1);
        signLevel.put('-', 1);
        signLevel.put('*', 2);
        signLevel.put('/', 2);

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        int i = 0;
        signStack.push('(');
        while(i <= s.length()) {
            if (i == s.length() || s.charAt(i) == ')') {
                while(signStack.peek() != '(') {
                    updateStacks(numStack, signStack);
                }
                signStack.pop();
                i++;
            } else if (s.charAt(i) == ' '){
                i++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int val = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = val* 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(val);
            } else if (s.charAt(i) == '(') {
                signStack.push('(');
                i++;
            } else if (signLevel.containsKey(s.charAt(i))) { // + - *
                while(signStack.peek() != '(' && signLevel.get(signStack.peek()) >= signLevel.get(s.charAt(i))) {
                    updateStacks(numStack, signStack);
                }
                signStack.push(s.charAt(i));
                i++;
            } 
        }
        return numStack.peek();
    }

    private void updateStacks(Stack<Integer> numStack, Stack<Character> signStack) {
        char sign = signStack.pop();
        int n2 = numStack.pop();
        int n1 = numStack.pop();
        numStack.push(calculate(sign, n1, n2));
    }

    private Integer calculate(char sign, int n1, int n2) {
        if (sign == '+') return n1+n2;
        if (sign == '-') return n1 - n2;
        if (sign == '*') return n1*n2;
        if (sign == '/') return n1/n2;
        throw new IllegalArgumentException("which signs");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculate("(2+6* 3+5- (3*14/7+2)*5)+3" ));
    }

}
// @lc code=end

