/*
 * key idea: binary search, we do the binary search twice, first search we find
 * the left bound second search we find the right bound
 * Time Complexity O(logn)
 * Space Complexity O(n)
 *
 * */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (A == null || A.length == 0) {
            return res;
        }
        //searh for left bound
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[left] == target) {
            res[0] = left;
        } else if (A[right] == target) {
            res[0] = right;
        } else {
            return res;
        }
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] == target) {
            res[1] = right;
        } else if (A[left] == target) {
            res[1] = left;
        } else {
            return res;
        }
        return res;
    }
}
