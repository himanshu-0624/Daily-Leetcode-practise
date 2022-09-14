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
class Solution 
{
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root)
    {
        if(root != null)
        call(root,new int[10]);
        return ans;
    }
    
    void call(TreeNode r, int [] v)
    {
        if(r.left == null && r.right == null)
        {
            v[r.val]++;
            int g = 0; 
            for(int i = 1; i<=9; i++)
                if(v[i]%2 != 0)
                    g++;
            if(g<=1)
                ans++;
            v[r.val]--;
        }
        else
        {
            v[r.val]++;
            if(r.left != null)
            {
                call(r.left,v);
            }
            if(r.right != null)
            {
                call(r.right,v);
            }
            v[r.val]--;
        }
    }
}