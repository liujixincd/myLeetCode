/*
 * key ideas: sort the array, search every possible combination
 * if we find the target sum, return sum
 * if we cannot find the target sum, we change left or right indicator
 * if current sum is closer to target we update the res
 * no need to worry about the duplicates in this problem
 * Time Complexity O(n ^ 2)
 * Space Complexity O(1);
 *
 * */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return -1;
        }
        Arrays.sort(num);
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < num.length; i++) {
            int l = i + 1;
            int r = num.length - 1;
            while (l < r) {
                int temp = num[i] + num[l] + num[r];
                if (temp == target) {
                    return temp;
                }
                if (temp > target) {
                    r--;
                } else {
                    l++;
                }
                res = Math.abs(temp - target) < Math.abs(res - target) ? temp : res;
            }
        }
        return res;
    }
}
