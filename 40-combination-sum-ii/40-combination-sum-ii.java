class Solution {
    int n;
    int t;
    List<List<Integer>> ans;
    HashMap<Integer,Integer> pp;
    public List<List<Integer>> combinationSum2(int[] can, int tar) {
       
        pp = new HashMap<>();
        for(int ll : can)
        {
            pp.put(ll,pp.getOrDefault(ll,0)+1);
        }
       
        ans = new ArrayList<>();
        t = tar;
        int [] arr = new int[pp.size()];
        int i = 0;
        for(int k : pp.keySet())
        {
            arr[i] = k;
            i++;
        }
        Arrays.sort(arr);
         n = arr.length;
        call(arr,0,0,new HashMap<Integer,Integer>());
        return ans;
    }
    
    void call(int [] can, int i, int sum, HashMap<Integer,Integer> x)
    {
        if(sum == t)
        {
            List<Integer> l = new ArrayList<>();
            
            for(int ll : x.keySet())
            {
                int cnt = x.get(ll);
                while(cnt>0)
                {
                    l.add(ll);
                    cnt--;
                }
            }
                 ans.add(l);
            
            
            return;
        }
        if(i == n)
            return;
        if(sum+can[i] > t)
            return;
        for(int j = i; j<n; j++)
        {
            if(sum+can[j] <= t)
            {
                int cnt = pp.get(can[j]);
                int d = 0;
                while(cnt>0 && sum+d <= t)
                {
                    d+=can[j];
                    x.put(can[j],x.getOrDefault(can[j],0)+1);
                    call(can,j+1,sum+d,x);
                    cnt--;
                }
                x.remove(can[j]);
            }
            else
                break;
        }
        return;
    }
    
}