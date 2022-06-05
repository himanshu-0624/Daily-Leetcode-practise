class Solution {
    int [][] x;
    public int totalNQueens(int n) {
        x = new int[n][n];
        return call(0,n);
        
    }
    
    int call(int i,int n)
    {
        if(i == n)return 1;
        int p= 0;
         for(int k =0; k<n; k++)
         {
             if(check(i,k,n))
             {
                 x[i][k] = 1;
                 p+=(call(i+1,n));
                 x[i][k] = 0;
             }
         }
        return p;
        
    }
    
    boolean check(int i, int j, int n)
    {
        for(int k =0; k<i; k++)
        {
           // System.out.println(k+" "+j);
            if(x[k][j] == 1)return false;
        }
         for(int k =0; k<j; k++)
        {
            if(x[i][k] == 1)return false;
        }
        int a = i;
        int b = j;
        while(a>=0 && b>=0)
        {
            if(x[a][b] == 1)return false;
            a--;
            b--;
        }
        a = i;
        b = j;
        while(a>=0 && b<n)
        {
            if(x[a][b] == 1)return false;
            a--;
            b++;
        }
        return true;
    }
}