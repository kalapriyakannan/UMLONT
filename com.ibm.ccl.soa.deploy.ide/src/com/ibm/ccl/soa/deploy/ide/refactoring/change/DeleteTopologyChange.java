package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.DeleteTopologyChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IDeleteTopologyChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.DeleteTopologyChangeOperation;

public class DeleteTopologyChange extends DeployRefactoringChange {

	public static DeleteTopologyChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new DeleteTopologyChange(model);
	}

	public static IDataModelProvider createDatamodelProvider() {
		return new DeleteTopologyChangeProvider();
	}

	public DeleteTopologyChange(IDataModel mdl) {
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
				ResourcesPlugin.getWorkspace().getRoot().getFile(getTopology()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getTopology());
	}

	@Override
	public String getName() {
		return "delete topology at " + URI.createPlatformResourceURI(getTopology().toString()); //$NON-NLS-1$
	}

	public void setTopology(org.eclipse.core.runtime.IPath topology) {
		getUnderlyingDataModel().setProperty(IDeleteTopologyChangeProperties.TOPOLOGY, topology);
	}

	public org.eclipse.core.runtime.IPath getTopology() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getProperty(
				IDeleteTopologyChangeProperties.TOPOLOGY);
	}

	public IStatus validateTopology() {
		return getUnderlyingDataModel().validateProperty(IDeleteTopologyChangeProperties.TOPOLOGY);
	}

	public org.eclipse.core.runtime.IPath getDefaultTopology() {
		return (org.eclipse.core.runtime.IPath) getUnderlyingDataModel().getDefaultProperty(
				IDeleteTopologyChangeProperties.TOPOLOGY);
	}

	public IDataModelOperation createConfiguredOperation() {
		return new DeleteTopologyChangeOperation(this);
	}

}
