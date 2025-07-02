package placement;

public class NQueensCheckAnswer {
    public static boolean placeQueens(char[][] board, int row) {
        if(row == board.length){
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                if(placeQueens(board,row+1)) return true;
                board[row][j]='X';
            }

        }
        return false;
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
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        if(placeQueens(board,0)){
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
}
