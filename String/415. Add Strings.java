415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry =0 , sum =0;
        int i = num1.length() -1;
        int j = num2.length() -1;
        
        while(i>=0 || j >= 0){
            sum = carry;
            if(i>=0){
                sum +=num1.charAt(i) -'0'; //这个操作可以让char 变int
            }
            if(j>=0){
                sum +=num2.charAt(j) -'0';
            }
            sb.append(sum % 10);//取余数
            carry = sum /10 ; // 看一下有没有进位
            i--;
            j--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();  
    }
}