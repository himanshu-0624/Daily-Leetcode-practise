class Solution {
    public int minSubArrayLen(int tar, int[] nums) {
          int sum = 0;
        int l = 0;
        int n = nums.length;
        int ans = n+1;
        
        for(int i = 0; i<n; i++)
        {
            sum+=nums[i];
            while(sum>=tar)
            {
                ans = Math.min(ans,i-l+1);
                sum-=nums[l];
                l++;
            }
        }
        
        if(ans == n+1)
            return 0;
        return ans;
    }
    
    
}