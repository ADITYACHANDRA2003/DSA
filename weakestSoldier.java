package placement;
import java.util.PriorityQueue;

public class weakestSoldier {

    public static class Info implements Comparable<Info> {
        int nos;
        int row;

        Info(int nos, int row){
            this.nos = nos;
            this.row = row;
        }

        @Override
        public int compareTo(Info info){
            if(this.nos == info.nos){
                return this.row - info.row; // agar no. of soldier same then compare index
            }
            else{
                return this.nos - info.nos;  // else compare no. of soldiers
            }
        }
    }
    public static void main(String[] args) {
        int[][] positions = {{1, 0, 0, 0},
                             {1, 1, 1, 1},
                             {1, 0, 0, 0},
                             {1, 0, 0, 0}
        };

        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        for(int i = 0; i<positions.length; i++){
            int count = 0;
            for(int j = 0; j<positions[i].length; j++){
                if(positions[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Info(count, i));
        }
        int noOfWeakestSoldier = 2;
        for(int i = 0; i<noOfWeakestSoldier; i++){
            System.out.println("Row "+pq.remove().row);
        }
    }
}
