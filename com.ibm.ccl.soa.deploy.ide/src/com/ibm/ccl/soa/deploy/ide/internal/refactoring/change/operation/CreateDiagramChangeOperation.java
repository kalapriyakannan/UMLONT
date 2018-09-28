/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * 
 * A {@code Change} object that can be used in the ltk refactoring toolkit that will create a new
 * {@code Diagram} {@code Resource} representing the given {@code model}.
 * 
 * <p>
 * Clients should use {@link CreateDiagramChange#createConfiguredOperation()} to create an instance
 * of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange
 * @generated (mde.utilities.datamodels)
 */
public class CreateDiagramChangeOperation extends DeployRefactoringChangeOperation implements
		ICreateDiagramChangeProperties {

	private CreateDiagramChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateDiagramChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new CreateDiagramChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateDiagramChangeOperation(CreateDiagramChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation#doExecute(IProgressMonitor)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		try {
			IFile topologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getModel());
			Resource modelResource = getResource(topologyFile);
			if (modelResource != null && modelResource.getContents().size() > 0) {
				Object root = modelResource.getContents().get(0);
				if (root instanceof DeployCoreRoot) {
					DeployCoreRoot deployRoot = (DeployCoreRoot) root;
					Topology topology = deployRoot.getTopology();
					Diagram diagram = ViewService.getInstance().createDiagram(
							new EObjectAdapter(topology),
							"DeployCore", new PreferencesHint("com.ibm.ccl.soa.deploy.core.ui")); //$NON-NLS-1$ //$NON-NLS-2$
					Resource resource = getScribbler().getResource(typesafeModel.getDiagram(),
							IEditModelScribbler.OPTION_LOAD_RESOURCE);
					resource.getContents().add(diagram);
				}
			}
		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		}

		return Status.OK_STATUS;
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(CreateDiagramChange mdl) {
		typesafeModel = mdl;
	}
}
