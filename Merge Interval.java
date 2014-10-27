/**
 * Key idea : sort the intervals and insert one by one into the result set
 * only insert non overlapping interval
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Comparator<Interval> cmp = new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            }
        };       
        Collections.sort(intervals, cmp);
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = res.get(res.size() - 1);
            Interval temp = intervals.get(i);
            if (temp.start > cur.end || temp.end < cur.start) {
                res.add(temp);
            } else {
                cur.end = Math.max(cur.end, temp.end);
                cur.start = Math.min(cur.start, temp.start);
            }
        }
        return res;
    }
}
