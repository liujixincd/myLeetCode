/*
key idea would be use the firstRow and first Column to record if we need to fill zeros in the correspondent 
row and columns.
Time Complexity(O(mn))
Space Complexity(O(1))
*/
public class Solution {
    public void setZeroes(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return;
        }
        boolean setFirstRow = false;
        boolean setFirstCol = false;
        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] == 0) {
                setFirstRow = true;
                break;
            }
        }
        for (int j = 0; j < m.length; j++) {
            if (m[j][0] == 0) {
                setFirstCol = true;
                break;
            }
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] == 0) {
                for (int j = 1; j < m[0].length; j++) {
                    m[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < m[0].length; j++) {
            if (m[0][j] == 0) {
                for (int i = 1; i < m.length; i++) {
                    m[i][j] = 0;
                }
            }
        }
        if (setFirstRow) {
            for (int j = 0; j < m[0].length; j++) {
                m[0][j] = 0;
            }
        }
        if (setFirstCol) {
            for (int i = 0; i < m.length; i++) {
                m[i][0] = 0;
            }
        }
    }
}