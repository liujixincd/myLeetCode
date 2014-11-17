/*
0
1
1 + (1 << 1) = 11
0 + (1 << 1) = 10
Space Complexity (2 ^ n)
Time Complexity (2 ^ n)

*/
public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for (int i = 2; i <= n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << (i - 1)));
            }
        }
        return res;
    }
}