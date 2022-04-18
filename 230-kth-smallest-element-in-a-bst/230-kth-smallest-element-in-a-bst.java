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
    int k;
    int val;
    void cal(TreeNode r)
    {
        if(r == null)return ;
        cal(r.left);
        if(k == 1)
        {
            val = r.val;
            k--;
        }
        else
        {
            k--;
        }
       
        cal(r.right);
    }
    // ArrayList<Integer> x = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        val = -1;
        this.k = k; 
        cal(root);
        return (int)val;
    }
    
}