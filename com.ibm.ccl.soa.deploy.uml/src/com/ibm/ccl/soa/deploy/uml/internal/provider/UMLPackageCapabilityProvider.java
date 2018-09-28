package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.uml2.uml.Package;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Capability provider for UML interface
 * 
 * @since 7.0
 * 
 */
public class UMLPackageCapabilityProvider extends UMLCapabilityProvider {

	public Object[] resolveCapabilities(Object anObject) {

		if (anObject instanceof Package) {
			Package pkg = (Package) anObject;
			UMLPackageCap umlpkg = UmlFactory.eINSTANCE.createUMLPackageCap();
			String name = pkg.getName();
			umlpkg.setName(UnitUtil.fixNameForID(name));
			umlpkg.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			umlpkg.setUmlVisibilityKind(getVisibility(pkg));
			// TODO canonical
			return new Capability[] { umlpkg };
		}

		return NO_CAPS;
	}
}
