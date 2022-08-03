class MyCalendar {
     TreeMap<Integer,Integer> x;
    public MyCalendar() {
        x = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer p = x.lowerKey(end);
        if(p == null)
        {    
            x.put(start,end);
            return true;
        }
        else 
        {
           // int s1 = p.intValue();
            int e1 = x.get(p);
            if(e1<=start)
            {
                 x.put(start,end);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */