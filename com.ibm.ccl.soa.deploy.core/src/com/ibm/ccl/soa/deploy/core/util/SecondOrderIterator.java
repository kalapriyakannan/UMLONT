/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates over all values associated with the objects returned by an iterator.
 * <p>
 * Example: consider a type called Car which contains objects of type Passenger. A subtype of
 * {@link SecondOrderIterator} would implement the {@link #getValues(Object)} so that given a Car
 * instance in would return all the Passengers instances. In the constructor of the
 * {@link SecondOrderIterator} subtype, the user would pass a list of Car instances, and the
 * iterator would collate all the Passengers contained in all the cars.
 */
public abstract class SecondOrderIterator implements Iterator {

	final Iterator objectIter;

	Iterator valueIter = null;

	boolean nextValueSet = false;

	Object nextValue = null;

	/**
	 * Construct an iterator over values of each object returned by the objectIter parameter.
	 * 
	 * @param objectIter
	 *           an iterator over values.
	 * 
	 * @see #getValues(Object)
	 */
	public SecondOrderIterator(Iterator objectIter) {
		assert objectIter != null;
		this.objectIter = objectIter;
	}

	/*
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (nextValueSet) {
			return true;
		}
		if ((valueIter != null) && (valueIter.hasNext())) {
			nextValue = valueIter.next();
			nextValueSet = true;
			return true;
		}

		while (objectIter.hasNext()) {
			Object object = objectIter.next();
			valueIter = getValues(object);
			if ((valueIter != null) && (valueIter.hasNext())) {
				nextValue = valueIter.next();
				nextValueSet = true;
				return true;
			}
		}
		return false;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Object result = nextValue;
		nextValueSet = false;
		return result;
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns an iterator over values contained in the object.
	 * 
	 * @param object
	 *           an object returned by the iterator provided in the constructor of this class.
	 * @return Iterator<Object> an iterator over secondary values of the object.
	 */
	public abstract Iterator getValues(Object object);
}
