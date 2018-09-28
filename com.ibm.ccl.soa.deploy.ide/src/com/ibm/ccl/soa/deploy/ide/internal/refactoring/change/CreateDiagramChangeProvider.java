/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange
 * @generated (mde.utilities.datamodels)
 */
public class CreateDiagramChangeProvider extends DeployRefactoringChangeProvider implements
		ICreateDiagramChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateDiagramChangeProperties#DIAGRAM
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDiagram() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateDiagramChangeProperties.DIAGRAM) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath diagramProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(ICreateDiagramChangeProperties.DIAGRAM);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Diagram property.
	 * @see ICreateDiagramChangeProperties#DIAGRAM
	 * @see CreateDiagramChange#getDiagram()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultDiagram() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateDiagramChangeProperties#MODEL
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateModel() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateDiagramChangeProperties.MODEL) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath modelProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(ICreateDiagramChangeProperties.MODEL);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Model property.
	 * @see ICreateDiagramChangeProperties#MODEL
	 * @see CreateDiagramChange#getModel()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultModel() {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * 
	 */
	public IStatus validate(String property) {
		if (ICreateDiagramChangeProperties.MODEL.equals(property)) {
			return validateModel();
		} else if (ICreateDiagramChangeProperties.DIAGRAM.equals(property)) {
			return validateDiagram();
		} else {
			return super.validate(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * 
	 */
	public Object getDefaultProperty(String property) {
		if (ICreateDiagramChangeProperties.MODEL.equals(property)) {
			return getDefaultModel();
		} else if (ICreateDiagramChangeProperties.DIAGRAM.equals(property)) {
			return getDefaultDiagram();
		} else {
			return super.getDefaultProperty(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * 
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(ICreateDiagramChangeProperties.MODEL);
		propertyNames.add(ICreateDiagramChangeProperties.DIAGRAM);
		propertyNames.addAll(super.getPropertyNames());
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		throw new UnsupportedOperationException(
				"getDefaultOperation() is not support in the " + getClass().getCanonicalName() + " class."); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
