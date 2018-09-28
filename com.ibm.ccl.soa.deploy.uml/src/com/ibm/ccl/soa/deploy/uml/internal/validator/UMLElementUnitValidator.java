package com.ibm.ccl.soa.deploy.uml.internal.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;

/**
 * 
 * @since 7.0
 * 
 */
public abstract class UMLElementUnitValidator extends UnitValidator {

	public UMLElementUnitValidator(EClass unitType) {
		super(unitType);
	}

	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		validateUMLConnections(unit, context, reporter);
		validateTypeExists(unit, context, reporter);
		validateStereotypes(unit, context, reporter);
	}

	protected void validateUMLConnections(Unit umlUnit, IDeployValidationContext context,
			IDeployReporter reporter) {

		NamedElement umlElement = ZephyrUmlUtil.resolveNamedElement(umlUnit);
		if (umlElement != null) {
			List reqdElems = ZephyrUmlUtil.getRequiredUmlElements(umlElement);
			if (reqdElems.isEmpty()) {
				//Bail if no depenencies.
				return;
			}
			//Map for UML to non-linked targets.
			Map<NamedElement, List<Unit>> targetUnitMap = new HashMap<NamedElement, List<Unit>>();
			Topology top = umlUnit.getEditTopology();
			Iterator iter = reqdElems.iterator();
			while (iter.hasNext()) {
				Object obj = iter.next();
				if (obj instanceof NamedElement) {

					NamedElement element = (NamedElement) obj;
					List resolvedUnits = ZephyrUmlUtil.resolveUnits(element, top);
					Iterator unitIter = resolvedUnits.iterator();
					while (unitIter.hasNext()) {
						Object obj1 = unitIter.next();
						if (obj1 instanceof Unit) {
							Unit resolvedUnit = (Unit) obj1;
							if (ZephyrUmlUtil.hasCommunicationConstraintLink(umlUnit, resolvedUnit,
									ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
								//Constraint found so remove the target UML ref from the list since there is no
								//need to check any other targets...we only care to find one
								iter.remove();
								//If the requirement UML elements is now empty we can stop checking.
								if (reqdElems.isEmpty()) {
									return;
								}
								//Since a comm constraint already exists for the UML ref element we can remove
								//it from the map.
								targetUnitMap.remove(element);
								// Quit processing resolved units - we have a link
								break;
							} else {
								//No comm constraint found so add it to the list for the UML ref element.
								List<Unit> targetUnits = targetUnitMap.get(element);
								if (targetUnits == null) {
									targetUnits = new ArrayList<Unit>();
									targetUnitMap.put(element, targetUnits);
								}
								targetUnits.add(resolvedUnit);
							}
						}
					}
				}
			}

			//Report statuses against all found units in the map.  These are all of the possible links that can be created.
			if (!targetUnitMap.isEmpty()) {
				// Add status
				// Derive model name for status
				Iterator<Map.Entry<NamedElement, List<Unit>>> mapIt = targetUnitMap.entrySet()
						.iterator();
				while (mapIt.hasNext()) {
					Map.Entry<NamedElement, List<Unit>> entry = mapIt.next();
					List<Unit> targetUnits = entry.getValue();
					for (int i = 0; i < targetUnits.size(); i++) {
						Unit targetUnit = targetUnits.get(i);
						String modelName = null;
						Object obj2 = entry.getKey().eContainer();
						if (obj2 instanceof Model) {
							modelName = ((Model) obj2).getLabel();
						}
						IDeployStatus status = ZephyrUmlUtil.createMissingConnectionStatus(umlUnit,
								targetUnit, modelName,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT);

						reporter.addStatus(status);
					}
				}
			}
		}
	}

	protected void validateTypeExists(Unit umlUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// Only deal with bound units
		if (!umlUnit.isBound() || ZephyrUmlUtil.getUMLElementArtifact(umlUnit) == null) {
			return;
		}
		UMLElementArtifact art = ZephyrUmlUtil.getUMLElementArtifact(umlUnit);
		if (art == null) {
			return;
		}

		if (ZephyrUmlUtil.resolveNamedElement(umlUnit) == null) {
			IDeployStatus status = ZephyrUmlUtil.createUnresolvedUMLElementStatus(umlUnit, art);
			reporter.addStatus(status);
		}
	}

	protected void validateStereotypes(Unit umlUnit, IDeployValidationContext context,
			IDeployReporter reporter) {

		if (!umlUnit.isBound()) {
			return;
		}

		NamedElement umlElement = ZephyrUmlUtil.resolveNamedElement(umlUnit);
		if (umlElement == null) {
			return;
		}

		// Missing stereotypes in Zephyr unit
		List<org.eclipse.uml2.uml.Stereotype> missingUmlStereotypes = ZephyrUmlUtil
				.findMissingStereotypes(umlElement, umlUnit);
		for (int i = 0; i < missingUmlStereotypes.size(); i++) {
			org.eclipse.uml2.uml.Stereotype umlSt = missingUmlStereotypes.get(i);
			IDeployStatus status = ZephyrUmlUtil.createMissingUmlStereotypeStatus(umlUnit, umlSt);
			reporter.addStatus(status);
		}

		// Extra stereotypes in Zephyr Unit
		List<Stereotype> extraZephyrStereotypes = ZephyrUmlUtil.findExtraStereotypes(umlElement,
				umlUnit);
		for (int i = 0; i < extraZephyrStereotypes.size(); i++) {
			Stereotype zepSt = extraZephyrStereotypes.get(i);
			IDeployStatus status = ZephyrUmlUtil.createExtraUmlStereotypeStatus(umlUnit, zepSt);
			reporter.addStatus(status);
		}
	}

}
