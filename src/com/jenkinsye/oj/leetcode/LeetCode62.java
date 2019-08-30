public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    board[i][j] = 1;
                    continue;
                }
                board[i][j] = ((i - 1) >= 0 ? board[i - 1][j] : 0)
                        + ((j - 1) >= 0 ? board[i][j - 1] : 0);

            }
        }
        return board[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        System.out.println(leetCode62.uniquePaths(50, 50));
    }
}
