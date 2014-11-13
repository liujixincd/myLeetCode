/*
 * key Idea: partion, swap, two pointers
 * Time Complexity O(n)
 * Space Complexity O(n)
*/
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length <= 1) {
            return;
        }
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] >= 'a' && chars[l] <= 'z') {
                l++;
            } else {
                swap(chars, l, r);
                r--;
            }
        }
    }
    public void swap(char[] A, int i, int j) {
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
