package com.roteaugen.advIter;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator with peeking functionality
 * 
 * @author Mingjing Zhang
 */
public final class PeekIterator<E> implements Iterator<E>{
	/** Wrapped iterator*/
	private Iterator<E> iter;
	
	/** Temporary variable that stores the next element after peeking*/
	private E tempVar;
	
	/** Whether we have already peeked the next element*/ 
	private boolean hasPeeked;
		
	public PeekIterator(Iterator<E> it) {
		this.iter = it;
		hasPeeked = false;
		tempVar = null;
	}
	
	public boolean hasNext() {
		// 1. iterator is not null AND
		// 2. we have a peeked value OR there is something next
		return ((iter != null) && 
				(hasPeeked || iter.hasNext()));
	}
	
	public E next() throws NoSuchElementException {
		peek();
		hasPeeked = false;
		return tempVar;
	}
	
	public E peek() throws NoSuchElementException {
		if (iter == null) throw new NoSuchElementException();
		if (!hasPeeked) {	// If no peeking has happened since last next();
			if (!iter.hasNext()) throw new NoSuchElementException();	
			tempVar = iter.next();	// get the next element and reset peeked status
			hasPeeked = true;
		}
		return tempVar;
	}
}
