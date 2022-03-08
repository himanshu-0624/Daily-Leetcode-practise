class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Long> x  = new Stack<>();
        
        for(int i : nums)
        {
            x.add((long)i);
            while(true)
            {
                long a = x.pop();
                while(!x.isEmpty() && gcd(a,x.peek())>1)
                {
                    long g = x.pop();
                    long f  = gcd(a,g);
                    a = (g*a)/f;
                    
                }
                
                x.add(a);
                break;
            }
        }
        
        for(long p : x)
        {
            ans.add((int)p);
        }
        return ans;
        
    }
    
     long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
     
}
