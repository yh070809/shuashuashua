Top k Largest Numbers 
Description
Given an integer array, find the top k largest numbers in it.

Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

思路
建立一个min-heap。过一遍数组把每个数字往里面扔。如果超过k个，就扔出来一个。
最后里面剩下k个最大的。然后一个一个拿出来放到答案的数组里。


class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue <Integer> (k);
        
        for (int num : nums){
            pq.add(num);
            if(pq.size() > k){
              pq.poll();   
            }
        }
        
        int[] res = new int[k];
        while(k - 1 >= 0){
            res[--k] = pq.poll();
        }
        return res;
    }
}