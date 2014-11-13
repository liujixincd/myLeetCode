/*
 *
 * keyIdea is using hashMap, same number plus one, different all numbers
 * decrease 1 and if count is zero, remove from hashset
 *
 * */
public int majorityNumber3(int[] A, int k){
    	if (A == null || A.length == 0 || k > A.length) {
    		return -1;
    	}
    	
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < A.length; i++) {
    		if (map.containsKey(A[i])) {
    			map.put(A[i], map.get(A[i]) + 1);
    		} else if (map.size() < k) {
    			map.put(A[i], 1);
    		} else {
    			ArrayList<Integer> keys = new ArrayList<Integer>();
    			for (Integer key : map.keySet()){
    				keys.add(key);
    			}
    			for (Integer key : keys) {
    				map.put(key, map.get(key) - 1);
    				if (map.get(key) == 0) {
    					map.remove(key);
    				}
    			}
    		}
    	}
    	
    	int res = 0;
    	int num = 0;
    	for (Integer key : map.keySet()) {
    		if (num < map.get(key)) {
    			num = map.get(key);
    			res = key;
    		}
    	}
    	
    	return res;
}
