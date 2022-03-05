class Solution {
    public int deleteAndEarn(int[] nums) {
          int [] dp = new int[10001];
        for(int i : nums)
        {
            dp[i]+=i;
        }
        
        int ans = 0;
        dp[2]+=dp[0];
        for(int i = 3; i<10001; i++)
        {
            dp[i]+=Math.max(dp[i-2],dp[i-3]);
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}