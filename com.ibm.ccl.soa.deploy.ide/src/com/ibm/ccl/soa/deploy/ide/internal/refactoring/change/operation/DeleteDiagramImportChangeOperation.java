package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteDiagramImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteDiagramImportChange;

public class DeleteDiagramImportChangeOperation extends DeployRefactoringChangeOperation implements
		IDeleteDiagramImportChangeProperties {

	private DeleteDiagramImportChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteDiagramImportChangeOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteDiagramImportChange(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeleteDiagramImportChangeOperation(DeleteDiagramImportChange tsMdl) {
		super(tsMdl);
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {

		try {
			IFile diagramFile = typesafeModel.getDiagram();

			if (diagramFile.isAccessible()) {
				Diagram diagram = getDiagram(typesafeModel.getDiagram());
				Topology topology = getTopology(typesafeModel.getImportedTopology());

				removeImportedElements(topology, diagram);
			}

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		} finally {
			if (typesafeModel != null) {
				typesafeModel.dispose();
			}
		}

		return Status.OK_STATUS;
	}

	protected void removeImportedElements(Topology topology, View aView) {
		removeImportedElement(topology, aView);
		for (Iterator<View> iter = aView.getChildren().iterator(); iter.hasNext();) {
			View view = iter.next();
			removeImportedElement(topology, view);
		}
	}

	protected void removeImportedElement(Topology topology, View aView) {
		EObject oElement = aView.getElement();
		if (null != oElement && CorePackage.eINSTANCE.getImport().isSuperTypeOf(oElement.eClass())) {
			Import importDmo = (Import) oElement;
			if (topology.getNamespace().equals(importDmo.getNamespace())
					&& topology.getName().equals(importDmo.getPattern())) {
				ViewUtil.destroy(aView);
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
	private void setTypeSafeModel(DeleteDiagramImportChange mdl) {
		typesafeModel = mdl;
	}

}
