class Solution {
    public boolean isValid(String s) {
        Stack<Character> x = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i<n)
        {
            if(s.charAt(i) == '(' ||s.charAt(i) == '{' || s.charAt(i) == '[' )
            {
                x.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')')
            {if(x.empty())return false;
                char c = x.pop();
                if(c != '(')
                {
                    return false;
                }
            }
             else if(s.charAt(i) == '}')
            {if(x.empty())return false;
                char c = x.pop();
                if(c != '{')
                {
                    return false;
                }
            }
             else if(s.charAt(i) == ']' )
            {
                 if(x.empty())return false;
                 
                char c = x.pop();
                if(c != '[' )
                {
                    return false;
                }
            }
            i++;
        }
        
    return x.empty();
    }
}