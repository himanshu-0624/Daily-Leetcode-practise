class Solution {
    public long smallestNumber(long num) {
        long h = num;
        num = (long)Math.abs(num);
        int c = 0;
        ArrayList<Integer> x = new ArrayList<>();
        while(num>0)
        {
            int g = (int)(num%10);
           // System.out.println(g+" "+num);
            if(g == 0)
            {
                c++;
            }
            x.add(g);
            num/=10;
        }
        Collections.sort(x);
        
        long ans = 0;
        if(h>0)
        {
            for(int i = 0; i<x.size(); i++)
            {
               // System.out.print(x.get(i)+" ");
                if(x.get(i) == 0)
                {
                    
                }
                else if(x.get(i) >0 && i-1>=0 &&x.get(i-1) == 0 )
                {
                    ans = x.get(i);
                    while(c>0)
                    {
                        ans = ans*10;
                        c--;
                    }
                }
                else
                {
                    ans = ans*10 + x.get(i);
                }
            }
            return ans;
        }
        else
        {
            for(int j = x.size()-1; j>=0; j--)
            {
                ans = ans*10 + x.get(j);
            }
            return ans*-1;
        }
        
        
    }
}