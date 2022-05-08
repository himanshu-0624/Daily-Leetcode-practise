/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
     List<Integer> x;
    int n;
    int i;
    public NestedIterator(List<NestedInteger> nested) {
        x = new ArrayList<Integer>();
        call(nested);
        i = 0;
    }
    
    void call (List<NestedInteger> p)
    {
        for(NestedInteger d : p)
        {
            if(d.isInteger())
            {
                int val = d.getInteger();
                x.add(val);
                n++;
            }
            else
            {
                call(d.getList());
            }
            
        }
    }

    @Override
    public Integer next() {
        int val = x.get(i);
        i++;
        return val;
    }

    @Override
    public boolean hasNext() {
        if(i == n)
            return false;
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */