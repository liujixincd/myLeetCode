/*
key idea : using dfs to recursively check the the front 3 character. we check the combinations of the 
3 strings if there is valid one(careful for strings like 0, 01, 001, if the first char is zero
the length of the string should be one);
Time complexity O(3 ^ n), space complexity O(n) + recursion stack cost;
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(res, new ArrayList<String>(), s, 0);
        return res;
    }
    public void helper(ArrayList<String> res, ArrayList<String> list, String s, int pos) {
        if (list.size() == 4) {
            if (pos == s.length()) {
                //generate results string
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(list.get(i));
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
            return;
        }
        for (int i = pos; i < pos + 3 && i < s.length(); i++) {
            String temp = s.substring(pos, i + 1);
            if (isValid(temp)) {
                list.add(temp);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isValid(String s) {
        int temp = Integer.parseInt(s);
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        } else {
            if (temp < 0 || temp > 255) {
                return false;
            }
        }
        return true;
    }
}