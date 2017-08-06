public class LeetCode0050 {
    public double myPow(double x, int n)
    {
        if (n == 0) {
            return 1;
        }
        double tmp = x, result = 1.0;

        for (int y = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : n < 0 ? -n : n; y != 0; y = y >> 1) {
            if ((y & 1) == 1) {
                result *= tmp;
            }
            tmp *= tmp;
        }

        if (n == Integer.MIN_VALUE) {
            result *= result;
        }
        return n < 0 ? 1 / result : result;
    }

    public static void main(String[] args)
    {
        LeetCode0050 leetcode = new LeetCode0050();
        System.out.println(leetcode.myPow(2, -2147483648));
    }
}
