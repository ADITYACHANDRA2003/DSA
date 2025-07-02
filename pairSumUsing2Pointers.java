package placement;

import java.util.ArrayList;

public class pairSumUsing2Pointers {
    public static boolean findPairSum(ArrayList<Integer> list, int tar) {
        int breakingPoint = -1, n =list.size();
        for (int i = 1; i < n; i++) {
            if (list.get(i - 1) > list.get(i)) {
                breakingPoint = i;
                break;
            }
        }
            int firstPointer = breakingPoint;
            int secondPointer = breakingPoint-1;

            while (firstPointer != secondPointer) {
                if(list.get(firstPointer) + list.get(secondPointer)==tar) {
                    return true;
                }
                else if(list.get(firstPointer) + list.get(secondPointer)<tar) {
                    firstPointer = (firstPointer + 1)%n;
                }
                else if(list.get(firstPointer) + list.get(secondPointer)>tar)
                    secondPointer = (n+secondPointer-1)%n;
            }
            return false;
        }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(findPairSum(list,21));
    }
}
