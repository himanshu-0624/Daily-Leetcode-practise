class Solution {
    public boolean winnerSquareGame(int n) {
       boolean [] ans = new boolean[n+1];
        ans[0] = false;
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j*j <=i; j++)
            {
                ans[i] = (ans[i]||!ans[i-j*j]);
            }
        }
        return ans[n];
    }
}