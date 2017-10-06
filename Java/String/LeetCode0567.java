import java.util.HashMap;
import java.util.Map;

public class LeetCode0567 {
    public boolean checkInclusion(String s1, String s2)
    {

        if (s1 == null || s1 == null || s1.length() > s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count0 = 0;
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                int pre = map.get(c);
                if (pre == 0) {
                    count0--;
                } else if (pre == 1) {
                    count0++;
                }
                map.put(c, pre - 1);
            }
            if (i >= s1.length()) {
                c = s2.charAt(j);
                if (map.containsKey(c)) {
                    int pre = map.get(c);
                    if (pre == 0) {
                        count0--;
                    } else if (pre == -1) {
                        count0++;
                    }
                    map.put(c, pre + 1);
                }
                j++;
            }
            if (count0 == map.size()) {
                return true;
            }
        }
        if (count0 == map.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        LeetCode0567 leetcode = new LeetCode0567();
        System.out.println(leetcode.checkInclusion("abcdxabcde", "abcdeabcdx"));
    }
}