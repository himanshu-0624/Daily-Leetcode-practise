class Solution {
    public int countSubstrings(String s) {
       int n = s.length();
        char [] x  = s.toCharArray();
        boolean[][] b = new boolean[n][n];
        for(int i = 0; i<s.length(); i++)
        {
            for(int j = 0, k = i; k<n ; j++,k++)
            {
                if(i == 0)
                {
                    b[j][k] = true;
                }
                else if(i == 1)
                {
                    if(x[j] == x[k])
                        b[j][k] = true;
                }
                else
                {
                    if(x[j] == x[k])
                        b[j][k] = b[j+1][k-1]; 
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n;i++)
        {
            for(int j = 0;j <n; j++)
            {
                if(b[i][j])ans++;
            }
        }
        return ans;
    }
}