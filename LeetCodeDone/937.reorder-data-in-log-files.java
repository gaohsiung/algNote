import java.util.*;
/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] arr1 = s1.split("\\W", 2);
                String[] arr2 = s2.split("\\W", 2);

                boolean isDigitLog1 = Character.isDigit(arr1[1].charAt(0));
                boolean isDigitLog2 = Character.isDigit(arr2[1].charAt(0));

                if (!isDigitLog1 && !isDigitLog2) {
                    int cur = arr1[1].compareTo(arr2[1]);
                    if (cur != 0) {
                        return cur;
                    } else {
                        return arr1[0].compareTo(arr2[0]);
                    }
                } else if (!isDigitLog1 && isDigitLog2) {
                    return -1;
                } else if (isDigitLog1 && !isDigitLog2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return logs;
    }
}
// @lc code=end

