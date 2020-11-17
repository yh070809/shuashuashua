207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 
Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//         Map<Integer,List<Integer>> map = new HashMap<>();
        
//         //每个节点的入度
//         int[] indegree = new int[numCourses];
//         for(int i = 0; i < prerequisites.length ; i++){
//             int first = prerequisites[i][0];
//             int second = prerequisites[i][1];
//             if (!map.containsKey(first))
//                 map.put(first,new ArrayList<>());
//             map.get(first).add(second);
            
//             //入度加一， 从first -> second
//             indegree[second] ++;
//         }
        
//         //存储所有入度为0的节点
        
//         Queue<Integer> q = new LinkedList<>();
//         for(int i =0 ; i < numCourses; i++){
//             if(indegree[i] ==0)
//             q.offer(i);
//         }
        
//         int count =0;
//         while (!q.isEmpty()){
//             int val = q.poll();
//             count++;
            
//             if(!map.containsKey(val))
//                 continue;
//             //获取val的临界点
            
//             List<Integer> tmp = map.get(val);
            
//             for(int i =0; i< tmp.size(); i++){
//                 int idx = tmp.get(i);
//                 indegree[idx] --;
                
//                 if(indegree[idx] ==0)
//                     q.offer(idx);
//             }
//         }
        
//         return count == numCourses;
        
        
//     }
// }



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean returnVal = true;
        int [] parents = new int [numCourses];
        for(int i =0; i < numCourses; i++){
            returnVal = dfs(i, prerequisites, parents);
            if(!returnVal){
                return returnVal;
            }
        }
        return returnVal;
        
        
    }
    
    
    public boolean dfs(int cur, int[][] prerequisites, int []parents){
        if (parents[cur] ==1){
            return false;
        }
         if (parents[cur] ==2){
            return true;
        }
        
        for(int i = 0; i <prerequisites.length; ++i ){
            if(prerequisites[i][0] == cur){
                parents[cur] = 1;
                boolean val = dfs(prerequisites[i][1], prerequisites,parents);
                    if(!val){
                        return val;
                    }
            }
            
           
        }
         parents[cur] =2;
            return true;
    }
}
