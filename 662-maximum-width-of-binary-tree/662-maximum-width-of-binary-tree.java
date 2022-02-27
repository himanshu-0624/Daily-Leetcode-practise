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
    HashMap<Integer,Pair> x;
    public int widthOfBinaryTree(TreeNode root)
    {
        x = new HashMap<>();
        if(root == null)
            return 0;
        call(root,0,1);
        int max  = 1;
        
        for(Pair d : x.values())
        {
            int ans = (int)(d.y - d.x +1);
            max = Math.max(ans, max);
        }
        return max;
            
    }
    
    void call(TreeNode r, int level, long dis)
    {
        if(r == null)
            return;
        
             if(x.containsKey(level))
             {
                 Pair d = x.get(level);
                 if(d.x > dis)
                 {
                     d.x = dis;
                 }
                 if(d.y < dis)
                 {
                     d.y = dis;
                 }
                 x.put(level,d);
             }
            else
            {
                x.put(level,new Pair(dis,dis));
            }
        
         call(r.left,level+1,2*dis);
         call(r.right,level+1,2*dis+1);
    }
    
    
    class Pair 
    {
        long x;
        long y;
        public Pair(long x,long y)
        {
            this.x = x;
            this.y = y;
        }
    }
}