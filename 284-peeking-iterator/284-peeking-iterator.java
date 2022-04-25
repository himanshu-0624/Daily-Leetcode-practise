// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    boolean hasPeeked;
    Integer ele;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr  = iterator;
        hasPeeked = false;
        
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasPeeked)
        {
            hasPeeked = true;
            ele = itr.next();
        }
        return ele;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasPeeked)
        {
            hasPeeked = false;
            return ele;
        }
        
        return itr.next();
	}
	
	@Override
	public boolean hasNext() {
	    return hasPeeked || itr.hasNext();
	}
}