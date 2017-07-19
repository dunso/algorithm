public class RandomizedCollection {

     private Map<Integer, Set<Integer>> map;
    private ArrayList<Integer> list;
    private Random ran = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {        
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val, set);
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        else {
            Set<Integer> set = map.get(val);
            int index = set.iterator().next();
            if (index < list.size() - 1)
            set.remove(index);
            {
                int lastOne = list.get(list.size() - 1);
                map.get(lastOne).add(index);
                map.get(lastOne).remove(list.size() - 1);            
                list.set(index, lastOne);    
            }
            list.remove(list.size() - 1);
            if (set.size() == 0) {
                map.remove(val);
            }            
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
