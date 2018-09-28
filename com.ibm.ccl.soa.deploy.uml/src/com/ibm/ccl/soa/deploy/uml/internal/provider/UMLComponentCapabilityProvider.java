package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.uml2.uml.Component;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Capability provider for UML component
 * 
 * @since 7.0
 * 
 */
public class UMLComponentCapabilityProvider extends UMLCapabilityProvider {

	public Object[] resolveCapabilities(Object anObject) {

		if (anObject instanceof Component) {
			Component comp = (Component) anObject;
			UMLComponent umlcomp = UmlFactory.eINSTANCE.createUMLComponent();
			String name = comp.getName();
			umlcomp.setName(comp.getName());
			umlcomp.setName(UnitUtil.fixNameForID(name));
			umlcomp.setDisplayName(name);
			umlcomp.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			umlcomp.setUmlVisibilityKind(getVisibility(comp));
			umlcomp.setAbstract(comp.isAbstract());
			umlcomp.setLeaf(comp.isLeaf());

			return new Capability[] { umlcomp };
		}

		return NO_CAPS;
	}

	public Object[] resolveRequirements(Object anObject) {

		Requirement hostingRequirement = CoreFactory.eINSTANCE.createRequirement();
		hostingRequirement.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostingRequirement.setDmoEType(AnalysisPackage.Literals.NODE);
		hostingRequirement.setName("HostingRequirement"); //$NON-NLS-1$
		hostingRequirement.setDisplayName("Node Hosting Requirement"); //$NON-NLS-1$
		hostingRequirement.setUse(RequirementUsage.OPTIONAL_LITERAL);

		Requirement membershipRequirement = CoreFactory.eINSTANCE.createRequirement();
		membershipRequirement.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		membershipRequirement.setDmoEType(AnalysisPackage.Literals.DEPLOYMENT_UNIT);
		membershipRequirement.setName("MembershipRequirement"); //$NON-NLS-1$
		membershipRequirement.setDisplayName("Deployment Unit Membership Requirement"); //$NON-NLS-1$
		membershipRequirement.setUse(RequirementUsage.OPTIONAL_LITERAL);
		// TODO a constraint?

		return new Requirement[] { hostingRequirement, membershipRequirement };

	}

}
