class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] c) {
          ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        
        for(int i = 0; i<n; i++)
        {
            x.add(new ArrayList<>());
           
        }
        
        for(int [] a : c)
        {
            x.get(a[0]).add(a[1]);
            x.get(a[1]).add(-1*a[0]);
        }
        boolean [] vis = new boolean[n];
        // vis[0] = true;
        
                 dfs(x,0,vis);
            
        return ans;
        
    }
    
    void  dfs(ArrayList<ArrayList<Integer>> x ,int i, boolean vis[])
    {
        if(vis[i])
            return;
        vis[i] = true;
        for(int  p : x.get(i))
        {
            if(!vis[Math.abs(p)])
            {
                if(p>0)
                {
                   dfs(x,p,vis);
                   ans++;   
                }
                else
                {
                    dfs(x,-1*p,vis);
                }
                 
            }
           
        }
        
    }
    
}
    
    