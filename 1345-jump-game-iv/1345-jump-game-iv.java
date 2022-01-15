class Solution {
    public int minJumps(int[] arr) {
         int n = arr.length;
         
        HashMap<Integer,ArrayList<Integer>> x = new HashMap<>();
        for(int i =0; i<n; i++ )
        {
            if(x.containsKey(arr[i]))
            {
                x.get(arr[i]).add(i);
            }
            else
            {
                ArrayList<Integer> p = new ArrayList<>();
                p.add(i);
                x.put(arr[i],p);          
            }
        }
        
        boolean [] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
           // System.out.print(size);
            for(int i = 0; i<size; i++)
            {
                int a  = q.poll();
                if(a == n-1)
                    return level;
                
                if(a-1 >= 0 && !vis[a-1])
                {
                    vis[a-1] = true;
                    q.add(a-1);
                }
                
                if(a+1 < n && !vis[a+1])
                {
                    vis[a+1] = true;
                    q.add(a+1);
                }
                
                
                if(x.containsKey(arr[a]))
                {
                    ArrayList<Integer> k =  x.get(arr[a]);
                    for(int kk : k)
                  {
                      if(kk >= 0 && kk<n &&!vis[kk])
                      {
                          vis[kk] = true;
                          q.add(kk);
                      }
                  }
                x.remove(arr[a]);
                }
                  
            }
            
            level++;
        }
        
       return -1;
    }
}