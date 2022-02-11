class Solution {
    public int networkDelayTime(int[][] t, int n, int k) {
           ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i =0; i<n; i++)
            adj.add(new ArrayList<int []>());
        for(int [] i : t)
          {
           // ArrayList<int []> o = new ArrayList<>();
           // o.add(new int[]{i[1],i[2]});
            
              adj.get(i[0]-1).add(new int[]{i[1]-1,i[2]});
          }
        int [] ans = new int[n];
        for(int i=0; i<n; i++)
        ans[i] = Integer.MAX_VALUE;
        ans[k-1] = 0;
        
        PriorityQueue<int [] > x = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        x.add(new int[] {
            k-1,0});
        while(!x.isEmpty())
        {
            int [] p = x.poll();
            ArrayList<int []> pd = adj.get(p[0]);
            for(int [] d : pd)
            {
                int node = d[0];
                int w = d[1];
                if(ans[node] > p[1]+w)
                {
                    ans[node] = p[1]+w;
                    x.add(new int[]{
                       node,ans[node] 
                    });
                }
                
            }
        }
        int max = 0;
        for(int i : ans)
            max = Math.max(i,max);
        
        if(max == Integer.MAX_VALUE)return -1;
        return max;
    }
}