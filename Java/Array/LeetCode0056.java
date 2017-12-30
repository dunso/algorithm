import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode0056 {

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return 1;
            }
        });

        Interval tmp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > tmp.end) {
                result.add(tmp);
                tmp = intervals.get(i);
            } else {
                tmp.end = Math.max(tmp.end, intervals.get(i).end);
            }
        }
        result.add(tmp);
        return result;
    }

    public static void main(String[] args) {
        LeetCode0056 leetcode = new LeetCode0056();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> result = leetcode.merge(intervals);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).start + "," + result.get(i).end);
            System.out.println();
        }
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}