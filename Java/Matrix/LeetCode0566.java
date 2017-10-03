public class LeetCode0566 {
    public int[][] matrixReshape(int[][] nums, int r, int c)
    {

        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }
        int rowLength = nums.length;
        int colLength = nums[0].length;

        int index = rowLength * colLength - 1;

        if (r * c - 1 != index) {
            return nums;
        }

        int[][] result = new int[r][c];

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int row = index / colLength;
                int col = index % colLength;
                result[i][j] = nums[row][col];
                index--;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        LeetCode0566 leetcode = new LeetCode0566();
        int[][] nums = { { 1, 2, 3, 4 } };
        int[][] result = leetcode.matrixReshape(nums, 2, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}