/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<Node> x = new LinkedList<>();
        x.add(root);
        while(!x.isEmpty())
        {
            int n = x.size();
            List<Integer> pp = new ArrayList<>(); 
            for(int i = 0; i<n;i++)
            {
                Node p = x.poll();
                pp.add(p.val);
                for(Node r : p.children)
                {
                    x.add(r);
                }
            }
            ans.add(pp);
        }
        
        return ans;
        
        
    }
}