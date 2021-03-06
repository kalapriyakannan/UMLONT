/**
 * <copyright>
 * </copyright>
 *
 * $Id: PortValidator.java,v 1.5 2007/12/19 23:37:05 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.validation;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;

/**
 * A sample validator interface for {@link com.ibm.ccl.soa.deploy.os.Port}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PortValidator {
	boolean validate();

	boolean validateApplicationLayerProtocol(String value);

	boolean validateIpAddressOrHostname(String value);

	boolean validatePort(BigInteger value);

	boolean validatePortName(String value);

	boolean validateTransportLayerProtocol(TransportLayerProtocolType value);
}
