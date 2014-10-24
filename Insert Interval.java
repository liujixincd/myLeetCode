/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
key idea, maintain a index of where should we insert the new interval,
if the end of current interval is smaller than the start of the newInterval,
we add the index, insert current,
if the start of ne current interval is larger thant the end of the newInterval,
we don not add the index, just insert the current interval

if it is not the condition above, it means that the newinterval has intersected with the current
interval, we don't insert the current interval, we just update the start and the end of the new
Interval
Time complexity O(n)
*/
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || newInterval == null) {
            return res;
        }
        int insertIdx = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) {
                res.add(cur);
                insertIdx++;
            } else if (cur.start > newInterval.end) {
                res.add(cur);
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        res.add(insertIdx, newInterval);
        return res;
    }
}