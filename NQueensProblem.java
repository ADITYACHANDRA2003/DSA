package placement;

public class NQueensProblem {
    public static void placeQueens(char[][] board, int row) {
        if(row == board.length){
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                placeQueens(board,row+1);
                board[row][j]='X';// If the recursive call fails (i.e., no valid placements in the next rows),
                // you need to remove the queen and try another column. This is why we reset the position back to 'X'
            }
        }
    }
    public static boolean isSafe(char[][] board, int row, int col) {
        // check up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        // check left diagonal
        for (int i = row-1 , j=col-1; i >= 0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') return false;
        }

        // check right diagonal
        for (int i = row-1 , j=col+1; i >= 0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    public static void printBoard(char[][] board){
    System.out.println("-------CHESS BOARD--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        placeQueens(board,0);
    }
}
