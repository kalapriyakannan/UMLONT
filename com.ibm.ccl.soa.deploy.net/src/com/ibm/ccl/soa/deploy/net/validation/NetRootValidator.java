/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetRootValidator.java,v 1.2 2008/02/01 20:40:01 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.validation;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.net.IpInterface;
import com.ibm.ccl.soa.deploy.net.IpInterfaceUnit;
import com.ibm.ccl.soa.deploy.net.L2Interface;
import com.ibm.ccl.soa.deploy.net.L2InterfaceUnit;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.net.NetRoot}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface NetRootValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateXMLNSPrefixMap(EMap value);
	boolean validateXSISchemaLocation(EMap value);
	boolean validateCapabilityIpInterface(IpInterface value);
	boolean validateCapabilityL2Interface(L2Interface value);
	boolean validateUnitIpInterfaceUnit(IpInterfaceUnit value);
	boolean validateUnitL2InterfaceUnit(L2InterfaceUnit value);
}
