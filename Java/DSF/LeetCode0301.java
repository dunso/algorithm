import java.util.ArrayList;
import java.util.List;

public class LeetCode0301 {
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        int[] minStep = new int[] { Integer.MAX_VALUE };
        DFS(s, "", 0, 0, 0, minStep, result);
        if (result.size() == 0) {
            result.add("");
        }
        return result;
    }

    private void DFS(String s, String current, int index, int stepCount,
        int leftCount, int[] minStep, List<String> result)
    {

        if (current.length() != 0 && leftCount < 0) {
            return;
        }

        if (index < s.length()) {
            char c = s.charAt(index);
            if (c != '(' && c != ')') {
                current += c;
                index += 1;
            }
        }

        if (index == s.length()) {
            if (leftCount != 0) {
                return;
            }
            if (stepCount < minStep[0]) {
                result.clear();
                result.add(current);
                minStep[0] = stepCount;
            } else if (stepCount == minStep[0] && !result.contains(current)) {
                result.add(current);
            }
            return;
        }

        char c = s.charAt(index);

        DFS(s, current + c, index + 1, stepCount, c == '(' ? leftCount + 1 
            : c == ')' ? leftCount - 1 : leftCount, minStep, result);
        DFS(s, current, index + 1, stepCount + 1, leftCount, minStep, result);
    }

    public static void main(String[] args)
    {
        LeetCode0301 leetcode = new LeetCode0301();
        System.out.println(leetcode.removeInvalidParentheses("()())()"));
    }
}
