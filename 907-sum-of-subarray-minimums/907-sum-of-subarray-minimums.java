class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans1 = 0;
        long mod = 1_000_000_007;
        // TreeMap<Integer,Long> x = new TreeMap<>();
         // x.put(arr[0],(long)arr[0]);
          Stack<Integer> x = new Stack<>();
        int n = arr.length;
          int [] ans =new int[n];
        for(int i = 0; i<n; i++)
        {
            while(!x.isEmpty() && arr[x.peek()] > arr[i])
                x.pop();
            if(x.isEmpty())
            {
                ans[i]= -1;
            }
            else
                ans[i] = x.peek();
            x.add(i);
        }
        
        long [] pp = new long[n];
        pp[0] = arr[0];
        ans1 = pp[0];
        for(int i = 1; i<n; i++)
        {
            int diff =  (i - ans[i]);
             pp[i] = ((long)arr[i])*diff;
            pp[i]%=mod;
            if(ans[i] != -1)
            {
                pp[i] += pp[ans[i]]%mod;
                pp[i]%=mod;
            }
            ans1+=(pp[i]);
            ans1%=mod;
        }
        return (int)ans1;
        
    }
}