// // Follow up for "Find Minimum in Rotated Sorted Array":
// // What if duplicates are allowed?
// Would this affect the run-time complexity? How and why?
// A: yes, worst case all elements the same, time complexity is o(n);
public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        }
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
        	int mid = left + (right - left) / 2;
        	if (num[mid] > num[right]) {
        		left = mid + 1;
        	} else if (num[mid] == num[right]) {// the right element is not useful we try to move left
        		right--;
        	} else {
        		right = mid;
        	}
        }
        return num[right];
    }
}