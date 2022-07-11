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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int j = 0; j<n-1; j++)
            {
                TreeNode cur = q.poll();
                
                if(cur.left != null)
                q.add(cur.left);
                
                if(cur.right != null)
                q.add(cur.right);
                
            }
            
             TreeNode cur = q.poll();
             
            ans.add(cur.val);
            
            if(cur.left != null)
                q.add(cur.left);
                
                if(cur.right != null)
                q.add(cur.right);
        }
        
        
        return ans;
    }
}