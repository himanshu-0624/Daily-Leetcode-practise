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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode r, int t) {
        ans = new ArrayList<>();
        hasPathSum(r,t,new ArrayList<Integer>());
        return ans;
    }
    
    void hasPathSum(TreeNode r, int t, ArrayList<Integer> y)
    {
         if(r == null)return ;
         
        if(t == r.val && (r.left == null && r.right == null))
        {
           List<Integer> j = new ArrayList<>();
            for(int i : y)
            {
                j.add(i);
            }
            j.add(t);
            ans.add(j);
            return;
        }
        
        if(r.left!= null)
        {   
             y.add(r.val);
            hasPathSum(r.left,t-r.val,y);
           y.remove(y.size()-1);
               
        }
        
        if(r.right!= null)
        {
            y.add(r.val);
           hasPathSum(r.right,t-r.val,y);
            y.remove(y.size()-1);
        }
        return ;
    }
}