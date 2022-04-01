class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> x = new ArrayList<>();
        
        for(char c : s.toCharArray())
        {
            if(c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'|| c == 'I' || c == 'O' || c == 'U')
            {
                x.add(c);
            }
        }
        
        int j = x.size()-1;
        StringBuffer a = new StringBuffer();
         for(char c : s.toCharArray())
        {
            if(c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'|| c == 'I' || c == 'O' || c == 'U')
            {
                a.append(x.get(j));
                j--;
            }
             else
             {
                 a.append(c);
             }
        }
        return a.toString();
    }
}