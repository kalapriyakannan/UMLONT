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
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * A deploy resolution parameter linked to a deploy object attribute.
 */
public class DeployResolutionObjectAttributeParameter extends
		DeployResolutionParameter implements
		IDeployResolutionObjectAttributeParameter {

	protected final DeployModelObject object;
	protected final EAttribute objectAttribute;
	protected final String objectAttributeName;

	/**
	 * Construct a resolution parameter associated with the value of a DMO EMF
	 * attribute.
	 * <p>
	 * The type of the parameter is derived from the attribute type.
	 * 
	 * @param resolution
	 *            the resolution which is parameterized.
	 * @param name
	 *            the name of the parameter.
	 * @param description
	 *            a description of the resolution parameter.
	 * @param object
	 *            the object whose attribute was parameterized.
	 * @param attribute
	 *            the EMF attribute on the object that is parameterized.
	 */
	public DeployResolutionObjectAttributeParameter(
			IDeployParameterizedResolution resolution, String name,
			String description, DeployModelObject object, EAttribute attribute) {
		super(resolution, attribute.getEAttributeType().getInstanceClass(),
				name, description);
		assert object != null;
		assert attribute != null;
		this.object = object;
		this.objectAttribute = attribute;
		this.objectAttributeName = attribute.getName();
	}

	/**
	 * Construct a resolution parameter associated with the value of a DMO
	 * attribute.
	 * 
	 * @param resolution
	 *            the resolution which is parameterized.
	 * @param name
	 *            the name of the parameter.
	 * @param description
	 *            a description of the resolution parameter.
	 * @param object
	 *            the object whose attribute was parameterized.
	 * @param attributeType
	 *            the type of the attribute.
	 * @param attributeName
	 *            the name of the attribute on the object that is parameterized.
	 */
	public DeployResolutionObjectAttributeParameter(
			IDeployParameterizedResolution resolution, String name,
			String description, DeployModelObject object,
			Class<?> attributeType, String attributeName) {
		super(resolution, attributeType, name, description);
		assert object != null;
		assert attributeName != null;
		this.object = object;
		EAttribute attribute = null;
		EStructuralFeature feature = object.getEObject().eClass()
				.getEStructuralFeature(attributeName);
		if ((feature != null) && (feature instanceof EAttribute)) {
			attribute = (EAttribute) feature;
		}
		this.objectAttribute = attribute;
		this.objectAttributeName = attributeName;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionObjectAttributeParameter#getParameterizedObject()
	 */
	public DeployModelObject getParameterizedObject() {
		return object;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionObjectAttributeParameter#getParameterizedObjectAttribute()
	 */
	public EAttribute getParameterizedObjectAttribute() {
		return objectAttribute;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionObjectAttributeParameter#getParameterizedObjectAttributeName()
	 */
	public String getParameterizedObjectAttributeName() {
		return objectAttributeName;
	}
}
