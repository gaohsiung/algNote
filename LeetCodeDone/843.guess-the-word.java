import java.util.*;
/*
 * @lc app=leetcode id=843 lang=java
 *
 * [843] Guess the Word
 */

// @lc code=start
/**
 * // This is the Master's API interface. // You should not implement it, or
 * speculate about its implementation interface Master { public int guess(String
 * word) {} }
 */
class Solution {
  public void findSecretWord(String[] wordlist, Master master) {
    
    for (int i = 0, num = 0; i < 10 && num != 6; i++) {
      String curGuessWord = selectGuessByCountMatrix(wordlist);
      num = master.guess(curGuessWord);
      List<String> templist = new ArrayList<>();
      for (String s: wordlist) {
        if (matchNum(curGuessWord, s) == num) {
          templist.add(s);
        }
      }
      wordlist = new String[templist.size()];
      for (int j = 0; j < templist.size(); j++) {
        wordlist[j] = templist.get(j);
      }
    }
  }
  private String selectGuessByCountMatrix(String[] wordlist) {
    int[][] countMatrix = new int[26][6];
    for (String s: wordlist) {
      for (int i = 0; i < s.length(); i++) {
        countMatrix[s.charAt(i) - 'a'][i]++;
      }
    }
    String ret = wordlist[0];
    int max = 0;
    for (String s: wordlist) {
      String curS = s;
      int curCount = 0;
      for (int i = 0; i < curS.length(); i++) {
        curCount += countMatrix[curS.charAt(i)-'a'][i];
      }
      if (curCount > max) {
        ret = curS;
        max = curCount;
      }
    }
    return ret;
  }
  private int matchNum(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
// @lc code=end
