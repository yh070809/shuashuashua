Kth Largest Element II 

Find K-th largest element in an array. and N is much larger than k.

Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
     
     //思路
//建立一个min-heap。过一遍数组把每个数字往里面扔。如果超过k个，就扔出来一个。
//最后里面剩下k个最大的。头上这个就是第k大。
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue <Integer>(k);
        
        for (int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
          }
          
          return pq.poll();
        }
    }