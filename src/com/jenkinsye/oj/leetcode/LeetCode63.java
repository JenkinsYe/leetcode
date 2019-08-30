public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] board = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    if(obstacleGrid[i][j] == 0){
                        board[i][j] = 1;
                        continue;
                    }else break;
                }
                if(obstacleGrid[i][j] == 1){
                    board[i][j] = 0;
                    continue;
                }
                board[i][j] = ((i - 1) >= 0 ? board[i - 1][j] : 0)
                        + ((j - 1) >= 0 ? board[i][j - 1] : 0);
            }
        }
        return board[m - 1][n -1];
    }

    public static void main(String[] args) {
        LeetCode63 leetCode63 = new LeetCode63();
        int[][] nums = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };
        System.out.println(leetCode63.uniquePathsWithObstacles(nums));
    }
}
