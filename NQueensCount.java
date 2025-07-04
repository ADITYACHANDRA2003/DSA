package placement;

public class NQueensCount {
    public static void placeQueens(char[][] board, int row) {
        if(row == board.length){
            count++; // causing pass by reference
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                placeQueens(board,row+1);
                board[row][j]='X';
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
    static int count=0;
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        placeQueens(board,0);
        System.out.println(count);
    }
}
