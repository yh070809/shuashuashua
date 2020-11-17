438. Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0) +1);
        }
        
        //variable so that we don't need to hit map many times
        int count = map.size();
        int right = 0 , left = 0 ;
        int windowSize = p.length();
        while(right < s.length()){
            char key = s.charAt(right);
            //maintaing a map of current window characters
            if(map.containsKey(key)){
                int val = map.get(key);
                map.put(key,--val);
                if(val ==0)
                    count --;
            }
            
            if (right -left + 1 < windowSize){
                right ++;
            }else if (right -left + 1  == windowSize){//if its equal to window size extract answer and move window
                if(count == 0){
                    ans.add(left);
                }
                char leftChar= s.charAt(left);
                if(map.containsKey(leftChar)){
                    int val = map.get(leftChar);
                    if(val == 0 ){
                        count ++;
                    }
                    map.put(leftChar,++val);
                }
                left ++;
                right ++;
                
            }
            
        }
        
        return ans;
    }
}