class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int cnt1 = 0;
        int max2 = Integer.MAX_VALUE;
        int cnt2 = 0;
        int  n = nums.length;
        for(int i : nums)
        {
            if(i == max1)
            {
                cnt1++;
            }
            else if(i == max2)
            {
                cnt2++;
                if(cnt2 > cnt1)
                {
                    int t = cnt1;
                    cnt1 = cnt2;
                    cnt2 = t;
                    t = max1;
                    max1 = max2;
                    max2 = t;
                }
            }
            else if(cnt1 == 0)
            {
                max1 = i;
                cnt1++;
                
            }
            else if(cnt2 == 0)
            {
                max2 = i;
                cnt2++;
                
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
         List<Integer> x = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for(int i :  nums)
        {
            if(i == max1)
                cnt1++;
            if(i == max2)
                cnt2++;
        }
        if(cnt1 > n/3)
        {
            x.add(max1);
        }
         if(cnt2 > n/3 )
        {
            x.add(max2);
        }
        return x;
    }
}