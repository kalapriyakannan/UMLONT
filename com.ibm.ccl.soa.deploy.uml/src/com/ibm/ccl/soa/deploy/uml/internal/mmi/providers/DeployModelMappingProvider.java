package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.DeployMMIManager;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.sync.SyncHelper;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.ITargetSynchronizer;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.cache.StructuredReferenceKey;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.map.AbstractModelMappingProvider;
import com.ibm.xtools.mmi.core.util.MMICoreConstants;
import com.ibm.xtools.mmi.core.util.MMICoreUtil;

public class DeployModelMappingProvider extends AbstractModelMappingProvider implements
		ITargetSynchronizer {

	private static DeployModelMappingProvider instance;
	private EObject aElement;

	public DeployModelMappingProvider() {
		instance = this;
	}

	public EObject adapt(TransactionalEditingDomain domain, Object source, EClass targetKind) {
		StructuredReference reference = createStructureReference(domain, source);
		assert reference != null;
		EObject unitElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
				reference, targetKind));
		checkScope();
		if (unitElement != null) {
			return unitElement;
		}
		return null;
	}

	private void checkScope() {
		UnitStructuredReferenceHandler unitHandler = UnitStructuredReferenceHandler.getInstance();
		if (unitHandler.isChangeScopeOpen()) {
			unitHandler.closeChangeScope(new NullProgressMonitor());
		}

	}

	private StructuredReference createStructureReference(TransactionalEditingDomain domain,
			Object source) {
		StructuredReference reference = null;
		if (source instanceof Unit) {
			Unit unit = (Unit) source;
			EClass langKind = unit.eClass();
			assert langKind != null;
			reference = UnitStructuredReferenceHandler.getInstance().getStructuredReference(domain,
					source);
			EObject classElement = MMIResourceCache.getCachedElement(domain,
					new StructuredReferenceKey(reference, langKind));
			if (classElement == null) {
				ITarget target = createVizObject(unit, domain);
				assert target != null;
				modifyVizElement(unit, target, domain);
				target.activate(this, reference);
				target.setClean(UMLPackage.eINSTANCE.getNamedElement_Name());
				DeployMMIManager.getInstance().cache(domain, reference, unit, target);
			}
		}
		return reference;
	}

	private void modifyVizElement(final Unit unit, final ITarget target,
			TransactionalEditingDomain domain) {
		AbstractEMFOperation emfOperation = new AbstractEMFOperation(domain, IConstants.EMPTY_STRING) {
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				EMFCoreUtil.setName(target, unit.getDisplayName());
				return Status.OK_STATUS;
			}

			@Override
			public boolean canUndo() {
				return false;
			}
		};

		try {
			emfOperation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			String message = e.getMessage();
			if (message == null) {
				message = e.getClass().getName();
			}
			DeployCorePlugin.log(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, e));
		}

	}

	private ITarget createVizObject(Unit unit, TransactionalEditingDomain domain) {
		EObject root = getModelObject(domain);
		return createVizElement((Model) root, unit, domain);

	}

	private EObject getModelObject(TransactionalEditingDomain domain) {
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
		return root;
	}

	private ITarget createVizElement(final Model modelObject, final Unit unit,
			TransactionalEditingDomain domain) {
		aElement = null;
		if (unit instanceof UMLActorUnit) {
			executeVizElementCreation(modelObject, unit, domain, false);
		} else {
			executeVizElementCreation(modelObject, unit, domain, true);
		}
		assert aElement instanceof ITarget;
		return (ITarget) aElement;
	}

	private EObject executeVizElementCreation(final Model modelObject, final Unit unit,
			TransactionalEditingDomain domain, final boolean shouldCreateComponent) {

		AbstractEMFOperation emfOperation = new AbstractEMFOperation(domain, IConstants.EMPTY_STRING) {
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				if (shouldCreateComponent) {
					//mmk 3/17/08
					if (unit instanceof NodeUnit) {
						aElement = modelObject.createPackagedElement(unit.getName(), UMLPackage.eINSTANCE
								.getNode());
					} else {
						aElement = modelObject.createPackagedElement(unit.getName(), UMLPackage.eINSTANCE
								.getComponent());
					}
				} else {
					aElement = modelObject.createPackagedElement(unit.getName(), UMLPackage.eINSTANCE
							.getActor());

				}
				return Status.OK_STATUS;
			}

			@Override
			public boolean canUndo() {
				return false;
			}
		};

		try {
			emfOperation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			String message = e.getMessage();
			if (message == null) {
				message = e.getClass().getName();
			}
			DeployCorePlugin.log(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, e));
		}
		return aElement;
	}

	public EObject resolve(TransactionalEditingDomain domain, StructuredReference vr, EClass class1) {
		EObject unitElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
				vr, class1));
		if (unitElement != null) {
			return unitElement;
		}
		if (class1 == UMLPackage.eINSTANCE.getOperation()) {
			return getOperationSource(domain, vr, class1);
		}
		if (class1 == UMLPackage.eINSTANCE.getDependency()) {
			return getDependencySource(domain, vr, class1);
		}
		Object source = UnitStructuredReferenceHandler.getInstance().resolveToDomainElement(domain,
				vr);
		assert source != null;
		return adapt(domain, source, class1);
	}

	private EObject getOperationSource(TransactionalEditingDomain domain, StructuredReference vr,
			EClass class1) {
		EObject unitElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
				vr, class1));
		if (unitElement != null) {
			return unitElement;
		}
		EObject source = (EObject) OperationStructuredReferenceHandler.getInstance()
				.resolveToDomainElement(domain, vr);
		return source;
	}

	private EObject getDependencySource(TransactionalEditingDomain domain, StructuredReference vr,
			EClass class1) {
		EObject unitElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
				vr, class1));
		if (unitElement != null) {
			return unitElement;
		}
		EObject source = (EObject) DependencyStructuredReferenceHandler.getInstance()
				.resolveToDomainElement(domain, vr);
		return source;
	}

	public boolean synchronizeFeature(EObject obj, EStructuralFeature sf, Object hint) {
		if (hint == null || !(hint instanceof SyncHelper)) {
			return false;
		}
		SyncHelper helper = (SyncHelper) hint;
		if (helper.getStructuredReference() == null) {
			return false;
		}
		StructuredReference reference = helper.getStructuredReference();
		Unit unit = (Unit) UnitStructuredReferenceHandler.getInstance().resolveToDomainElement(null,
				reference);
		if (unit == null) {
			return false;
		}
		if (sf == uml2().getNamedElement_Name()) {
			EMFCoreUtil.setName(obj, unit.getDisplayName());
		}
		checkScope();
		return true;
	}

	static UMLPackage uml2() {
		return UMLPackage.eINSTANCE;
	}

	public void verifyFeatureContents(EObject obj, EStructuralFeature sf, Object hint) {
	}

	public static DeployModelMappingProvider getInstance() {
		if (instance == null) {
			instance = new DeployModelMappingProvider();
		}
		return instance;
	}

}
