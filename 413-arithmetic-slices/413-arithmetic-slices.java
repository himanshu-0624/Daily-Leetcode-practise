class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<=2)return 0;
        HashMap<Integer,Integer> x = new HashMap<>();
        int ans  = 0;
        int cnt = 0;
        for(int i = 2; i<n; i++)
        {
            if((nums[i-1]-nums[i]) == (nums[i-2] -nums[i-1]))
            {
                cnt++;
                ans+=cnt;
            }
           else
               cnt = 0;
        }
        return ans;
    }
}