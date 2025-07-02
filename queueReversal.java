package placement;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class queueReversal {

    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        while(!q.isEmpty()) {
            int val = q.remove();
            s.push(val);
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        reverse(queue);

        while(!queue.isEmpty()) {
            System.out.print(queue.remove()+" ");
        }
    }
}
