package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.DeleteDiagramImportChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteDiagramImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeleteDiagramImportChangeOperation;

public class DeleteDiagramImportChange extends DeployRefactoringChange {

	public static DeleteDiagramImportChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteDiagramImportChange(model);
	}

	public static IDataModelProvider createDatamodelProvider() {
		return new DeleteDiagramImportChangeProvider();
	}

	public DeleteDiagramImportChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange#getAffectedObjects()
	 */
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getDiagram() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return getDiagram();
	}

	@Override
	public String getName() {
		return "delete views of imported topology '" + getImportedTopology().getFullPath() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void setImportedTopology(IFile topology) {
		getUnderlyingDataModel().setProperty(IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY,
				topology);
	}

	public IFile getImportedTopology() {
		return (IFile) getUnderlyingDataModel().getProperty(
				IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public IStatus validateImportedTopology() {
		return getUnderlyingDataModel().validateProperty(
				IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public IFile getDefaultImportedTopology() {
		return (IFile) getUnderlyingDataModel().getDefaultProperty(
				IDeleteDiagramImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public void setDiagram(IFile diagram) {
		getUnderlyingDataModel().setProperty(IDeleteDiagramImportChangeProperties.DIAGRAM, diagram);
	}

	public IFile getDiagram() {
		return (IFile) getUnderlyingDataModel().getProperty(
				IDeleteDiagramImportChangeProperties.DIAGRAM);
	}

	public IStatus validateDiagram() {
		return getUnderlyingDataModel()
				.validateProperty(IDeleteDiagramImportChangeProperties.DIAGRAM);
	}

	public IFile getDefaultDiagram() {
		return (IFile) getUnderlyingDataModel().getDefaultProperty(
				IDeleteDiagramImportChangeProperties.DIAGRAM);
	}

	public IDataModelOperation createConfiguredOperation() {
		return new DeleteDiagramImportChangeOperation(this);
	}

}
