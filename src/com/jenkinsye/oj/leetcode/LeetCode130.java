package com.jenkinsye.oj.leetcode;

import java.util.Arrays;

public class LeetCode130 {
    public  static int width, length;

    public void solve(char[][] board) {
        width = board.length;
        if (width == 0)
            return;
        length = board[0].length;
        for (int i = 0; i < width; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][length - 1] == 'O')
                dfs(board, i, length - 1);
        }
        for (int j = 0; j < length; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[width - 1][j] == 'O')
                dfs(board, width - 1, j);
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';

            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= width || j >= length || board[i][j] != 'O')
            return;
        board[i][j] = '*';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        LeetCode130 leetCode130 = new LeetCode130();
        leetCode130.solve(map);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
