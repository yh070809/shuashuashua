Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.

Notice
You can only move either down or right at any point in time.


思路
我们开一个m x n的数组f作为状态数组，坐标[i][j]表示从起始位置走到这个位置的最小路径和。因为从一点只能往下或者往右，所以[i][j]的值是它上面和左边的值中取最小，再加上[i][j]这个点的值。
我们的状态方程是f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j]。
初始化。第一行只能往右。第一列只能往下。


Code
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
