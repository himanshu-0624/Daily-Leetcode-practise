class Solution {
    public int longestPalindrome(String s) {
        int [] cnt = new int[256];
        boolean odd = false;
        for(char c : s.toCharArray())
        {
            cnt[c]++;
        }
        int ans = 0;
        
        for(int i :  cnt)
        {
            if(i%2 != 0)
                odd = true;
            ans+=2*(i/2);
        }
        if(odd)
            ans++;
        return ans;
    }
}