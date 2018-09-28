/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel}.
 * The provider is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionAttributeDataModelProvider extends AbstractDataModelProvider implements
		IResolutionAttributeDataModelProperties {

	/** The typed view over the model (may be null). */
	protected ResolutionAttributeDataModel typedModel = null;

	/**
	 * @return the typed view over the model of this provider.
	 */
	public ResolutionAttributeDataModel getTypedModel() {
		if (typedModel == null) {
			typedModel = new ResolutionAttributeDataModel(model);
		}
		return typedModel;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionAttributeDataModelProperties#ATTRIBUTE_NAME
	 */
	public IStatus validateAttributeName() {
		// Required String
		IStatus status = ResolutionDataModelProvider.validatePropertyType(model, ATTRIBUTE_NAME,
				String.class, true);
		if (!status.isOK()) {
			return status;
		}
		String attrName = getTypedModel().getAttributeName();

		// Object on which attribute is defined
		status = validateDeployModelObject();
		if (!status.isOK()) {
			return Status.CANCEL_STATUS;
		}
		DeployModelObject object = getTypedModel().getDeployModelObject();
		if (object == null) {
			// Can't validate attribute without object
			return Status.CANCEL_STATUS;
		}

		// Attribute in object
		EStructuralFeature feature = object.eClass().getEStructuralFeature(attrName);
		if (feature != null && feature instanceof EAttribute) {
			return internalValidateAttributeTypeMatch(((EAttribute) feature).getEAttributeType(),
					IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
		}
		ExtendedAttribute extAttr = object.getExtendedAttribute(attrName);
		if (extAttr != null) {
			return internalValidateAttributeTypeMatch(extAttr.getInstanceType(),
					IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
		}
		return ResolutionDataModelProvider.createAttributeValueStatus(ATTRIBUTE_NAME, attrName);
	}

	/**
	 * 
	 * @return The default value of the AttributeName property.
	 * @see IResolutionAttributeDataModelProperties#ATTRIBUTE_NAME
	 * @see ResolutionAttributeDataModel#getAttributeName()
	 */
	protected String getDefaultAttributeName() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionAttributeDataModelProperties#DEPLOY_MODEL_OBJECT
	 */
	public IStatus validateDeployModelObject() {
		Object objectValue = model
				.getProperty(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT);
		if (objectValue == null) {
			return ResolutionDataModelProvider
					.createAttributeUndefinedStatus(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT);
		}
		if (!(objectValue instanceof DeployModelObject)) {
			return ResolutionDataModelProvider.createAttributeValueTypeStatus(
					IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT, objectValue);
		}

		return Status.OK_STATUS;
	}

	/**
	 * @see IResolutionAttributeDataModelProperties#DEPLOY_MODEL_OBJECT
	 */
	protected DeployModelObject getDefaultDeployModelObject() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionAttributeDataModelProperties#ATTRIBUTE
	 */
	public IStatus validateAttribute() {
		// Optional EAttribute
		IStatus status = ResolutionDataModelProvider.validatePropertyType(model, ATTRIBUTE,
				EAttribute.class, false);
		if (!status.isOK()) {
			return status;
		}
		EAttribute attr = getTypedModel().getAttribute();
		if (attr == null) {
			return Status.OK_STATUS;
		}

		// Object on which attribute is defined
		status = validateDeployModelObject();
		if (!status.isOK()) {
			return Status.CANCEL_STATUS;
		}
		DeployModelObject object = getTypedModel().getDeployModelObject();
		if (object == null) {
			// Can't validate attribute without object
			return Status.CANCEL_STATUS;
		}

		if (!attr.getContainerClass().isInstance(object)) {
			return ResolutionDataModelProvider.createAttributeValueStatus(
					IResolutionAttributeDataModelProperties.ATTRIBUTE, attr.getName());
		}

		return internalValidateAttributeTypeMatch(attr.getEAttributeType(),
				IResolutionAttributeDataModelProperties.ATTRIBUTE);
	}

	/**
	 * Validate that the attribute type matches the type of the resolution parameter.
	 * 
	 * @param type
	 *           the attribute type.
	 * @param property
	 *           the property whose attribute does not match.
	 * @return an OK status if the attribute matches the resolution parameter type.
	 * @see ResolutionDataModel#getType()
	 */
	protected IStatus internalValidateAttributeTypeMatch(EDataType type, String property) {
		IStatus status = getTypedModel().getResolutionDataModel().validateType();
		if (!status.isOK()) {
			return Status.CANCEL_STATUS;
		}
		Class rType = getTypedModel().getResolutionDataModel().getType();
		if (rType == null) {
			return Status.CANCEL_STATUS;
		}
		if (!rType.isAssignableFrom(type.getInstanceClass())) {
			return ResolutionDataModelProvider.createAttributeValueStatus(property, type);
		}

		return Status.OK_STATUS;
	}

	/**
	 * @see IResolutionAttributeDataModelProperties#ATTRIBUTE
	 */
	protected EAttribute getDefaultAttribute() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionAttributeDataModelProperties#RESOLUTION_DATA_MODEL
	 */
	public IStatus validateResolutionDataModel() {
		// Required IDataModel
		IDataModel nestedModel = model.getNestedModel(RESOLUTION_DATA_MODEL);
		if (nestedModel == null) {
			return ResolutionDataModelProvider.createAttributeUndefinedStatus(RESOLUTION_DATA_MODEL);
		}
		return nestedModel.validate();
	}

	/**
	 * @see IResolutionAttributeDataModelProperties#RESOLUTION_DATA_MODEL
	 */
	protected IDataModel getDefaultResolutionDataModel() {
		return null;
	}

	/**
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 */
	public IStatus validate(String property) {
		if (IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT.equals(property)) {
			return validateDeployModelObject();
		} else if (IResolutionAttributeDataModelProperties.ATTRIBUTE.equals(property)) {
			return validateAttribute();
		} else if (IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL.equals(property)) {
			return validateResolutionDataModel();
		} else if (IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME.equals(property)) {
			return validateAttributeName();
		} else {
			return Status.OK_STATUS;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT.equals(property)) {
			return getDefaultDeployModelObject();
		} else if (IResolutionAttributeDataModelProperties.ATTRIBUTE.equals(property)) {
			return getDefaultAttribute();
		} else if (IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL.equals(property)) {
			return getDefaultResolutionDataModel();
		} else if (IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME.equals(property)) {
			return getDefaultAttributeName();
		} else {
			return null;
		}

	}

	/**
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		return super.propertySet(propertyName, propertyValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT);
		propertyNames.add(IResolutionAttributeDataModelProperties.ATTRIBUTE);
		propertyNames.add(IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL);
		propertyNames.add(IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new ResolutionAttributeDataModelOperation(model);
	}
}
