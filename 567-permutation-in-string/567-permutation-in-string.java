class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] x = new int[26];
        for(char c : s1.toCharArray())
            x[c-'a']++;
        
        int [] d = new int[26];
        if(s1.length() > s2.length())return false;
        
        for(int i = 0; i<s1.length()-1; i++)
            d[s2.charAt(i)-'a']++;
        
        for(int i = s1.length()-1; i<s2.length(); i++ )
        {
            d[s2.charAt(i)-'a']++;
            if(ch(d,x))return true;
            d[s2.charAt(i-s1.length()+1)-'a']--;
        }
        return false;
    }
    
    boolean ch(int [] a, int [] b)
    {
        for(int i = 0; i<26; i++)
            if(a[i] != b[i])
                return false;
        
        return true;
    }
}