/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min;
    int max;
   void vertical(TreeNode r , int d, HashMap<Integer,ArrayList<int []>>x,int le)
    { min = Math.min(min,d);
     max= Math.max(max,d);
        if(x.containsKey(d))
        {
            x.get(d).add(new int [] {r.val,le});
        }
       else
       {
           x.put(d,new ArrayList<int []>());
            x.get(d).add(new int [] {r.val,le});
       }
       if(r.left!=null)
       {
           vertical(r.left,d-1,x,le+1);
       }
        if(r.right!=null)
       {
           vertical(r.right,d+1,x,le+1);
       }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<int []>> x = new HashMap<>();
        min = 0;
        max = 0;
        if(root == null)return null;
        
        vertical(root,0,x,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = min; i<=max; i++)
        {
            Collections.sort(x.get(i),(a,b)->{
                if(a[1] == b[1])
                return a[0]-b[0];
                
                return a[1]-b[1];
            });
            ArrayList<Integer> p = new ArrayList<>();
            for(int [] d : x.get(i))
            {
                p.add(d[0]);
            }
            ans.add(p);
        }
        return ans;
    }
}