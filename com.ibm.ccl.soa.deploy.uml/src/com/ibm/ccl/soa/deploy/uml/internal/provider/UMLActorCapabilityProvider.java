package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.uml2.uml.Actor;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.uml.UMLActor;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Capability provider for UML component
 * 
 * @since 7.0
 * 
 */
public class UMLActorCapabilityProvider extends UMLCapabilityProvider {

	public Object[] resolveCapabilities(Object anObject) {

		if (anObject instanceof Actor) {
			Actor actor = (Actor) anObject;
			UMLActor umlactor = UmlFactory.eINSTANCE.createUMLActor();
			String name = actor.getName();
			umlactor.setName(actor.getName());
			umlactor.setName(UnitUtil.fixNameForID(name));
			umlactor.setDisplayName(name);
			umlactor.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			umlactor.setUmlVisibilityKind(getVisibility(actor));
			umlactor.setAbstract(actor.isAbstract());
			umlactor.setLeaf(actor.isLeaf());

			return new Capability[] { umlactor };
		}

		return NO_CAPS;
	}

	public Object[] resolveRequirements(Object anObject) {

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		req.setDmoEType(AnalysisPackage.Literals.LOCATION_UNIT);
		req.setName("locationMemeberRequirement"); //$NON-NLS-1$
		req.setDisplayName("Location Group Req"); //$NON-NLS-1$
		req.setUse(RequirementUsage.OPTIONAL_LITERAL);
		//Add Group constraint
		GroupCardinalityConstraint grpConstraint = ConstraintFactory.eINSTANCE
				.createGroupCardinalityConstraint();
		grpConstraint.setName("grpConstraint"); //$NON-NLS-1$
		grpConstraint.setMinValue("0"); //$NON-NLS-1$
		grpConstraint.setMaxValue("1"); //$NON-NLS-1$
		req.getConstraints().add(grpConstraint);
		return new Requirement[] { req };

	}

}
