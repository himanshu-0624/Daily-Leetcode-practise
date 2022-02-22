class Solution {
    public int titleToNumber(String cT) {
        int ans = 0;
        
        for(char c: cT.toCharArray())
        {
            ans*=26;
           
            ans+=(c-'A'+1);
            
            
        }
        return ans;
    }
}