class KthLargest {
  final  PriorityQueue<Integer> x;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        x = new PriorityQueue<>(k);
        for(int i = 0; i<nums.length; i++)
            x.add(nums[i]);
        
    }
    
    public int add(int val) {
      
                 x.add(val);
             while(x.size() > k)
              x.poll();
        
        return (int)x.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */