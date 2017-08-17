Unique Paths II

Description
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.


Notice
m and n will be at most 100.



Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.



思路
和Unique Path一样的做法。
初始化：
从始发点开始往下，往右。把unique路径数设为1。
如果碰到障碍，障碍位置以及之后位置的unique path数都设成0。

遍历matrix，当前位置的unique path是当前位置上面和左边的unique path之和。如果碰到障碍，障碍位置的unique path为0。



Code
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            f[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            f[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                }
                else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        
        return f[m - 1][n - 1];
    }
}