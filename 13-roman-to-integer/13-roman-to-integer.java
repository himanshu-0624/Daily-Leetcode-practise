class Solution {
    
    
    public int romanToInt(String s) {
//         I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
        HashMap<Character,Integer>x = new HashMap<>();
        x.put('I',1);
        x.put('V',5);
         x.put('X',10);
         x.put('L',50);
         x.put('C',100);
         x.put('D',500);
         x.put('M',1000);
         
        int ans = 0;
        for(int i = 0; i<s.length(); i++)
        {
            int g = x.get(s.charAt(i));
            if(i+1 <s.length())
            {
                int f = x.get(s.charAt(i+1));
                if(g>=f)
                {
                    ans+=g;
                }
                else
                {
                    ans+=(f-g);
                    i++;
                }
            }
            else
            {
                ans+=g;
            }
        }
        
        return ans;
        
    }
}