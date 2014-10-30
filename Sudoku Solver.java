/*
 * key idea : dfs 
 *
 * */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        helper(board, 0, 0);
    }
    public boolean helper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return helper(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return helper(board, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            board[row][col] = (char)('0' + i);
            if (isValid(board, row, col)) {
                if (helper(board, row, col + 1)) {
                    return true;
                }
            }
            board[row][col] = '.';
        }
        return false;
    }
    public boolean isValid(char[][] board, int row, int col) {
        //check current row
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }
        //check current column
        for (int j = 0; j < 9; j++) {
            if (j != row && board[j][col] == board[row][col]) {
                return false;
            }
        }
        //check matrix
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
