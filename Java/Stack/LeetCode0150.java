import java.util.Stack;

public class LeetCode0150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i< tokens.length; i++) {
            String str = tokens[i];
            if(str == " ") {
                continue;
            }
            switch(str) {
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                int meiosis = stack.pop();
                stack.push(stack.pop() - meiosis);
                break;
            case "*":
                stack.push(stack.pop() * stack.pop());
                break;
            case "/":
                int divisor = stack.pop();
                stack.push(stack.pop() / divisor);
                break;
            default:
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode0150 leetcode = new LeetCode0150();
        String[] tokens = new String[] {"4", "13", "5", "/", "+"};
        System.out.println(leetcode.evalRPN(tokens));
    }
}