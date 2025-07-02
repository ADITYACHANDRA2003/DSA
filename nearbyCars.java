package placement;

import java.util.PriorityQueue;

public class nearbyCars {

    static class Points implements Comparable<Points> {

        int x;
        int y;
        int distance;
        int idx;

        public Points(int x, int y, int distance, int idx) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Points o) {
            return this.distance - o.distance;  // sort in ascending order
        }

    }
    public static void main(String[] args) {
     int pts[][] = {{3,3},{5,-1},{-2,4}};
     PriorityQueue<Points> pq = new PriorityQueue<Points>();
     for (int i = 0; i < pts.length; i++) {
          int dis = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
          pq.add(new Points(pts[i][0],pts[i][1],dis,i));
     }
     int k = 2;
     for (int i = 0; i < k; i++) {
         System.out.println("C" + pq.remove().idx);
     }
    }
}
