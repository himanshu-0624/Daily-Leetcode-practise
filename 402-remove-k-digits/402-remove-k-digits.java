class Solution {
    public String removeKdigits(String num, int k) {
         Stack<Character>  ans = new Stack<>();
          for(char c : num.toCharArray())
          {
                            
             while(k>0 && !ans.isEmpty() && ans.peek() > c)
             {
                 ans.pop();
                 k--;
             }
              ans.add(c);
          }
        while(k>0)
        {
            ans.pop();
            k--;
        }
        StringBuffer res = new StringBuffer();
        boolean f = false;
        for(char c:  ans)
        {
            if(!f && c == '0')
            {
                
            }
            else if(!f)
            {
                f = true;
                res.append(c);
            }
            else
            res.append(c);
        }
        
        if(res.length()==0)
            res.append('0');
        return res.toString();
    }
}