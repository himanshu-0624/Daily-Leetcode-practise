class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i :  nums)
        {
            if(i == 1)
            {
                cnt++;
            }
        }
        int max = cnt;
        int zer = 0;
        int oner = cnt;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                zer++;
            }
            else
            {
                oner--;
            }
            max = Math.max(max,zer+oner);
        }
        List<Integer> ans = new ArrayList<>();
         zer = 0;
         oner = cnt;
        if(max == oner+zer)
        {
            ans.add(0);
        }
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                zer++;
            }
            else
            {
                oner--;
            }
           if(max == oner+zer)
          {
            ans.add(i+1);
          }
        }
        
        return ans;
        
    }
}