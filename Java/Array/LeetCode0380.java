import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0380 {

	private Map<Integer, Integer> map;
	private List<Integer> list;

	public LeetCode0380() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();

	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		int lastIndex = list.size() - 1;
		list.set(index, list.get(lastIndex));
		map.put(list.get(lastIndex), index);
		list.remove(lastIndex);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		return list.get((int) (Math.random() * list.size()));
	}
}
