/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    static HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        map = new HashMap<>();
        return bfs(node);
    }

    public Node bfs(Node node){
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node adj:curr.neighbors){
                if(!map.containsKey(adj)){
                    map.put(adj, new Node(adj.val));
                    q.offer(adj);
                }

                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return clone;
    }
}