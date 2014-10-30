/*
 * Using BFS and Queue to serialize and recover the tree.
 */
class Solution {
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == Integer.MIN_VALUE) {
                    sb.append("#,");
                    continue;
                } else {
                    sb.append(cur.val);
                    sb.append(",");
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                } else {
                    q.offer(new TreeNode(Integer.MIN_VALUE));
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                } else {
                    q.offer(new TreeNode(Integer.MIN_VALUE));
                }
            }
        }
        while (Character.isDigit(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
        	return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int idx = 1;
        while (!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if (idx < nodes.length) {
        			TreeNode left = nodes[idx].equals("#") ? null : new TreeNode(Integer.parseInt(nodes[idx]));
        			if (left != null) {
        				q.offer(left);
        			}
        			cur.left = left;
        			idx++;
        		}
        		if (idx < nodes.length) {
        			TreeNode right = nodes[idx].equals("#") ? null : new TreeNode(Integer.parseInt(nodes[idx]));
        			if (right != null) {
        				q.offer(right);
        			}
        			cur.right = right;
        			idx++;
        		}
        	}
        }
        return root;
    }
    
}

//using rescursion + dfs + global idx to help recovering the tree.
class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }
    int idx = 0;
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        return helper(nodes);
    }
    public TreeNode helper(String[] nodes) {
        if (idx == nodes.length || nodes[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++]));
        root.left = helper(nodes);
        root.right = helper(nodes);
        return root;
    }
}





