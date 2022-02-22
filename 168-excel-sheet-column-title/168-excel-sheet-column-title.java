class Solution {
    public String convertToTitle(int cN) {
        StringBuffer ans  = new StringBuffer();
        while(cN>0)
        {
            int a = cN%26;
            char c='a';
            if(a == 0)
            {
                c = 'Z';
                cN-=26;
            }
            else
             c =(char)('A'+a-1);
            
            ans.append(c);
            cN-=a;
            cN/=26;
        }
        ans.reverse();
        return ans.toString();
    }
}