package wangheng.leetcode;

public class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = 'X';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }

}
