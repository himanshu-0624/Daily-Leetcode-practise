class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> x = new PriorityQueue<>((a,b)->{
           return Double.compare(b,a); 
        });
        
        double sum = 0;
        for(int i: nums)
        {
             sum+=i;
            x.add((double)i);
        }
        
        double c = sum/2;
        
        int cnt= 0;
        while(sum > c)
        {
            double g = x.poll()/2;
            sum-=g;
            x.add(g);
            cnt++;
        }
        
        return cnt;
    }
}