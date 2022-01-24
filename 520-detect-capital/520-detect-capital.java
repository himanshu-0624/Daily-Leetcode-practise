class Solution {
    public boolean detectCapitalUse(String word) {
        char [] x  = word.toCharArray();
        int n = x.length;
        if(n==1)return true;
        if(Character.isUpperCase(x[0]))
        {
            if(Character.isUpperCase(x[1]))
            {
              for(int i = 1; i<n; i++)
            {
                if(Character.isLowerCase(x[i]))return false;
            }  
            }
            else
            {
                for(int i = 1; i<n; i++)
            {
                if(Character.isUpperCase(x[i]))return false;
            }
            }
        }
        else
        {
            for(int i = 1; i<n; i++)
            {
                if(Character.isUpperCase(x[i]))return false;
            }
        }
        return true;
    }
}