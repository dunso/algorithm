
public class LeetCode0073 {

    public void setZeroes(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;

        boolean isLastColNeedMark = false;

        for (int i = 0; i <= lastRow; i++) {
            if (matrix[i][lastCol] == 0) {
                isLastColNeedMark = true;
            }
            for (int j = 0; j < lastCol; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][lastCol] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 0; j < lastCol; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i <= lastRow; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = lastRow; i >= 0; i--) {
            if (matrix[i][lastCol] == 0) {
                for (int j = 0; j < lastCol; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (isLastColNeedMark) {
                matrix[i][lastCol] = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 0, 5, 2 }, { 8, 9, 2, 0 }, { 5, 7, 2, 1 } };
        LeetCode0073 leetcode = new LeetCode0073();
        leetcode.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
