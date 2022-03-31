class Solution {
    public int splitArray(int[] nums, int m) {
        int a = 0;
        int b = Integer.MAX_VALUE;
        while(a<b)
        {
            int mid = (a+b)/2;
            
            if(call(nums, m, mid))
            {
               b = mid;
            }
            else
            {
                a = mid+1;
            }
        }
        return a;
        
        
    }
    boolean call(int nums[], int m, int mid)
    {
        int n = nums.length;
        int i = 0;
        while(i<n)
        {
            int sum = 0;
            while(i<n && sum+nums[i]<=mid)
            {
                
                sum+=nums[i];
                i++;
            }
            if(i<n && nums[i] > mid)
                return false;
            
            m--;
            
        }
        if(m<0 || i<n)return false;
        return true;
    }
}