package com.jenkinsye.oj.leetcode;


public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        boolean result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)){
            return false;
        }

        boolean result;
        board[i][j] <<= 2;
        result = dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i, j - 1, index + 1)
                || dfs(board, word, i, j + 1, index + 1);
        board[i][j] >>= 2;

        return result;
    }
    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEED";
        System.out.println(leetCode79.exist(board, word));
    }
}
