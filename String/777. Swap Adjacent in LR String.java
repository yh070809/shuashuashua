777. Swap Adjacent in LR String
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

 

Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Example 2:

Input: start = "X", end = "L"
Output: false
Example 3:

Input: start = "LLR", end = "RRL"
Output: false
Example 4:

Input: start = "XL", end = "LX"
Output: true
Example 5:

Input: start = "XLLR", end = "LXLX"
Output: false


// 这道题给了我们一个只含有L，R，X三个字符的字符串，然后说有两种操作，一种是把 "XL" 变成 "LX"，另一种是把 "RX" 变成 "XR"。博主刚开始没有读题意，以为二者是可以互换的，错误的认为认为 "LX" 也能变成 "XL"，其实题目这种变换是单向，这种单向关系就是解题的关键，具体来说，就是要把 start 字符串变成 end 字符串的话，L只能往前移动，因为是把 "XL" 变成 "LX"，同样，R只能往后移动，因为是把 "RX" 变成 "XR"。题目给的那个例子并不能很好的说明问题，博主之前那种双向变换的错误认知会跪在这个例子：

// start = "XXRXXLXXXX"
// end  = "XXXXRXXLXX"

// 观察这个 test case，可以发现 start 中的R可以往后移动，没有问题，但是 start 中的L永远无法变到end中L的位置，因为L只能往前移。这道题被归类为 brainteaser，估计就是因为要观察出这个规律吧。那么搞明白这个以后，其实可以用双指针来解题，思路是，每次分别找到 start 和 end 中非X的字符，如果二者不相同的话，直接返回 false，想想问什么？这是因为不论是L还是R，其只能跟X交换位置，L和R之间是不能改变相对顺序的，所以如果分别将 start 和 end 中所有的X去掉后的字符串不相等的话，那么就永远无法让 start 和 end 相等了。这个判断完之后，就来验证L只能前移，R只能后移这个限制条件吧，当i指向 start 中的L时，那么j指向 end 中的L必须要在前面，所以如果i小于j的话，就不对了，同理，当i指向 start 中的R，那么j指向 end 中的R必须在后面，所以i大于j就是错的，最后别忘了i和j同时要自增1，不然死循环了。while 循环退出后，有可能i或j其中一个还未遍历到结尾，而此时剩余到字符中是不能再出现L或R的，否则不能成功匹配，此时用两个 while 循环分别将i或j遍历完成，需要到了L或R直接返回 false 即可，加上了这一步后就不用在开头检测 start 和 end 中L和R的个数是否相同了，参见代码如下：
// 这道题给了我们一个只含有L，R，X三个字符的字符串，然后说有两种操作，一种是把 "XL" 变成 "LX"，另一种是把 "RX" 变成 "XR"。博主刚开始没有读题意，以为二者是可以互换的，错误的认为认为 "LX" 也能变成 "XL"，其实题目这种变换是单向，这种单向关系就是解题的关键，具体来说，就是要把 start 字符串变成 end 字符串的话，L只能往前移动，因为是把 "XL" 变成 "LX"，同样，R只能往后移动，因为是把 "RX" 变成 "XR"。题目给的那个例子并不能很好的说明问题，博主之前那种双向变换的错误认知会跪在这个例子：

// start = "XXRXXLXXXX"
// end  = "XXXXRXXLXX"

// 观察这个 test case，可以发现 start 中的R可以往后移动，没有问题，但是 start 中的L永远无法变到end中L的位置，因为L只能往前移。这道题被归类为 brainteaser，估计就是因为要观察出这个规律吧。那么搞明白这个以后，其实可以用双指针来解题，思路是，每次分别找到 start 和 end 中非X的字符，如果二者不相同的话，直接返回 false，想想问什么？这是因为不论是L还是R，其只能跟X交换位置，L和R之间是不能改变相对顺序的，所以如果分别将 start 和 end 中所有的X去掉后的字符串不相等的话，那么就永远无法让 start 和 end 相等了。这个判断完之后，就来验证L只能前移，R只能后移这个限制条件吧，当i指向 start 中的L时，那么j指向 end 中的L必须要在前面，所以如果i小于j的话，就不对了，同理，当i指向 start 中的R，那么j指向 end 中的R必须在后面，所以i大于j就是错的，最后别忘了i和j同时要自增1，不然死循环了。while 循环退出后，有可能i或j其中一个还未遍历到结尾，而此时剩余到字符中是不能再出现L或R的，否则不能成功匹配，此时用两个 while 循环分别将i或j遍历完成，需要到了L或R直接返回 false 即可，加上了这一步后就不用在开头检测 start 和 end 中L和R的个数是否相同了，参见代码如下：


class Solution {
    public boolean canTransform(String start, String end) {
        if(start.length() != end.length()){
            return false;
        }
        
        int n = end.length();
        
        for(int i =0 , j =0 ; true; i++,j++){// i<n && j < n
            while( i< n && start.charAt(i) =='X') i++;
            while(j < n && end.charAt(j) == 'X') j++;
            
            if( i==n || j == n){
                return i == j;
            }
            
            
            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i < j)  return false;
            if(start.charAt(i) == 'R' && i > j)  return false;
            
        }
        
    }
}