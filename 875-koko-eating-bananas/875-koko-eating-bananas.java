class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = 1000_000_000;
        while(i<j)
        {
            int mid = (i+j)/2;
            if(check(mid,piles,h))
            {
                j = mid;
            }
            else
                i = mid+1;
            
        }
        return i;
    }
    boolean check(int k, int [] p, int h)
    {
        for(int i : p)
        {
            int c = i/k;
            if(i%k!=0)
            {
                c++;
            }
            if(c>h)return false;
            h-=c;
        }
        return true;
    }
}