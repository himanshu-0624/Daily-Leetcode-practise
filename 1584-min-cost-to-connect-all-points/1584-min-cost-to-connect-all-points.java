class Solution {
    int [] dsu;
     int min;
    void union(int i, int j, int w)
    {
       int a = find(i); 
        int b = find(j); 
        if(a == b)return;
        min+=w;
        dsu[a] = b;
    }
    int find(int i)
    {
        if(dsu[i] == i)return i;
         else
         {
             int u = find(dsu[i]);
             dsu[i] = u;
             return u;
         }
    }
    
    public int minCostConnectPoints(int[][] p) {
        //ArrayList<ArrayList<int []>> x = new ArrayList<>();
        PriorityQueue<int []> u = new PriorityQueue<>((a,b)->{return a[2]-b[2];});
        // ArrayList<int []> u = new ArrayList<>();
         int n = p.length;
        for(int i=0;i<n; i++){
       
            for(int j = i+1; j<n; j++)
            {
                // x.get(i).add(new int[]{j,Math.abs(p[i][0]-p[j][0])+Math.abs(p[i][1]-p[j][1])});
                    u.add(new int[]{
                        i,j,Math.abs(p[i][0]-p[j][0])+Math.abs(p[i][1]-p[j][1])
                    });
            }
        }
        
        
        
        dsu = new int[n];
        for(int i =0; i<n; i++)
        {
            dsu[i]=i;
        }
        min = 0;
    
        while(!u.isEmpty() )
        {   int [] d = u.poll();
            union(d[0],d[1],d[2]);
        }
        
        return min;
    }
}