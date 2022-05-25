class Solution {
    public int maxEnvelopes(int[][] env)
    {
       int n = env.length;
       Arrays.sort(env,(a,b)->{
         int c= Integer.compare(a[0],b[0]);
           if(c == 0)
               return Integer.compare(b[1],a[1]);
              return c;
       });
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int [] e : env)
        {
            int val = e[1];
            
            int d = call(ans,val);
            if(d == ans.size())
            {
                ans.add(val);
            }
            else
            {
                ans.set(d,val);
            }
        }
        
        
        return ans.size();
    }
    
    int call(ArrayList<Integer> x, int val)
    {
        int i = 0;
        int j = x.size()-1;
       
        int ans = 0;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            
            if(x.get(mid) < val)
            {
                ans = mid+1;
                i = mid+1;
            }
            else
            {
                j = mid-1;
            }
        }
        
        return ans;
    }
}