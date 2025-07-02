package placement;

// ONLY MOVING RIGHT AND DOWN IS ALLOWED
// O(2^(n+m))
public class gridProblem {
    public static int ways(int currRow,int currCol,int arrayRows,int arrayCol) {

      if(currRow==arrayRows-1 && currCol==arrayCol-1) return 1; // boundary condition
      else if(currRow==arrayRows || currCol==arrayCol) return 0; // out of boundary condition

      //move right
      int way1 = ways(currRow,currCol+1,arrayRows,arrayCol);

      //move down
      int way2 = ways(currRow+1,currCol,arrayRows,arrayCol);

      return way1+way2;
    }
    public static void main(String[] args) {
        System.out.println(ways(0,0,3,3));
    }
}
