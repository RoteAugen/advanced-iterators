package com.roteaugen.advIter.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.roteaugen.advIter.EvenIterator;

public class EvenIteratorTest {

	@Test
	public void testNull() {
		Iterator<Integer> testee = new EvenIterator<Integer>(null);
		try {
			testee.hasNext();
			fail(".hasNext() on full is expected to fail.");
		}
		catch (NullPointerException ex) {
		}
		
		try {
			testee.next();
			fail(".next() on null is expected to fail.");
		}
		catch (NullPointerException ex) {
			
		}
		
	}

	@Test
	public void testOne() {
		List<Integer> testA = new ArrayList<Integer>();
		testA.add(1);
		List<Integer> resultA = new ArrayList<Integer>();
		resultA.add(1);
		
		Iterator<Integer> testee = new EvenIterator<Integer>(testA.iterator());
		
		while (testee.hasNext()) {
			assertEquals(testee.next(), resultA.iterator().next());
		}
	}

}
