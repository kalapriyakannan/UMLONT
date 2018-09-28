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

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;

/**
 * A list that can re-associate adds and removals with a list managed by the edited container,
 * rather than a list referenced from another imported container.
 * 
 * @since 1.0
 * 
 */
public class DMOLinkAwareList extends LinkAwareList implements List {

	private DeployModelObject source;

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param proxy
	 *           The proxy to set as the source of a link.
	 * @param editable
	 * @param readonly
	 */
	public DMOLinkAwareList(DeployModelObject proxy, EList editable, List readonly) {
		super(editable, readonly);
		source = proxy;
	}

	protected void configureLink(Object linkable) {
		Assert.isTrue(linkable instanceof RealizationLink);
		((RealizationLink) linkable).setSource(source);
	}

	protected void deconfigureLink(Object linkable) {
		Assert.isTrue(linkable instanceof RealizationLink);
		((RealizationLink) linkable).setSource(null);
	}

}
