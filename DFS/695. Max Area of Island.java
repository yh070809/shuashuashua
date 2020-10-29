695. Max Area of Island
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

class Solution {
    private static int[][] dires = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int curArea;
    private int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        if(row == 0)
            return 0;
        col = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != 0){
                    curArea = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int x, int y){
        grid[x][y] = 0;
        curArea++;
        for(int[] dire : dires){
            int newX = x + dire[0];
            int newY = y + dire[1];
            if(isIn(newX, newY) && grid[newX][newY] != 0)
                dfs(grid, newX, newY);
        }
    }

    private boolean isIn(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }


}