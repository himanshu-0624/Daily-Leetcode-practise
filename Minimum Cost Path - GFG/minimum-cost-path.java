//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	int [][] dp;
	
	  class Pair
    {
        int i;
        int j;
        int val;
        public Pair(int i, int j, int val)
          {
              this.i = i;
              this.j = j;
              this.val = val;
          }
    }
    public int minimumCostPath(int[][] g)
    {
        // Code here
        int n = g.length;
        int m = g[0].length;
        dp = new int[n][m];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        
        PriorityQueue<Pair> x = new PriorityQueue<Pair>(n*m,(a,b)->{
            if(a.val > b.val)return 1;
            return -1;
        });
        
        x.add(new Pair(0,0,g[0][0]));
        while(!x.isEmpty())
        {
           Pair p = x.poll();
           if(p.i == n-1 && p.j==m-1)
           return p.val;
           if(dp[p.i][p.j] > p.val)
           {
               dp[p.i][p.j] = p.val;
               if(p.i -1 >=0 )
               {
                   x.add(new Pair(p.i-1,p.j,p.val+g[p.i-1][p.j]));
               }
               if(p.i+1 <n )
               {
                    x.add(new Pair(p.i+1,p.j,p.val+g[p.i+1][p.j]));
               }
               
               if(p.j -1 >=0 )
               {
                    x.add(new Pair(p.i,p.j-1,p.val+g[p.i][p.j-1]));
               }
               if(p.j +1 <m )
               {
                    x.add(new Pair(p.i,p.j+1,p.val+g[p.i][p.j+1]));
               }
           }
           
        }
        
        return -1;
        
        
    }
    
    
  
}