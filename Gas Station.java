/*
 * key idea: greedy, if the total gas minus total cost is larger than 0
 * it means that there must be a way to complete the circuit
 * we maintain a variable to record where we can start,
 * if at one point during the pass, the temp is smaller than zero means we 
 * cannot reach current tank with that start point, and the only possible start
 * point is i + 1;
 * */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int total = 0;
        int start = 0;
        int temp = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            temp += gas[i] - cost[i];
            if (temp < 0) {
                start = i + 1;
                temp = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
