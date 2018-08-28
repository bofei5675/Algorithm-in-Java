package MyPeekIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekIterator implements Iterator<Integer> {
	/**
	 * Leetcode 284
	 * Design an iterator that supports peek operation
	 */
	Integer next;
	Iterator<Integer> iter;
	boolean noSuchElement;
	
	public PeekIterator(Iterator<Integer> iterator) {
		// Assign iter first
		this.iter = iterator;
		// this function will assign next if iter does have next
		advanceIter();
	}
	
	public Integer peek() {
		return this.next;
	}
	
	@Override
	public boolean hasNext() {
		return !noSuchElement;
	}
	@Override
	public Integer next() {
		if( noSuchElement )
			throw new NoSuchElementException();
		Integer res = this.next; // save the current next
		advanceIter(); // update next 
		return res;
	}
	private void advanceIter() {
		if(this.iter.hasNext()) {
			this.next = this.iter.next();
		} else {
			noSuchElement = true;
		}
	}
	
}
