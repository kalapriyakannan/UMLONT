package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.AbstractCachingStructuredReferenceProvider;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;
import com.ibm.xtools.mmi.core.util.MMICoreConstants;
import com.ibm.xtools.mmi.core.util.MMICoreUtil;

public class ModelStructuredReferenceHandler extends AbstractCachingStructuredReferenceProvider
		implements IDeployMMInterface {

	private static ModelStructuredReferenceHandler structuredReferenceHandler = null;
	private ChangeScope<Topology, DeploymentTopologyDomain> changeScope;

	@Override
	protected StructuredReference constructStructuredReference(Object referencedContext,
			Object domainElement) {
		if (referencedContext instanceof Model) {
			// Should we provide a table indicating client and supplier in 2nd parameter?
			StructuredReference vr = getModifier().createStructuredReference(UREF_MODEL_HANDLER_ID,
					null, null);
			assert domainElement != null;
			return vr;
		}
		return null;

	}

	public Object resolveToDomainElement(Object referencedContext, StructuredReference ref) {
		if (referencedContext instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain domain = (TransactionalEditingDomain) referencedContext;
			return getModelObject(domain);
		}
		return null;
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

	public static ModelStructuredReferenceHandler getInstance() {
		if (structuredReferenceHandler == null) {
			structuredReferenceHandler = (ModelStructuredReferenceHandler) StructuredReferenceService
					.getInstance().getHandler(UREF_MODEL_HANDLER_ID);
		}
		return structuredReferenceHandler;

	}

	public Object getInfo(Object referencedContext, StructuredReference ref, String infoName) {
		return null;
	}

//	/**
//	 * Sets or changes the name of the target's StructuredReference's name
//	 * 
//	 * @param target
//	 * @param name
//	 */
//	public void setName(ITarget target, String name) {
//		String featureName = "name"; //$NON-NLS-1$
//		getModifier().setProperty(target.getStructuredReference(), featureName, name);
//	}

}
