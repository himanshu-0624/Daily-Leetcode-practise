class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        int [] p = new int[10];
        call(0,n,k,1,p);
        return ans;
    }
    
    void call(int sum, int t,int k, int i,int [] cnt)
    {
        if(sum>t)return;
        if(sum == t && k == 0)
        {
            List<Integer> x = new ArrayList<>();
            for(int a = 0; a<10; a++)
            {
                if(cnt[a] == 1)
                {
                    x.add(a);
                }
            }
            ans.add(x);
            return;
        }
        
        if(k == 0)
            return;
        
        if(i == 10)return;
        
        call(sum,t,k,i+1,cnt);
        cnt[i]++;
        call(sum+i,t,k-1,i+1,cnt);
        cnt[i]--;
        
    }
}