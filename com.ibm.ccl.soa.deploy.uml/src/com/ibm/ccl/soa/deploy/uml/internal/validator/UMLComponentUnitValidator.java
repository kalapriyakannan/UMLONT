package com.ibm.ccl.soa.deploy.uml.internal.validator;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.UnitCaptionProvider;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;

/**
 * 
 * @since 7.0
 * 
 */
public class UMLComponentUnitValidator extends UMLElementUnitValidator {

	/**
	 * Construct a validator for {@link SoftwareComponent} instances.
	 */
	public UMLComponentUnitValidator() {
		this(CorePackage.eINSTANCE.getSoftwareComponent());

		// Disable core validation because we want to allow subtypes of {@link SoftwareComponent} to
		// override core semantics. For example: EAR contained EJB modules with hosting requirements
		// do not need to have them linked, because they are implicitly linked when the EAR is hosted.
		setCoreValidationEnabled(false);
	}

	/**
	 * 
	 * @param unitType
	 */
	public UMLComponentUnitValidator(EClass unitType) {
		super(unitType);
		// TODO Auto-generated constructor stub

		//addCapabilityTypeConstraint(UmlPackage.eINSTANCE.getUMLComponent(),
		//CapabilityLinkTypes.ANY_LITERAL, 1, 1);
	}

	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
		assert CorePackage.eINSTANCE.getSoftwareComponent().isSuperTypeOf(unitType);
		validateCommunicationConstraintLink(reporter, unit);
	}

	private NodeUnit getHostOfNode(Unit member) {
		Unit host = ValidatorUtils.getHost(member);
		if (host instanceof NodeUnit) {
			return (NodeUnit) host;
		}
		return null;
	}

	protected void validateCommunicationConstraintLink(IDeployReporter reporter, Unit sourceUnit) {
		NodeUnit node1 = getHostOfNode(sourceUnit);
		if (node1 != null) {
			Iterator<ConstraintLink> iter = sourceUnit.getConstraintLinks().iterator();
			while (iter.hasNext()) {
				ConstraintLink link = iter.next();
				DeployModelObject targetUnit = link.getTarget();
				if (!(targetUnit instanceof Unit)) {
					continue;
				}
				NodeUnit node2 = getHostOfNode((Unit) targetUnit);
				if (node2 != null) {
					if (!node1.equals(node2)) {
						if (!ZephyrUmlUtil.hasCommunicationConstraintLink(node1, node2,
								ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT)) {
							UnitCaptionProvider ucp = node1.getCaptionProvider();
							reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									IStatus.INFO,
									IUMLDomainValidators.COMPONENT_VALIDATE_NODE_COMMUNICATION,
									IUMLProblemType.COMMUNICATION_LINK_UNDEFINED,
									UMLDomainMessages.COMPONENT_VALIDATE_NODE_COMMUNICATION, new Object[] {
											ucp.title(node1), ucp.title(node2), ucp.title(sourceUnit),
											ucp.title((Unit) targetUnit) }, link));
						}
					}
				}
			}
		}
	}
}
