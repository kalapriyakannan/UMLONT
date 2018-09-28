package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.DeleteImportChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeleteImportChangeOperation;

public class DeleteImportChange extends DeployRefactoringChange {

	public static DeleteImportChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteImportChange(model);
	}

	public static IDataModelProvider createDatamodelProvider() {
		return new DeleteImportChangeProvider();
	}

	public DeleteImportChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange#getAffectedObjects()
	 */
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getModifiedElement() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return getTopology();
	}

	@Override
	public String getName() {
		return "delete import of topology model '" + getImportedTopology().getFullPath() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void setImportedTopology(IFile importedTopology) {
		getUnderlyingDataModel().setProperty(IDeleteImportChangeProperties.IMPORTED_TOPOLOGY,
				importedTopology);
	}

	public IFile getImportedTopology() {
		return (IFile) getUnderlyingDataModel().getProperty(
				IDeleteImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public IStatus validateImportedTopology() {
		return getUnderlyingDataModel().validateProperty(
				IDeleteImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public IFile getDefaultImportedTopology() {
		return (IFile) getUnderlyingDataModel().getDefaultProperty(
				IDeleteImportChangeProperties.IMPORTED_TOPOLOGY);
	}

	public void setTopology(IFile importedTopology) {
		getUnderlyingDataModel()
				.setProperty(IDeleteImportChangeProperties.TOPOLOGY, importedTopology);
	}

	public IFile getTopology() {
		return (IFile) getUnderlyingDataModel().getProperty(IDeleteImportChangeProperties.TOPOLOGY);
	}

	public IStatus validateTopology() {
		return getUnderlyingDataModel().validateProperty(IDeleteImportChangeProperties.TOPOLOGY);
	}

	public IFile getDefaultTopology() {
		return (IFile) getUnderlyingDataModel().getDefaultProperty(
				IDeleteImportChangeProperties.TOPOLOGY);
	}

	public IDataModelOperation createConfiguredOperation() {
		return new DeleteImportChangeOperation(this);
	}

}
