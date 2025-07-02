package placement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class jobSequencingProblem {
    // Make a object
    public static class Jobs{
        int id;
        int deadline;
        int profit;

        Jobs(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void sequence(int[][] arr){
        ArrayList<Jobs> job = new ArrayList<>();
        int maxNoOfJobs = 0;

        // Add elements in this list for type Jobs
        for(int i=0; i<arr.length; i++){
            job.add(new Jobs(i,arr[i][0],arr[i][1]));
        }
        // Sort the list in descending order so that high profit elements on top
        Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<job.size(); i++){
            Jobs curr = job.get(i);
            if(curr.deadline > time){  // Matlab deadline element ki hai (ex 2 hai) aur time abhi zero hai to kar sakte
                seq.add(curr.id);
                time++;                 // hai us kaam ko since hamere paas time hai
                maxNoOfJobs++;
            }
        }

        System.out.println("The sequence is:-");
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " " );
        }
        System.out.println();

        System.out.println("Maximum no. of jobs that can be performed: " + maxNoOfJobs);
    }
    public static void main(String[] args) {
        int[][] arr = {{4,20},{1,10},{1,40},{1,30}};
        sequence(arr);
    }
}
