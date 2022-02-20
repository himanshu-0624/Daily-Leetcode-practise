class Solution {
    public int removeCoveredIntervals(int[][] inte) {
        int n = inte.length;
        Arrays.sort(inte,(a,b)->{
            if(a[0] != b[0])
            return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });
        
        int cnt = 0;
        int i = 0;
       
        while(i<n)
        {
            int a[] = inte[i];
             int j = i+1;
            while(j<n && inte[j][1] <= a[1])
            {
                cnt++;
                j++;
            }
            i = j;
        }
        return n-cnt;
    }
}