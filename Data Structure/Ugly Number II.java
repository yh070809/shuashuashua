Ugly Number II

Description
Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...


Notice
Note that 1 is typically treated as an ugly number.



Example
If n=9, return 10.



思路
求第n个ugly数。每个ugly数其实都是一个ugly数乘以2，3或者5。我们用priority queue的方法，维护3个list。每个list分别是ugly数的2，3和5倍：
multi2：1 x 2，2 x 2，3 x 2，4 x 2，5 x 2，6 x 2，8 x 2，9 x 2，10 x 2 ...
multi3：1 x 3，2 x 3，3 x 3，4 x 3，5 x 3，6 x 3，8 x 3，9 x 3，10 x 3 ...
multi5：1 x 5，2 x 5，3 x 5，4 x 5，5 x 5，6 x 5，8 x 5，9 x 5，10 x 5 ...
我们在扩展这3个list的时候用类似merge sort的做法，取最小的数放进我们的uglyList。



Code 
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n <= 0) {
            return 0;
        }
        
        ArrayList<Integer> uglyList = new ArrayList<Integer>();
        uglyList.add(1);
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (uglyList.size() < n) {
            int multi2 = uglyList.get(i) * 2;
            int multi3 = uglyList.get(j) * 3;
            int multi5 = uglyList.get(k) * 5;
            
            int min = Math.min(Math.min(multi2, multi3), multi5);
            uglyList.add(min);
            
            if (min == multi2) {
                i++;
            }
            if (min == multi3) {
                j++;
            }
            if (min == multi5) {
                k++;
            }
        }
        
        return uglyList.get(n - 1);
    }
}
