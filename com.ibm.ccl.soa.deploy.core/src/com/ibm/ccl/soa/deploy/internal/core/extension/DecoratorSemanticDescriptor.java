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
 * Provides a layer around an IConfigurationElement from
 * <b>com.ibm.ccl.soa.deploy.core.topology/decoratorSemantic</b>
 * 
 * @since 1.0
 * 
 */
public class DecoratorSemanticDescriptor extends CommonDescriptor {

	private final String id;
	private final String icon;

	/**
	 * Create a descriptor for elements with the name "discoverer" that are defined as part of a
	 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "discoverer" that conforms to the schema of
	 *           <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b>.
	 */
	public DecoratorSemanticDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_DECORATOR_SEMANTIC.equals(anElement.getName());
		id = anElement.getAttribute(ATT_ID) == null ? EMPTY_STRING : anElement.getAttribute(ATT_ID);
		icon = anElement.getAttribute(ATT_ICON) == null ? EMPTY_STRING : anElement
				.getAttribute(ATT_ICON);
	}

	/**
	 * @return The value of the id attribute from the extension. (Already externalized and ready for
	 *         display).
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return The value of the string value of the attribute from the extension.
	 */
	public String getIcon() {
		return icon;
	}

}
