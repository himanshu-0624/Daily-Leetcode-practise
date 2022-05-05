class MyStack {
 Queue<Integer> q;
    Queue<Integer> qu;
    boolean y ;
    /** Initialize your data structure here. */
    public MyStack() {
               q = new LinkedList<>();
        qu = new LinkedList<>();
        y = true;  
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
                 if(y)
        {
           q.add(x); 
        }
        else
        {
            qu.add(x);
        }



    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
         if(!y)
        {
            y=!y;
            while(!qu.isEmpty())
            {
                int h = qu.poll();
                if(qu.isEmpty()) return h;
                q.add(h);
            }
        
        }
        else
        {
            y=!y;
             while(!q.isEmpty())
            {
                int h = q.poll();
                if(q.isEmpty()) return h;
                qu.add(h);
            }
            
        }
        return 0;
    }
    
    /** Get the top element. */
    public int top() {
           if(!y)
        {
            y=!y;
            while(!qu.isEmpty())
            {
                int h = qu.poll();
                q.add(h);
                if(qu.isEmpty()) return h;
                
            }
        
        }
        else
        { y=!y;
             while(!q.isEmpty())
            {
                int h = q.poll();
                  qu.add(h);
                if(q.isEmpty()) return h;
               
            }
            //x=!x;
        }
        return 0;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty() && qu.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */