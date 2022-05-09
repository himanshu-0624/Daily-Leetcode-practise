class Solution {
     List<String> x = null;
     String [] map =new String[] {" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"} ;
    public List<String> letterCombinations(String digits) {
       x = new ArrayList<>();
        if(digits.length() == 0)return x;
        
        dfs(0, digits, new StringBuilder());
        return x;
    }
   void dfs(int len, String digit, StringBuilder temp)
    {
        if(len == digit.length())
        {
            x.add(temp.toString());
            return;
        }
       
       char ch = digit.charAt(len);
       String str = map[ch-'0'];
       for(char c : str.toCharArray())
       {
           temp.append(c);
           dfs(len+1,digit,temp);
           temp.deleteCharAt(temp.length()-1);
       }
       
    }
}