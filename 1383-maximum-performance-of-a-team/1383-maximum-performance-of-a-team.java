class Solution
{
    public int maxPerformance(int n, int[] sp, int[] ef, int k)
    {
        int [][] arr = new int[n][2];
        for(int i= 0; i<n; i++)
        {
            arr[i][0] = ef[i];
            arr[i][1] = sp[i];
        } 
        
        Arrays.sort(arr,(a,b)->{return Integer.compare(b[0],a[0]);});
        
       PriorityQueue<Long> x = new PriorityQueue<>();
        
        long sum = 0;
        long max = 0;
        long mod = 1_000_000_007;
        for(int i = 0; i<n; i++)
        {
           long val = arr[i][0];
           sum+=arr[i][1];
            if(x.size() == k)
            sum-=x.poll();
            x.add((long)arr[i][1]);
            max = Math.max(max,sum*val);
            
        }
        
        return (int)(max%mod);
    }
    
   
}