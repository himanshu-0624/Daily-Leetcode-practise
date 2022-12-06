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
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] g)
    {
        // Code here
        int n = g.length;
        int m = g[0].length;
        int [][]  ans = new int[n][m];
        Queue<int [] > q = new LinkedList<>();
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(g[i][j] == 1)
                {
                    q.add(new int[]{i,j});
                }
                else
                {
                    ans[i][j] = -1;
                    
                }
            }
        }
        
        int cnt  = 0;
        while(!q.isEmpty())
        {
            int  l = q.size();
            for(int i =0; i<l; i++)
            {
                int [] v = q.poll();
                ans[v[0]][v[1]] = cnt;
                if(v[0]-1 >=0 && ans[v[0]-1][v[1]] == -1)
                {
                    ans[v[0]-1][v[1]] = cnt+1;
                    q.add(new int[]{v[0]-1,v[1]});
                }
                 if(v[1]-1 >=0 && ans[v[0]][v[1]-1] == -1)
                {
                    ans[v[0]][v[1]-1] = cnt+1;
                     q.add(new int[]{v[0],v[1]-1});
                }
                 if(v[0]+1 <n && ans[v[0]+1][v[1]] == -1)
                {
                    ans[v[0]+1][v[1]]  = cnt+1;
                     q.add(new int[]{v[0]+1,v[1]});
                }
                 if(v[1]+1 < m && ans[v[0]][v[1]+1] == -1)
                {
                    ans[v[0]][v[1]+1] = cnt+1;
                     q.add(new int[]{v[0],v[1]+1});
                }
            }
            cnt++;
        }
        
        return ans;
    }
}

