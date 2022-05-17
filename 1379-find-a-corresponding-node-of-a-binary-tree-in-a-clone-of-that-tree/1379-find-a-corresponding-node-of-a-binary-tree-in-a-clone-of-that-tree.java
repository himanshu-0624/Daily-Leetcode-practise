/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode or, final TreeNode cl, final TreeNode t) {
        if(or == null)
            return null;
        if(or.val == t.val)
            return cl;
        TreeNode f1 = getTargetCopy(or.left,cl.left,t);
        if(f1 != null)
            return f1;
         TreeNode f2 = getTargetCopy(or.right,cl.right,t);
         if(f2 != null)
            return f2;
        return null;
            
    }
}