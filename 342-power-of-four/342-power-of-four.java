class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
            return false;
        if((n&(n-1)) != 0)
             return false;
        if(n == 1)
            return true;
        int cnt = 0;
        while(n > 0)
        {
            n = n/2;
            cnt++;
        }
        cnt++;
        return cnt%2 == 0;
    }
}