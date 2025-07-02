package placement;

public class Sudoku {
    public static boolean solveSudoku(int[][] sudoku, int startRow, int startCol) {
        //base case
         if(startRow==9){
             return true;
         }

        int newRow = startRow, newCol = startCol+1; // moving to next element
         if(startCol+1==9){   // if reached to the last column of a row move to next row
            newRow = startRow+1;
            newCol = 0;
        }

         if(sudoku[startRow][startCol]!=0){
             return solveSudoku(sudoku, newRow, newCol);
         }
        //recursion
        for(int digit=1;digit<=9;digit++) {
            if(isSafe(sudoku,startRow,startCol,digit)){
                sudoku[startRow][startCol] = digit;
                if(solveSudoku(sudoku,newRow,newCol)){  // if returns then soln exists
                    return true;
                }
                sudoku[startRow][startCol] = 0; // if return false
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {

        int startRow = (row/3)*3, startCol = (col/3)*3;  // this is the formula to find the index of first row
        // and column of the 3x3 subarray the element belongs to

        // check whether same no. exist on the row or not is yes then false
        for(int i=0;i<9;i++) {
            if(sudoku[row][i]==digit){
                return false;
            }
        }

        // check whether same no. exist on the column or not is yes then false
        for(int i=0;i<9;i++) {
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        for(int i=startRow;i<startRow+3;i++) {
            for(int j=startCol;j<startCol+3;j++) {
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static void printSudoku(int[][] sudoku){
        for(int row=0;row<sudoku.length;row++){
            for(int col=0;col<sudoku[row].length;col++){
                System.out.print(sudoku[row][col]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = {
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},
                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},
                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };
        if(solveSudoku(sudoku,0,0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }
        else
            System.out.println("Solution not exists");
    }
}
