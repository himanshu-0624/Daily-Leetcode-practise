class Solution {
    public int[] findOriginalArray(int[] ch) {
        int n = ch.length;
        if(n%2 != 0)return new int[]{};
        HashMap<Integer,Integer> x = new HashMap<>();
        for(int i : ch)
        {
            x.put(i,x.getOrDefault(i,0)+1);
        }
       
        int [] ans = new int[n/2];
        //  if(x.size() == 1)
        // {
        //     if(x.containsKey(0))
        //     {
        //        return ans; 
        //     }
        //      else
        //      {
        //          return new int[]{};
        //      }
        // }
        int y = 0;
        ArrayList<Integer> p = new ArrayList<>(x.keySet());
        Collections.sort(p);
        for(int u :  p)
        {
            if(x.containsKey(u))
            {
                if(u == 0)
                {
                    if(x.get(u)%2!= 0)
                    {
                         return new int[]{};
                    }
                    else
                    {
                         y+= x.get(0)/2;
                        x.remove(0);
                       
                    }
                }
                else if(!x.containsKey(2*u) || x.get(u) > x.get(2*u))
                {
                    return new int[]{};
                }
                else
                {
                    int k = x.get(u);
                    while(k>0)
                    {
                        ans[y++] = u;
                        
                        k--;
                    }
                    
                    x.put(2*u,x.get(2*u)-x.get(u));
                    
                    if(x.get(2*u) == 0)
                        x.remove(2*u);
                    x.remove(u);
                }
            }
            
        }
        return ans;
        
    }
}