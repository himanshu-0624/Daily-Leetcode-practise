class Solution 
{
    HashSet<Integer> [] x ;
    public boolean canCross(int[] stones) 
    {
        int n = stones.length;
        x = new HashSet[n];
        for(int i = 0; i<n; i++)
            x[i] = new HashSet<>(); 
        return call(stones,0,0);
    }
    
    boolean call(int [] st, int i, int k )
    {
        if(st.length-1 == i)
            return true;
        if(x[i].contains(k))
            return false;
        for(int j = i+1; j<st.length; j++)
        {
            int diff = st[j] - st[i];
            if(diff > k+1)
                break;
            if(diff == k+1)
            {
                if(call(st,j,k+1))
                    return true;
               
            }
            else if(diff == k)
            {
                if(call(st,j,k))
                    return true;
            }
            else if(diff == k-1)
            {
                if(call(st,j,k-1))
                    return true;
            }
        }
        x[i].add(k);
        
        return false;
        
    }
}