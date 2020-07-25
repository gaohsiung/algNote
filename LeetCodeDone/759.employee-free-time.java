import java.util.*;

/*
 * @lc app=leetcode id=759 lang=java
 *
 * [759] Employee Free Time
 */

// @lc code=start
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
// class Interval {
//     public int start;
//     public int end;

//     public Interval() {}

//     public Interval(int _start, int _end) {
//         start = _start;
//         end = _end;
//     }
// };

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> sortedIntervals = new ArrayList<>();
        for(List<Interval> listItv: schedule) {
            for(Interval itv: listItv) {
                sortedIntervals.add(itv);
            }
        }
        Collections.sort(sortedIntervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                } else {
                    return i1.end - i2.end;
                }
            }
        });
        Interval prev = sortedIntervals.get(0);
        List<Interval> mergedIntervals = new ArrayList<>();
        for(Interval itv: sortedIntervals) {
            if (prev == null) {
                prev = itv;
                continue;
            }
            if (prev.end >= itv.start) {
                prev.end = Math.max(prev.end, itv.end);
            } else {
                mergedIntervals.add(prev);
                prev = itv;
            }
        }
        mergedIntervals.add(prev);

        List<Interval> res = new LinkedList<>();
        if (mergedIntervals.size() == 1) {
            return res;
        }
        prev = null;
        for(Interval cur: mergedIntervals) {
            if (prev == null) {
                prev = cur;
                continue;
            }
            res.add(new Interval(prev.end, cur.start));
            prev = cur;
        }
        return res;
    }
}
// @lc code=end

