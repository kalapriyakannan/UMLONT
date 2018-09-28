/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Provides a wrapper around <b>&lt;resourceTypeBinding /&gt;</b> configuration elements parsed
 * from the <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class ResourceTypeBindingDescriptor extends CommonDescriptor {

	private String id;
	private String resourceTypeId;
	private String context;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "resourceTypeBinding" IConfigurationElement from the registry reader.
	 */
	protected ResourceTypeBindingDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_RESOURCE_TYPE_BINDING.equals(anElement.getName());
		init();
	}

	private void init() {
		id = getElement().getAttribute(ATT_ID);
		context = getElement().getAttribute(ATT_CONTEXT);
		resourceTypeId = getElement().getAttribute(ATT_RESOURCE_TYPE_ID);
	}

	public String toString() {
		return "ResourceTypeBindingDescriptor[resourceTypeId=" + resourceTypeId + ", context=" + context + ", id=" + id + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * The id of this resource descriptor
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return the Resource type id of this binding
	 */
	public String getResourceTypeId() {
		return resourceTypeId;
	}

	/**
	 * 
	 * @return The context of this binding
	 */
	public String getContext() {
		return context;
	}

}
