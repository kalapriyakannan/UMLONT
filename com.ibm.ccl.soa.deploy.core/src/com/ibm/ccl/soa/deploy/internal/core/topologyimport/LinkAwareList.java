/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.FilterList;

/**
 * A list that can re-associate adds and removals with a list managed by the edited container,
 * rather than a list referenced from another imported container.
 * 
 * @since 1.0
 * 
 */
public abstract class LinkAwareList extends NotifyingReassociationList implements List {

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param eAdapterManager
	 * @param feature
	 * @param proxifiedSource
	 * @param editable
	 * @param readonly
	 */
	public LinkAwareList(DeployModelObject eAdapterManager, EStructuralFeature feature,
			DeployModelObject proxifiedSource, EList editable, List readonly) {
		super(eAdapterManager, feature, proxifiedSource, new FilterList(editable,
				new LinkProxyFilter(proxifiedSource)), readonly);
	}

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param notifier
	 * @param feature
	 * @param editable
	 * @param readonly
	 */
	public LinkAwareList(EList editable, List readonly) {
		super(null, null, null, editable, readonly);
	}

	public boolean add(Object added) {
		// source must be configured before the link will be accepted for add
		configureLink(added);
		return super.add(added);
	}

	public void add(int index, Object added) {
		// source must be configured before the link will be accepted for add
		configureLink(added);
		super.add(index, added);
	}

	public boolean addAll(Collection added) {
		// source must be configured before the link will be accepted for add
		for (Iterator iterator = added.iterator(); iterator.hasNext();) {
			configureLink(iterator.next());
		}
		return super.addAll(added);
	}

	public boolean addAll(int index, Collection added) {
		// source must be configured before the link will be accepted for add
		for (Iterator iterator = added.iterator(); iterator.hasNext();) {
			configureLink(iterator.next());
		}
		return super.addAll(index, added);
	}

	public void clear() {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public boolean removeAll(Collection arg0) {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public boolean retainAll(Collection arg0) {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public boolean remove(Object removed) {
		if (super.remove(removed)) {
			deconfigureLink(removed);
			return true;
		}
		return false;
	}

	public Object remove(int index) {
		Object removed = super.remove(index);
		if (removed != null) {
			deconfigureLink(removed);
		}
		return removed;
	}

	protected abstract void configureLink(Object linkable);

	protected abstract void deconfigureLink(Object linkable);

}
