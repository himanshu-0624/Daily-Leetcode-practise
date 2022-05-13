/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         Queue<Node> x = new LinkedList<>();
        if(root == null)return root;
        x.add(root);
        while(!x.isEmpty())
        {
            int n = x.size();
            Node prev = x.poll();
            Node cur = null;
            for(int i = 0; i<n; i++)
            {
                if(prev.left!= null)
                {
                    x.add(prev.left);
                  // x.add(prev.right);
                }
                if(prev.right!= null)
                {
                    // x.add(prev.left);
                  x.add(prev.right);
                }
                
                if(i !=n-1)
                cur = x.poll();
                else 
                    cur = null;
                prev.next = cur;
                prev = cur;
            }
            
        }
        return root;
        
    }
}