/*
 *
 * key idea: find two indices i and j
 * i:starting at the end of the array, find the first number that is smaller 
 * than the next number
 * j: starting at i + 1 find the first number that is equal or smaller than A[i]
 * then j - 1
 * swap A[i] and A[j]
 * reverse A[i] to A[A.length - 1]
 * */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = i + 1;
            while (j < num.length && num[j] > num[i]) {
                j++;
            }
            j--;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        reverse(num, i+ 1);
    }
    public void reverse(int[] num, int start) {
        int left = start;
        int right = num.length - 1;
        while (left < right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
}
