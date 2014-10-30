public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }
        int left = n;
        int right = n;
        helper(res, n, n, new StringBuilder());
        return res;
    }
    public void helper(ArrayList<String> res, int left, int right, StringBuilder sb) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        helper(res, left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        helper(res, left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
