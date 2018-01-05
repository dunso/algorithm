public class LeetCode0038 {
    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = "1";
        for (int i = 2; i <= n; i++) {
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c != pre) {
                    sb.append(count).append(pre);
                    count = 1;
                    pre = c;
                } else {
                    count++;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
            sb.setLength(0);
        }
        return str;
    }

    public static void main(String[] args) {
        LeetCode0038 leetcode = new LeetCode0038();
        System.out.println(leetcode.countAndSay(5));
    }
}