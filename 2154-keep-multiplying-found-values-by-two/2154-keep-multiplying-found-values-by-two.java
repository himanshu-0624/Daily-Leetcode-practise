class Solution {
    public int findFinalValue(int[] nums, int or) {
        int i = 0;
        while(i<nums.length)
        {
            if(nums[i] == or)
            {
                or = or*2;
                i = -1;
            }
            i++;
        }
        return or;
    }
}