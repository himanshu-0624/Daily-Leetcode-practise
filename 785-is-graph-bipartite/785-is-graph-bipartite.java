class Solution {
    public boolean isBipartite(int[][] g) {
        int n = g.length;  
        int color[] = new int[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(color,-1);
         int c = 0;
        
        
        for(int i =0;i<n;i++)
        {
            if(!vis[i])
            {
                Queue<Integer> xx = new LinkedList<>();
                xx.add(i);
                color[i] = 0;
                vis[i] = true;
                while(!xx.isEmpty())
                {
                    int u = xx.poll();
                    for(int j : g[u])
                    {
                        if(!vis[j])
                        {
                            vis[j] = true;
                            color[j] = 1-color[u];
                            xx.add(j);
                        }
                        else
                        {
                            //System.out.println(i+"  "+j);
                            if(color[j] == color[u])return false;
                        }
                    }
                }
            }
        }
        return true;
        
    }

}