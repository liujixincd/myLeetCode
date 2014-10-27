public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String res = "/";
        String[] paths = path.split("/+");
        ArrayList<String> item = new ArrayList<String>();
        for (String str : paths) {
        	if (str.equals("..")) {
        		if (!item.isEmpty()) {
        			item.remove(item.size() - 1);
        		}
        	} else {
        	    if (!str.equals(".") && !str.equals("")) {
        		    item.add(str);
        	    }
        	}
        }
        for (String str : item) {
            if (str.length() > 0)
            res += str + "/";
        }
        if (res.length() > 1) {
        	res = res.substring(0, res.length() - 1);
        }
        return res;
    }
}
