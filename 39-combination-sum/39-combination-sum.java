class Solution {
    int t;
     List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] c, int t) {
         ans = new ArrayList<>();
        this.t = t;
        int cnt[] = new int[c.length];
          go(0,0,cnt,c);
        return ans;
    }
    
    void go(int sum , int i, int [] cnt, int c[])
    {
        if(t<sum)return;
        if(t == sum)
        {
            List<Integer> p = new ArrayList<>();
            for(int ii = 0; ii<c.length; ii++)
            {
                for(int j = 0;j<cnt[ii]; j++ )
                {
                    p.add(c[ii]);
                }
            }
            ans.add(p);
            return;
        }
        
        if(i == cnt.length)
            return;
        
        sum+=c[i];
        cnt[i]++;
        go(sum,i,cnt,c);
       // go(sum,i+1,cnt,c);
        sum-=c[i];
        cnt[i]--;
       go(sum,i+1,cnt,c);
        
    }
}