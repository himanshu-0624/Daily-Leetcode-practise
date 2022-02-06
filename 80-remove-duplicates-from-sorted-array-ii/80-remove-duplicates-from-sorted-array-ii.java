class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        int j = 0;
        int cnt = 0;
        while(j<n)
        {
           if(j+1 == n)
           {
               nums[i] = nums[j];
               cnt++;
               break;    
           }
           else if(nums[j] == nums[j+1])
           {
               nums[i++] = nums[j];
               nums[i++] = nums[j++];
               cnt+=2;
               while(j<n && nums[i-1] == nums[j])
                   j++;
               
           }
            else
            {
                cnt++;
                 nums[i++] = nums[j++];
            }
        }
        return cnt;
    }
}