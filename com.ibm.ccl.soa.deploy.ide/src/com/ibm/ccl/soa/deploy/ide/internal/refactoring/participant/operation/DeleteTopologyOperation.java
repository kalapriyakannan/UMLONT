package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IDeleteTopologyModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.DeleteTopologyDescriptor;

public class DeleteTopologyOperation extends AbstractDataModelOperation implements
		IDeleteTopologyModelProperties {

	private DeleteTopologyDescriptor typesafeModel;

	public DeleteTopologyOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteTopologyDescriptor(dMdl));
	}

	public DeleteTopologyOperation(DeleteTopologyDescriptor tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	private void setTypeSafeModel(DeleteTopologyDescriptor mdl) {
		typesafeModel = mdl;
	}

}
