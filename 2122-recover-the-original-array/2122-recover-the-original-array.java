class Solution
{
    public int[] recoverArray(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length/2;
        for(int k = 1; k<2*n; k++)
        {
            
        if((nums[k] - nums[0])%2 != 0)
            continue;
        int diff =  (nums[k] - nums[0])/2;
            if(diff ==0)
                continue;
            
        HashMap<Integer,Integer> x = new HashMap<>();
        for(int i : nums)
        {
            x.put(i,x.getOrDefault(i,0)+1);
        }
        int ans[] = new int[n];
        int i = 0;
        for(int j : nums)
        {
            if(x.containsKey(j))
            {
                int g = x.get(j);
                // System.out.println(j);
                x.put(j,x.get(j)-1);
                if(x.get(j) ==0 )
                    x.remove(j);
                int val1 = j + 2*diff;
                 // System.out.println(val1);
                int val2 = j - 2*diff;
                if(x.containsKey(val1))
                {
                    x.put(val1,x.get(val1)-1);
                    if(x.get(val1) == 0)
                    x.remove(val1);
                    ans[i++] = val1-diff;
                }
                else if(x.containsKey(val2))
                {
                     x.put(val2,x.get(val2)-1);
                    if(x.get(val2) == 0)
                    x.remove(val2);
                    ans[i++] = val2+diff;
                }
            }
        }
            
            if(i == n)
        return ans;
            
        }
        
        return new int[0];
    }
}