
public class LeetCode0048 {
    class Param {
        public int x;
        public int y;
        public int direction;
        public int step;
        public int rowLength;
        public Param(int x, int y, int direction, int step, int rowLength)
        {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.step = step;
            this.rowLength = rowLength;
        }
    }

    public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        if (rowLength != colLength) {
            return;
        }

        rowLength = rowLength - 1;

        if (rowLength == 0) {
            return;
        }

        Param param = new Param(0, 0, 0, rowLength, rowLength);

        while (param.step > 0) {

            param.x = param.y = param.rowLength - param.step;
            param.direction = 0;

            int from = matrix[param.y][param.x];
            int to = -1;

            while ((param = next(param)) != null) {
                to = matrix[param.y][param.x];
                matrix[param.y][param.x] = from;
                from = to;
                if (param.direction == 5) {
                    param.x++;
                    if (param.x > param.step) {
                        break;
                    }
                    param.direction = 0;
                }
            }
            param.step--;
        }
    }

    private Param next(Param param)
    {

        if (param.direction == 0) {
            param.x += param.step;
            if (param.x > param.step) {
                param.y = param.x - param.step;
                param.x = param.step;
            }
            param.direction = 1;
        } else if (param.direction == 1) {
            param.y += param.step;
            if (param.y > param.step) {
                param.x = param.step - (param.y - param.step);
                param.y = param.step;
            }
            param.direction = 2;
        } else if (param.direction == 2) {
            param.x -= param.step;
            if (param.x < 0) {
                param.y = (param.x + param.step);
                param.x = param.rowLength - param.step;
            }
            param.direction = 3;
        } else if (param.direction == 3) {
            param.y -= param.step;
            if (param.y < 0) {
                param.x = param.step - (param.x + param.step);
                param.y = param.rowLength = param.step;
            }
            param.direction = 5;
        }
        return param;
    }

    public static void main(String[] args)
    {
        LeetCode0048 leetcode = new LeetCode0048();
        int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };
        leetcode.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
