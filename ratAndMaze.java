package placement;

public class ratAndMaze {
    public static void printWays(int[][] maze,int startRow,int startCol,int[][] visited){
        //base case
        if(startRow==maze.length-1 && startCol==maze[0].length-1){
            visited[startRow][startCol]=1;
            printSol(visited);
            visited[startRow][startCol]=0;
            return;
        }


        //Boundary conditions
        if (startRow < 0 || startCol < 0 || startRow >= maze.length || startCol >= maze[0].length || visited[startRow][startCol] == 1 || maze[startRow][startCol] == 0) {
            return;  // Skip invalid positions
        }



        visited[startRow][startCol]=1;

        //Recursion

        //move right
        printWays(maze,startRow,startCol+1,visited);
        //move left
        printWays(maze,startRow,startCol-1, visited);
        //move up
        printWays(maze,startRow-1,startCol,visited);
        //move down
        printWays(maze,startRow+1,startCol,visited);

        visited[startRow][startCol]=0;

    }
    public static void printSol(int[][] visited){
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int maze[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,1,1},
                {1,1,0,1}
        };
        int n = maze.length, m = maze[0].length;
        int[][] visited = new int[n][m];
        printWays(maze,0,0,visited);
    }
}
