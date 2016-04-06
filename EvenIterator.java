package com.roteaugen.advIter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterators that only returns the elements with even indices (0-based)
 * 
 * e.g. Container = [3, 5, 4, 7]
 * EvenIterator returns [3, 4]
 * 
 * @author Mingjing Zhang
 */
public class EvenIterator<E> implements Iterator<E> {
	Iterator<E> iter;

	public EvenIterator(Iterator<E> it) {
		iter = it;
	}
	
	@Override
	public boolean hasNext() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return iter.hasNext();
	}

	@Override
	public E next() throws NoSuchElementException {
		// Get the next item
		E nextItem = iter.next();
		
		// and prepare for the following next() call
		if (iter.hasNext()) iter.next();
		return nextItem;
	}

}
