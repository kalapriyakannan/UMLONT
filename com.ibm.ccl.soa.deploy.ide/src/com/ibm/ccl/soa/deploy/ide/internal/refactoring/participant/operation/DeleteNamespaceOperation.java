package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IDeleteNamespaceModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.DeleteNamespaceDescriptor;

public class DeleteNamespaceOperation extends AbstractDataModelOperation implements
		IDeleteNamespaceModelProperties {

	private DeleteNamespaceDescriptor typesafeModel;

	public DeleteNamespaceOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new DeleteNamespaceDescriptor(dMdl));
	}

	public DeleteNamespaceOperation(DeleteNamespaceDescriptor tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	private void setTypeSafeModel(DeleteNamespaceDescriptor mdl) {
		typesafeModel = mdl;
	}

}
