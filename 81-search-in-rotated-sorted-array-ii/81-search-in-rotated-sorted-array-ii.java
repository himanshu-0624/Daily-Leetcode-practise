class Solution {
    public boolean search(int[] nums, int t) {
        for(int i : nums)
            if(i == t)return true;
        return false;
    }
}