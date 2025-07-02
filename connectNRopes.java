package placement;

import java.util.PriorityQueue;

public class connectNRopes {

    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size()>1){
            int first = pq.remove();
            int second = pq.remove();
            cost += first+second;
            pq.add(first+second);
        }
        System.out.println("The Cost is : "+cost);
    }
}
