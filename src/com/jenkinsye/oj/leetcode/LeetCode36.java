public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                if(row[i][num] || column[j][num] || block[(i / 3) * 3 + j / 3][num])
                    return false;
                row[i][num] = true;
                column[j][num] = true;
                block[(i / 3) * 3 + j / 3][num] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode36 leetCode36 = new LeetCode36();

    }
}
