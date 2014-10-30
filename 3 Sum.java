/*
 *
 * Key Idea: Sort the Array and then use two pointers to search for reasults
 *
 *Caution: skip the duplicates after finding a result.
 *
 * */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = num.length - 1;
            while (l < r) {
                int temp = num[i] + num[l] + num[r];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[l]);
                    list.add(num[r]);
                    res.add(list);
                    l++;
                    r--;
                    while (l < r && num[l] == num[l - 1]) {
                        l++;
                    }
                    while (l < r && num[r] == num[r + 1]) {
                        r--;
                    }
                } else if (temp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
