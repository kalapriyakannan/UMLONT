package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class NamespaceElementSorter extends ViewerSorter {

	private final NamespaceElementComparator fComparator;

	/**
	 * Constructor.
	 */
	public NamespaceElementSorter() {
		super(null); // delay initialization of collator
		fComparator = new NamespaceElementComparator();
	}

	/**
	 * 
	 * @param element
	 *           the element
	 * @param property
	 *           the property
	 * @return always <code>true</code>
	 */
	public boolean isSorterProperty(Object element, Object property) {
		return true;
	}

	/*
	 * @see ViewerSorter#category
	 */
	public int category(Object element) {
		return fComparator.category(element);
	}

	/*
	 * @see ViewerSorter#compare
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		return fComparator.compare(viewer, e1, e2);
	}

	/**
	 * Overrides {@link org.eclipse.jface.viewers.ViewerSorter#getCollator()}.
	 * 
	 * @deprecated The method is not intended to be used by clients.
	 */
	public final java.text.Collator getCollator() {
		// kept in for API compatibility
		if (collator == null) {
			collator = java.text.Collator.getInstance();
		}
		return collator;
	}
}
