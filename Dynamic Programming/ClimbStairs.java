ClimbStairs

Description
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example
Given an example n=3 , 1+1+1=2+1=1+2=3
return 3 


思路

                 ｜——
      ｜——     2
——    1
 0

我们用f[i]来表示从底层跳到第i层有多少种方法。
我们看最底层是第0层，小人本来就在那里。所以初始化f[0] = 1。
跳到第1层，只有1种跳法。所以初始化f[1] = 1。
我们看第2层。要跳到第2层，只有2种办法。一种是从第0层跳2，另一种是从第1层跳1。那么其实第i层的跳法就是之前两层的走法的和。f[i] = f[i - 2] + f[i - 1]。
这里我们要注意，从i - 2层跳1步再跳1步的这个走法，已经包含在跳到第i - 1层的走法里了。所以不需要重复去加一次。 
再仔细看看这是啥？这不就是Fibonacci Sequence嘛！


Code
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int prevPrev = 1;
        int prev = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = prevPrev + prev;
            prevPrev = prev;
            prev = sum;
        }
        return sum;
    }
}