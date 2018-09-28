/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel;

/**
 * 
 * Nested datamodel used to handle attribute operations
 * 
 * <p>
 * Clients should use {@link ResolutionAttributeDataModel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionAttributeDataModelOperation extends AbstractDataModelOperation implements
		IResolutionAttributeDataModelProperties, IResolutionDataModelProperties {

	private ResolutionAttributeDataModel typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public ResolutionAttributeDataModelOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new ResolutionAttributeDataModel(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public ResolutionAttributeDataModelOperation(ResolutionAttributeDataModel tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		DeployModelObject dmo = (DeployModelObject) getDataModel().getProperty(DEPLOY_MODEL_OBJECT);
		EAttribute attribute = (EAttribute) getDataModel().getProperty(ATTRIBUTE);
		String attributeName = getDataModel().getStringProperty(ATTRIBUTE_NAME);
		//	IDataModel resolutionDataModel = (IDataModel) getDataModel().getProperty(RESOLUTION_DATA_MODEL);
		Object value = getDataModel().getProperty(VALUE);

		if (attribute != null) {
			dmo.eSet(attribute, value);
			return Status.OK_STATUS;
		}
		ExtendedAttribute extendedAttribute = DeployModelObjectUtil.getOrCreateExtendedAttribute(dmo,
				attributeName, null);
		if (value == null || extendedAttribute.getInstanceType().isInstance(value)) {
			extendedAttribute.setValue(value);
			return Status.OK_STATUS;
		}
		System.out.println("Could not find attribute " + attributeName + " on " + dmo);//$NON-NLS-1$//$NON-NLS-2$
		return Status.CANCEL_STATUS;
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(ResolutionAttributeDataModel mdl) {
		typesafeModel = mdl;
	}
}
