/*
HashMap<number, Position>
O(n)
O(n)
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i + 1;
                return res;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return res;
    }
}