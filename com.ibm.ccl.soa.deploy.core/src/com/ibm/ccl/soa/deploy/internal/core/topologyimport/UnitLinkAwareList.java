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

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;

/**
 * A list that can re-associate adds and removals with a list managed by the edited container,
 * rather than a list referenced from another imported container.
 * 
 * @since 1.0
 * 
 */
public class UnitLinkAwareList extends LinkAwareList implements List {

	private final Unit proxy;

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param facade
	 *           The proxy to set as the source of a link.
	 * @param nonProxyNotifier
	 *           The notifier object used to acquire the list of adapters.
	 * @param feature
	 *           The abstract feature represented in this list.
	 * @param editable
	 *           The list of links managed by the container, passed by reference (e.g.
	 *           topology.getHostingLinks())
	 * @param readonly
	 *           A smart list that knows the subset of items that comes from the proxied model.
	 */
	public UnitLinkAwareList(Unit facade, DeployModelObject nonProxyNotifier,
			EStructuralFeature feature, EList editable, List readonly) {
		super(nonProxyNotifier, feature, facade, editable, readonly);
		proxy = facade;
	}

	protected void configureLink(Object linkable) {
		Assert.isTrue(linkable instanceof UnitLink);
		((UnitLink) linkable).setSource(proxy);
	}

	protected void deconfigureLink(Object linkable) {
		Assert.isTrue(linkable instanceof UnitLink);
		((UnitLink) linkable).setSource(null);
	}
}
