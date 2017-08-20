
public class LeetCode0048 {
    class Param {
        public int x;
        public int y;
        public int direction;
        public int step;
        public int start;
        public int end;

        public Param(int x, int y, int direction, int start, int end)
        {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.step = end - start;
            this.start = start;
            this.end = end;
        }
    }

    public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        if (rowLength != colLength || rowLength - 1 == 0) {
            return;
        }

        Param param = new Param(0, 0, 0, 0, rowLength - 1);

        while (param.start < param.end) {

            param.x = param.y = param.start;
            param.direction = 0;

            int from = matrix[param.y][param.x];
            int to = -1;

            while (true) {
                param = next(param);
                to = matrix[param.y][param.x];
                matrix[param.y][param.x] = from;
                from = to;
                if (param.direction == 4) {
                    param.x++;
                    if (param.x == param.end) {
                        break;
                    }
                    from = matrix[param.y][param.x];
                    param.direction = 0;
                }
            }

            param.start++;
            param.end--;
            param.step = param.end - param.start;
        }
    }

    private Param next(Param param)
    {

        if (param.direction == 0) {
            param.x += param.step;
            if (param.x > param.end) {
                param.y = param.start + param.x - param.end;
                param.x = param.end;
            }
            param.direction = 1;
        } else if (param.direction == 1) {
            param.y += param.step;
            if (param.y > param.end) {
                param.x = param.end - (param.y - param.end);
                param.y = param.end;
            }
            param.direction = 2;
        } else if (param.direction == 2) {
            param.x -= param.step;
            if (param.x < param.start) {
                param.y = param.end - (param.start - param.x);
                param.x = param.start;
            }
            param.direction = 3;
        } else if (param.direction == 3) {
            param.y -= param.step;
            if (param.y < param.start) {
                param.x = param.start + (param.start - param.y);
                param.y = param.start;
            }
            param.direction = 4;
        }
        return param;
    }

    public static void main(String[] args)
    {
        LeetCode0048 leetcode = new LeetCode0048();
        int[][] matrix = { 
            { 1, 2, 3, 4, 5 }, 
            { 6, 7, 8, 9, 10 }, 
            { 11, 12, 13, 14, 15 }, 
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 } };
        leetcode.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
