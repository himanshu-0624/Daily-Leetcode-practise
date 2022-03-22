class Solution {
    public String getSmallestString(int n, int k) {
        StringBuffer ans = new StringBuffer();
        int [] arr =  new int[n];
        
        Arrays.fill(arr,1);
         k-=n;
        
        int i  = n-1;
        while(k>0  )
        {
            arr[i] += Math.min(25,k);
            if(k>=25)
            {
                k-=25;
            }
            else
                k=0;
            i--;
        }
        
        for( i = 0; i<n; i++)
        {
            char c = (char)(arr[i]+'a'-1);
            ans.append(c);
        }
        return ans.toString();
        
    }
}