import java.util.Stack;

public class LeetCode0020 {
    public boolean isValid(String s)
    {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty()) {
                int top = stack.peek();
                if (top == '(' && c == ')' || top == '[' && c == ']' || top == '{' && c == '}') {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            else if (c == ')' || c == ']' || c == '}') {
                return false;
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        LeetCode0020 leetcode = new LeetCode0020();
        System.out.println(leetcode.isValid("()[]"));
    }
}
