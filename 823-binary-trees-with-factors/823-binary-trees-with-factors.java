class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
         Arrays.sort(arr);
        long res = 0, mod = (int)1e9 + 7;
        HashMap<Integer,Long> x = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
         x.put(arr[i],1l);   
            for(int j = 0; j<i; j++)
            {
                if(arr[i]%arr[j] == 0)
                {
                    x.put(arr[i], (x.get(arr[i]) + x.get(arr[j]) * x.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
            }
            res = (res + x.get(arr[i])) % mod;
        }
        return (int)res;
    }
}