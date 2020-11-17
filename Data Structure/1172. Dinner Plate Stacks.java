1172. Dinner Plate Stacks
You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
void push(int val) Pushes the given positive integer val into the leftmost stack with size less than capacity.
int pop() Returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
int popAtStack(int index) Returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
Example:

Input: 
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output: 
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation: 
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
                                                       1  3  5
                                                       ﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
                                                        1  3  5
                                                        ﹈ ﹈ ﹈ 
D.pop()            // Returns 5.  The stacks are now:      4
                                                        1  3 
                                                        ﹈ ﹈  
D.pop()            // Returns 4.  The stacks are now:   1  3 
                                                        ﹈ ﹈   
D.pop()            // Returns 3.  The stacks are now:   1 
                                                        ﹈   
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.


class DinnerPlates {
   int mCapacity;
int pushIndex;
int popIndex;
Stack<Integer>[] list = new Stack[100000];
public DinnerPlates(int capacity) {
    mCapacity=capacity;
}

public void push(int val) {
    Stack stack = list[pushIndex];
    if(stack==null) stack=new Stack();
    stack.push(val);
    list[pushIndex]=stack;
    if(stack.size()==mCapacity){
        for(int i=pushIndex+1;i<list.length;i++){
            if(list[i]==null||list[i].size()<mCapacity){
                pushIndex=i;
                break;
            }
        }
    }
    if(pushIndex>popIndex) popIndex=list[pushIndex]==null?pushIndex-1:pushIndex;
}

public int pop() {
    if(list[popIndex].size()==0) return -1;
    int res = list[popIndex].pop();
    if(list[popIndex].size()==0){
        for(int i=popIndex-1;i>=0;i--){
            if(list[i].size()>0){
                popIndex=i;
                break;
            }
        }
    }
    if(popIndex<pushIndex) pushIndex=list[popIndex].size()==mCapacity?popIndex+1:popIndex;
    return res;
}

public int popAtStack(int index) {
    if(index==popIndex) return pop();
    if(index>popIndex) return -1;
    if(list[index].size()==0) return -1;
    if(index<pushIndex) pushIndex=index;
    return list[index].pop();
}
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */