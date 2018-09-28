package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.listener;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drop.AbstractDropTargetListener;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drop.IDropTargetEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class DeployUMLDragDropListener extends AbstractDropTargetListener implements
		IDeployMMInterface {
	private Resource umlResource;
	private ISelection currentSelection = null;

	private static DeployUMLDragDropListener Instance = new DeployUMLDragDropListener();

	private DeployUMLDragDropListener() {
	}

	@Override
	public boolean canSupport() {
		if (umlResource == null) {
			return false;
		}
		IDropTargetEvent event = getCurrentEvent();
		ISelection selection = getCurrentAgent().getSelection(event.getCurrentDataType());
		if (currentSelection == selection) {
			return false;
		}
		currentSelection = selection;
		stampTopology(selection);
		return false;
	}

	private void stampTopology(ISelection selection) {
		IStructuredSelection selections = (IStructuredSelection) selection;
		for (Iterator iterator = selections.iterator(); iterator.hasNext();) {
			Object dmo = iterator.next();
			if (dmo instanceof DeployModelObject) {
				DeployModelObject deployModelObject = (DeployModelObject) dmo;
				Topology topology = deployModelObject.getEditTopology();
				if (shouldConstrainTopology(topology)) {					ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(topology);
					try {
						changeScope.execute(getModifyOPeration(changeScope),
								ChangeScope.OPTION_DO_NOT_SAVE, null);

					} finally {
						if (changeScope != null) {
							changeScope.close(null);
						}

					}

				}

			}
		}

	}

	public AbstractEMFOperation getModifyOPeration(ChangeScope changeScope) {
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(),
				UmlUIMessages.DeployUMLDragDropListener_add_UmlInteraction_constraint_to_to_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
						.findChangeScope(info);
				Topology topologyWrite = scope.openTopology();
				if (topologyWrite == null) {
					return Status.CANCEL_STATUS;
				}
				UMLInteractionConstraint umlConstr = UmlFactory.eINSTANCE
						.createUMLInteractionConstraint();
				umlConstr.setName(umlResource.getURI().toString());
				umlConstr.setName(getUniqueName(topologyWrite, "iC0")); //$NON-NLS-1$
				umlConstr.setResourceURI(umlResource.getURI().toString());
				topologyWrite.getConstraints().add(umlConstr);
				scope.close(monitor);
				return Status.OK_STATUS;

			}
		};

		return op;

	}

	private boolean shouldConstrainTopology(Topology topology) {
		String constraintUri = umlResource.getURI().toString();
		List<DeployModelObject> constraints = topology.getConstraints();
		for (Iterator iterator = constraints.iterator(); iterator.hasNext();) {
			DeployModelObject dObject = (DeployModelObject) iterator.next();
			if (dObject instanceof UMLInteractionConstraint) {
				UMLInteractionConstraint constraint = (UMLInteractionConstraint) dObject;
				if (constraint.getResourceURI().equals(constraintUri)) {
					return false;
				}
			}
		}
		return true;

	}

	public void setUmlResource(Resource umlResource) {
		this.umlResource = umlResource;
	}

	public static DeployUMLDragDropListener getInstance() {
		return Instance;
	}

	private String getUniqueName(DeployModelObject container, String name) {
		String newName = name;
		int uniqifier = 0;
		while (null != container.resolve(newName)) {
			newName += uniqifier++;
		}

		return newName;
	}

}
