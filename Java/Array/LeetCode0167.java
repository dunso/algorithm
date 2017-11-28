import java.util.Arrays;

public class LeetCode0167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[] { -1, -1 };
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] { i + 1, j + 1 };
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0167 leetcode = new LeetCode0167();
        int[] numbers = new int[] { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(leetcode.twoSum(numbers, 9)));
    }
}
