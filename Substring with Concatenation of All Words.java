/*
key idea two hashmap
one store what we need to find
one store what we already found in this iteration
Time Complexity O(L.length * len)
Space Complexity O(L.length * len)
*/
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0 || L[0].length() == 0) {
            return res;
        }
        int len = L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String temp : L) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            HashMap<String, Integer> toFind = new HashMap<String, Integer>(map);
            for (int j = i; j <= S.length() - len; j += len) {
                String temp = S.substring(j, j + len);
                if (toFind.containsKey(temp)) {
                    toFind.put(temp, toFind.get(temp) - 1);
                    if (toFind.get(temp) == 0) {
                        toFind.remove(temp);
                    }
                    if (toFind.size() == 0) {
                        res.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}