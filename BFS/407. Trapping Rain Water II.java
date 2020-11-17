407. Trapping Rain Water II
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
he above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
After the rain, water is trapped between the blocks. The total volume of water trapped is 4.



//https://qoogle.top/leetcode-407-trapping-rain-water-ii/

class Solution {
    // 申明结构体
    public class cell{
        int row ;
        int col;
        int height;
        public cell (int row , int col, int height){
            this.row = row;
            this.col = col;
            this.height = height; 
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        //corner case 
        if(heightMap == null || heightMap.length ==0 || heightMap[0].length ==0){
            return 0;
        }
        //建立优先队列
        PriorityQueue<cell> queue = new PriorityQueue<>(1, new Comparator<cell>(){
            public int compare(cell a, cell b){
                return a.height - b.height;
            }
        });
        
       int m = heightMap.length;
       int n = heightMap[0].length;
       boolean[][] visited = new boolean[m][n];
       
       for(int i =1; i < m-1 ; i++){
           visited[i][0] = true;
           visited[i][n-1] = true;
           queue.offer(new cell(i,0,heightMap[i][0]));
           queue.offer(new cell(i,n-1,heightMap[i][n-1]));
       }
        
        for(int i =0; i <n ; i++){
           visited[0][i] = true;
           visited[m-1][i] = true;
           queue.offer(new cell(0,i,heightMap[0][i]));
           queue.offer(new cell(m-1,i,heightMap[m-1][i]));
       }  
        
        
//       for (int i = 0; i < c; ++i) {
//             pq.push(Node(0, i, hm[0][i]));
//             pq.push(Node(r - 1, i, hm[r - 1][i]));
//             vis[0][i] = 1;
//             vis[r - 1][i] = 1;
//         }
        
//         for (int i = 1; i < r - 1; ++i) {
//             pq.push(Node(i, 0, hm[i][0]));
//             pq.push(Node(i, c - 1, hm[i][c - 1]));
//             vis[i][0] = 1;
//             vis[i][c - 1] = 1;
//         }  
        
       int [][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
       int res = 0;
       while (!queue.isEmpty()){
           cell cel = queue.poll();
           for (int[] dir : dirs){
               int row = cel.row +dir[0];
               int col = cel.col +dir[1];
               if(row >=0 && row <m && col >=0 && col< n && !visited[row][col]){
                   visited[row][col] = true;
                   res += Math.max(0,cel.height-heightMap[row][col]);
                   queue.offer(new cell(row,col,Math.max(heightMap[row][col],cel.height)));
               }
           }
       }
            
        return res;    
        
        
    }
}

