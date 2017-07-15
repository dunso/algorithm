import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode0352_1 {

	class Interval {
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

	public class SummaryRanges {
		List<Interval> l;
		HashSet<Integer> hs;

		public SummaryRanges() {
			l = new ArrayList();
			hs = new HashSet();
		}

		public void addNum(int val) {
			if (!hs.contains(val)) {
				hs.add(val);
				if (l.size() == 0) {
					l.add(new Interval(val, val));
					return;
				}
				int pos = binsearch(val);
				Interval temp1 = null;
				Interval temp2 = null;
				if (pos < l.size())
					temp1 = l.get(pos);
				if (pos > 0)
					temp2 = l.get(pos - 1);
				if (pos < l.size() && temp1.start == val + 1 && (temp2 == null || temp2.end < val - 1))
					l.set(pos, new Interval(val, temp1.end));
				else if (pos > 0 && temp2.end == val - 1 && (temp1 == null || temp1.start > val + 1))
					l.set(pos - 1, new Interval(temp2.start, val));
				else if (pos > 0 && pos < l.size() && temp1.start == val + 1 && temp2.end == val - 1) {
					l.remove(pos);
					l.remove(pos - 1);
					l.add(pos - 1, new Interval(temp2.start, temp1.end));
				} else
					l.add(pos, new Interval(val, val));
			}
		}

		public int binsearch(int target) {
			int low = 0, high = l.size() - 1;
			if (l.get(high).start < target)
				return high + 1;
			while (low < high) {
				int mid = (high - low) / 2 + low;
				if (l.get(mid).start > target)
					high = mid;
				else
					low = mid + 1;
			}
			return low;
		}

		public List<Interval> getIntervals() {
			return l;
		}
	}
}
