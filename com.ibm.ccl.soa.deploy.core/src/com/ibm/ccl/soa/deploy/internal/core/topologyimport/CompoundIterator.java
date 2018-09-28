/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * An iterator that allows full traversal of the list but prevents any modifications of the second
 * delegate list.
 * 
 * @since 1.0
 * 
 */
public class CompoundIterator implements Iterator {

	private final Iterator[] iterators;
	private int currentIterator;
	private final int initModCount;
	private final Modifiable source;

	public interface Modifiable {
		int getModCount();
	}

	/**
	 * Construct an iterator to traverse the enclosing list.
	 * 
	 * @param iterables
	 *           An array of iterators, the first of which contains an iterator that may be edited
	 *           (e.g. {@link Iterator#remove()}.
	 * @param modifiable
	 *           A list or object that maintains a modCount based on the number of changes the object
	 *           experiences. Used to determine when {@link ConcurrentModificationException}.
	 * 
	 */
	public CompoundIterator(Iterator[] iterables, CompoundIterator.Modifiable modifiable) {
		source = modifiable;
		initModCount = modifiable.getModCount();
		currentIterator = 0;

		iterators = iterables;
	}

	public boolean hasNext() {
		checkSafety();
		for (; currentIterator < iterators.length; ++currentIterator) {
			if (iterators[currentIterator].hasNext()) {
				return true;
			}
		}
		return false;
	}

	public Object next() {
		checkSafety();
		return iterators[currentIterator].next();
	}

	public void remove() {
		checkSafety();
		if (currentIterator == 0) {
			iterators[0].remove();
		} else {
			throw new UnsupportedOperationException("Cannot remove the selected element."); //$NON-NLS-1$
		}
	}

	private void checkSafety() {
		if (source.getModCount() != initModCount) {
			throw new ConcurrentModificationException();
		}

	}

}