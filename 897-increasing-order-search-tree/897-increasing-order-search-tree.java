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
    public TreeNode increasingBST(TreeNode root) {
        return ans(root, null);
    }
    TreeNode ans(TreeNode r, TreeNode p)
    {
        if(r == null)return p;
        
        TreeNode le = ans(r.left, r);
        r.left = null;
        r.right = ans(r.right,p);
       return le; 
    }
   

}