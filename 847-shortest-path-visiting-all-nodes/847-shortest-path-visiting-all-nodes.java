class Solution {
    public int shortestPathLength(int[][] gr) {
        int n = gr.length;
        if(n == 1)
        return 0;
        
        int finalAns = (1<<n)-1;
        
        Queue<int []> x = new LinkedList<>();
        int ans = 0;
        int mat[][] = new int[n][finalAns+1];
        for(int i = 0; i<n; i++)
        {
            x.add(new int[]{i,1<<i});
           
        }
        while(!x.isEmpty())
        {
           
           int size = x.size();
            ans++;
            for(int i = 0; i<size; i++)
            {
                int arr[] = x.poll();
                int id = arr[0];
                int val = arr[1];
                
                for(int node : gr[id])
                {
                    int newBit =  val | (1<<node);
                    if(mat[node][newBit] == 1)
                        continue;
                    if(newBit == finalAns)
                        return ans;
                    
                    mat[node][newBit] = 1;
                    x.add(new int[]{node,newBit});
                }
            }
                        
            
        }
               
        return -1;
    }
    
    
}