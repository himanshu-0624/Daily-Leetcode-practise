class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        long jj = (1l<<n)-1;
        int ans = 0;
        for(long i = 1; i<=jj; i++)
        {
            int [] d = new int[26];
            boolean f = true;
            int max = 0;
            for(int j = 0; j<n; j++)
            {
                if(((i>>j)&1) != 0)
                {
                    for(char c : arr.get(j).toCharArray())
                    {
                        if(d[c-'a'] == 1)
                        {
                            f = false;
                            break;
                        }
                        else
                        {
                            d[c-'a']=1;
                            max++;
                        }
                    }
                    
                }
                if(!f)break;
            }
            
            if(f)
            {
                ans = Math.max(ans,max);
            }
        }
        return ans;
        
    }
    
    
}