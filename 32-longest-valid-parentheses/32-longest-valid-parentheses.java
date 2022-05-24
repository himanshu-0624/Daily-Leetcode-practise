class Solution {
    class Pair {
        char c;
        int i;
        Pair(char c, int i)
        {
            this.c = c;
            this.i = i;
        }
    }
    public int longestValidParentheses(String s) {
          Stack<Pair> x = new Stack<>();
        for(int i = 0; i<s.length(); i++)
        {
            char p = s.charAt(i);
            
            if(!x.isEmpty() && (x.peek().c == '(' && p == ')') )
            {
                x.pop();
            }
            else
            {
                x.push(new Pair(p,i));
            }
        }
         //System.out.println(x.size());
        ArrayList<Pair> xx = new ArrayList<>(x);
        xx.add(new Pair('a',s.length()));
        int max = xx.get(0).i - 0;
        for(int i = 0; i<xx.size()-1; i++)
        {
           
            int y = xx.get(i+1).i-xx.get(i).i-1;
            max= Math.max(max,y);
        }
        return max;
    }
}