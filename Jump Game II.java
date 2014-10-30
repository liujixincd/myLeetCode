/*
 * key idea: sequence dp. 2 indicator :
 * canReach, the current index we can Reach
 * if can Reach < i, we cannot reach i
 * lastReach : after last jump, the index we can reach
 * if lastReach < i <= canReach
 * it means that we have to jump onece to reach the current i
 * update the canReach index we it is necessary.
 *
 *
 * */
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int canReach = A[0];
        int lastReach = 0;
        int steps = 0;
        for (int i = 0; i < A.length && canReach >= i; i++) {
            if (lastReach < i) {
                steps++;
                lastReach = canReach;
            }
            canReach = Math.max(i + A[i], canReach);
        }
        return steps;
    }
}
