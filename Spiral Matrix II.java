/*
in total, we need to traverse n / 2 layers.
for each layer it starts from m[layer][layer] ends with m[layer][n - layer - 1]
if the length one edge in layer is n, we generate[layer][layer] to  [layer][n -layer - 2], 
we then generate [layer][n - layer - 1] to [n - layer - 2][n - layer - 1];
then [n - layer - 1][n - layer - 1] to [n - layer - 1][layer + 1]
then [n - layer - 1][layer] to [layer + 1][layer];
if (n % 2 = 1), we need to generate [layer][layer]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int count = 1;
        int[][] res = new int[n][n];
        int layer = n / 2;
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < n - i - 1; j++) {
                res[i][j] = count++;
            }
            for (int j = i; j < n - i - 1; j++) {
                res[j][n - i - 1] = count++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[n - i - 1][j] = count++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[j][i] = count++;
            }
        }
        if (n % 2 == 1) {
            res[layer][layer] = count;
        }
        return res;
    }
}