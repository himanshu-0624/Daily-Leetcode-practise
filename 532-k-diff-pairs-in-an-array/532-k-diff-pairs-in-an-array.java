class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        for(int i :  nums)
        {
            ans.put(i,ans.getOrDefault(i,0)+1);
        }
        int an= 0;
        for(int i: ans.keySet())
        {
            int j = ans.get(i);
            if(k == 0)
            {
                if(j>1)
                {
                    an++;
                }
                continue;
            }
            int a = ans.getOrDefault(i-k,0);
            int l = ans.getOrDefault(i+k,0);
             if(j != 0 && a!= 0)
                 an++;
             if(j != 0 && l!= 0)
                 an++;
            ans.put(i,0);
        }
        return an;
    }
}