/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.attribute;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Base abstract implementation of the {@link IDeployAttributeValidator} interface.
 * <p>
 * Provides methods for retrieving the value of the attribute, and reporting errors. Supports
 * {@link EAttribute} on the {@link DeployModelObject} as well as
 * {@link DeployModelObject#getExtendedAttributes()}.
 * <p>
 * For validation of {@link RequirementExpression#getAttributeName()} use
 * {@link DeployRequirementAttributeValidator}.
 * 
 * @see UnitValidator#addAttributeValidator(IDeployAttributeValidator)
 */
public abstract class DeployAttributeValidator implements IDeployAttributeValidator {

	protected final EAttribute attribute;

	protected final String attributeName;

	protected final String fullAttributeName;

	protected final EClass attributeContainer;

	protected final String validatorID;

	/**
	 * Construct a new attribute validator for the specified attribute.
	 * 
	 * @param validatorID
	 *           identifies the validator.
	 * @param attribute
	 *           an attribute declared in a subtype of {@link DeployModelObject}.
	 * 
	 * @see EAttribute#getName()
	 * @see EAttribute#getEContainingClass()
	 */
	public DeployAttributeValidator(String validatorID, EAttribute attribute) {
		assert validatorID != null;
		assert attribute != null;
		if (!CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(
				attribute.getEContainingClass())) {
			throw new IllegalArgumentException(attribute.toString());
		}
		this.validatorID = validatorID;
		this.attribute = attribute;
		attributeName = attribute.getName();
		fullAttributeName = DeployCoreStatusUtil.getFullEAttributeName(attribute);
		attributeContainer = attribute.getEContainingClass();
	}

	/**
	 * Construct a new attribute validator for the specified containing class and attribute name.
	 * <p>
	 * Use for attribute validators on extended attributes ({@link DeployModelObject#getEObject()}).
	 * 
	 * @param validatorID
	 *           identifies the validator.
	 * @param attributeContainer
	 *           the type of the attribute container (must be a subtype of {@link DeployModelObject}).
	 * @param attributeName
	 *           the name of the {@link EAttribute} or {@link ExtendedAttribute} defined the instance
	 *           of <code>attributeContainer</code>.
	 */
	public DeployAttributeValidator(String validatorID, EClass attributeContainer,
			String attributeName) {
		assert validatorID != null;
		assert attributeContainer != null;
		assert attributeName != null;
		if (!CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(attributeContainer)) {
			throw new IllegalArgumentException(attributeContainer.toString());
		}
		this.validatorID = validatorID;
		this.attributeContainer = attributeContainer;
		this.attributeName = attributeName;
		if (attributeContainer.getEStructuralFeature(attributeName) instanceof EAttribute) {
			attribute = (EAttribute) attributeContainer.getEStructuralFeature(attributeName);
			fullAttributeName = DeployCoreStatusUtil.getFullEAttributeName(attribute);
		} else {
			attribute = null;
			fullAttributeName = attributeContainer.eClass().getInstanceClassName()
					+ IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR + attributeName;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator#appliesTo(com.ibm.ccl.soa.deploy.core.DeployModelObject,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext)
	 */
	public boolean appliesTo(DeployModelObject object, IDeployValidationContext context) {
		return getAttributeContainer().isSuperTypeOf(object.getEObject().eClass());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#getAttributeContainer()
	 */
	public EClass getAttributeContainer() {
		return attributeContainer;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#getAttributeName()
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * @return the fully qualified name of the attribute, prepended with the class name.
	 */
	public String getFullAttributeName() {
		return fullAttributeName;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployAttributeValidator#getValidatorID()
	 */
	public String getValidatorID() {
		return validatorID;
	}

	/**
	 * Retrieves the attribute value from the specified object.
	 * 
	 * @param object
	 *           a deploy object of type {@link #getAttributeContainer()}.
	 * @return the object value.
	 */
	protected Object getAttributeValue(DeployModelObject object) {
		if (attribute != null) {
			return object.eGet(attribute);
		}

		ExtendedAttribute extAttr = object.getExtendedAttribute(attributeName);
		if (extAttr != null) {
			return extAttr.getValue();
		}
		return null;
	}

	/**
	 * Uses the reporter to add a {@link IDeployAttributeStatus} with problem type
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED} on the object.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param object
	 *           the object to which the status will be added.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the reporter used to add the status.
	 */
	protected void reportAttributeUndefinedStatus(int severity, DeployModelObject object,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert context != null;
		String problemType = ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED;
		String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined;
		Object[] bindings = new Object[] { object, getAttributeName() };
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				severity, getValidatorID(), problemType, unboundMessage, bindings, object,
				getFullAttributeName());
		reporter.addStatus(status);
	}

	/**
	 * Uses the reporter to add a {@link IDeployAttributeStatus} with problem type
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} on the object.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param object
	 *           the object to which the status will be added.
	 * @param value
	 *           the object value that was invalid.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the reporter used to add the status.
	 */
	protected void reportAttributeInvalidStatus(int severity, DeployModelObject object,
			Object value, IDeployValidationContext context, IDeployReporter reporter) {
		assert context != null;
		String problemType = ICoreProblemType.OBJECT_ATTRIBUTE_INVALID;
		String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid;
		Object[] bindings = new Object[] { object, getAttributeName(), value };
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				severity, getValidatorID(), problemType, unboundMessage, bindings, object,
				getFullAttributeName());
		reporter.addStatus(status);
	}
}
