class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int [] cnt = new int[256];
        for(char c : jewels.toCharArray())
        {
            cnt[c]++;
        }
        
        int ans = 0;
        for(char c : stones.toCharArray())
        {
            if(cnt[c] > 0)
                ans++;
        }
        
        return ans;
        
    }
}