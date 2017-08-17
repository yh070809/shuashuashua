Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.



Solution:

Method 1: Dynamic Programming

From start point (0, 0), if we only go left, there is only one way. If we only go down, there is also only one way.

Given any other point (x, y) in the grid, the only way to reach this point is from its top or its left.

Therefore, if we know the number of unique paths to point (x - 1, y) and the number of unique paths to point (x, y - 1). We simply add these two numbers and it is the number of unique paths to point (x, y).

The time complexity is O(mn) since we need to go through all points in the grid.



Code:


public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int x = 0; x < m; x++) {
            paths[x][0] = 1;
        }
        for (int y = 0; y < n; y++) {
            paths[0][y] = 1;
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                paths[x][y] = paths[x - 1][y] + paths[x][y - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}