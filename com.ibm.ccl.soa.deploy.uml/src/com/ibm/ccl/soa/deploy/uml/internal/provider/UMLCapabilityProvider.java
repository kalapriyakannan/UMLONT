package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind;

public abstract class UMLCapabilityProvider extends CapabilityProvider {

	protected UMLVisibilityKind getVisibility(NamedElement elem) {

		if (elem == null) {
			return UMLVisibilityKind.UNDEFINED_LITERAL;
		}
		switch (elem.getVisibility().getValue())
		{
		case VisibilityKind.PUBLIC: {
			return UMLVisibilityKind.PUBLIC_LITERAL;
		}
		case VisibilityKind.PROTECTED: {
			return UMLVisibilityKind.PROTECTED_LITERAL;
		}
		case VisibilityKind.PRIVATE: {
			return UMLVisibilityKind.PRIVATE_LITERAL;
		}
		case VisibilityKind.PACKAGE: {
			return UMLVisibilityKind.PACKAGE_LITERAL;
		}
		default:
			return UMLVisibilityKind.UNDEFINED_LITERAL;
		}
	}

}
