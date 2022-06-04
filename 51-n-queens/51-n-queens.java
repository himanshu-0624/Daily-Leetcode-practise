class Solution {
    char [][] x;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
       x = new char[n][n]; 
      for(int i = 0; i<n; i++)
      {
          for(int j = 0; j<n; j++)
          {
              x[i][j] = '.';
          }
      }
        ans = new ArrayList<>(); 
      solve(0,n);
        return ans;
        
    }
    void solve(int i, int n)
    {
        if(i == n)
        {
            List<String> b = new ArrayList<>();
            for(char [] p: x)
            {
                StringBuffer sb = new StringBuffer();
                for(char c : p)
                    sb.append(c);
                b.add(sb.toString());
            }
            ans.add(b);
            return;
        }
        
        for(int k = 0; k<n; k++)
        {
            if(isSafe(i,k,n))
            {
                x[i][k]='Q';
                solve(i+1,n);
            }
            x[i][k] ='.';
        }
        
    }
    boolean isSafe(int i, int j, int n)
    {
        for(int k = 0; k<n; k++)
        {
            if(x[i][k] == 'Q')return false;
            if(x[k][j] == 'Q')return false;
        }
        
        int min = Math.min(i,j);
        int r = i-min;
        int c = j-min;
        while(r<n && c<n)
        {
            if(x[r][c] == 'Q')return false;
            r++;
            c++;
        }
        int u =  Math.min(n-i-1,j);
        r =     i+u;
        c = j-u;
        
            while(r>=0 && c <n)
            {
                if(x[r][c] == 'Q')return false;
                r--;
                 c++;
            }
        return true;
    }
}