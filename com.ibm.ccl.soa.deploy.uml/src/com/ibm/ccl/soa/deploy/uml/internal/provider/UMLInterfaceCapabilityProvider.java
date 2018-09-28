package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.uml2.uml.Interface;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.uml.UMLInterface;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Capability provider for UML interface
 * 
 * @since 7.0
 * 
 */
public class UMLInterfaceCapabilityProvider extends UMLCapabilityProvider {

	public Object[] resolveCapabilities(Object anObject) {

		if (anObject instanceof Interface) {
			Interface interf = (Interface) anObject;
			UMLInterface umlint = UmlFactory.eINSTANCE.createUMLInterface();
			String name = interf.getName();
			umlint.setName(UnitUtil.fixNameForID(name));
			umlint.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			umlint.setUmlVisibilityKind(getVisibility(interf));
			umlint.setAbstract(interf.isAbstract());
			umlint.setLeaf(interf.isLeaf());

			return new Capability[] { umlint };
		}

		return NO_CAPS;
	}
}
