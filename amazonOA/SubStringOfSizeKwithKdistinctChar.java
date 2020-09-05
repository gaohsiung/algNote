import java.util.*;

public class SubStringOfSizeKwithKdistinctChar {
    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] charCounts = new int[26];
        int lowerBound = 0;
        int higherBound = 0;
        while(lowerBound <= higherBound && higherBound < s.length()) {
            charCounts[s.charAt(higherBound)-'a']++;
            while(charCounts[s.charAt(higherBound) - 'a'] != 1) {
                charCounts[s.charAt(lowerBound ) - 'a']--;
                lowerBound++;
            }
            if(higherBound-lowerBound +1 == k) {
                set.add(s.substring(lowerBound, higherBound+1));
                charCounts[s.charAt(lowerBound)-'a']--;
                lowerBound++;
            }
            higherBound++;
        }
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        return set;
    }
    
    public static void main(String[] args) {
        uniqueSubstringSizeK("abcabc", 3);
        uniqueSubstringSizeK("abacab", 3);
        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
    }
}