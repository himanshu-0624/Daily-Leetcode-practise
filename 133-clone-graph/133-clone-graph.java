/*
// Definition for a Node.
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
  
    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return null;
        HashMap<Node,Node> x = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        x.put(node,new Node(node.val));
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                Node a = q.poll();
                for(Node g : a.neighbors)
                {
                    if(!x.containsKey(g))
                    {
                        Node l = new Node(g.val);
                        x.put(g,l);
                        q.add(g);
                    }
                    x.get(a).neighbors.add(x.get(g));
                    
                }
            }
            
        }
        return x.get(node);
          
    }
    
   
}