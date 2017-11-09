public class LeetCode0227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0, record = 0, multOrDiv = 0, plusOrMinus = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                for (i++; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                i--;
                if (multOrDiv == 1) {
                    record *= num;
                    multOrDiv = 0;
                } else if (multOrDiv == -1) {
                    if (num == 0) {
                        return 0;
                    } else {
                        record /= num;
                    }
                    multOrDiv = 0;
                } else {
                    record = num;
                }
            } else if (c == '*') {
                multOrDiv = 1;
            } else if (c == '/') {
                multOrDiv = -1;
            } else if (c == '+') {
                result += plusOrMinus * record;
                plusOrMinus = 1;
            } else if (c == '-') {
                result += plusOrMinus * record;
                plusOrMinus = -1;
            }
        }
        return result + plusOrMinus * record;
    }

    public static void main(String[] args) {
        LeetCode0227 leetcode = new LeetCode0227();
        System.out.println(leetcode.calculate("2*3+4"));
    }
}
