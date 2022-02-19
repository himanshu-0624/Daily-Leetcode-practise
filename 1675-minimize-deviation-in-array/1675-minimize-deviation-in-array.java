class Solution {
    class Pair{
        int val;
        int max;
        public Pair(int val, int max)
        {
            this.val = val;
            this.max = max;
        }
    }
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Pair> x = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.val,b.val);
        });
        
        int max = -1;
        for(int i :  nums)
        {
            int  p = i;
            while(i%2 == 0)
            {
                i/=2;
            }
            if(p%2 == 0)
            {
                 x.add(new Pair(i,p));
               
            }
             else
                x.add(new Pair(i,p*2));
            
             max = Math.max(max,i);
            
           
        }
        
        int ans = Integer.MAX_VALUE;
        while(true)
        {
            Pair g =  x.poll();
             ans = Math.min(ans,max - g.val);
            if(g.val == g.max)
                break;
            int d = g.val*2;
            max = Math.max(d,max);
            x.add(new Pair(d,g.max));
        }
        return ans;
        
    }
}