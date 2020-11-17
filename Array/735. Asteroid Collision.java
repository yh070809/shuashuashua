735. Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.



class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int a : asteroids){
            //这几种情况直接入栈：为空， 相反， 不相关
            if(stack.isEmpty() || a * stack.peek() > 0 || stack.peek() < 0 && a > 0){
                stack.push(a);
            }//先销再入栈
            else{
                boolean flag = true;
                while(!stack.isEmpty() && stack.peek()*a < 0){
                    if(Math.abs(stack.peek())==Math.abs(a)){
                        stack.pop();
                        //碰撞掉了， 没了
                        flag = false;
                        break;
                    }else if (Math.abs(stack.peek()) < Math.abs(a)){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
                if(flag) stack.push(a);
            }
        }
        
        int size = stack.size();
        int[] res = new int[size];
        int index = size -1;
        while (stack.size() > 0){
            res[index --] = stack.pop();
        }
        
        return res;
        
        
    }
}