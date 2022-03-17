class Solution {
    public int scoreOfParentheses(String s) {
        char [] x = s.toCharArray();
         if(x.length == 0)
             return 0;
         if(x.length == 2)
             return 1;
        
        int ans = 0;
        int i = 0;
        
        while(i<x.length)
        {
            if(x[i] == '(' && x[i+1] == ')')
            {
                ans+=1;
                i+=2;
            }
            else
            {
                int j = i+1;
                int  p = 1;
                while(p!= 0 )
                {
                    if(x[j] == '(')
                    {
                        p++;
                    }
                    else
                        p--;
                    j++;
                }
                
                ans = ans + 2*(scoreOfParentheses(s.substring(i+1,j-1)));
                i= j;
            }
        }
        
        return ans;
        
        
             
        
    }
    
  
}