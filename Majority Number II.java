/*
 * key idea: canceling out different numbers
 * use two candidates
 * if current candidate is zero, we add current number as candidates.
 * if find a same number of one of those two candidates, we add the counts 
 * of that candidates
 * if the number is different from  twn candidates, the counter of two
 * candidates minus 1.
 *
 * Time Complexity O(n)
 * Space Complexity O(n)
 * */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count1 == 0) {
                num1 = nums.get(i);
            }
            if (count2 == 0 && nums.get(i) != num1) {
                num2 = nums.get(i);
            }
            if (nums.get(i) == num1) {
                count1++;
            } else if (nums.get(i) == num2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        return count1 > count2 ? num1 : num2;
    }
}

