package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.cache.StructuredReferenceKey;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.AbstractCachingStructuredReferenceProvider;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;
import com.ibm.xtools.mmi.core.util.MMICoreConstants;
import com.ibm.xtools.mmi.core.util.MMICoreUtil;
import com.ibm.xtools.uml.type.UMLElementFactory;
import com.ibm.xtools.uml.type.UMLElementTypes;

public class OperationStructuredReferenceHandler extends AbstractCachingStructuredReferenceProvider
		implements IDeployMMInterface {

	private static OperationStructuredReferenceHandler operationStructuredReferenceHandler = null;
	private ChangeScope<Topology, DeploymentTopologyDomain> changeScope;
	private Operation operation;

	@Override
	protected StructuredReference constructStructuredReference(Object referencedContext,
			Object domainElement) {
		if (referencedContext instanceof NamedElement) {
			NamedElement element = (NamedElement) referencedContext;
			StructuredReference vr = getModifier().createStructuredReference(
					UREF_OPERATION_HANDLER_ID, null, null);
			assert domainElement != null;
			String operationName = (String) domainElement;
			getModifier().setProperty(vr, CONTAINER_NAME, element.getName());
			getModifier().setProperty(vr, TYPE_NAME, operationName);
			return vr;
		}
		return null;

	}

	public Object resolveToDomainElement(Object referencedContext, StructuredReference ref) {
		if (referencedContext instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain domain = (TransactionalEditingDomain) referencedContext;
			StructuredReferenceKey key = new StructuredReferenceKey(ref, UMLPackage.eINSTANCE
					.getOperation());
			Object obj = MMIResourceCache.getCachedElement(domain, key);
			if (obj != null) {
				return obj;
			}
			return createAbstractOperaton(domain, ref);
		}
		return null;
	}

	private Operation createAbstractOperaton(final TransactionalEditingDomain domain,
			final StructuredReference ref) {

		operation = null;
		AbstractEMFOperation emfOP = new AbstractEMFOperation(domain,
				UMLDomainMessages.OperationStructuredReferenceHandler_create_Uml_Operatio_) {
			@Override
			protected IStatus doExecute(IProgressMonitor arg0, IAdaptable arg1)
					throws ExecutionException {
				String containerName = ref.getProperty(CONTAINER_NAME);
				String opName = ref.getProperty(TYPE_NAME);
				Model modelObject = getModelObject(domain);
				PackageableElement element = modelObject.getPackagedElement(containerName);
				operation = (Operation) UMLElementFactory.createElement(element,
						UMLElementTypes.OPERATION, new NullProgressMonitor());
				operation.setName(opName);
				((ITarget) operation).activate(DeployModelMappingProvider.getInstance(), ref);
				MMIResourceCache.cache(domain, operation);
				return Status.OK_STATUS;
			}
		};

		try {
			emfOP.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
		}
		return operation;

	}

	private Model getModelObject(TransactionalEditingDomain domain) {
		Resource vizResource = domain.getResourceSet().getResource(MMICoreConstants.MMI_RESOURCE_URI,
				false);
		if (vizResource == null) {
			vizResource = domain.getResourceSet().createResource(MMICoreConstants.MMI_RESOURCE_URI);
		}
		EObject root = null;
		if (vizResource.getContents().size() == 0) {
			root = MMICoreUtil.create(UMLPackage.eINSTANCE.getModel());
			vizResource.getContents().add(root);
		} else {
			root = vizResource.getContents().get(0);
		}
		return (Model) root;
	}

	public static OperationStructuredReferenceHandler getInstance() {
		if (operationStructuredReferenceHandler == null) {
			operationStructuredReferenceHandler = (OperationStructuredReferenceHandler) StructuredReferenceService
					.getInstance().getHandler(UREF_OPERATION_HANDLER_ID);
		}
		return operationStructuredReferenceHandler;

	}

	public Object getInfo(Object referencedContext, StructuredReference ref, String infoName) {
		return null;
	}

}
