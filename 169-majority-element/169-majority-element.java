class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int cur = -1;
        for(int i = 0; i<n; i++)
        {
            if(cur == nums[i])
            {
                cnt++;
                
            }
            else if(cnt == 0)
            {
                cur = nums[i];
                cnt =1;
            }
            else
            {
                cnt--;
            }
        }
        
        return cur;
        
    }
}