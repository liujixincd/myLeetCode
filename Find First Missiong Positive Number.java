/*
 *Key idea :trough swapping we put every ligit number to it's correct place
			A[i] = i + 1;
			if A[i] == 0 || A[i] > A.length  || A[i] == A[A[i] - 1] skip
			we pass the array again to find which number is missing
			when we reached the end of the array, we still couldn't find the missing positive then
			it's A.length + 1
			Time complexity O(n);
			Space complexityO(1);
 *
 *
 *
 *
 * */
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) {
                i++;
            } else {
                swap(A, i, A[i] - 1);
            }
        }
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return A.length + 1;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
