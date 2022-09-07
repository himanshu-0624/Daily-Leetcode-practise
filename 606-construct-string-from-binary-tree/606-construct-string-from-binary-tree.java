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
    StringBuffer ans;
    public String tree2str(TreeNode root) {
        ans = new StringBuffer();
        call(root);
        return ans.toString();
    }
    
    void call(TreeNode root)
    {
        if(root== null)
            return;
        ans.append(root.val);
        if(root.left != null )
        {
            ans.append("(");
            call(root.left);
            // call(root.right);
            ans.append(")");
        }
         if(root.right != null )
        {
             if(root.left == null)
             {
                 ans.append("()");
             }
            ans.append("(");
            // call(root.left);
            call(root.right);
            ans.append(")");
        }
       
    }
}