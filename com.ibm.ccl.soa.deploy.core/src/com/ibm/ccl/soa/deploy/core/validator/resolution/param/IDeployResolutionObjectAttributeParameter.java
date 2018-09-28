/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * A resolution parameter that is linked to a deploy model object attribute.
 * <p>
 * Setting the resolution parameter has the effect of the resolution setting the
 * underlying attribute in the object. The object must be contained in the
 * topology of the resolution status object.
 */
public interface IDeployResolutionObjectAttributeParameter extends
		IDeployResolutionParameter {

	/**
	 * Returns the resolution status object's EMF attribute which is
	 * parameterized, if applicable.
	 * <p>
	 * Use {@link #getParameterizedObjectAttributeName()} for extended
	 * attributes.
	 * 
	 * @return the EMF attribute of the parameterized object, or null if its an
	 *         extended attribute.
	 * @see #getParameterizedObject()
	 */
	public EAttribute getParameterizedObjectAttribute();

	/**
	 * Returns the name of the resolution status object's attribute which is
	 * parameterized.
	 * 
	 * @return the name of the EMF or extended object attribute that is
	 *         parameterized.
	 * @see #getParameterizedObject()
	 */
	public String getParameterizedObjectAttributeName();

	/**
	 * @return the object whose attribute was parameterized.
	 */
	public DeployModelObject getParameterizedObject();
}
