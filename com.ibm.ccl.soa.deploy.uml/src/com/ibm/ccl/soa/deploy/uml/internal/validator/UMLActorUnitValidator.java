package com.ibm.ccl.soa.deploy.uml.internal.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.UnitCaptionProvider;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;

/**
 * 
 * @since 7.0
 * 
 */
public class UMLActorUnitValidator extends UMLElementUnitValidator {

	/**
	 * Construct a validator for {@link UMLActorUnit} instances.
	 */
	public UMLActorUnitValidator() {
		this(UmlPackage.eINSTANCE.getUMLActorUnit());
		// Disable core validation because we want to allow subtypes of {@link SoftwareComponent} to
		// override core semantics. For example: EAR contained EJB modules with hosting requirements
		// do not need to have them linked, because they are implicitly linked when the EAR is hosted.
		setCoreValidationEnabled(false);

	}

	/**
	 * 
	 * @param unitType
	 */
	public UMLActorUnitValidator(EClass unitType) {
		super(unitType);
		// TODO Auto-generated constructor stub

		addCapabilityTypeConstraint(UmlPackage.eINSTANCE.getUMLActor(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
	}

	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
		assert UmlPackage.eINSTANCE.getUMLActorUnit().isSuperTypeOf(unitType);
		validateCommunicationConstraintLink(reporter, unit);
	}

	private LocationUnit getMemberOfLocation(Unit member) {
		List<Unit> groupUnits = ValidatorUtils.getImmediateGroups(member);
		for (Iterator iterator = groupUnits.iterator(); iterator.hasNext();) {
			Unit group = (Unit) iterator.next();
			if (group instanceof LocationUnit) {
				return (LocationUnit) group;
			}
		}
		return null;
	}

	protected void validateCommunicationConstraintLink(IDeployReporter reporter, Unit sourceUnit) {
		LocationUnit location1 = getMemberOfLocation(sourceUnit);
		if (location1 != null) {
			Iterator iter = sourceUnit.getConstraintLinks().iterator();
			while (iter.hasNext()) {
				ConstraintLink link = (ConstraintLink) iter.next();
				DeployModelObject targetUnit = link.getTarget();
				if (!(targetUnit instanceof Unit)) {
					continue;
				}
				LocationUnit location2 = getMemberOfLocation((Unit) targetUnit);
				if (location2 != null) {
					if (!location1.equals(location2)) {
						if (!ZephyrUmlUtil.hasCommunicationConstraintLink(location1, location2,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
							UnitCaptionProvider ucp = location1.getCaptionProvider();
							reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									IStatus.INFO,
									IUMLDomainValidators.ACTOR_VALIDATE_LOCATION_COMMUNICATION,
									IUMLProblemType.COMMUNICATION_LINK_UNDEFINED,
									UMLDomainMessages.ACTOR_VALIDATE_LOCATION_COMMUNICATION, new Object[] {
											ucp.title(location1), ucp.title(location2), ucp.title(sourceUnit),
											ucp.title((Unit) targetUnit) }, link));
						}
					}
				}
			}
		}
	}

}
