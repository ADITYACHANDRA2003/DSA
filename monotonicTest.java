package placement;

import java.util.ArrayList;

public class monotonicTest {

    public static boolean monotone(ArrayList<Integer> list) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                increasing = false;
            }
            if (list.get(i - 1) < list.get(i)) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        System.out.println(monotone(list)); // Expected output: true
    }
}
