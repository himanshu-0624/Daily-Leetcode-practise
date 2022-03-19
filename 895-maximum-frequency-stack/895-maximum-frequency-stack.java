class FreqStack {
static Map<Integer, Integer> freqMap ; 
  
  
    static Map<Integer, Stack<Integer> > setMap; 
  
  
    static int maxfreq = 0; 
    public FreqStack() {
         freqMap = new HashMap<>();
        setMap = new HashMap<>(); 
        
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1; 
  
        
        freqMap.put(x, freq); 
  
       
        if (freq > maxfreq) 
            maxfreq = freq; 
  
        
        setMap.computeIfAbsent(freq, z -> new Stack()).push(x); 
    }
    
    public int pop() {
       
        int top = setMap.get(maxfreq).pop(); 
  
         
        freqMap.put(top, freqMap.get(top) - 1); 
  
       
        if (setMap.get(maxfreq).size() == 0) 
            maxfreq--; 
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */