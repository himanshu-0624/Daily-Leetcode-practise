class Solution {
    public String longestPalindrome(String s) {
          int n = s.length();
        char [] x  = s.toCharArray();
        boolean[][] b = new boolean[n][n];
        int a  = 0;
        int ba = 1;
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
                    {
                         b[j][k] = true;
                        a = j;
                        ba = k+1;
                    }
                       
                }
                else
                {
                    if(x[j] == x[k])
                    {
                        b[j][k] = b[j+1][k-1];
                        if(b[j][k] )
                        {
                            a = j;
                          ba = k+1;
                        }
                    }
                         
                }
            }
        }
        return s.substring(a,ba);
        
    }
}