
K Closest Points 

Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
     //思路 ： 维护一个max-heap,把Point一个一个放进去，如果超过容量，把最大的踢掉
    //heap里剩下的就是最小的K个
    public Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        
        globalOrigin = origin;
      
      //Comparator 根据题意 ，先比较距离，如果距离相等，比较X，如果X相等再比较Y
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int diff = getDistance(b, globalOrigin) - getDistance(a, globalOrigin);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        for (Point pt : points) {
            pq.add(pt);
            if (pq.size() > k)
                pq.poll();
        }
        
        
        Point[] result = new Point[k];
        while (k - 1 >= 0) {
            result[--k] = pq.poll();
        }
        
        return result;
    }
    
    public int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
    }
}


