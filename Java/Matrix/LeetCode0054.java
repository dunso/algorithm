import java.util.ArrayList;
import java.util.List;

public class LeetCode0054 {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int firstRow = 0, lastRow = matrix.length, firstCol = 0, lastCol = matrix[0].length;

        while (firstRow < lastRow && firstCol < lastCol) {
            int i = firstRow, j = firstCol;
            if (j == lastCol) {
                break;
            }
            for (; j < lastCol; j++) {
                result.add(matrix[i][j]);
            }
            lastCol--;
            j--;
            i++;
            if (i == lastRow) {
                break;
            }
            for (; i < lastRow; i++) {
                result.add(matrix[i][j]);
            }
            lastRow--;
            i--;
            j--;
            if (j < firstCol) {
                break;
            }
            for (; j >= firstCol; j--) {
                result.add(matrix[i][j]);
            }
            firstCol++;
            j++;
            i--;
            if (i <= firstRow) {
                break;
            }
            for (; i > firstRow; i--) {
                result.add(matrix[i][j]);
            }
            firstRow++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0054 leetcode = new LeetCode0054();

        int[][] matrix = { { 7 }, { 9 }, { 6 } };
        List<Integer> result = leetcode.spiralOrder(matrix);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
