394. Decode String
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"


class Solution {
    public String decodeString(String s) {
        String res = "";
        //记录'['之前的数字
        Stack<Integer> countStack = new Stack<>();
        //记录'['之前的运算结果
        Stack<String> resStack = new Stack<>();
        
        int idx = 0;
        int curNum =0;
        while(idx < s.length()){
            char ch= s.charAt(idx);
            if(Character.isDigit(ch)){
                while(Character.isDigit(s.charAt(idx))){
                    curNum = 10 * curNum +(s.charAt(idx++) -'0');
                }
                
            }else if(ch =='['){
                resStack.push(res);
                res ="";
                countStack.push(curNum);
                curNum =0;
                idx++;
            }else if(ch ==']'){
                StringBuilder tmp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for(int i =0; i < repeatTimes ; i++){
                    tmp.append(res);
                }
                res =tmp.toString();
                idx ++;
            }else{
                res +=s.charAt(idx++);
            }
        }
        return res;
        
    }
}