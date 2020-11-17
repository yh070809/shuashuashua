79. Word Search

Share
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


class Solution {
    public boolean exist(char[][] board, String word) {
      int m = board.length, n = board[0].length;
         boolean[][] visited = new boolean[m][n];
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (word.charAt(0) == board[i][j] && dfs(i, j, 0, word, board, visited))
                     return true;
             }
         }
         return false;
    }
    
    
  private boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] visited) {
        if(index == word.length())
            return true;
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        if(dfs(i + 1, j, index + 1, word, board, visited) || dfs(i, j + 1, index + 1, word, board, visited) 
          || dfs(i - 1, j, index + 1, word, board, visited) || dfs(i, j - 1, index + 1, word, board, visited))
            return true;
        visited[i][j] = false;
        return false;
    }
}