package placement;
import java.util.Queue;
import java.util.LinkedList;

public class interleave2HalvesOfQueue {

    public static void interleave(Queue<Integer> q) {
        int size = q.size()/2;
        Queue<Integer> helper = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int value = q.remove();
            helper.add(value);
        }
        for (int i = 0; i < size; i++) {
            q.add(helper.remove());
            int value = q.remove();
            q.add(value);
        }
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        interleave(queue);
    }
}
