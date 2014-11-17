/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 *Idea: bfs + hashMap + queue Time Complexity O(m + n) Space complexity O(n)
 *
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        q.offer(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        while(!q.isEmpty()) {
        	UndirectedGraphNode cur = q.poll();
        	for (UndirectedGraphNode temp : cur.neighbors) {
        		if (map.containsKey(temp)) {
        			map.get(cur).neighbors.add(map.get(temp));
        		} else {
        			newNode = new UndirectedGraphNode(temp.label);
        			map.put(temp, newNode);
        			q.offer(temp);
        			map.get(cur).neighbors.add(newNode);
        		}
        	}
        }
        return map.get(node);
    }
}