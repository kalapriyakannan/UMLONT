/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;

/**
 * Status associated with the attribute of a deploy model object.
 */
public interface IDeployAttributeStatus extends IDeployStatus {

	/**
	 * Separator character between the class name and the attribute name.
	 * 
	 * @see DeployCoreStatusUtil#getFullEAttributeName(EAttribute)
	 */
	public static final char ATTRIBUTE_NAME_CLASS_SEPARATOR = '#';

	/**
	 * Returns the <em>full</em> name of the attribute including the class on which it was defined.
	 * <p>
	 * Use {@link #getAttributeShortName()} to get the attribute name without the class prefix.
	 * 
	 * @return the full name of the deploy model object attribute associated with this status.
	 * 
	 * @see #ATTRIBUTE_NAME_CLASS_SEPARATOR
	 * @deprecated use {@link #getAttributeType}
	 */
	public String getAttributeName();

	/**
	 * @return the non-fully qualified name of the attribute
	 * @deprecated use {@link #getAttributeType}
	 */
	public String getAttributeShortName();

	/**
	 * Returns the static or dynamic declaration of the attribute associated with the status.
	 * <p>
	 * Dynamic attributes are associated at the instance level using {@link ExtendedAttribute} which
	 * is a subtype of {@link EAttribute}.
	 * 
	 * @return the type declaration of the attribute, or null if it is has not been declared on the
	 *         type of the object (static) or on the object itself (dynamic).
	 */
	public EAttribute getAttributeType();

	/**
	 * Sets the attribute associated with this status.
	 * 
	 * @param attribute
	 *           an attribute of the EMF object.
	 * 
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setAttributeName(EAttribute attribute);
}
