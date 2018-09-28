/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IRenameDiagramModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.RenameDiagramModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation.RenameDiagramOperation;

/**
 * 
 * 
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>diagram</b>:
 * 
 * </li>
 * <li><b>name</b>:
 * 
 * </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class RenameDiagramDescriptor {

	private final ROTopologyModelManager modelManager = null;
	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static RenameDiagramDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new RenameDiagramDescriptor(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new RenameDiagramModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameDiagramDescriptor(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDiagram
	 *           The new value of the Diagram property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDiagram(String newDiagram) {
		model.setProperty(IRenameDiagramModelProperties.DIAGRAM, newDiagram);
	}

	/**
	 * 
	 * 
	 * @return The value of the Diagram property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDiagram() {
		return (String) model.getProperty(IRenameDiagramModelProperties.DIAGRAM);
	}

	/**
	 * Determine if the Diagram property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Topology
	 *         property is valid.
	 * @see #getTopology()
	 * @see #setTopology(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDiagram() {
		return model.validateProperty(IRenameDiagramModelProperties.DIAGRAM);
	}

	/**
	 * Determine the default value of the Diagram property.
	 * 
	 * @return The default value of the Diagram property.
	 * @see #getTopology()
	 * @see #setTopology(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDiagram() {
		return (String) model.getDefaultProperty(IRenameDiagramModelProperties.DIAGRAM);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newName
	 *           The new value of the Name property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setName(String newName) {
		model.setProperty(IRenameDiagramModelProperties.NAME, newName);
	}

	/**
	 * 
	 * 
	 * @return The value of the Name property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getName() {
		return (String) model.getProperty(IRenameDiagramModelProperties.NAME);
	}

	/**
	 * Determine if the Name property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Name
	 *         property is valid.
	 * @see #getName()
	 * @see #setName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateName() {
		return model.validateProperty(IRenameDiagramModelProperties.NAME);
	}

	/**
	 * Determine the default value of the Name property.
	 * 
	 * @return The default value of the Name property.
	 * @see #getName()
	 * @see #setName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultName() {
		return (String) model.getDefaultProperty(IRenameDiagramModelProperties.NAME);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		RenameDiagramOperation operation = new RenameDiagramOperation(this);
		return operation;
	}

	/**
	 * The underlying datamodel that backs this facade.
	 * 
	 * @return The underlying datamodel that backs this facade.
	 */
	public final IDataModel getUnderlyingDataModel() {
		return model;
	}

	/**
	 * Validates all properties associated with this type-safe data model.
	 * 
	 * @return The collective status of all properties associated with the underlying datamodel.
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate() {
		return model.validate(false);
	}
}
