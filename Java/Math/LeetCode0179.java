import java.util.Arrays;
import java.util.Comparator;

public class LeetCode0179 {
    public String largestNumber(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2)
            {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });

        if ("0".equals(array[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] { 3, 30, 34, 5, 9 };
        LeetCode0179 leetcode = new LeetCode0179();
        System.out.println(leetcode.largestNumber(nums));
    }
}
