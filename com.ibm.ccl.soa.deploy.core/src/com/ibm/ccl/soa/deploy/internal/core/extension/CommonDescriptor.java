/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Provides a wrapper around configuration elements parsed from the extension points in
 * <b>com.ibm.ccl.soa.deploy.core</b> plugin.
 * 
 * <p>
 * A <i>Descriptor</i> provides a higher level abstraction to handle parsing, validation, and
 * failsafeness around configuration elements parsed from the Eclipse extension point mechanism.
 * </p>
 * 
 * <p>
 * Subclasses are required to validate or protect the value returned from any <i>getXXX()</i>
 * method.
 * </p>
 * 
 * <p>
 * Subclasses are also required to define zero or more <i>createXXX()</i> methods.
 * </p>
 * <p>
 * In createXXX() methods, unless a null value signifies a particular condition or behavior, define
 * a non-API singleton implementation of the required interface or type to return in place of
 * exceptions or null return values.
 * </p>
 * <p>
 * For example, if the extension defines an implementation of IMyInterface, define a non-API
 * implementation of IMyInterface named SkeletonMyInterface (in an internal package) which
 * implements IMyInterface (with no-op methods) and declares a public static final IMyInterface
 * INSTANCE = new SkeletonMyInterface(); singleton field. Also make the the constructor private so
 * that it cannot be inadvertantly instantiated. Then whenever an exception occurs when trying to
 * instantiate the specific implementation from the extension, return SkeletonMyInterface.INSTANCE
 * instead of null.
 * </p>
 * 
 * @since 1.0
 * 
 */
public abstract class CommonDescriptor implements ICommonDeployExtensionConstants {

	private IConfigurationElement element;

	protected final String EMPTY_STRING = ""; //$NON-NLS-1$

	private final String name;

	private final String description;

	/**
	 * @param anElement
	 *           The configuration element from the parsed extension point.
	 */
	public CommonDescriptor(IConfigurationElement anElement) {
		Assert.isNotNull(anElement);
		element = anElement;
		name = element.getAttribute(ATT_NAME) == null ? EMPTY_STRING : element.getAttribute(ATT_NAME);
		description = element.getAttribute(ATT_DESCRIPTION) == null ? EMPTY_STRING : element
				.getAttribute(ATT_DESCRIPTION);
	}

	/**
	 * @return The value of the name attribute from the extension. (Already externalized and ready
	 *         for display).
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The value of the description attribute from the extension. (Already externalized and
	 *         ready for display).
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Provides access to the configuration element for subclasses.
	 * 
	 * @return the configuration element used to construct this descriptor.
	 */
	protected final IConfigurationElement getElement() {
		return element;
	}

}
