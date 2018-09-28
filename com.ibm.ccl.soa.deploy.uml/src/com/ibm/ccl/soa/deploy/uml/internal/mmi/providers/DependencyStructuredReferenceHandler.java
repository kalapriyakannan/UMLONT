package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.AbstractCachingStructuredReferenceProvider;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;
import com.ibm.xtools.mmi.core.util.MMICoreConstants;
import com.ibm.xtools.mmi.core.util.MMICoreUtil;
import com.ibm.xtools.uml.type.UMLElementFactory;
import com.ibm.xtools.uml.type.UMLElementTypes;

public class DependencyStructuredReferenceHandler extends
		AbstractCachingStructuredReferenceProvider implements IDeployMMInterface {

	private static DependencyStructuredReferenceHandler dependencyStructuredReferenceHandler = null;
	private ChangeScope<Topology, DeploymentTopologyDomain> changeScope;

	@Override
	protected StructuredReference constructStructuredReference(Object referencedContext,
			Object domainElement) {
		if (referencedContext instanceof Model) {
			// Should we provide a table indicating client and supplier in 2nd parameter?
			StructuredReference vr = getModifier().createStructuredReference(
					UREF_DEPENDENCY_HANDLER_ID, null, null);
			assert domainElement != null;
			String dependencyName = (String) domainElement;
			getModifier().setProperty(vr, TYPE_NAME, dependencyName);
			return vr;
		}
		return null;

	}

	public Object resolveToDomainElement(Object referencedContext, StructuredReference ref) {
		if (referencedContext instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain domain = (TransactionalEditingDomain) referencedContext;
			String depName = ref.getProperty(TYPE_NAME);
			Model modelObject = getModelObject(domain);
			Dependency dependency = (Dependency) UMLElementFactory.createElement(modelObject,
					UMLElementTypes.DEPENDENCY, new NullProgressMonitor());
			dependency.setName(depName);
			((ITarget) dependency).activate(DeployModelMappingProvider.getInstance(), ref);
			MMIResourceCache.cache(domain, dependency);
			return dependency;
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

			// mmk --
			// Need to associate SR w/ VizModelImpl in order for Strategy to work,
			// since participantID of delta (req'd to prevent error in strategy for Viz element commands) is set only if StructuredReference is set on Model
			// And this structure ref doesn't get set on init for Models, as it does for Viz elements w/ 1-1 mapping to source elements
			StructuredReference vr = ModelStructuredReferenceHandler.getInstance()
					.getStructuredReference(root, root);
			((ITarget) root).activate(DeployModelMappingProvider.getInstance(), vr);
			//

			vizResource.getContents().add(root);
		} else {
			root = vizResource.getContents().get(0);
		}
		return (Model) root;
	}

	public static DependencyStructuredReferenceHandler getInstance() {
		if (dependencyStructuredReferenceHandler == null) {
			dependencyStructuredReferenceHandler = (DependencyStructuredReferenceHandler) StructuredReferenceService
					.getInstance().getHandler(UREF_DEPENDENCY_HANDLER_ID);
		}
		return dependencyStructuredReferenceHandler;

	}

	public Object getInfo(Object referencedContext, StructuredReference ref, String infoName) {
		return null;
	}

	/**
	 * Sets or changes the name of the target's StructuredReference's name
	 * 
	 * @param target
	 * @param name
	 */
	public void setName(ITarget target, String name) {
		String featureName = "name"; //$NON-NLS-1$
		getModifier().setProperty(target.getStructuredReference(), featureName, name);
	}

}
