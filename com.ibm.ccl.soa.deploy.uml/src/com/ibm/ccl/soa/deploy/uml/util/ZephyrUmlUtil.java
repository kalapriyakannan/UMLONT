package com.ibm.ccl.soa.deploy.uml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.operations.ElementOperations;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLDomainValidators;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLProblemType;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * 
 * @since 7.0
 * 
 */
public final class ZephyrUmlUtil {

	private Interaction interaction;
	Map<NamedElement, Unit> umlZephyrMap = new HashMap<NamedElement, Unit>();
	Map<Unit, List<Unit>> unitInteractionMap = new HashMap<Unit, List<Unit>>();
	private static ZephyrUmlUtil instance;

	private static final String PLATFORM_RESOURCE_PREFIX = "platform:/resource/"; //$NON-NLS-1$
	private static final String SEPARATOR = "/"; //$NON-NLS-1$

	private ZephyrUmlUtil() {
		// static methods only
	}

	public static ZephyrUmlUtil getInstance() {
		if (instance == null) {
			instance = new ZephyrUmlUtil();
		}
		return instance;
	}

	public static UMLElementArtifact getUMLElementArtifact(DeployModelObject dmo) {
		if (dmo != null) {
			List artifacts = dmo.getArtifacts();
			if (artifacts != null && artifacts.size() > 0) {
				for (int i = 0; i < artifacts.size(); i++) {
					Artifact artifact = (Artifact) artifacts.get(i);
					if (artifact instanceof UMLElementArtifact) {
						return (UMLElementArtifact) artifact;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Resolve the UML2 NamedElement from the DeployModelObject using the previously persisted
	 * artifact information from the unit provider.
	 * 
	 * return null if no backing element found
	 * 
	 * @param dmo
	 * @return
	 */
	public static NamedElement resolveNamedElement(DeployModelObject dmo) {

		UMLElementArtifact artifact = getUMLElementArtifact(dmo);
		if (artifact == null) {
			return null;
		}
		String qualifiedName = artifact.getQualifiedName();
		String resourceUri = artifact.getResourceURI();

		IProject proj = ProjectUtilities.getProject(dmo);
		String resolvedURI = getResolvedResourceURI(resourceUri, proj.getName());

		Resource res = loadUMLResource(resolvedURI);
		if (res != null) {
			Collection elements = UMLUtil.findNamedElements(res, qualifiedName);
			if (elements.size() > 0) {
				// Return the 1st one
				return (NamedElement) elements.iterator().next();
			}
		} else {
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

		return null;

	}

	/**
	 * Find a unit in the topology that matches the information from the NamedElement. This will
	 * introspect UnitProvider-added artifact information that associates a unit to it's backing
	 * source object (a NamedElement)
	 * 
	 * @element
	 * @top
	 * 
	 * @return the corresponding unit, null if not found
	 */
	public static Unit resolveUnit(NamedElement element, Topology top) {
		List units = top.getUnits();
		Iterator iter = units.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof Unit) // May need a base UML unit type for cases such as these
			{
				Unit unit = (Unit) obj;
				Iterator artIter = unit.getArtifacts().iterator();
				while (artIter.hasNext()) {
					Object obj1 = artIter.next();
					if (obj1 instanceof UMLElementArtifact) {
						UMLElementArtifact umlart = (UMLElementArtifact) obj1;
						String resuri = umlart.getResourceURI();
						String resolvedUri = getResolvedResourceURI(resuri, ProjectUtilities.getProject(
								top).getName());
						String qName = umlart.getQualifiedName();

						if (element.getQualifiedName().equals(qName)
								&& element.eResource().getURI().toString().equals(resolvedUri)) {
							return unit;
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * Find units in the topology that matches the information from the NamedElement. This will
	 * introspect UnitProvider-added artifact information that associates a unit to it's backing
	 * source object (a NamedElement)
	 * 
	 * @element
	 * @top
	 * 
	 * @return the matching units, empty list if none
	 */
	public static List resolveUnits(NamedElement element, Topology top) {
		List units = top.getUnits();
		List foundUnits = new ArrayList();
		Iterator iter = units.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof Unit) // May need a base UML unit type for cases such as these
			{
				Unit unit = (Unit) obj;
				Iterator artIter = unit.getArtifacts().iterator();
				while (artIter.hasNext()) {
					Object obj1 = artIter.next();
					if (obj1 instanceof UMLElementArtifact) {
						UMLElementArtifact umlart = (UMLElementArtifact) obj1;
						String resuri = umlart.getResourceURI();
						String resolvedUri = getResolvedResourceURI(resuri, ProjectUtilities.getProject(
								top).getName());
						String qName = umlart.getQualifiedName();

						if (element.getQualifiedName().equals(qName)
								&& element.eResource().getURI().toString().equals(resolvedUri)) {
							foundUnits.add(unit);
						}
					}
				}
			}
		}

		return foundUnits;
	}

	/**
	 * Return the set of UML elements required by the specified NamedElement Returns only a list of
	 * target elements for DirectedRelationships that this element is a source for, or an empty list
	 * if the specified element has no required elements from relationships.
	 * 
	 * @param umlElement
	 *           NamedElement
	 * @return List of required UML elements (may be empty if none)
	 */
	public static List getRequiredUmlElements(NamedElement umlElement) {
		List<Element> allRequiredTargetElements = new ArrayList<Element>();
		List relationships = ElementOperations.getRelationships(umlElement);
		if (relationships != null) {
			for (int i = 0; i < relationships.size(); i++) {
				Object obj = relationships.get(i);
				// Only deal with DirectedRelationships for now
				// Eventuall use logic as in RelationshipHelper.getNormalizedEnds() ?
				if (obj instanceof DirectedRelationship) {
					DirectedRelationship rel = (DirectedRelationship) obj;
					// Only drive status from source element
					// Assuming source is the current umlElement, what targets are required for its connections?
					EList<Element> tgts = rel.getTargets();
					for (int j = 0; j < tgts.size(); j++) {
						Object tgt = tgts.get(j);
						if (tgt instanceof Element && !tgt.equals(umlElement)) // Don't add self as req'd target
						{
							Element elem = (Element) tgt;
							if (!elem.eIsProxy()) {
								allRequiredTargetElements.add(elem);
							}
						}

					}
				}
			}
		}
		return allRequiredTargetElements;
	}

	/**
	 * Return the set of UML elements that require the specified NamedElement. Returns only a list of
	 * source elements for DirectedRelationships that this element is a target for, or an empty list
	 * if the specified element has no required elements from relationships.
	 * 
	 * @param umlElement
	 *           NamedElement
	 * @return List of required UML elements (may be empty if none)
	 */
	public static List getRequiringUmlElements(NamedElement umlElement) {
		List<Element> allRequiringElements = new ArrayList<Element>();
		List relationships = ElementOperations.getRelationships(umlElement);
		if (relationships != null) {
			for (int i = 0; i < relationships.size(); i++) {
				Object obj = relationships.get(i);
				if (obj instanceof DirectedRelationship) {
					DirectedRelationship rel = (DirectedRelationship) obj;
					// Only drive status from target element
					EList<Element> srcs = rel.getSources();
					for (int j = 0; j < srcs.size(); j++) {
						Object src = srcs.get(j);
						if (src instanceof Element && !src.equals(umlElement)) {
							Element elem = (Element) src;
							if (!elem.eIsProxy()) {
								allRequiringElements.add(elem);
							}
						}

					}
				}
			}
		}
		return allRequiringElements;
	}

	/**
	 * Return the set of UML elements that are related by the specified NamedElement.
	 * 
	 * Returns a list of target and source elements for DirectedRelationships that this element is a
	 * source or target for, or an empty list if the specified element has no related elements from
	 * relationships.
	 * 
	 * @param umlElement
	 *           NamedElement
	 * @return List of related UML elements (may be empty if none)
	 */
	public static List getRelatedUmlElements(NamedElement umlElement) {
		List<Element> allRelatedTargetElements = new ArrayList<Element>();
		List relationships = ElementOperations.getRelationships(umlElement);
		if (relationships != null) {
			for (int i = 0; i < relationships.size(); i++) {
				Object obj = relationships.get(i);
				if (obj instanceof DirectedRelationship) {
					DirectedRelationship rel = (DirectedRelationship) obj;
					EList<Element> relatedElements = rel.getRelatedElements();
					for (int j = 0; j < relatedElements.size(); j++) {
						Object elem = relatedElements.get(j);
						if (elem instanceof Element && !elem.equals(umlElement)) // Don't add self as req'd target
						{
							Element el = (Element) elem;
							if (!el.eIsProxy()) {
								allRelatedTargetElements.add(el);
							}
						}
					}

				}
			}
		}
		return allRelatedTargetElements;
	}

	// Brad help with these
	public static boolean hasCommunicationConstraintLink(Unit sourceUnit, Unit targetUnit,
			EClass communicationConstraintType) {

		Iterator iter = sourceUnit.getConstraintLinks().iterator();
		while (iter.hasNext()) {
			ConstraintLink link = (ConstraintLink) iter.next();
			if (link.getTarget() != null && link.getTarget().getName().equals(targetUnit.getName())) {
				// Check that link has a comm constraint
				Iterator constraints = link.getConstraints().iterator();
				while (constraints.hasNext()) {
					Constraint con = (Constraint) constraints.next();
					//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]
//					if (con instanceof CommunicationConstraint) {
					if (communicationConstraintType.isInstance(con)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static IDeployStatus createMissingConnectionStatus(Unit sourceUnit, Unit targetUnit,
			String modelName) {
		return createMissingConnectionStatus(sourceUnit, targetUnit, modelName, null);
	}

	// Create a DeployCommunicationStatus for a missing connection
	public static IDeployStatus createMissingConnectionStatus(Unit sourceUnit, Unit targetUnit,
			String modelName, EClass typeHint) {
		String message;
		Object[] bindings;

		if (modelName != null && modelName.length() > 0) {
			message = UMLDomainMessages.Unit_0_missing_connection_to_unit_1_from_2;
			bindings = new Object[] { sourceUnit.getDisplayName(), targetUnit.getDisplayName(),
					modelName };
		} else {
			message = UMLDomainMessages.Unit_0_missing_connection_to_unit_1;
			bindings = new Object[] { sourceUnit.getDisplayName(), targetUnit.getDisplayName() };
		}

		// Add status
		String type = ICoreProblemType.MISSING_NET_COMM;
		if (typeHint != null) {
			if (ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT == typeHint) {
				type = ICoreProblemType.MISSING_APP_COMM;
			}
		} else if (sourceUnit != null && sourceUnit instanceof BaseComponentUnit) {
			type = ICoreProblemType.MISSING_APP_COMM;
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployCommunicationStatus(
				IStatus.WARNING, IUMLDomainValidators.UNIT_MISSING_CONNECTION_001, type, message,
				bindings, sourceUnit, targetUnit);

		return status;
	}

	/**
	 * Create a status for an resolved backing type for a UML Zephyr instance
	 * 
	 * @param umlUnit
	 * @param art
	 * 
	 * @return status
	 */
	public static IDeployStatus createUnresolvedUMLElementStatus(Unit umlUnit, UMLElementArtifact art) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
				IUMLDomainValidators.UNRESOLVED_ELEMENT_001,
				IUMLProblemType.UML_ELEMENT_TYPE_NOT_RESOLVED,
				UMLDomainMessages.UMLElementUnitValidator_Could_not_resolve_UML_type_0,
				new Object[] { art.getQualifiedName() }, umlUnit);

		return status;
	}

	/**
	 * Create a status for a missing UML stereotype in Zephyr
	 * 
	 * @param umlUnit
	 * @param missingStereotype
	 * @return status
	 */
	public static IDeployStatus createMissingUmlStereotypeStatus(Unit umlUnit,
			org.eclipse.uml2.uml.Stereotype missingStereotype) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.WARNING,
						IUMLDomainValidators.MISSING_UML_STEREOTYPE_001,
						IUMLProblemType.MISSING_UML_STEREOTYPE,
						UMLDomainMessages.UMLElementUnitValidator_Missing_UML_stereotype_keyword_0_profile_1,
						new Object[] { missingStereotype.getKeyword(),
								missingStereotype.getProfile().getName() }, umlUnit);

		return status;
	}

	/**
	 * Create a status for an extra UML stereotype in Zephyr
	 * 
	 * @param umlUnit
	 * @param extraStereotype
	 * @return status
	 */
	public static IDeployStatus createExtraUmlStereotypeStatus(Unit umlUnit,
			Stereotype extraStereotype) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
				IUMLDomainValidators.EXTRA_UML_STEREOTYPE_001, IUMLProblemType.EXTRA_UML_STEREOTYPE,
				UMLDomainMessages.UMLElementUnitValidator_Extra_UML_stereotype_keyword_0_profile_1,
				new Object[] { extraStereotype.getKeyword(), extraStereotype.getProfile() }, umlUnit);

		return status;
	}

	/**
	 * Create required communication links to and from the specified unit Links will be created based
	 * upon relationships defined in a backing UML model
	 * 
	 * @param unit
	 */
	public static void linkRequiredElements(Unit unit) {

		NamedElement umlElement = ZephyrUmlUtil.resolveNamedElement(unit);
		if (umlElement == null) {
			return;
		}
		// Handle links the unit is a SOURCE of 
		Iterator tgtElems = ZephyrUmlUtil.getRequiredUmlElements(umlElement).iterator();
		while (tgtElems.hasNext()) {
			Object obj = tgtElems.next();
			if (obj instanceof NamedElement) {
				NamedElement elem = (NamedElement) obj;
				List resolvedUnits = ZephyrUmlUtil.resolveUnits(elem, unit.getEditTopology());
				Iterator resIter = resolvedUnits.iterator();
				while (resIter.hasNext()) {
					Object obj1 = resIter.next();
					if (obj1 instanceof Unit) {
						Unit targetUnit = (Unit) obj1;
						if (!ZephyrUmlUtil.hasCommunicationConstraintLink(unit, targetUnit,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
							createCommConstraintLink(unit, targetUnit);
						}
					}
				}
			}
		}

		// Handle links the unit is a TARGET of
		Iterator srcElems = ZephyrUmlUtil.getRequiringUmlElements(umlElement).iterator();
		while (srcElems.hasNext()) {
			Object obj = srcElems.next();
			if (obj instanceof NamedElement) {
				NamedElement elem = (NamedElement) obj;
				List resolvedUnits = ZephyrUmlUtil.resolveUnits(elem, unit.getEditTopology());
				Iterator resIter = resolvedUnits.iterator();
				while (resIter.hasNext()) {
					Object obj1 = resIter.next();
					if (obj1 instanceof Unit) {
						Unit sourceUnit = (Unit) obj1;
						if (!ZephyrUmlUtil.hasCommunicationConstraintLink(sourceUnit, unit,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
							createCommConstraintLink(sourceUnit, unit);
						}
					}
				}
			}
		}
	}

	/**
	 * Create a commmunication constraint link between the two units
	 * 
	 * @param sourceUnit
	 * @param targetUnit
	 */
	public static void createCommConstraintLink(Unit sourceUnit, Unit targetUnit) {
		Constraint constraint = ConstraintFactory.eINSTANCE
				.createApplicationCommunicationConstraint();
		constraint.setName("Communication"); //$NON-NLS-1$
		ConstraintLink link = LinkFactory.createConstraintLink(sourceUnit, targetUnit);
		link.getConstraints().add(constraint);
		constraint.setName(UnitUtil.assignUniqueName(constraint));
	}

	/**
	 * Return a list of UMLStereotypes that exist in the NamedElement, but not in the specified
	 * Zephyr unit
	 * 
	 * @param NamedElement
	 * @param Unit
	 * @return list of missing stereotypes
	 */
	public static List findMissingStereotypes(NamedElement umlElement, Unit zephyrUnit) {

		List<org.eclipse.uml2.uml.Stereotype> missingUmlStereotypes = new ArrayList();
		List<Stereotype> stereotypes = zephyrUnit.getStereotypes();

		//Compare stereotypes of this unit with its backing unit
		List umlStereotypes = ElementOperations.getAppliedStereotypes(umlElement);
		Iterator it = umlStereotypes.iterator();
		while (it.hasNext()) {
			org.eclipse.uml2.uml.Stereotype umlSt = (org.eclipse.uml2.uml.Stereotype) it.next();
			Iterator it2 = stereotypes.iterator();
			boolean match = false;
			while (it2.hasNext()) {
				Stereotype zephyrSt = (Stereotype) it2.next();
				if (umlSt.getProfile().getName().equals(zephyrSt.getProfile())) {
					if (umlSt.getKeyword().equals(zephyrSt.getKeyword())) {
						match = true;
					}
				}
			}
			if (!match) {
				missingUmlStereotypes.add(umlSt);
			}
		}

		return missingUmlStereotypes;
	}

	/**
	 * Return a list of Zephyr Stereotypes that exist in the Zephyr unit, but not in the specified
	 * Named Element
	 * 
	 * @param NamedElement
	 * @param Unit
	 * @return list of extra stereotypes
	 */
	public static List findExtraStereotypes(NamedElement umlElement, Unit zephyrUnit) {

		List<Stereotype> extraUmlStereotypes = new ArrayList();
		List<org.eclipse.uml2.uml.Stereotype> umlStereotypes = ElementOperations
				.getAppliedStereotypes(umlElement);

		//Compare stereotypes of this unit with its backing unit
		List zepStereotypes = zephyrUnit.getStereotypes();
		Iterator it = zepStereotypes.iterator();
		while (it.hasNext()) {
			Stereotype zephyrSt = (Stereotype) it.next();
			Iterator it2 = umlStereotypes.iterator();
			boolean match = false;
			while (it2.hasNext()) {
				org.eclipse.uml2.uml.Stereotype umlSt = (org.eclipse.uml2.uml.Stereotype) it2.next();
				if (umlSt.getProfile().getName().equals(zephyrSt.getProfile())) {
					if (umlSt.getKeyword().equals(zephyrSt.getKeyword())) {
						match = true;
					}
				}
			}
			if (!match) {
				extraUmlStereotypes.add(zephyrSt);
			}
		}

		return extraUmlStereotypes;
	}

	/**
	 * 
	 * @param constraint
	 * @param topology
	 * @return
	 */
	public Map<Unit, List<Unit>> getInteractionLinkedUnits(
			final UMLInteractionConstraint constraint, Topology topology) {
		if (constraint == null || topology == null) {
			return null;
		}
		Resource umlResource = loadResource(constraint);
		if (umlResource == null) {
			return null;
		}
		unitInteractionMap.clear();
		umlZephyrMap.clear();
		String interactionQName = constraint.getInteractionQName();
		if (interactionQName != null) {
			buildUmlZephyrMap(topology, umlResource, interactionQName);
		}
		buildInteractionMap();
		return unitInteractionMap;

	}

	/**
	 * 
	 * @param topology
	 * @return
	 */
	public Map<Unit, List<Unit>> getModelLinkedUnits(Topology topology) {

		Map<Unit, List<Unit>> unitLinkMap = new HashMap<Unit, List<Unit>>();

		buildUmlZephyrMap(topology);
		Iterator elements = umlZephyrMap.keySet().iterator();
		while (elements.hasNext()) {
			NamedElement element = (NamedElement) elements.next();
			Unit unit = umlZephyrMap.get(element);
			List targetElements = getRequiredUmlElements(element);
			List targetUnits = new ArrayList();
			for (int i = 0; i < targetElements.size(); i++) {
				NamedElement tgtElement = (NamedElement) targetElements.get(i);
				Unit targetUnit = umlZephyrMap.get(tgtElement);
				if (targetUnit != null) {
					targetUnits.add(targetUnit);
				}
			}
			unitLinkMap.put(unit, targetUnits);
		}

		return unitLinkMap;
	}

	/**
	 * Link the zephyr units in the topology as dictated by the containted interactions. Only link
	 * specifed units (source or target)
	 * 
	 * @param units
	 *           list of units to link to and from
	 * @param top
	 *           the topology
	 */
	public static void linkRequiredInteractionElements(List units, Topology top) {

		Iterator constraintIter = top.getConstraints().iterator();
		while (constraintIter.hasNext()) {
			Object obj = constraintIter.next();
			if (!(obj instanceof UMLInteractionConstraint)) {
				continue;
			}
			UMLInteractionConstraint umlConst = (UMLInteractionConstraint) obj;
			Map<Unit, List<Unit>> linkedUmlUnits = getInstance().getInteractionLinkedUnits(umlConst,
					top);
			if (linkedUmlUnits == null) {
				continue;
			}
			Iterator<Unit> keyIter = linkedUmlUnits.keySet().iterator();
			while (keyIter.hasNext()) {
				boolean relevant = false;
				Unit sourceUnit = keyIter.next();
				if (units.contains(sourceUnit)) {
					relevant = true;
				}
				Iterator<Unit> tgtUnitsIter = linkedUmlUnits.get(sourceUnit).iterator();
				if (tgtUnitsIter == null) {
					continue;
				}
				while (tgtUnitsIter.hasNext()) {
					Unit targetUnit = tgtUnitsIter.next();
					if (!relevant && units.contains(targetUnit)) {
						relevant = true;
					}
					if (relevant) // Only check and create links involving units we care about
					{
						if (!ZephyrUmlUtil.hasCommunicationConstraintLink(sourceUnit, targetUnit,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
							createCommConstraintLink(sourceUnit, targetUnit);
						}
					}
				}
			}
		}
	}

	/**
	 * Link the zephyr units in the topology as dictated by the containted interactions.
	 * 
	 * @param top
	 *           the topology
	 */
	public static void linkRequiredInteractionElements(Topology top) {

		Iterator constraintIter = top.getConstraints().iterator();
		while (constraintIter.hasNext()) {
			Object obj = constraintIter.next();
			if (!(obj instanceof UMLInteractionConstraint)) {
				continue;
			}
			UMLInteractionConstraint umlConst = (UMLInteractionConstraint) obj;
			Map<Unit, List<Unit>> linkedUmlUnits = getInstance().getInteractionLinkedUnits(umlConst,
					top);
			if (linkedUmlUnits == null) {
				continue;
			}
			Iterator<Unit> keyIter = linkedUmlUnits.keySet().iterator();
			while (keyIter.hasNext()) {
				Unit sourceUnit = keyIter.next();
				Iterator<Unit> tgtUnitsIter = linkedUmlUnits.get(sourceUnit).iterator();
				if (tgtUnitsIter == null) {
					continue;
				}
				while (tgtUnitsIter.hasNext()) {
					Unit targetUnit = tgtUnitsIter.next();

					if (!ZephyrUmlUtil.hasCommunicationConstraintLink(sourceUnit, targetUnit,
							ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
						createCommConstraintLink(sourceUnit, targetUnit);
					}
				}
			}
		}
	}

	private void buildInteractionMap() {
		Set<NamedElement> set = umlZephyrMap.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			NamedElement sourceElement = (NamedElement) iterator.next();
			Lifeline sourceLifeLine = getSourceLifeLine(sourceElement);
			if (interaction != null) {
				searchMessages(sourceElement, sourceLifeLine, interaction);
			}
		}

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

	private void searchMessages(NamedElement sourceElement, Lifeline sourceLifeLine, Behavior behave) {
		Interaction interaction = (Interaction) behave;
		if (interaction.getMessages().isEmpty()) {
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
				Lifeline target_LifeLine = target.getCovereds().get(0);
				NamedElement targetProperty = target_LifeLine.getRepresents();
				findUnits(sourceElement, targetProperty);
			}

		}
	}

	private void findUnits(NamedElement sourceProperty, NamedElement targetProperty) {
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
			updateMap(sourceUnit, targetUnit);
		}

	}

	private void updateMap(Unit sourceUnit, Unit targetUnit) {
		if (unitInteractionMap.containsKey(sourceUnit)) {
			List<Unit> units = unitInteractionMap.get(sourceUnit);
			if (!units.contains(targetUnit)) {
				units.add(targetUnit);
			}
		} else {
			List<Unit> unitList = new ArrayList<Unit>();
			unitList.add(targetUnit);
			unitInteractionMap.put(sourceUnit, unitList);
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

		buildUmlZephyrMap(topology);

	}

	// A simpler to build the map for model cases
	private void buildUmlZephyrMap(Topology topology) {

		umlZephyrMap.clear();
		for (Iterator iter = topology.getUnits().iterator(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			// Does unit have backing UML artifact
			NamedElement element = resolveNamedElement(unit);
			if (element != null) {
				umlZephyrMap.put(element, unit);
			}
		}

	}

	private Resource loadResource(UMLInteractionConstraint constraint) {
		UMLInteractionConstraint umlConst = constraint;
		String resourceUri = umlConst.getResourceURI();

		IProject proj = ProjectUtilities.getProject(constraint);
		String resolvedURI = getResolvedResourceURI(resourceUri, proj.getName());

		if (resolvedURI == null || resolvedURI.length() == 0) {
			return null;
		}

		Resource umlResource = loadUMLResource(resolvedURI);
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
		return umlResource;
	}

	public static Resource loadUMLResource(String resourceUri) {
		URI resUri = URI.createURI(resourceUri);

		IFile file = WorkbenchResourceHelper.getPlatformFile(resUri);
		if (file == null) {
			return null;
		}
		if (file.isAccessible()) {
			ResourceSet set = ResourceUtil.getResourceSet();
			if (set == null) {
				return null;
			}
			Resource resource = set.getResource(resUri, true);
			return resource;
		} else {
			return null;
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

	public static String getResolvedResourceURI(String resourceURI, String projectName) {
		// Add platform-project info to relative URIs
		if (resourceURI != null && !resourceURI.startsWith(PLATFORM_RESOURCE_PREFIX)) {
			String path = projectName + SEPARATOR + resourceURI;
			return URI.createPlatformResourceURI(path).toString();
		}

		return resourceURI;

	}

}