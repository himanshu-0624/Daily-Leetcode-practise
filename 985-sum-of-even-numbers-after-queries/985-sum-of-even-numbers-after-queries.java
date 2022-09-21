class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] qu) {
        int e = 0;
        int o  = 0 ;
        for(int i : nums)
        {
            if(i%2 == 0)
                e+=i;
            else
                o+=i;
        }
        
        int ans[] = new int[qu.length];
        for(int i = 0; i<qu.length; i++)
        {
            int val = qu[i][0];
            int j = qu[i][1];
            if(nums[j]%2 == 0)
            {
                if(val%2 == 0)
                {
                    nums[j]+=val;
                    e+=val;
                    ans[i] = e;
                }
                else
                {
                    e-=nums[j];
                    nums[j]+=val;
                    o+=nums[j];
                    ans[i] = e;
                }
            }
            else
            {
                if(val%2 == 0)
                {
                    nums[j]+=val;
                    ans[i] = e;
                }
                else
                {
                    o-=nums[j];
                    nums[j]+=val;
                    e+=nums[j];
                    ans[i] = e;
                }
            }
        }
        
        return ans;
    }
}