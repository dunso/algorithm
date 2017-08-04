public class LeetCode0338 {
    public int[] countBits(int num)
    {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args)
    {
        LeetCode0038 leetcode = new LeetCode0038();
        int[] results = leetcode.countBits(5);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
