import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;

public class LeetCode0599 {

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public String[] findRestaurant(String[] list1, String[] list2)
    {
        List<String> result = new ArrayList<String>();

        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
            return result.toArray(new String[0]);
        }

        int list1Length = list1.length;
        int list2Length = list2.length;

        if (list1Length < list2Length) {
            initMap(list1);
            result = findAllSameRestaurant(list2);
        } else {
            initMap(list2);
            result = findAllSameRestaurant(list1);
        }

        return result.toArray(new String[result.size()]);
    }

    private void initMap(String[] array)
    {
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
    }

    private List<String> findAllSameRestaurant(String[] array)
    {
        List<String> result = new ArrayList<String>();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int sum = i + map.get(array[i]);
                if (sum > min) {
                    continue;
                }
                if (sum < min) {
                    result.clear();
                    min = sum;
                }
                result.add(array[i]);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0599 leetcode = new LeetCode0599();
        String[] array1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] array2 = new String[] { "KFC", "Shogun", "Burger King" };
        System.out.println(Arrays.toString(leetcode.findRestaurant(array1, array2)));
    }
}