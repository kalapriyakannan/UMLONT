package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;

import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.xtools.mmi.core.delta.ModelChangeDelta;
import com.ibm.xtools.mmi.core.services.sync.AbstractSourceSynchronizationProvider;
import com.ibm.xtools.mmi.core.services.sync.ISourceSynchronizationProvider;

public class DeployModelSourceSynchronizationProvider extends AbstractSourceSynchronizationProvider
		implements ISourceSynchronizationProvider {

	public boolean provides(IOperation operation) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected ICommand doEmit(ModelChangeDelta delta) throws Exception {
		if (delta.getValue() instanceof Operation) {
			return new CreateOperation(
					UMLDomainMessages.DeployModelSourceSynchronizationProvider_create_VizOperatio_,
					delta);

		} else if (delta.getOwner() instanceof Model
				&& delta.getFeature().getName().equals("packagedElement") //$NON-NLS-1$
				&& delta.getValue() instanceof Dependency
				|| delta.getOwner() instanceof Dependency
				&& delta.getFeature().getName().equals("client") //$NON-NLS-1$
				|| delta.getOwner() instanceof Dependency
				&& delta.getFeature().getName().equals("supplier") //$NON-NLS-1$
				|| delta.getOwner() instanceof Dependency
				&& delta.getFeature().getName().equals("name") //$NON-NLS-1$
		) {
			return new WorkWithDependency(
					UMLDomainMessages.DeployModelSourceSynchronizationProvider_create_VizDependency_,
					delta);
		} else {
			return new CreateOperation(
					UMLDomainMessages.DeployModelSourceSynchronizationProvider_empty_operatio_, delta);
		}

	}

	@Override
	public boolean isEditable(ModelChangeDelta delta) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean matchesEmitCriteria(ModelChangeDelta delta) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean supports(ModelChangeDelta delta) {
		// TODO Auto-generated method stub
		return true;
	}

}
