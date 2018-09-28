package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.DeleteDiagramChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeleteDiagramChangeOperation;

public class DeleteDiagramChange extends DeployRefactoringChange {

	public static DeleteDiagramChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteDiagramChange(model);
	}

	public static IDataModelProvider createDatamodelProvider() {
		return new DeleteDiagramChangeProvider();
	}

	public DeleteDiagramChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange#getAffectedObjects()
	 */
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getModifiedElement(),
				ResourcesPlugin.getWorkspace().getRoot().getFile(getDiagram()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getDiagram());
	}

	@Override
	public String getName() {
		return "delete diagram " + URI.createPlatformResourceURI(getDiagram().toString()); //$NON-NLS-1$
	}

	public void setDiagram(org.eclipse.core.runtime.IPath diagram) {
		getUnderlyingDataModel().setProperty(IDeleteDiagramChangeProperties.DIAGRAM, diagram);
	}

	public org.eclipse.core.runtime.IPath getDiagram() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IDeleteDiagramChangeProperties.DIAGRAM);
	}

	public IStatus validateDiagram() {
		return getUnderlyingDataModel().validateProperty(IDeleteDiagramChangeProperties.DIAGRAM);
	}

	public org.eclipse.core.runtime.IPath getDefaultDIAGRAM() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IDeleteDiagramChangeProperties.DIAGRAM);
	}

	public IDataModelOperation createConfiguredOperation() {
		return new DeleteDiagramChangeOperation(this);
	}

}
