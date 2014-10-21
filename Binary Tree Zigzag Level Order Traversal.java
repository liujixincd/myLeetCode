/**
 * Idea: use two stack, one stores current level nodes that we need to add to result set,
 * Other is nextLevel stack, which stores the next level nodes that we need to traverse. 
 * Time Complexity O(N) Space Complexity O(N) 
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        boolean normalOrder = true;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!currentLevel.isEmpty()) {
                TreeNode cur = currentLevel.pop();
                level.add(cur.val);
                if (normalOrder) {
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                }
            }
            normalOrder = !normalOrder;
            Stack<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            res.add(level);
        }
        return res;
    }
}