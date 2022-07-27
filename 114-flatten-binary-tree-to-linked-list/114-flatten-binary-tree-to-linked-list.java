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
    public void flatten(TreeNode root) {
         if(root == null)return ;
        if(root.left == null)
        {
            flatten(root.right);
            return;
        }
        if(root.right == null)
        {
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = l;
        root.left = null;
        while(l.right!= null)
            l = l.right;
        l.right = r;
    }
}
   