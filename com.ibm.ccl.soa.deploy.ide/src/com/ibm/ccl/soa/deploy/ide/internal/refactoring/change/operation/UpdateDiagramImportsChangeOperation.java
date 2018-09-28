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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateDiagramImportsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange;

/**
 * 
 * Provides a type-specific implementation of the UpdateDiagramImportsChange model.
 * 
 * <p>
 * Clients should use {@link UpdateDiagramImportsChange#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeployRefactoringChangeOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange
 * @generated (mde.utilities.datamodels)
 */
public class UpdateDiagramImportsChangeOperation extends DeployRefactoringChangeOperation implements
		IUpdateDiagramImportsChangeProperties {

	private UpdateDiagramImportsChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateDiagramImportsChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new UpdateDiagramImportsChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public UpdateDiagramImportsChangeOperation(UpdateDiagramImportsChange tsMdl) {
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
			IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					typesafeModel.getDiagram());

			Topology topology = getTopology(topologyFile);
			Diagram diagram = getDiagram(diagramFile);
			updateImports(topology, diagram);
			for (Iterator<Edge> iter = diagram.getEdges().iterator(); iter.hasNext();) {
				Edge edge = iter.next();
				updateImports(topology, edge);
			}

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		}

		return Status.OK_STATUS;
	}

	@SuppressWarnings("unchecked")
	protected void updateImports(Topology topology, View aView) {
		updateImport(topology, aView);
		for (Iterator<View> iter = aView.getChildren().iterator(); iter.hasNext();) {
			View view = iter.next();
			updateImports(topology, view);
		}
	}

	protected void updateImport(Topology topology, View aView) {
		EObject oElement = aView.getElement();
		if (null != oElement
				&& CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(oElement.eClass())) {
			DeployModelObject oldElement = (DeployModelObject) oElement;
			String uri = EcoreUtil.getURI(oldElement).toString();
			if (uri.indexOf(typesafeModel.getSource() + IConstants.TOPOLOGY_SEPARATOR
					+ IConstants.PATH_SEPARATOR) > 0) {
				String path = uri.substring(uri.indexOf(typesafeModel.getSource())
						+ typesafeModel.getSource().length());
				String qualifiedName = typesafeModel.getDestination() + path;
//				if (CorePackage.Literals.IMPORT.isSuperTypeOf(oldElement.getEObject().eClass())) {
//					if (qualifiedName.indexOf(IConstants.DOT_SEPARATOR) > -1) {
//						qualifiedName = qualifiedName.substring(qualifiedName
//								.lastIndexOf(IConstants.DOT_SEPARATOR) + 1);
//					}
//				}
				DeployModelObject newElement = topology.resolve(qualifiedName);
				aView.setElement(newElement);
			} else if (null != oElement
					&& CorePackage.Literals.IMPORT.isSuperTypeOf(oldElement.getEObject().eClass())) {

				String oldNamespace = typesafeModel.getSource().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
						.getSource().substring(0,
								typesafeModel.getSource().lastIndexOf(IConstants.DOT_SEPARATOR))
						: new String();
				String oldName = typesafeModel.getSource().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
						.getSource().substring(oldNamespace.length() + 1)
						: typesafeModel.getSource();

				if (uri.endsWith(IConstants.PATH_SEPARATOR + oldName)) {

					String newNamespace = typesafeModel.getDestination().indexOf(
							IConstants.DOT_SEPARATOR) > 0 ? typesafeModel.getDestination().substring(0,
							typesafeModel.getDestination().lastIndexOf(IConstants.DOT_SEPARATOR))
							: new String();
					String newName = typesafeModel.getDestination().indexOf(IConstants.DOT_SEPARATOR) > 0 ? typesafeModel
							.getDestination().substring(newNamespace.length() + 1)
							: typesafeModel.getDestination();

					DeployModelObject newElement = topology.resolve(newName);
					if (CorePackage.Literals.IMPORT.isSuperTypeOf(newElement.getEObject().eClass())) {
						Import newImport = (Import) newElement;
						if (newImport.getName().equals(newName)
								&& newImport.getNamespace().equals(newNamespace)) {
							aView.setElement(newImport);
						}
					}
				}
			}
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
	private void setTypeSafeModel(UpdateDiagramImportsChange mdl) {
		typesafeModel = mdl;
	}
}
