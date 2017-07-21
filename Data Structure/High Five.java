High Five

There are two properties in the node student id and scores, to ensure that each student will have 
at least 5 points, find the average of 5 highest scores for each person.

Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return 


/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        
        //define 出口 
        Map<Integer,Double> res = new HashMap <Integer,Double>();
        
        //根据题意，对于每一个id，我们维护一个大小为K的min-heap。一个一个把Record放进去，如果容量超了，就把最小的踢掉。这样heap里永远是最大的K个。
        HashMap<Integer,PriorityQueue<Record>> map = new HashMap <Integer,PriorityQueue<Record>>();
        
        int k =5;
        for (Record r : results) {
            if(!map.containsKey(r.id)){
                //一个min-heap的实现
                PriorityQueue<Record> pq = new PriorityQueue <Record> (k,new Comparator<Record>(){
                    public int compare (Record a, Record b){
                        return a.score - b.score; //min-heap --> left -right 
                        //如果是max -heap, ---> right -left (大的减去小的)
                    }
                });
                
                map.put(r.id,pq);
            }
            map.get(r.id).add(r);
            
            if(map.get(r.id).size()> k){
                map.get(r.id).poll(); // 如果大于K了,每次移出最小值,剩下的就是K个最大值
            }
        }
        
       // 全部放完以后，对于每一个id，我们把heap里的Record拿出来算一下平均数。
       for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            res.put(id, average);
        }
        
        return res;
    }
}


