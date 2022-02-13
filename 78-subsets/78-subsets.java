class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         int n = nums.length;
         int x = 1<<n;
        int i = 0;
        while(i<x)
        {
            List<Integer> d = new ArrayList<Integer>();
            for(int j =0; j<n;j++)
            {
                if(((i>>j)&1) != 0)
                {
                    d.add(nums[j]);
                }
            }
            ans.add(d);
            i++;
        }
        return ans;
    }
}