Two Sum - Data structure design 

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.


Example ：

add(1); add(3); add(5);
find(4) // return true
find(7) // return false


思路
Two Sum的一个变形。
还是维护一个HashMap，在add的时候把这个数字的出现过的频率也统计上。
查找value的时候，遍历一下HashMap的keySet，对于每一个key，看看value - key是不是也在keySet里。
注意一下如果key == target的时候我们要看看key的频率是不是大于1。否则就不是答案。


public class TwoSum {

    private HashMap<Integer,Integer> map;
    
    public TwoSum(){
        map = new HashMap<>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number,1);// 1是指出现的频率
        }else {
            map.put(number,map.get(number)+1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for( int key : map.keySet()){
            int target = value - key;
            if(map.containsKey(target)){
                if(target != key || map.get(target) >1){
                    return true;
                }
            }
        }
        
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);