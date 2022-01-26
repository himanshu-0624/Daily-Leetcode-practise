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
    ArrayList<Integer> a1;
    ArrayList<Integer> a2;   
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        a1 = new ArrayList<Integer>();
        a2 = new ArrayList<Integer>();
        pre(root1,a1);
        pre(root2,a2);
        List<Integer> ans = new ArrayList<Integer>();
        int n1 = a1.size();
        int n2 = a2.size();
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2)
        {
            if(a1.get(i) > a2.get(j))
            {
                ans.add(a2.get(j));
                j++;
            }
            else
            {
               ans.add(a1.get(i));
                i++; 
            }
        }
        
        while(i<n1)
        {
           ans.add(a1.get(i));
                i++;   
        }
        
         while(j<n2)
        {
           ans.add(a2.get(j));
                j++;   
        }
        
        return ans;
    }
    
    void pre(TreeNode root, ArrayList<Integer> a)
    {
        if(root == null)
            return;
        pre(root.left,a);
        a.add(root.val);
        pre(root.right,a);
    }
}