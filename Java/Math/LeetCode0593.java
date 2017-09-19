import java.util.HashMap;
import java.util.Map;

public class LeetCode0593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {

        Map<Double, Integer> map = new HashMap<Double, Integer>();
        map.put(distance(p1, p2), 1);

        double tmp = distance(p1, p3);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        tmp = distance(p1, p4);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        tmp = distance(p2, p3);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        tmp = distance(p2, p4);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        tmp = distance(p3, p4);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        return !map.containsKey(0.0) && map.values().size() == 2 && map.values().contains(4)
            && map.values().contains(2);
    }

    private double distance(int[] a, int[] b)
    {
        int diffX = a[0] - b[0];
        int diffY = a[1] - b[1];
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public static void main(String[] args)
    {
        int[] p1 = new int[] { 1, 0 };
        int[] p2 = new int[] { -1, 0 };
        int[] p3 = new int[] { 0, 1 };
        int[] p4 = new int[] { 0, -1 };

        LeetCode0593 leetcode = new LeetCode0593();
        System.out.println(leetcode.validSquare(p1, p2, p3, p4));
    }
}