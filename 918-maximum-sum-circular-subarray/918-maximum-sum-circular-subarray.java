class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++)
        {
            sum+=nums[i];
            max = Math.max(sum,max);
            if(sum<0)
            {
               sum=0;
               
            }
                
        }
        if(max < 0)    
            return max;
        
        int d = 0;
        sum=0;
        int m = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++)
        {
            d+=(nums[j]);
            // nums[j]*=-1;
            sum+=nums[j];
            m = Math.min(sum,m);
            if(sum>0)
            {
               sum=0;
                
            }
        }
        return Math.max(max,d-m);
        
    }
}