/*
key idea binary search
Time Complexity O(logn)
Becareful about situations : target is smaller than the front element
Target is larger than the end element
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (target < A[0]) {
            return 0;
        }
        if (target > A[A.length - 1]) {
            return A.length;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            return left;
        } else {
            return right;
        }
    }
}