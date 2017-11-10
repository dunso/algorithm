import java.util.Stack;

public class LeetCode0224 {

    private Stack<Character> signStack = new Stack<Character>();
    private Stack<Integer> numStack = new Stack<Integer>();

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        signStack.push('+'); //extra add '0+'
        numStack.push(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int num = c - '0';
                for (++i; i < s.length(); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                    } else if (c == ' ') {
                        continue;
                    } else {
                        break;
                    }
                }
                i--;

                if (signStack.peek() == '*') {
                    numStack.push(numStack.pop() * num);
                } else if (signStack.peek() == '/') {
                    if (num == 0) {
                        return 0;
                    }
                    numStack.push(numStack.pop() / num);
                } else {
                    numStack.push(num);
                }
            } else if (c == '(') {
                signStack.push('(');
                numStack.push(0); //extra add '0+'
                signStack.push('+');
            } else if (c == ')') {
                while (signStack.peek() != '(') {
                    plusOrMinus();
                }
                signStack.pop();
            }
            if (c == '+' || c == '-') {
                plusOrMinus();
                signStack.push(c);
            }
            if (c == '*' || c == '/') {
                signStack.push(c);
            }
        }

        while (!signStack.isEmpty()) {
            plusOrMinus();
        }
        return numStack.pop();
    }

    private void plusOrMinus() {
        int o1 = numStack.pop();
        int o2 = numStack.pop();

        boolean plus = signStack.pop() == '+' ? true : false;

        if (plus) {
            numStack.push(o2 + o1);
        } else {
            numStack.push(o2 - o1);
        }
    }

    public static void main(String[] args) {
        LeetCode0224 leetcode = new LeetCode0224();
        System.out.println(leetcode.calculate("2-1+2"));
    }
}