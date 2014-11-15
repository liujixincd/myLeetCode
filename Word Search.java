/*
key idea : dfs backtracing be careful you can not going back when you already used that character
in matrix board.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = helper(board, word, i + 1, j, pos + 1) || helper(board, word, i - 1, j, pos + 1) || helper(board, word, i, j + 1, pos + 1) || helper(board, word, i, j - 1, pos + 1);
        board[i][j] = temp;
        return res;
    }
}