/*
key idea, hashMap<String, ArrayList<String>> iteration through the hashMap use iterator Map.Entry
map.entrySet.iterator();
change each string to charArray and sort the array as index of one anagram, add each str to the 
correspondent ArrayList.
if the length of the arrayList is greater than one it means that there is anagrams for this string in 
strs[], add the arrayList to the results set

Time complexity O(nKlogK) Space O(n);
t
*/
public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
        	return res;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String temp : strs) {
        	char[] arr = temp.toCharArray();
        	Arrays.sort(arr);
        	String str = new String(arr);
        	if (map.containsKey(str)) {
        		map.get(str).add(temp);
        	} else {
        		ArrayList<String> newList = new ArrayList<String>();
        		newList.add(temp);
        		map.put(str, newList);
        	}
        }
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry ety = (Map.Entry)itr.next();
            ArrayList<String> cur = (ArrayList<String>) ety.getValue();
            if (cur.size() > 1) {
                res.addAll(cur);
            }
        }
        return res;
    }
}