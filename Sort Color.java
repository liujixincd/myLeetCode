/*
Key Idea: we maintain the 3 indicators that represents the next index that 0, 1, 2 need to be inserted
we traverse the array, if we found a 0, we move all 2s, and 1s right for one slot and then 
we insert it to the index of indicator of zero, and we increment it 
Time complexity O(n)
*/
public class Solution {
    public void sortColors(int[] A) {
        if (A == null) {
            return;
        }
        int pos0 = 0;
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[pos2++] = 2;
                A[pos1++] = 1;
                A[pos0++] = 0;
            } else if (A[i] == 1) {
                A[pos2++] = 2;
                A[pos1++] = 1;
            } else {
                A[pos2++] = 2;
            }
        }
    }
}