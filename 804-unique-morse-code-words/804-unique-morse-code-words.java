class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String,Integer> x = new HashMap<>();
        String [] p = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String s : words)
        {
            StringBuffer ans = new StringBuffer();
            for(char c : s.toCharArray())
            {
                ans.append(p[c-'a']);
            }
            x.put(ans.toString(),x.getOrDefault(ans.toString(),0)+1);
        }
        int cnt = 0;
       
        return x.size();
    }
}