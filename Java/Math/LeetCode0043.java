public class LeetCode0043 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        int[] sum = new int[num1.length() + num2.length() - 1];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                sum[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = sum.length - 1; i >= 0; i--) {
            sum[i] += carry;
            carry = sum[i] / 10;
            sb.append(sum[i] % 10);
        }

        while (carry != 0) {
            sb.append(carry % 10);
            carry /= 10;
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode0043 leetcode = new LeetCode0043();
        System.out.println(leetcode.multiply("13", "13"));
    }
}