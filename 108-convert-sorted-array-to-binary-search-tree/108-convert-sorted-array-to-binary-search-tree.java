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
     public TreeNode sortedArrayToBST(int[] nums) {
        return gg(nums, 0,nums.length-1);
    }
    
    TreeNode gg(int nums[], int i, int j)
    {    if(i>j)return null;
        int mid = (i+j)/2;
        TreeNode f = new TreeNode(nums[mid]);
        f.left = gg(nums,i,mid-1);
        f.right = gg(nums,mid+1,j);
        return f;
    }
}