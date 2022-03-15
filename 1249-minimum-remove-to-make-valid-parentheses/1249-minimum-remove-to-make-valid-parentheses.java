class Solution {
    public String minRemoveToMakeValid(String s) {
         char [] x = s.toCharArray();
        
        int k =0;
        
        StringBuffer y  = new StringBuffer();
              for(char j : x)
              {
                  if(j == '(')
                  {
                      k++;
                  }
                  else if(j == ')')
                  {
                    if(k == 0) continue;
                      
                      k--;
                  }
                  
                  y.append(j);
                  
                  
              }
        
                StringBuffer z  = new StringBuffer();

        for(int i = y.length()-1;i>=0;i--)
        {
            if(y.charAt(i) == '(' && k-->0)continue;
            z.append(y.charAt(i));
        }
       
        
        return z.reverse().toString();
        
    }
}