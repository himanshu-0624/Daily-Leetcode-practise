class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        int l = p.length();
        int [] cnt = new int[26];
         int [] pcnt = new int[26];
        for(char c : p.toCharArray())
        {
            cnt[c-'a']++;
        }
        
        for(int i = 0; i<s.length() && i<l-1; i++)
        {
            pcnt[s.charAt(i)-'a']++;
        }
        
        for(int j = l-1; j<s.length(); j++)
        {
            pcnt[s.charAt(j)-'a']++;
            if(isAnagram(pcnt,cnt))
            {
                ans.add(j-l+1);
            }
            pcnt[s.charAt(j-l+1)-'a']--;
        }
        
        return ans;
    }
    
    boolean isAnagram(int [] a1, int [] a2)
    {
        for(int i = 0; i<26; i++)
        {
            if(a1[i] != a2[i])
                return false;
        }
        
        return true;
    }
}