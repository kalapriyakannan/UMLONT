/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;

/**
 * A filtered view on the elements of another list.
 * <p>
 * The view is mutable, supporting addition and removal of elements.
 */
public final class FilterList implements EList {

	protected final EList list;

	protected final IObjectFilter filter;

	protected final IObjectAdapter addObjectAdapter;

	/**
	 * Construct a filtered list as a view over an other list.
	 * <p>
	 * Added objects are not adapted.
	 * 
	 * @param list
	 *           the list whose elements will be filtered.
	 * @param filter
	 *           the element filter (non-null).
	 */
	public FilterList(EList list, IObjectFilter filter) {
		this(list, filter, null);
	}

	/**
	 * Construct a filtered list as a view over an other list.
	 * 
	 * @param list
	 *           the list whose elements will be filtered.
	 * @param filter
	 *           the element filter (non-null).
	 * @param addObjectAdapter
	 *           optional adapter invoked before adding objects to the list (may be null).
	 */
	public FilterList(EList list, IObjectFilter filter, IObjectAdapter addObjectAdapter) {
		assert list != null;
		assert filter != null;

		this.list = list;
		this.filter = filter;
		this.addObjectAdapter = addObjectAdapter;
	}

	/**
	 * Returns the elements of the list in a new list.
	 * <p>
	 * <b>Warning</b>: for internal use only -- should never be returned.
	 * 
	 * @return the elements of the list in a new list.
	 */
	private List getElementsInNewList() {
		ArrayList list = new ArrayList(size());
		for (Iterator iter = iterator(); iter.hasNext();) {
			list.add(iter.next());
		}
		return list;
	}

	/**
	 * Returns the index of an element in the wrapped list, given its index in the filtered view.
	 * 
	 * @param relativeIndex
	 *           the index of an element in the filtered view.
	 * @return the index of the element in the wrapped list.
	 */
	protected int getAbsoluteIndex(int relativeIndex) {
		int index = 0;
		int filterIndex = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				if (filterIndex == relativeIndex) {
					return index;
				}
				filterIndex++;
			}
			index++;
		}
		if (relativeIndex == filterIndex + 1) {
			return index + 1;
		}
		throw new IndexOutOfBoundsException();
	}

	public int size() {
		int count = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				count++;
			}
		}
		return count;
	}

	public boolean isEmpty() {
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(Object arg0) {
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element) && arg0.equals(element)) {
				return true;
			}
		}
		return false;
	}

	public Iterator iterator() {
		return new FilterIterator(list.iterator(), filter);
	}

	public Object[] toArray() {
		Object[] result = new Object[size()];
		if (result.length == 0) {
			return result;
		}
		int index = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				result[index++] = element;
			}
		}

		return result;
	}

	public Object[] toArray(Object[] arg0) {
		int size = size();
		if (size > arg0.length) {
			arg0 = new Object[size];
		}
		int index = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				arg0[index++] = element;
			}
		}

		return arg0;
	}

	public boolean add(Object arg0) {
		if (addObjectAdapter == null) {
			if (!filter.accept(arg0)) {
				throw new IllegalArgumentException(arg0.toString());
			}
		} else {
			arg0 = addObjectAdapter.adapt(arg0);
			if (arg0 == null) {
				throw new IllegalArgumentException();
			}
		}
		return list.add(arg0);
	}

	public boolean remove(Object arg0) {
		if (!filter.accept(arg0)) {
			throw new IllegalArgumentException(arg0.toString());
		}
		return list.remove(arg0);
	}

	public boolean containsAll(Collection arg0) {
		return getElementsInNewList().containsAll(arg0);
	}

	public boolean addAll(Collection arg0) {
		boolean changed = false;
		for (Iterator iter = arg0.iterator(); iter.hasNext();) {
			if (add(iter.next())) {
				changed = true;
			}
		}
		return changed;
	}

	public boolean addAll(int index, Collection arg1) {
		boolean changed = false;
		index = getAbsoluteIndex(index);
		for (Iterator iter = arg1.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (addObjectAdapter == null) {
				if (!filter.accept(element)) {
					element = null;
				}
			} else {
				element = addObjectAdapter.adapt(element);
			}

			if (element != null) {
				list.add(index, element);
				changed = true;
				index++;
			}
		}
		return changed;
	}

	public boolean removeAll(Collection arg0) {
		return list.removeAll(arg0);
	}

	public boolean retainAll(Collection arg0) {
		boolean changed = false;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				if (!arg0.contains(element)) {
					iter.remove();
					changed = true;
				}
			}
		}
		return changed;
	}

	public void clear() {
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				iter.remove();
			}
		}
	}

	public Object get(int index) {
		index = getAbsoluteIndex(index);
		return list.get(index);
	}

	public Object set(int index, Object value) {
		index = getAbsoluteIndex(index);
		if (addObjectAdapter == null) {
			if (!filter.accept(value)) {
				throw new IllegalArgumentException(value.toString());
			}
		} else {
			value = addObjectAdapter.adapt(value);
			if (value == null) {
				throw new IllegalArgumentException();
			}
		}
		return list.set(index, value);
	}

	public void add(int index, Object value) {
		index = getAbsoluteIndex(index);
		if (addObjectAdapter == null) {
			if (!filter.accept(value)) {
				throw new IllegalArgumentException(value.toString());
			}
		} else {
			value = addObjectAdapter.adapt(value);
			if (value == null) {
				throw new IllegalArgumentException();
			}
		}
		list.add(index, value);
	}

	public Object remove(int index) {
		index = getAbsoluteIndex(index);
		return list.remove(index);
	}

	public int indexOf(Object value) {
		if (!filter.accept(value)) {
			return -1;
		}
		int index = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				if (value.equals(element)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}

	public int lastIndexOf(Object value) {
		if (!filter.accept(value)) {
			return -1;
		}

		int index = 0;
		int foundIndex = -1;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (value.equals(element)) {
				foundIndex = index;
			}
			if (filter.accept(element)) {
				index++;
			}
		}
		return foundIndex;
	}

	public ListIterator listIterator() {
		throw new UnsupportedOperationException();
	}

	public ListIterator listIterator(int arg0) {
		throw new UnsupportedOperationException();
	}

	public List subList(int fromIndex, int toIndex) {
		List subList = new ArrayList(toIndex - fromIndex);
		int index = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (filter.accept(element)) {
				if (index >= toIndex) {
					return subList;
				}
				if (index >= fromIndex) {
					subList.add(element);
				}
				index++;
			}
		}
		return subList;
	}

	public void move(int newPosition, Object object) {
		move(newPosition, indexOf(object));

	}

	public Object move(int newPosition, int oldPosition) {
		return list.move(newPosition, oldPosition);
	}

}
