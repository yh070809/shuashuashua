974. Subarray Sums Divisible by K
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //(presum[i] % K == (presum[j]) % K)
        int n = A.length;
        int count = 0 ;
        int [] modToFreq = new int [K];
        modToFreq[0] = 1;
        for(int i = 0 ; i < n ; i++){
            if( i> 0){
                A[i] += A[i -1];
            }
            int mod  = A[i] % K < 0 ? A[i] % K +K : A[i] % K;
            count += modToFreq[mod];
            modToFreq[mod] ++;
        }
        
        return count;
        
    }
}