/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateDiagramElementsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramElementsChange;

/**
 * 
 * Provides a type-specific implementation of the UpdateDiagramElementsChange model.
 * 
 * <p>
 * Clients should use {@link UpdateDiagramElementsChange#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramElementsChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateDiagramElementsChangeOperation extends DeployRefactoringChangeOperation
		implements IUpdateDiagramElementsChangeProperties {

	private UpdateDiagramElementsChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateDiagramElementsChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new UpdateDiagramElementsChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateDiagramElementsChangeOperation(UpdateDiagramElementsChange tsMdl) {
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
					typesafeModel.getDestination());
			IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getDiagram());

			Topology topology = getTopology(topologyFile);
			Diagram diagram = getDiagram(diagramFile);
			updateElements(topology, diagram);
			for (Iterator<Edge> iter = diagram.getEdges().iterator(); iter.hasNext();) {
				updateElements(topology, iter.next());
			}

			if (diagram.eResource() != null) {
				diagram.eResource().setModified(true);
			}

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		}

		return Status.OK_STATUS;
	}

	protected void updateElements(Topology topology, View aView) {
		updateElement(topology, aView);
		for (Iterator<View> iter = aView.getChildren().iterator(); iter.hasNext();) {
			View view = iter.next();
			updateElements(topology, view);
		}
	}

	protected void updateElement(Topology topology, View aView) {
		EObject oElement = aView.getElement();
		if (null != oElement
				&& CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(oElement.eClass())) {
			DeployModelObject oldElement = (DeployModelObject) oElement;
			DeployModelObject newElement = topology.resolve(oldElement.getFullPath());
			aView.setElement(newElement);
		}
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(UpdateDiagramElementsChange mdl) {
		typesafeModel = mdl;
	}
}
