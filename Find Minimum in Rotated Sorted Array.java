/*
Idea, binary search.
if num[mid] > num[right], becasue it is a rotated sorted array, the minimum must in [mid + 1, right]
else the minimum must be in [left, mid];
*/
public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return num[right];
    }
}