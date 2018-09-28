package com.ibm.ccl.soa.deploy.uml.internal.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployTransactionReporter;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.DeployMMIManager;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.providers.DeployModelMappingProvider;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.providers.UnitStructuredReferenceHandler;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class UMLInteractionConstraintValidator extends ConstraintValidator {

	Map<NamedElement, Unit> umlZephyrMap = new HashMap<NamedElement, Unit>();
	DeployTransactionReporter reporter = new DeployTransactionReporter();
	Map<Unit, IStatus> statusMap = new HashMap<Unit, IStatus>();
	private Interaction interaction;
	private Topology topology;
	private final Adapter constraintListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (msg.getEventType() == Notification.SET) {
				List constraints = ValidatorUtils.getConstraints(topology,
						UmlPackage.Literals.UML_INTERACTION_CONSTRAINT);
				if (constraints.isEmpty()) {
					List units = topology.getUnits();
					for (Iterator iterator = units.iterator(); iterator.hasNext();) {
						Unit unit = (Unit) iterator.next();
						flushStatus(unit);
						removeAdapter();
					}

				}
			}

		}

		private void removeAdapter() {
			topology.removeTopologyListener(constraintListener, UmlPackage.eINSTANCE
					.getUMLDeployRoot_ConstraintUmlInteraction());
		}

		private void flushStatus(Unit unit) {
			reporter.updateStatus(unit, new ArrayList(), new ArrayList());
		}
	};

	public UMLInteractionConstraintValidator() {
		reporter.setGroupID(IConstants.COMMUNICATION_VALDIATOR_ID);
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		if (constraint instanceof UMLInteractionConstraint) {
			return true;
		}
		return false;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		umlZephyrMap.clear();
		statusMap.clear();

		if (!(context instanceof Topology)) {
			return Status.OK_STATUS;
		}
		topology = (Topology) context;
		assert topology != null;
		addTopologyListener();

		UMLInteractionConstraint umlConst = (UMLInteractionConstraint) constraint;
		String resourceUri = umlConst.getResourceURI();
		IProject proj = ProjectUtilities.getProject(constraint);
		String resolvedURI = ZephyrUmlUtil.getResolvedResourceURI(resourceUri, proj.getName());

		String interactionQName = umlConst.getInteractionQName();

		if (resolvedURI == null || resolvedURI.length() == 0) {
			return Status.OK_STATUS;
		}

		Resource umlResource = ZephyrUmlUtil.loadUMLResource(resolvedURI);
		if (umlResource == null) {
			DeployCorePlugin
					.log(
							IStatus.WARNING,
							0,
							NLS
									.bind(
											NLS
													.bind(
															UMLDomainMessages.UMLInteractionConstraintValidator_UML_resource_0_could_not_be_acces_,
															resolvedURI), Collections.EMPTY_MAP), null);
		}

		Resource topologyResource = topology.eResource();
		if (umlResource != null) {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlResource);
			if (domain == null) {
				domain = GMFEditingDomainFactory.getInstance().createEditingDomain();
			}
			List<StructuredReference> references = getStructuredReferences(topologyResource);
			if (references == null || references.isEmpty()) {
				resolveStructuredReferences(umlResource);
				references = getStructuredReferences(topologyResource);
			}

			if (references != null) {
				buildUmlZephyrMap(references, topology, domain);
			}

			if (interactionQName != null) {
				buildUmlZephyrMap(topology, umlResource, interactionQName);
			}
			validateCommunication();
			reportStatus();
		}

		return Status.OK_STATUS;
	}

	private void addTopologyListener() {
		//feature check in topology api
		if (!topology.eAdapters().contains(constraintListener)) {
			topology.addTopologyListener(constraintListener, UmlPackage.eINSTANCE
					.getUMLDeployRoot_ConstraintUmlInteraction());
		}

	}

	private void reportStatus() {
		if (statusMap.isEmpty()) {
			return;
		}
		Set units = statusMap.keySet();
		for (Iterator iterator = units.iterator(); iterator.hasNext();) {
			Unit unit = (Unit) iterator.next();
			IStatus status = statusMap.get(unit);
			if (status == null) {
				continue;
			}
			updateStatus(status, unit);

		}

	}

	private void buildUmlZephyrMap(Topology topology, Resource umlResource, String interactionQname) {

		// Load interaction
		Collection interactions = UMLUtil.findNamedElements(umlResource, interactionQname);
		if (interactions != null && interactions.size() > 0) {
			Object obj = interactions.iterator().next();
			if (obj instanceof Interaction) {
				interaction = (Interaction) obj;
			}
		}

		if (interaction == null) {
			// Did not find interaction, no need to continue
			return;
		}

		for (Iterator iter = topology.getUnits().iterator(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			// Does unit have backing UML artifact
			UMLElementArtifact artifact = ZephyrUmlUtil.getUMLElementArtifact(unit);
			if (artifact != null) {
				String qName = artifact.getQualifiedName();
				Collection elements = UMLUtil.findNamedElements(umlResource, qName);
				if (elements.size() > 0) {
					NamedElement namedElement = (NamedElement) elements.iterator().next();
					umlZephyrMap.put(namedElement, unit);
				}
			}
		}

	}

	private void buildUmlZephyrMap(List<StructuredReference> references, Topology topology,
			TransactionalEditingDomain domain) {

		for (Iterator iterator = references.iterator(); iterator.hasNext();) {
			StructuredReference reference = (StructuredReference) iterator.next();
			Object unitObj = UnitStructuredReferenceHandler.getInstance().resolveToDomainElement(
					topology, reference);
			UnitStructuredReferenceHandler.getInstance().closeChangeScope(null);
			if (unitObj != null && unitObj instanceof Unit) {
				Unit unit = getUnit(topology, unitObj);
				loadNamedElements(domain, reference, unit);
			} else {
				DeployCorePlugin.log(IStatus.WARNING, 0, NLS.bind(
						UMLDomainMessages.UMLInteractionConstraintValidator_Could_not_resolve_0_,
						reference.getProperties()), null);
			}
		}

	}

	private void loadNamedElements(TransactionalEditingDomain domain, StructuredReference reference,
			Unit unit) {
		Object obj = null;
		if (unit instanceof UMLActorUnit) {
			obj = DeployModelMappingProvider.getInstance().resolve(domain, reference,
					UMLPackage.eINSTANCE.getActor());
		} else if (unit instanceof NodeUnit) {
			obj = DeployModelMappingProvider.getInstance().resolve(domain, reference,
					UMLPackage.eINSTANCE.getNode());
		} else {
			obj = DeployModelMappingProvider.getInstance().resolve(domain, reference,
					UMLPackage.eINSTANCE.getComponent());
		}
		if (obj != null && obj instanceof ITarget) {
			EObject eObj = (EObject) obj;
			Collection namedElements = EMFCoreUtil.getReferencers(eObj,
					new EReference[] { UMLPackage.eINSTANCE.getTypedElement_Type() });
			if (namedElements.isEmpty()) {
				return;
			} else {
				for (Iterator iterator = namedElements.iterator(); iterator.hasNext();) {
					NamedElement element = (NamedElement) iterator.next();
					umlZephyrMap.put(element, unit);
				}
			}
		}
	}

	private void validateCommunication() {
		Set<NamedElement> set = umlZephyrMap.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			NamedElement sourceElement = (NamedElement) iterator.next();
			Lifeline sourceLifeLine = getSourceLifeLine(sourceElement);
			if (interaction != null) {
				searchMessages(sourceElement, sourceLifeLine, interaction);
			} else {
				Collaboration collab = (Collaboration) sourceElement.getOwner();
				List<Behavior> behaviors = collab.getOwnedBehaviors();
				for (Iterator iteratorBehave = behaviors.iterator(); iteratorBehave.hasNext();) {
					Behavior behave = (Behavior) iteratorBehave.next();
					if (behave instanceof Interaction) {
						searchMessages(sourceElement, sourceLifeLine, behave);
					}
				}

			}
		}
	}

	private void searchMessages(NamedElement sourceElement, Lifeline sourceLifeLine, Behavior behave) {

		Interaction interaction = (Interaction) behave;
		if (interaction.getMessages().isEmpty()) {
			clearStatus(sourceElement);
			return;
		}
		for (Iterator messageIter = interaction.getMessages().iterator(); messageIter.hasNext();) {
			Lifeline targetLifeLine = null;
			Message message = (Message) messageIter.next();
			MessageOccurrenceSpecification source = (MessageOccurrenceSpecification) message
					.getSendEvent();
			if (sourceLifeLine == null) {
				targetLifeLine = source.getCovered(sourceElement.getName(), true);
			} else {
				targetLifeLine = source.getCovered(sourceLifeLine.getName(), true);
			}
			if (targetLifeLine != null) {
				MessageOccurrenceSpecification target = (MessageOccurrenceSpecification) message
						.getReceiveEvent();
				// TODO iterate over covered
				Lifeline target_LifeLine = target.getCovereds().get(0);
				//String propertyTargetName = target_LifeLine.getReName();
				NamedElement targetProperty = target_LifeLine.getRepresents();
				validate(sourceElement, targetProperty);
			}

		}
	}

	private void clearStatus(NamedElement sourceElement) {
		if (sourceElement == null) {
			return;
		}
		Unit sourceUnit = umlZephyrMap.get(sourceElement);
		if (sourceUnit == null) {
			return;
		}
		upDateOkStatus(sourceUnit);

	}

	private Lifeline getSourceLifeLine(NamedElement sourceElement) {
		if (sourceElement instanceof Lifeline) {
			return (Lifeline) sourceElement;
		}
		Collection<Setting> collection = UML2Util.getInverseReferences(sourceElement);
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Setting setting = (Setting) iterator.next();
			if (setting.getEStructuralFeature().equals(UMLPackage.eINSTANCE.getLifeline_Represents())) {
				return (Lifeline) setting.getEObject();
			}

		}
		return null;
	}

	private void validate(NamedElement sourceProperty, NamedElement targetProperty) {
		Unit sourceUnit = umlZephyrMap.get(sourceProperty);
		Unit targetUnit = umlZephyrMap.get(targetProperty);
		if (sourceUnit == null) {
			sourceUnit = findUnit(sourceProperty);
		}
		if (targetUnit == null) {
			targetUnit = findUnit(targetProperty);
		}

		if (sourceUnit == null || targetUnit == null) {
			return;
		}
		//Look for any communication.
		EClass type = null;
		if (sourceUnit instanceof BaseComponentUnit || sourceUnit instanceof DeploymentUnit) {
			//Look for AppCommConstraint
			type = ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT;
		} else {
			type = ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT;
		}
		if (!ZephyrUmlUtil.hasCommunicationConstraintLink(sourceUnit, targetUnit, type)) {
			DeployStatus status = (DeployStatus) ZephyrUmlUtil.createMissingConnectionStatus(
					sourceUnit, targetUnit, null, type);
			status.setValidatorGroupID(IConstants.COMMUNICATION_VALDIATOR_ID);
			collectStatuses(status, sourceUnit);
		} else {
			upDateOkStatus(sourceUnit);
		}

	}

	private Unit findUnit(NamedElement sourceProperty) {
		Unit sourceUnit = null;
		sourceUnit = deriveUnitbyNameElement(sourceProperty);
		if (sourceUnit == null && sourceProperty instanceof ConnectableElement) {
			sourceProperty = ((ConnectableElement) sourceProperty).getType();
			sourceUnit = umlZephyrMap.get(sourceProperty);
		}
		return sourceUnit;
	}

	private Unit deriveUnitbyNameElement(NamedElement targetProperty) {
		Set<NamedElement> elementSet = umlZephyrMap.keySet();
		for (Iterator iterator = elementSet.iterator(); iterator.hasNext();) {
			NamedElement element = (NamedElement) iterator.next();
			if (element.getName().equalsIgnoreCase(targetProperty.getName())) {
				return umlZephyrMap.get(element);
			}

		}
		return null;
	}

	private void collectStatuses(IDeployStatus status, Unit sourceUnit) {
		IStatus existingStatus = statusMap.get(sourceUnit);
		if (existingStatus == null) {
			statusMap.put(sourceUnit, status);
		} else {
			if (existingStatus instanceof MultiStatus) {
				MultiStatus multiStatus = (MultiStatus) existingStatus;
				multiStatus.add(status);
			} else {
				MultiStatus multiStatus = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] {
						status, existingStatus }, null, null);
				statusMap.put(sourceUnit, multiStatus);
			}
		}

	}

	private void upDateOkStatus(Unit sourceUnit) {
		updateStatus(null, sourceUnit);
	}

	private NamedElement getProperty(String propertyTargetName) {
		Set<NamedElement> namedElements = umlZephyrMap.keySet();
		for (Iterator iterator = namedElements.iterator(); iterator.hasNext();) {
			NamedElement element = (NamedElement) iterator.next();
			if (element.getName().equalsIgnoreCase(propertyTargetName)) {
				return element;
			}

		}
		return null;
	}

	private Unit getUnit(Topology topology, Object unitObj) {
		Unit unit = (Unit) unitObj;
		String path = unit.getFullPath();
		Unit writeUnit = (Unit) topology.resolve(path);
		return writeUnit;
	}

	private List<StructuredReference> getStructuredReferences(Resource resource) {
		DeployMMIManager manager = DeployMMIManager.getInstance();
		List<StructuredReference> references = manager.getStructuredReferences(resource.getURI()
				.toPlatformString(true));
		return references;
	}

	private void resolveStructuredReferences(Resource resource) {
		EcoreUtil.resolveAll(resource);
	}

	protected void updateStatus(final IStatus status, final DeployModelObject dmo) {
		Topology topology = dmo.getEditTopology();
		if (topology == null) {
			return;
		}
		final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(topology);
		try {
			changeScope.execute(getModifyOperation(status, dmo, changeScope, reporter),
					ChangeScope.OPTION_DO_NOT_SAVE, null);

		} finally {
			if (changeScope != null) {
				changeScope.close(null);
			}
		}

	}

	public AbstractEMFOperation getModifyOperation(final IStatus status,
			final DeployModelObject source, ChangeScope changeScope,
			final DeployTransactionReporter reporter) {
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(),
				UMLDomainMessages.UMLInteractionConstraintValidator_add_statu_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				ArrayList<IStatus> list = new ArrayList<IStatus>();
				if (status != null) {
					list.add(status);
				}
				reporter.updateStatus(source, new ArrayList(), list);
				return Status.OK_STATUS;

			}

			@Override
			public boolean canUndo() {
				return true;
			}
		};

		return op;

	}

}
