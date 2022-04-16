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
    public TreeNode convertBST(TreeNode root) {
        Gst(root,0);
        return root;
    }
    
    int Gst(TreeNode r, int sum)
    {
        if(r == null)return sum;
        
        sum = Gst(r.right,sum);
        sum+=r.val;
        r.val = sum;
        
       sum= Gst(r.left,sum);
        return sum;
    }
}