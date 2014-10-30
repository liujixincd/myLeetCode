/*
 * basic idea is the same with 3 sum,
 * add another layer of loop
 * Time complexity O(n ^ 3)
 * Space Complexity O(1)
 * */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    int temp = num[i] + num[j] + num[k] + num[l];
                    if (temp == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[l]);
                        res.add(list);
                        l--;
                        k++;
                        while (l > k && num[l] == num[l + 1]) {
                            l--;
                        }
                        while (k < l && num[k] == num[k - 1]) {
                            k++;
                        }
                    } else if (temp > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
