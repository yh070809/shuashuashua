345. Reverse Vowels of a String
Easy

836

1322

Add to List

Share
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"

class Solution {
    public String reverseVowels(String s) {
        // 对撞指针解法
        // 区分大小写
        if(s == null || s.length() < 2) return s;

        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        
        while (i < j) {
            // 从前向后找到元音
            while(i < chars.length && !isVowel(chars[i]))
                i++;
            // 从后向前找到元音
            while(j >= 0 && !isVowel(chars[j]))
                j--;
            if (i < j) {
                // 进行元音反转
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    // 判断一个字符是否是元音字母
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;
    }
}
