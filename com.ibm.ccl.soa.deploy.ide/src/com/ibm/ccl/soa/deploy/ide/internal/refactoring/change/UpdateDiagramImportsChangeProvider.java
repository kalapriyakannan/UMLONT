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

import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange}. The provider
 * is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateDiagramImportsChangeProvider extends DeployRefactoringChangeProvider
		implements IUpdateDiagramImportsChangeProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateDiagramImportsChangeProperties#DIAGRAM
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDiagram() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IUpdateDiagramImportsChangeProperties.DIAGRAM) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath diagramProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(IUpdateDiagramImportsChangeProperties.DIAGRAM);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Diagram property.
	 * @see IUpdateDiagramImportsChangeProperties#DIAGRAM
	 * @see UpdateDiagramImportsChange#getDiagram()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultDiagram() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateDiagramImportsChangeProperties#MODEL
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateModel() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IUpdateDiagramImportsChangeProperties.MODEL) instanceof org.eclipse.core.runtime.IPath);
		//org.eclipse.core.runtime.IPath modelProperty = (org.eclipse.core.runtime.IPath)  model.getProperty(IUpdateDiagramImportsChangeProperties.MODEL);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Model property.
	 * @see IUpdateDiagramImportsChangeProperties#MODEL
	 * @see UpdateDiagramImportsChange#getModel()
	 * @generated (mde.utilities.datamodels)
	 */
	protected org.eclipse.core.runtime.IPath getDefaultModel() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateDiagramImportsChangeProperties#SOURCE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IUpdateDiagramImportsChangeProperties.SOURCE) instanceof String);
		//String sourceProperty = (String)  model.getProperty(IUpdateDiagramImportsChangeProperties.SOURCE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Source property.
	 * @see IUpdateDiagramImportsChangeProperties#SOURCE
	 * @see UpdateDiagramImportsChange#getSource()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultSource() {
		return "null"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IUpdateDiagramImportsChangeProperties#DESTINATION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IUpdateDiagramImportsChangeProperties.DESTINATION) instanceof String);
		//String destinationProperty = (String)  model.getProperty(IUpdateDiagramImportsChangeProperties.DESTINATION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Destination property.
	 * @see IUpdateDiagramImportsChangeProperties#DESTINATION
	 * @see UpdateDiagramImportsChange#getDestination()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultDestination() {
		return "null"; //$NON-NLS-1$ 
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IUpdateDiagramImportsChangeProperties.SOURCE.equals(property)) {
			return validateSource();
		} else if (IUpdateDiagramImportsChangeProperties.MODEL.equals(property)) {
			return validateModel();
		} else if (IUpdateDiagramImportsChangeProperties.DESTINATION.equals(property)) {
			return validateDestination();
		} else if (IUpdateDiagramImportsChangeProperties.DIAGRAM.equals(property)) {
			return validateDiagram();
		} else {
			return super.validate(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IUpdateDiagramImportsChangeProperties.SOURCE.equals(property)) {
			return getDefaultSource();
		} else if (IUpdateDiagramImportsChangeProperties.MODEL.equals(property)) {
			return getDefaultModel();
		} else if (IUpdateDiagramImportsChangeProperties.DESTINATION.equals(property)) {
			return getDefaultDestination();
		} else if (IUpdateDiagramImportsChangeProperties.DIAGRAM.equals(property)) {
			return getDefaultDiagram();
		} else {
			return super.getDefaultProperty(property);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IUpdateDiagramImportsChangeProperties.SOURCE);
		propertyNames.add(IUpdateDiagramImportsChangeProperties.MODEL);
		propertyNames.add(IUpdateDiagramImportsChangeProperties.DESTINATION);
		propertyNames.add(IUpdateDiagramImportsChangeProperties.DIAGRAM);
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
