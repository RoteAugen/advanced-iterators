package com.roteaugen.advIter.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.roteaugen.advIter.PeekIterator;

public class PeekIteratorTest {

	@Test
	public void testNullIterator() {
		// Test Case 1: null iterator
		PeekIterator<Integer> testee = new PeekIterator<Integer>(null);
		assertFalse(testee.hasNext());
		try{
			testee.next();
			fail(".hasNext() did not throw exception.");
		}
		catch (NullPointerException ex) {
			
		}
	}
	
	@Test
	public void testOnEmptyContainer() {
		// Test Case 2: iterator on empty container
		List<Integer> testA = new ArrayList<Integer>();
		PeekIterator<Integer> testee  = new PeekIterator<Integer>(testA.iterator());
		
		assertFalse(testee.hasNext());
		try{
			testee.next();
			fail(".hasNext() did not throw exception.");
		}
		catch (NoSuchElementException ex) {
			
		}
		
		// Test Case 
	}
	
	@Test
	public void testOnContainerOfOne() {
		// Test Case 3: iterator on iterator with only one element
		List<Integer> testA = new ArrayList<Integer>();
		testA.add(0);
		PeekIterator<Integer> testee = new PeekIterator<Integer>(testA.iterator());
		
		//
		for (int i = 0; i < 5; ++i)
			assertTrue(testee.hasNext()); 
		
		try{
			for (int i = 0; i < 5; ++i)
				testee.peek();
		}
		catch (NoSuchElementException ex) {
			fail(".peek() must not throw exception.");
		}
		
		try{
			testee.next();
		}
		catch (NoSuchElementException ex) {
			fail(".next() must not throw exception here.");
		}
		
		try{
			testee.next();
			fail(".next() must throw exception here.");
		}
		catch (NoSuchElementException ex) {
		}
		
		try{
			testee.peek();
			fail(".peek() must throw exception here.");
		}
		catch (NoSuchElementException ex) {
		}
		
		assertFalse(testee.hasNext());
		// Test Case 
	}

	
	@Test
	public void testOnContainerOfTwo() {
		// Test Case 3: iterator on iterator with only one element
		List<Integer> testA = new ArrayList<Integer>();
		testA.add(0);
		testA.add(-1);
		PeekIterator<Integer> testee = new PeekIterator<Integer>(testA.iterator());
		
		
		// First hasNext should always succeed
		for (int i = 0; i < 5; ++i)
			assertTrue(testee.hasNext()); 
		
		// First peek should always succeed
		try{
			for (int i = 0; i < 5; ++i)
				testee.peek();
		}
		catch (NoSuchElementException ex) {
			fail(".peek() must not throw exception.");
		}
		
		// First next should always succeed
		try{
			testee.next();
		}
		catch (NoSuchElementException ex) {
			fail(".next() must not throw exception here.");
		}

		// Second peek should always succeed
		try{
			for (int i = 0; i < 5; ++i)
				testee.peek();
		}
		catch (NoSuchElementException ex) {
			fail(".peek() must not throw exception.");
		}
		
		// Second next should also succeed
		try{
			testee.next();
		}
		catch (NoSuchElementException ex) {
			fail(".next() must not throw exception here.");
		}
		
		// Third next must fail 
		try{
			testee.next();
			fail(".next() must throw exception here.");
		}
		catch (NoSuchElementException ex) {
		}
		
		// Third peek must fail 
		try{
			testee.peek();
			fail(".peek() must throw exception here.");
		}
		catch (NoSuchElementException ex) {
		}
		
		// Last hasNext must fail
		assertFalse(testee.hasNext());
		// Test Case 
	}
}
