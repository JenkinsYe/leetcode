package com.jenkinsye.oj.leetcode;

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    dfs(grid, visit, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (visit[i][j] || grid[i][j] == '0') {
            return;
        }
        visit[i][j] = true;
        dfs(grid, visit, i - 1, j);
        dfs(grid, visit, i + 1, j);
        dfs(grid, visit, i, j + 1);
        dfs(grid, visit, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };
        System.out.println(new LeetCode200().numIslands(grid));
    }
}
