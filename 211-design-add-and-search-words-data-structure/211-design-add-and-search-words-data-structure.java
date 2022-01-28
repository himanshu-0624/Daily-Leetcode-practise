class WordDictionary {
      class Node {
          boolean is;
          Node [] x;
          public Node()
          {
              x = new Node[26];
          }
      }
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray())
        {
            if(cur.x[c-'a'] == null)
            {
                cur.x[c-'a'] = new Node();
            }
            cur = cur.x[c-'a'];
        }
        cur.is = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        
        return call(cur, 0, word.toCharArray());
    }
    
    boolean call(Node r, int i, char [] word)
    {
        if(r == null)return false;
        if(word.length-1 == i)
        {
            if(word[i] == '.')
            {
                for(Node g : r.x)
                {
                    if(g!= null && g.is)return true;
                }
                return false;
            }
            else
            {
                if(r.x[word[i]-'a']==null)return false;
                return r.x[word[i]-'a'].is;
            }
        }
        
        if(word[i] == '.')
        {
           for(Node g : r.x)
           {
               if(g!= null)
               {
                   if(call(g,i+1,word))return true;
               }
           }
            return false;
        }
        else
        {
             Node g = r.x[word[i]-'a'];
            if(g == null)return false;
            
            return call(g,i+1,word);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */