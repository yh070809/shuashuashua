406. Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. A pair of integers [hi, ki] describe each person, where hi is the height of the ith person and ki is the number of people in front of the ith person who has a height greater than or equal to hi. Write an algorithm to reconstruct the queue.

 Example 1:

Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Example 2:

Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

// 先从人里面挑出最高的，根据他们的k值进行排列。排完后，再从剩下的人里挑出最高的，根据k值插入到刚刚排好的队列里，直到没有人还没排。所以这里直接先将人根据身高从高到低进行排序。

// 这里比较 tricky 的就是当你把最高的人挑出来后，再将下次挑出来的人插入到之前排好的队列时，k 代表的就是索引值。


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 排序数组
    Arrays.sort(people, 
                (a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
    // 新建一个List
    List<int[]> list = new ArrayList<>();
    // 将每个数组中第二个数值作为下标，将该数组插入List
    for(int[] p : people){
        list.add(p[1],p);
    }
    // 将list转为数组返回
    int[][] res = new int[people.length][2];
    for(int i=0;i<list.size();i++){
        res[i]=list.get(i);
    }
    return res;
        
    }
}