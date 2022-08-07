class Solution {
    public int countVowelPermutation(int n) {
        long [] ans = new long[5];
        Arrays.fill(ans,1);
         long mod = 1_000_000_007;
        for(int i = 1; i<n; i++)
        {
            long [] p =new long[5];
            // a == 0 || e == 1 || i == 2 || o == 3 || u == 4
             p[0] = (ans[1] + ans[4]+ans[2])%mod;
             p[1] = (ans[0] +ans[2])%mod;
             p[2] = (ans[3] + ans[1])%mod;
            p[3] = (ans[2] )%mod;
            p[4] = (ans[3] + ans[2] )%mod;
            ans = p;
        }
        
        long p = 0;
       
        for(long e : ans)
        {
            p = (p+e)%mod;
        }
        
        return (int)p;
        
    }
}