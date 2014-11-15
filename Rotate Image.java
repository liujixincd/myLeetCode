//Time complexity O(n^2)
//Space complexity O(1)
//cycleing solution
public class Solution {
    public void rotate(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return;
        }
        for (int i = 0; i < m.length / 2; i++) {
            for (int j = i; j < m.length - i - 1; j++) {
                int temp = m[i][j];
                m[i][j] = m[m.length - 1 - j][i];
                m[m.length - 1 - j][i] = m[m.length - i - 1][m.length - 1 - j];
                m[m.length - i - 1][m.length - 1 - j] = m[j][m.length - 1 - i];
                m[j][m.length - 1 - i] = temp;
            }
        }
    }
}
//mirroring solution
public class Solution {
    public void rotate(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return;
        }
        //diagnal mirroring
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(m, i, j, j, i);
            }
        }
        //vertical mirroring
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length / 2; j++) {
                swap(m, i, j, i, m.length - 1 - j);
            }
        }
    }
    public void swap(int[][]m,int i, int j, int k, int l) {
        int temp = m[i][j];
        m[i][j] = m[k][l];
        m[k][l] = temp;
    } 
}