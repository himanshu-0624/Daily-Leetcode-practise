class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length <3)return false;
        Stack<Integer> x = new Stack<>();
        int min [] = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i<nums.length; i++)
        {
            min[i] = Math.min(nums[i],min[i-1]);
        }
        for(int i = nums.length-1; i>=0; i--)
        {
            while(!x.isEmpty() && x.peek() <= min[i])x.pop();
            
           if(!x.isEmpty() && x.peek() < nums[i])return true;
            
            x.push(nums[i]);
        }
        return false;
    
    }
}