class Solution {
    public boolean canPlaceFlowers(int[] fl, int na) {
        int max = 0;
        int i =0 ;
        int n = fl.length;
        
        int cnt = 1;
        while(i<n)
        {
            if(fl[i] == 1)
            {
                i++;
                cnt=0;
                continue;
            }
            while(i<n && fl[i] == 0)
            {
                i++;
                cnt++;
            }
            if(i!=n)
            cnt--;
            max+=(cnt/2);
            cnt = 0;
        }
        
        return max >= na;
    }
}