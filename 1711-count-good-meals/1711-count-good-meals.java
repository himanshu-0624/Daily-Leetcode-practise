class Solution {
    public int countPairs(int[] deli) {
        HashMap<Integer,Integer> x = new HashMap<>();
        
        for(int i : deli)
        {
            x.put(i,x.getOrDefault(i,0)+1);
        }
        
        long ans = 0;
        long mod = 1_000_000_007;
        int arr[] = new int[32];
         for(int i = 0; i<=31; i++)
        {
                arr[i] = 1<<i;
        }
        for(int i : x.keySet())
        {
           for(int j : arr)
           {
               
               if(j-i != i)
               {
                   long val = x.getOrDefault(j-i,0);
                   ans+= (val*x.get(i))%mod;
                   ans%=mod;
               }
               else
               {
                   long val = x.get(i);
                   ans+= ((val*(val-1))/2)%mod;
                   ans%=mod;
               }
           }
            x.put(i,0);
        }
        
        return (int) (ans%mod);
    }
    
   
    
}