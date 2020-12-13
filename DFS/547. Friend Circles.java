547. Friend Circles
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:

Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
 

Example 2:

Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

class Solution {
    //方法一：DFS
//      public int findCircleNum(int[][] M) {
//          int length = M.length;
//          if(length ==0) return 0;
//          int count =0;
//          for(int n = 0 ; n < length ; n ++){//总共有n名学生
//              if(M[n][n] == 1){//直接找学生，为1说明还没有成为记录过的学生
//                  DFSfindF(n,M);//以这名学生开始遍历他的朋友
//                  count ++;
//              }
//          }
//          return count;
//      }
    
//     private void DFSfindF(int n , int[][] M){
//         if(M[n][n] == 0) return;
//         M[n][n] =0;//记录这个人已经遍历过， 因为M[n][n]是必定等于1的，为0则说明已经遍历过了
//         //查找遍历这个人的朋友
//         for(int i = 0; i < M.length ; i++){
//             //遍历其他同学， 看看是否和他是朋友
//             if(M[n][i]==1){//找到n的朋友i, 继续递归找i的朋友
//                 DFSfindF(i,M);       
//             }
//         }
//     }
    
    
//方法二 ： 并查集
    public int findCircleNum(int[][] M) {
        int length=M.length;
        if(length==0) return 0;
        UnionFind unionF=new UnionFind(length);
        for(int row=0;row<length;row++){
            for(int col=row+1;col<length;col++){
                //这边只需要遍历row后面的朋友即可，因为前面的朋友关系已经遍历过。
                if(M[row][col]==1){
                    //如果为1说明是朋友关系，合并朋友圈
                    unionF.unionF(row,col);
                }
            }
        }
        return unionF.count;
    }
    
    public class UnionFind{
    int[] roots;
    int count;//朋友圈数量
    public UnionFind(int n){
        roots=new int[n];//初始化，学生关系，每个学生默认只跟自己是朋友
        for(int i=0;i<n;i++){
            roots[i]=i;
            count++;//默认每个学生是独立的朋友圈，则学生数量就是朋友圈数量。
        }
    }
    //找朋友关系
    public int findF(int n){
        int root=n;
        while(roots[root]!=root){//找到连接的朋友关系
            root=roots[root];
        }
        //路径压缩,将可以成为朋友的，都依次指向root，这样缩短了层次，只有两层
        while(roots[n]!=n){
            int temp=roots[n];
            roots[n]=root;
            n=temp;
        }
        return root;
    }
    //表示b和p是好朋友，需要合并他们朋友圈
    public void unionF(int b,int p){
        int rootB=findF(b);
        int rootP=findF(p);
        if(rootB!=rootP){//他们当前不是好朋友，则合并
            roots[rootB]=rootP;
            count--;//没合并一个学生，则朋友圈减少一个
        }
  }
}


}
