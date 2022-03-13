class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest)
    {
        ArrayList<ArrayList<Pair>> x = new ArrayList<>();
        ArrayList<ArrayList<Pair>> xy = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            x.add(new ArrayList<>());
            xy.add(new ArrayList<>());
        }
        
        for(int [] e : edges)
        {
            x.get(e[0]).add(new Pair(e[1],e[2]));
            xy.get(e[1]).add(new Pair(e[0],e[2]));
        }
        
        long [] dis1  = new long[n];
        long [] dis2  = new long[n];
        long [] dis3  = new long[n];
        
        Arrays.fill(dis1,Long.MAX_VALUE);
        Arrays.fill(dis2,Long.MAX_VALUE);
        Arrays.fill(dis3,Long.MAX_VALUE);
        
        shortestPath(dis1,src1,x);
        shortestPath(dis2,src2,x);
        shortestPath(dis3,dest,xy);
        
        long ans = Long.MAX_VALUE;
        
        for(int i = 0; i<n; i++)
        {
            if(dis3[i] != Long.MAX_VALUE && dis1[i] != Long.MAX_VALUE && dis2[i] != Long.MAX_VALUE )
            {
                ans = Math.min(ans,dis1[i]+dis2[i]+dis3[i]);
            }
            
        }
        
        if(ans == Long.MAX_VALUE)
            return -1;
        
        return ans;
    }
    
    void shortestPath(long [] dis, int src, ArrayList<ArrayList<Pair>> adj)
    {
        dis[src] = 0;
        
        PriorityQueue<Pair> x = new PriorityQueue<>((a,b)->{
            return Long.compare(a.val,b.val);
        });
        x.add(new Pair(src,0));
        boolean [] removed = new boolean[adj.size()];
        
        
        while(!x.isEmpty())
        {
            Pair g = x.poll();
            if(removed[g.x])continue;
             removed[g.x] = true;
            for(Pair f : adj.get(g.x))
            {
                
                if(dis[f.x] > g.val+f.val)
                {
                     dis[f.x] = g.val+f.val;
                    x.add(new Pair(f.x,dis[f.x]));
                }
                   
                 
            }
        }
        
        
    }
    
    class Pair
    {
        int x;
        long val;
        
        public Pair(int x, long val)
        {
            this.x = x;
            this.val = val;
        }
    }
        
        
        
}