import java.util.Arrays;

public class LeetCode0087 {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        if (s1.length() == 1 && s2.length() == 1) {
            if (s1.equals(s2)) {
                return true;
            } else {
                return false;
            }
        }
        return isScrambleDFS(s1, s2);
    }

    private boolean isScrambleDFS(String s1, String s2) {
        if (s1.length() == 1) {
            return true;
        }
        if (!isContainsSame(s1, s2)) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);
            if (isScrambleDFS(s1Left, s2Left) && isScrambleDFS(s1Right, s2Right)) {
                return true;
            }

            s2Left = s2.substring(0, s2.length() - i);
            s2Right = s2.substring(s2.length() - i);
            if (isScrambleDFS(s1Left, s2Right) && isScrambleDFS(s1Right, s2Left)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainsSame(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0087 leetcode = new LeetCode0087();
        System.out.println(leetcode.isScramble("great", "rgtae"));
    }
}
