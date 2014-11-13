public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] row = new int[n];
        int[] res = new int[1];
        helper(n, row, res, 0);
        return res[0];
    }
    public void helper(int n, int[] row, int[] res, int curRow) {
        if (curRow == n) {
            res[0] += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            row[curRow] = i;
            if (isValid(row, curRow)) {
                helper(n, row, res, curRow + 1);
            }
        }
    }
    public boolean isValid(int[] row, int curRow) {
        for (int i = 0; i < curRow; i++) {
            if (row[i] == row[curRow] || curRow - i == Math.abs(row[i] - row[curRow])) {
                return false;
            }
        }
        return true;
    }
}