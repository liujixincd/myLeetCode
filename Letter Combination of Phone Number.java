/*
dfs + hashMap
Time Complexity O(k * n)
Space Complexity O(k * n)
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            res.add("");
            return res;
        }
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        helper(res, new StringBuilder(), map, 0, digits);
        return res;
    }
    public void helper(ArrayList<String> res, StringBuilder sb, HashMap<Character, char[]> map, int pos, String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(pos))) {
            sb.append(c);
            helper(res, sb, map, pos + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}