import java.util.Stack;

public class LeetCode0591 {

    public boolean isValid(String code)
    {
        if (code == null || code.length() == 0) {
            return true;
        }

        if (code.startsWith("<!") || !code.startsWith("<")) {
            return false;
        }

        Stack<String> stack = new Stack<String>();

        String sub = "";
        for (int i = 0; i < code.length(); i++) {

            sub += code.charAt(i);
            if (!sub.startsWith("<")) {
                sub = "";
                continue;
            }

            if (sub.startsWith("<![CDATA[")) {
                if (sub.endsWith("]]>")) {
                    sub = "";
                }
            } else if (sub.startsWith("</")) {
                if (sub.endsWith(">")) {
                    String tagName = sub.substring(2, sub.length() - 1);
                    if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                        return false;
                    }

                    if (i < code.length() - 1 && stack.isEmpty()) {
                        return false;
                    }
                    sub = "";
                }
            } else if (sub.startsWith("<")) {
                if (sub.endsWith(">")) {
                    String tagName = sub.substring(1, sub.length() - 1);
                    if (!checkTagName(tagName)) {
                        return false;
                    }
                    stack.add(tagName);
                    sub = "";
                }
            }
        }

        return stack.isEmpty() && sub.length() == 0;
    }

    private boolean checkTagName(String tagName)
    {
        if (tagName.length() > 9 || tagName.length() < 1) {
            return false;
        }
        for (int i = 0; i < tagName.length(); i++) {
            if (!Character.isUpperCase(tagName.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        LeetCode0591 leetcode = new LeetCode0591();
        System.out.println(leetcode.isValid("<A></A><B></B>"));
    }
}