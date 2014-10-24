/*
 start from the 2nd row,
 each new row the say number[i][j] = number[i - 1][j - 1] number[i - 1][j]
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        for (int i = 1; i < numRows; i++) {
            temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}