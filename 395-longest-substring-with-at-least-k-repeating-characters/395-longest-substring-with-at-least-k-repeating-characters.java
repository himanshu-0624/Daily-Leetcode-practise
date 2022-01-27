class Solution {
    public int longestSubstring(String s, int k) {
        char [] x = s.toCharArray();
        int ans = call(x,0,x.length-1,k);
        return ans;
        
    }
    
    int call(char [] x, int i, int j,int si)
    {
        if(j-i+1 < si)
            return 0;
        int cnt[] = new int[26];
        for(int l = i; l<=j; l++)
        {
            cnt[x[l]-'a']++;
        }
        int max = 0;
        int k = i;
        while(k<=j)
        {
            int a = k;
            while(k<=j && cnt[x[k]-'a'] >= si)
            {
                k++;
            }
            if(a == i && k == j+1)
                return k - a;
            
            max = Math.max(max,call(x,a,k-1,si));
            k++;
        }
        return max;
    }
}