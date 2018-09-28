package com.ibm.ccl.soa.deploy.uml.internal.mmi.sync;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.cache.MMIResourceCache;
import com.ibm.xtools.mmi.core.cache.StructuredReferenceKey;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.refactor.AutoTriggeredSynchronizationManager;

public class UnitSynchronizer implements Runnable {
	private final List<StructuredReference> structuredReferences;
	private final TransactionalEditingDomain domain;
	private final EClass unitEClass = CorePackage.eINSTANCE.getConceptualNode();

	public UnitSynchronizer(TransactionalEditingDomain transactionDomain,
			List<StructuredReference> references) {
		structuredReferences = references;
		domain = transactionDomain;
		AutoTriggeredSynchronizationManager.getInstance(domain).queueSynchronizationRequest(this);
	}

	public void run() {
		for (Iterator iterator = structuredReferences.iterator(); iterator.hasNext();) {
			StructuredReference structuredReference = (StructuredReference) iterator.next();
			EObject umlElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
					structuredReference, uml2().getComponent()));
			if (umlElement == null) {
				umlElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
						structuredReference, uml2().getActor()));
			}
			if (umlElement == null) {
				umlElement = MMIResourceCache.getCachedElement(domain, new StructuredReferenceKey(
						structuredReference, uml2().getNode()));
			}
			if (umlElement instanceof ITarget) {
				ITarget umlVizElement = (ITarget) umlElement;
				umlVizElement.setDirty(uml2().getNamedElement_Name(), createHint(structuredReference));

			}
		}
	}

	private Object createHint(StructuredReference structuredReference) {
		SyncHelper syncHelper = new SyncHelper(structuredReference);
		return syncHelper;
	}

	static UMLPackage uml2() {
		return UMLPackage.eINSTANCE;
	}
}
