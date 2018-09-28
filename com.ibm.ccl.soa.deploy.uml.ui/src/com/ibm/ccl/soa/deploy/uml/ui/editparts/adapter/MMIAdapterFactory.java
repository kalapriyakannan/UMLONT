package com.ibm.ccl.soa.deploy.uml.ui.editparts.adapter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.adapter.EditPartAdapterFactory;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;

public class MMIAdapterFactory implements IAdapterFactory {

	private final EditPartAdapterFactory adapter = new EditPartAdapterFactory();

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof EditPart) {

			EditPart part = (EditPart) adaptableObject;
			Object adapted = adapter.getAdapter(part, adapterType);

			if (null != adapted) {
				return adapted;
			}

			StructuredReference reference = (StructuredReference) adapter.getAdapter(part,
					StructuredReference.class);
			if (null != reference) {
				DeployModelObject dmo = resolveDeployStructuredReference(reference);
				if (null != dmo) {
					if (adapterType == DeployModelObject.class) {
						return dmo;
					} else if (adapterType == Unit.class) {
						if (CorePackage.Literals.UNIT.isSuperTypeOf(dmo.getEObject().eClass())) {
							return dmo;
						}
					}
				}
			}
		}

		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { View.class, Unit.class, DeployModelObject.class, ITarget.class,
				StructuredReference.class };
	}

	private DeployModelObject resolveDeployStructuredReference(StructuredReference reference) {
		if (null != reference) {
			if (reference.getProviderId().equals(IDeployMMInterface.UREF_HANDLER_ID)) {
				String projectName = reference.getProperty(IDeployMMInterface.CONTAINER_NAME);
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				if (null != project && project.isAccessible()) {
					Object resolved = StructuredReferenceService.resolveToDomainElement(
							getEditingDomain(project), reference);
					if (null != resolved
							&& resolved instanceof EObject
							&& CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(((EObject) resolved)
									.eClass())) {
						return (DeployModelObject) resolved;
					}
				}
			}
		}

		return null;
	}

	private static final TransactionalEditingDomain getEditingDomain(IResource resource) {
		IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE.getContext(resource
				.getProject());
		TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(context.getResourceSet());

		if (txdomain == null) {
			txdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(context
					.getResourceSet());
		}

		return txdomain;
	}

}
