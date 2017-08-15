
public class LeetCode0240 {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int colLength = matrix[0].length;

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < colLength) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        LeetCode0240 leetcode = new LeetCode0240();
        int[][] matrix = {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
        };
        System.out.println(leetcode.searchMatrix(matrix, 5));
    }
}
