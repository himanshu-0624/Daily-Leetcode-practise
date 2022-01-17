class Solution {
    public boolean wordPattern(String pat , String s) {
       
        String[] arr= s.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
         HashMap<String,Character> check = new HashMap<>();
        if(arr.length!= pat.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pat.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                
                if(check.containsKey(arr[i]))
                    return false;
                map.put(c, arr[i]);
                check.put(arr[i],c);
            }    
        }
        return true;
    }
}