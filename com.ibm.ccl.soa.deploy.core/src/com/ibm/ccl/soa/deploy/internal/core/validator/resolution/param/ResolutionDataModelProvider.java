/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterValueDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel}. The
 * provider is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionDataModelProvider extends AbstractDataModelProvider implements
		IResolutionDataModelProperties {

	/** The typed view over the model (may be null). */
	protected ResolutionDataModel typedModel = null;

	/**
	 * @return the typed view over the model of this provider.
	 */
	public ResolutionDataModel getTypedModel() {
		if (typedModel == null) {
			typedModel = new ResolutionDataModel(model);
		}
		return typedModel;
	}

	/**
	 * Validates that the name of the resolution parameter name is set.
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#NAME
	 */
	public IStatus validateName() {
		// Required String
		IStatus status = ResolutionDataModelProvider.validatePropertyType(model, NAME, String.class,
				true);
		if (!status.isOK()) {
			return status;
		}

		// Non-empty String
		String strValue = getTypedModel().getName();
		if (strValue.trim().length() == 0) {
			return ResolutionDataModelProvider.createAttributeValueStatus(
					IResolutionDataModelProperties.NAME, strValue);
		}

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Name property.
	 * @see IResolutionDataModelProperties#NAME
	 * @see ResolutionDataModel#getName()
	 */
	protected String getDefaultName() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#DESCRIPTION
	 */
	public IStatus validateDescription() {
		// Optional String
		return ResolutionDataModelProvider.validatePropertyType(model, DESCRIPTION, String.class,
				false);
	}

	/**
	 * @return The default value of the Description property.
	 * @see IResolutionDataModelProperties#DESCRIPTION
	 * @see ResolutionDataModel#getDescription()
	 */
	protected String getDefaultDescription() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#VALUE_SET
	 */
	public IStatus validateValueSet() {
		// optional Boolean
		return ResolutionDataModelProvider.validatePropertyType(model, VALUE_SET, Boolean.class,
				false);
	}

	/**
	 * 
	 * @return The default value of the ValueSet property.
	 * @see IResolutionDataModelProperties#VALUE_SET
	 * @see ResolutionDataModel#getValueSet()
	 */
	protected boolean getDefaultValueSet() {
		return true;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#VALID_VALUE_LIST_EXCLUSIVE
	 */
	public IStatus validateValidValueListExclusive() {
		// Optional Boolean
		return ResolutionDataModelProvider.validatePropertyType(model, VALID_VALUE_LIST_EXCLUSIVE,
				Boolean.class, false);
	}

	/**
	 * 
	 * @return The default value of the ValidValueListExclusive property.
	 * @see IResolutionDataModelProperties#VALID_VALUE_LIST_EXCLUSIVE
	 * @see ResolutionDataModel#getValidValueListExclusive()
	 */
	protected boolean getDefaultValidValueListExclusive() {
		return false;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#RESOLUTION
	 */
	public IStatus validateResolution() {
		// Required IDeployResolution
		return ResolutionDataModelProvider.validatePropertyType(model, RESOLUTION,
				IDeployResolution.class, true);
	}

	/**
	 * @see IResolutionDataModelProperties#RESOLUTION
	 */
	protected IDeployParameterizedResolution getDefaultResolution() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 */
	public IStatus validateValidValues() {
		// Optional List
		IStatus status = ResolutionDataModelProvider.validatePropertyType(model, VALID_VALUES,
				List.class, false);
		if (!status.isOK()) {
			return status;
		}
		List<IDeployResolutionParameterValueDescriptor> list = getTypedModel().getValidValues();
		if (list == null) {
			return Status.OK_STATUS;
		}
		for (Object obj : list) {
			if (!(obj instanceof IDeployResolutionParameterValueDescriptor)) {
				return ResolutionDataModelProvider.createAttributeValueTypeStatus(VALID_VALUES, obj);
			}
		}

		return Status.OK_STATUS;
	}

	/**
	 * @see IResolutionDataModelProperties#VALID_VALUES
	 */
	protected List getDefaultValidValues() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#TYPE
	 */
	public IStatus validateType() {
		// Required Class
		return ResolutionDataModelProvider.validatePropertyType(model, TYPE, Class.class, true);
	}

	/**
	 * @see IResolutionDataModelProperties#TYPE
	 */
	protected Class getDefaultType() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#VALUE
	 */
	public IStatus validateValue() {
		Object value = getProperty(VALUE);

		// Check its type
		IStatus status = validateType();
		if (status.isOK()) {
			Class<?> type = getTypedModel().getType();
			if (type != null && value != null) {
				// returns null if type is null, or a non-primitive type
				type = EcoreUtil.wrapperClassFor(type);
				if (!type.isInstance(value)) {
					return ResolutionDataModelProvider.createAttributeValueTypeStatus(VALUE, value);
				}
			}
		} else {
			return status;
		}

		// Check if the values are restricted
		if (getTypedModel().isValidValueListExclusive() && validateValidValues().isOK()) {
			boolean found = false;
			List<IDeployResolutionParameterValueDescriptor> list = (List<IDeployResolutionParameterValueDescriptor>) getProperty(VALID_VALUES);
			if (list != null) {
				for (IDeployResolutionParameterValueDescriptor descr : list) {
					if (ValidatorUtils.equals(descr.getValue(), value)) {
						found = true;
						break;
					}
				}
			}
			if (!found) {
				return ResolutionDataModelProvider.createAttributeValueStatus(VALUE, value);
			}
		}

		return Status.OK_STATUS;
	}

	/**
	 * @see IResolutionDataModelProperties#VALUE
	 */
	protected Object getDefaultValue() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IResolutionDataModelProperties#DEFAULT_VALUE
	 */
	public IStatus validateDefaultValue() {
		return Status.OK_STATUS;
	}

	/**
	 * @see IResolutionDataModelProperties#DEFAULT_VALUE
	 */
	protected Object getDefaultDefaultValue() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE.equals(property)) {
			return validateValidValueListExclusive();
		} else if (IResolutionDataModelProperties.RESOLUTION.equals(property)) {
			return validateResolution();
		} else if (IResolutionDataModelProperties.NAME.equals(property)) {
			return validateName();
		} else if (IResolutionDataModelProperties.TYPE.equals(property)) {
			return validateType();
		} else if (IResolutionDataModelProperties.DESCRIPTION.equals(property)) {
			return validateDescription();
		} else if (IResolutionDataModelProperties.VALID_VALUES.equals(property)) {
			return validateValidValues();
		} else if (IResolutionDataModelProperties.VALUE_SET.equals(property)) {
			return validateValueSet();
		} else if (IResolutionDataModelProperties.DEFAULT_VALUE.equals(property)) {
			return validateDefaultValue();
		} else if (IResolutionDataModelProperties.VALUE.equals(property)) {
			return validateValue();
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
		if (IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE.equals(property)) {
			return getDefaultValidValueListExclusive();
		} else if (IResolutionDataModelProperties.RESOLUTION.equals(property)) {
			return getDefaultResolution();
		} else if (IResolutionDataModelProperties.NAME.equals(property)) {
			return getDefaultName();
		} else if (IResolutionDataModelProperties.TYPE.equals(property)) {
			return getDefaultType();
		} else if (IResolutionDataModelProperties.DESCRIPTION.equals(property)) {
			return getDefaultDescription();
		} else if (IResolutionDataModelProperties.VALID_VALUES.equals(property)) {
			return getDefaultValidValues();
		} else if (IResolutionDataModelProperties.VALUE_SET.equals(property)) {
			return getDefaultValueSet();
		} else if (IResolutionDataModelProperties.DEFAULT_VALUE.equals(property)) {
			return getDefaultDefaultValue();
		} else if (IResolutionDataModelProperties.VALUE.equals(property)) {
			return getDefaultValue();
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
		propertyNames.add(IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE);
		propertyNames.add(IResolutionDataModelProperties.RESOLUTION);
		propertyNames.add(IResolutionDataModelProperties.NAME);
		propertyNames.add(IResolutionDataModelProperties.TYPE);
		propertyNames.add(IResolutionDataModelProperties.DESCRIPTION);
		propertyNames.add(IResolutionDataModelProperties.VALID_VALUES);
		propertyNames.add(IResolutionDataModelProperties.VALUE_SET);
		propertyNames.add(IResolutionDataModelProperties.DEFAULT_VALUE);
		propertyNames.add(IResolutionDataModelProperties.VALUE);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new ResolutionDataModelOperation(model);
	}

	/**
	 * Static utility method to report an invalid nested data model.
	 * 
	 * @param dataModel
	 *           the datamodel whose nesting is invalid.
	 * @param missingNestedModel
	 *           the type of the expected model nested.
	 * @return the created status.
	 */
	public static IStatus createInvalidNestedDataModelStatus(IDataModel dataModel,
			String missingNestedModel) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
				DeployCoreMessages.Data_model_0_not_nested_in_1, dataModel.getID(), missingNestedModel));
	}

	/**
	 * Creates a status for a property that is undefined.
	 * 
	 * @param attribute
	 *           the undefined property.
	 * @return the created status.
	 */
	public static IStatus createAttributeUndefinedStatus(String attribute) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
				DeployCoreMessages.Attribute_0_not_defined, attribute));
	}

	/**
	 * Creates a status for a property whose value is of an invalid type.
	 * 
	 * @param attribute
	 *           the property.
	 * @param value
	 *           the value.
	 * @return the created status.
	 */
	public static IStatus createAttributeValueTypeStatus(String attribute, Object value) {
		Object type;
		if (value instanceof EObject) {
			type = ((EObject) value).eClass();
		} else {
			type = value.getClass();
		}
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, DeployNLS.bind(
				DeployCoreMessages.Attribute_0_value_type_1_invalid, attribute, type));
	}

	/**
	 * Creates a status for an attribute whose valid is not valid.
	 * 
	 * @param attribute
	 *           the property.
	 * @param value
	 *           the value.
	 * @return the created status.
	 */
	public static IStatus createAttributeValueStatus(String attribute, Object value) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, DeployNLS.bind(
				DeployCoreMessages.Attribute_0_value_1_invalid, attribute, value));
	}

	/**
	 * Utility method which validates the type of the property of a data model.
	 * 
	 * @param model
	 *           the data model on which the property is defined.
	 * @param name
	 *           the name of the property.
	 * @param type
	 *           the type of the property value.
	 * @param required
	 *           true if a null value should be treated as an error.
	 * @return the status of validating the property type.
	 */
	public static IStatus validatePropertyType(IDataModel model, String name, Class<?> type,
			boolean required) {
		assert model.isProperty(name) : model.getID() + ": " + name;//$NON-NLS-1$
		Object value = model.getProperty(name);
		if (value == null) {
			if (required) {
				return ResolutionDataModelProvider.createAttributeUndefinedStatus(name);
			}
			return Status.OK_STATUS;
		}
		if (!type.isInstance(value)) {
			return ResolutionDataModelProvider.createAttributeValueTypeStatus(name, value);
		}
		return Status.OK_STATUS;
	}
}
