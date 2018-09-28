/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

public class FilteredListTest extends TestCase {

	private void checkFilterView(FilterList view, List expected,
			Integer notIncludedFilteredValue, String notIncludedValue) {
		List emptyContains = new ArrayList();
		List contains = new ArrayList();
		contains.add(notIncludedValue);

		assert view.containsAll(emptyContains);
		assert !view.containsAll(contains);
		assert !view.contains(notIncludedFilteredValue);
		assert !view.contains(notIncludedValue);
		if (view.size() == 0) {
			try {
				view.get(0);
				assert false;
			} catch (IndexOutOfBoundsException e) {
				// ok
			}
		} else {
			for (int i = 0; i < expected.size(); i++) {
				assert view.get(i).equals(expected.get(i));
			}
		}
		assert view.isEmpty() == expected.isEmpty();
		Iterator viewIter = view.iterator();
		Iterator expectedIter = view.iterator();
		while (viewIter.hasNext()) {
			Object obj = viewIter.next(); // ECS 5/18 allow test to work even
											// w/o assertions enabled
			assert obj.equals(expectedIter.next());
		}
		assert !expectedIter.hasNext();
		assert view.indexOf(notIncludedValue) == -1;
		assert view.indexOf(notIncludedFilteredValue) == -1;
		assert view.lastIndexOf(notIncludedFilteredValue) == -1;
		assert view.lastIndexOf(notIncludedValue) == -1;
		for (int i = 0; i < expected.size(); i++) {
			Object value = expected.get(i);
			assert view.indexOf(value) == expected.indexOf(value);
			assert view.lastIndexOf(value) == expected.lastIndexOf(value);
		}
		assert view.size() == expected.size();
		assert view.subList(0, 0).size() == 0;
		assert view.subList(0, view.size()).equals(
				expected.subList(0, view.size()));
		assert Arrays.equals(view.toArray(), expected.toArray());
		assert Arrays.equals(view.toArray(new Object[100]), expected
				.toArray(new Object[100]));
	}

	public void testFilteredList() throws Exception {
		EList list = new BasicEList();
		List expected = new ArrayList();

		FilterList view = new FilterList(list, new IObjectFilter() {
			public boolean accept(Object value) {
				if (value instanceof Integer) {
					return ((Integer) value).intValue() >= 0;
				}
				return false;
			}
		}, new IObjectAdapter() {
			public Object adapt(Object object) {
				if (object instanceof Integer) {
					return object;
				} else if (object instanceof String) {
					return new Integer(((String) object).length());
				}
				return null;
			}
		});

		checkFilterView(view, expected, new Integer(999), "AAA");

		list.add(new Integer(-1));
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.clear();

		view.add(new Integer(1));
		expected.add(new Integer(1));
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.add(0, new Integer(-1));
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.add(new Integer(-2));
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.remove(0);
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.add(0, new Integer(-1));
		checkFilterView(view, expected, new Integer(999), "AAA");

		list.add(new Integer(2));
		expected.add(new Integer(2));
		checkFilterView(view, expected, new Integer(999), "AAA");

		//

		view.clear();
		expected.clear();
		checkFilterView(view, expected, new Integer(999), "AAA");

		assert list.size() == 2;
		assert ((Integer) list.get(0)).intValue() == -1;
		assert ((Integer) list.get(1)).intValue() == -2;

		//

		view.add("Z");
		expected.add(new Integer(1));
		checkFilterView(view, expected, new Integer(999), "AAA");

		//

		list.clear();
		expected.clear();
		checkFilterView(view, expected, new Integer(999), "AAA");
	}
}
