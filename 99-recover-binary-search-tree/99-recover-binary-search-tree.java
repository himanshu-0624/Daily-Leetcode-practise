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
    TreeNode f = null;
    TreeNode s = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
       
       in(root);   
        int t = f.val;
        f.val =  s.val;
        s.val = t;
        return ;
        
    }
    
    void in(TreeNode r)
    {
        if(r == null)
            return;
        in(r.left);
        
        
        if (f == null && pre.val > r.val) {
            f = pre;
        }
    
       
        if (f != null && pre.val >= r.val) {
            s = r;
        }        
        pre = r;
        
        in(r.right);
    }
}