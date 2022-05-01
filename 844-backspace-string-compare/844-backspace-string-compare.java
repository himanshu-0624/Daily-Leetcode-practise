class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> x = new Stack<>();
       Stack<Character> y = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c == '#' && x.size() > 0)
                x.pop();
            else if(c != '#')
                x.add(c);
        }
         for(char c : t.toCharArray())
        {
            if(c == '#' && y.size() > 0)
                y.pop();
            else if(c != '#')
                y.add(c);
        }
        
        if(x.size() != y.size())
            return false;
        while(!x.isEmpty())
        {
            
            if(x.pop() != y.pop())
                return false;
        }
        
        return true;
        
    }
}