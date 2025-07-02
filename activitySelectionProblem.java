package placement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activitySelectionProblem {

    // HAVE A LOOK AT THIS FIRST

//    public static void main(String[] args) {
//        int[] start = {1,3,0,5,8,5};
//        int[] end = {2,4,6,7,9,9};
//
//        int activitySelected = 0;
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        // first activity selected
//        activitySelected = 1;  // paheli activity hamne manually select ki
//        arr.add(0);
//        int lastEnd = end[0];
//        for (int i = 1; i < start.length; i++) {
//            if(start[i]>=lastEnd){
//                arr.add(i);
//                lastEnd = end[i];
//                activitySelected++;
//            }
//        }
//
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.print("A"+arr.get(i)+" ");
//        }
//        System.out.println();
//        System.out.println("No. of activities selected => "+activitySelected);
//    }

    // 2D MATRIX APPROACH IN CASE OUR TIMES ARE NOT SORTED  (Easy hai)
    // here we will be storing index at first column , second column startTime , third column endTime

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        int activitySelected = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] activities = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
         // lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));  // we defined that we are sorting activities
        // second column(endTime)

        // first activity selected
        activitySelected = 1;  // paheli activity hamne manually select ki
        arr.add(activities[0][0]);  // storing the activity no. (currently first)
        int lastEnd = activities[0][2];
        for (int i = 1; i < start.length; i++) {
            if(activities[i][1]>=lastEnd){
                arr.add(activities[i][0]);
                lastEnd = activities[i][2];
                activitySelected++;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print("A"+arr.get(i)+" ");
        }
        System.out.println();
        System.out.println("No. of activities selected => "+activitySelected);
    }
}
